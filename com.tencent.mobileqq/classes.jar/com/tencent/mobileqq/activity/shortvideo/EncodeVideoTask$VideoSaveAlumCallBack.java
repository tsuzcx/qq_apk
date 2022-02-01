package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EncodeVideoTask$VideoSaveAlumCallBack
  implements FFmpegExecuteResponseCallback
{
  PublishVideoEntry a;
  EncodeVideoTask.EncodeProcessListener b;
  String c;
  String d;
  long e;
  
  public EncodeVideoTask$VideoSaveAlumCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.a = paramPublishVideoEntry;
    this.b = paramEncodeProcessListener;
    this.c = paramString1;
    this.d = paramString2;
    this.e = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.b.a(-12);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step fail:");
      localStringBuilder.append(paramString);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step cost:");
      double d1 = System.currentTimeMillis() - this.e;
      Double.isNaN(d1);
      localStringBuilder.append(d1 / 1000.0D);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.b.b(this.a, this.d);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File(this.d));
    com.tencent.mobileqq.utils.FileUtils.deleteFile(this.c);
    EncodeVideoTask.a(System.currentTimeMillis() - this.e, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */