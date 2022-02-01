package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import xvv;

class FFmpegExecuteAsyncTask
  extends AsyncTask<Void, String, CommandResult>
{
  public static final String TAG = "Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask";
  public final String[] cmd;
  public final FFmpegExecuteResponseCallback ffmpegExecuteResponseHandler;
  public boolean isFFmpegExecutable;
  public boolean isWorkThread;
  public Context mContext;
  public Boolean mIsDebug = Boolean.valueOf(false);
  public Process mProcess;
  public StringBuilder output;
  public final ShellCommand shellCommand;
  public long startTime;
  public final long timeout;
  
  FFmpegExecuteAsyncTask(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    this.mContext = paramContext;
    this.cmd = paramArrayOfString;
    this.timeout = paramLong;
    this.isWorkThread = paramBoolean;
    this.ffmpegExecuteResponseHandler = paramFFmpegExecuteResponseCallback;
    this.shellCommand = new ShellCommand();
    this.output = new StringBuilder();
  }
  
  private void checkAndUpdateProcess()
  {
    if (!Util.isProcessCompleted(this.mProcess))
    {
      if ((this.timeout != 9223372036854775807L) && (SystemClock.uptimeMillis() > this.startTime + this.timeout))
      {
        QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow]  timeout");
        throw new TimeoutException("FFmpeg timed out");
      }
      for (;;)
      {
        String str;
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.mProcess.getInputStream()));
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (isCancelled()) {
            return;
          }
          this.output.append(str).append("\n");
          if (this.isWorkThread)
          {
            if ((TextUtils.isEmpty(str)) || (this.ffmpegExecuteResponseHandler == null)) {
              continue;
            }
            this.ffmpegExecuteResponseHandler.onProgress(str);
            continue;
          }
        }
        catch (IOException localIOException)
        {
          QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow]  IOException");
          localIOException.printStackTrace();
        }
        publishProgress(new String[] { str });
      }
    }
  }
  
  private CommandResult getFailCommandResult()
  {
    CommandResult localCommandResult = CommandResult.getDummyFailureResponse();
    if (this.isWorkThread)
    {
      handleResult(localCommandResult);
      localCommandResult.isDone = true;
    }
    return localCommandResult;
  }
  
  private CommandResult getOutputCommandResult(Process paramProcess)
  {
    paramProcess = CommandResult.getOutputFromProcess(paramProcess);
    if (this.isWorkThread)
    {
      handleResult(paramProcess);
      paramProcess.isDone = true;
    }
    return paramProcess;
  }
  
  private void handleResult(CommandResult paramCommandResult)
  {
    if (this.ffmpegExecuteResponseHandler != null)
    {
      this.output.append(paramCommandResult.output);
      if (!paramCommandResult.success) {
        break label92;
      }
      this.ffmpegExecuteResponseHandler.onSuccess(this.output.toString());
    }
    for (;;)
    {
      this.ffmpegExecuteResponseHandler.onFinish(paramCommandResult.success);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.ffmpegExecuteResponseHandler.onFailure(this.output.toString());
    }
  }
  
  protected CommandResult doInBackground(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.isFFmpegExecutable) {
        this.isFFmpegExecutable = Util.setFileExecutable(new File(FileUtils.getFFmpeg(this.mContext)));
      }
      xvv.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.cmd));
      this.mProcess = this.shellCommand.run(this.cmd);
      paramVarArgs = this.mProcess;
      if (paramVarArgs == null)
      {
        paramVarArgs = getFailCommandResult();
        return paramVarArgs;
      }
      if (this.mIsDebug.booleanValue())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = this.cmd;
        int j = arrayOfString.length;
        while (i < j)
        {
          localStringBuilder.append(arrayOfString[i]);
          localStringBuilder.append(' ');
          i += 1;
        }
        publishProgress(new String[] { localStringBuilder.toString() });
      }
      checkAndUpdateProcess();
      paramVarArgs = getOutputCommandResult(paramVarArgs);
      return paramVarArgs;
    }
    catch (TimeoutException paramVarArgs)
    {
      xvv.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new CommandResult(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      xvv.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return getFailCommandResult();
    }
    finally
    {
      Util.destroyProcess(this.mProcess);
      xvv.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cmd));
    }
  }
  
  boolean isProcessCompleted()
  {
    return Util.isProcessCompleted(this.mProcess);
  }
  
  protected void onPostExecute(CommandResult paramCommandResult)
  {
    if (!paramCommandResult.isDone) {
      handleResult(paramCommandResult);
    }
  }
  
  protected void onPreExecute()
  {
    this.startTime = SystemClock.uptimeMillis();
    if (this.ffmpegExecuteResponseHandler != null)
    {
      if (this.isWorkThread) {
        ThreadManager.post(new FFmpegExecuteAsyncTask.1(this), 5, null, true);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.ffmpegExecuteResponseHandler.onStart();
  }
  
  protected void onProgressUpdate(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.ffmpegExecuteResponseHandler != null)) {
      this.ffmpegExecuteResponseHandler.onProgress(paramVarArgs[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteAsyncTask
 * JD-Core Version:    0.7.0.1
 */