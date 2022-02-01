package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

public class EncodeVideoTask$ResponseCallBack
  extends ExecuteBinResponseCallback
{
  EncodeVideoTask.EncodeProcessListener a;
  PublishVideoEntry b;
  String c;
  String d;
  long e;
  
  public EncodeVideoTask$ResponseCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.b = paramPublishVideoEntry;
    this.c = paramString1;
    this.d = paramString2;
    this.e = System.currentTimeMillis();
  }
  
  public void a(EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.a = paramEncodeProcessListener;
  }
  
  public void onFailure(String paramString)
  {
    this.a.a(-11);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|second step fail:");
      localStringBuilder.append(paramString);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|second step cost:");
      double d1 = System.currentTimeMillis() - this.e;
      Double.isNaN(d1);
      localStringBuilder.append(d1 / 1000.0D);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.a.a(this.b, this.d);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    FileUtils.deleteFile(this.c);
    EncodeVideoTask.a(System.currentTimeMillis() - this.e, 2);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResponseCallBack
 * JD-Core Version:    0.7.0.1
 */