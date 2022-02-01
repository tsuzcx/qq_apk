package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ypi;

public class EncodeVideoTask$VideoSaveAlumCallBack
  implements FFmpegExecuteResponseCallback
{
  EncodeVideoTask.EncodeProcessListener listener;
  long mStartTime;
  PublishVideoEntry publishVideoEntry;
  String sourcePath;
  String videoFinalPath;
  
  public EncodeVideoTask$VideoSaveAlumCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.publishVideoEntry = paramPublishVideoEntry;
    this.listener = paramEncodeProcessListener;
    this.sourcePath = paramString1;
    this.videoFinalPath = paramString2;
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.listener.onError(-12);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step fail:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|third step cost:" + (System.currentTimeMillis() - this.mStartTime) / 1000.0D + ", isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.listener.onSend(this.publishVideoEntry, this.videoFinalPath);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    ypi.b(BaseApplication.getContext(), new File(this.videoFinalPath));
    FileUtils.deleteFile(this.sourcePath);
    EncodeVideoTask.generateTimeReport(System.currentTimeMillis() - this.mStartTime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */