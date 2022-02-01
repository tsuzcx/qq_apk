package com.tencent.biz.qqstory.utils.ffmpeg;

import java.io.IOException;
import ykq;

class ShellCommand
{
  Process run(String[] paramArrayOfString)
  {
    try
    {
      Process localProcess = Runtime.getRuntime().exec(paramArrayOfString);
      return localProcess;
    }
    catch (IOException localIOException)
    {
      ykq.c("Q.qqstory.ffmpeg.FFmpeg", "Exception while trying to run: " + paramArrayOfString, localIOException);
    }
    return null;
  }
  
  CommandResult runWaitFor(String[] paramArrayOfString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Process localProcess = run(paramArrayOfString);
    if (localProcess != null) {}
    for (;;)
    {
      try
      {
        int i = localProcess.waitFor();
        localObject1 = Integer.valueOf(i);
        localObject3 = null;
      }
      catch (InterruptedException localInterruptedException1)
      {
        ykq.c("Q.qqstory.ffmpeg.FFmpeg", "Interrupt exception", localInterruptedException1);
        Util.destroyProcess(localProcess);
        localObject2 = localObject3;
        localObject3 = paramArrayOfString;
        continue;
      }
      finally
      {
        Util.destroyProcess(localProcess);
      }
      paramArrayOfString = localObject2;
      Object localObject2 = localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.ShellCommand
 * JD-Core Version:    0.7.0.1
 */