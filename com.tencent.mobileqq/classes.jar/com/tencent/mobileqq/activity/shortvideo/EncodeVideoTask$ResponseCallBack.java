package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class EncodeVideoTask$ResponseCallBack
  extends ExecuteBinResponseCallback
{
  EncodeVideoTask.EncodeProcessListener listerner;
  long mStartTime;
  PublishVideoEntry publishVideoEntry;
  String sourcePath;
  String targetPath;
  
  public EncodeVideoTask$ResponseCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.publishVideoEntry = paramPublishVideoEntry;
    this.sourcePath = paramString1;
    this.targetPath = paramString2;
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.listerner.onError(-11);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step fail:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step cost:" + (System.currentTimeMillis() - this.mStartTime) / 1000.0D + ", isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.listerner.onNext(this.publishVideoEntry, this.targetPath);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    FileUtils.deleteFile(this.sourcePath);
    EncodeVideoTask.generateTimeReport(System.currentTimeMillis() - this.mStartTime, 2);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
    }
  }
  
  public void setProcessListener(EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.listerner = paramEncodeProcessListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResponseCallBack
 * JD-Core Version:    0.7.0.1
 */