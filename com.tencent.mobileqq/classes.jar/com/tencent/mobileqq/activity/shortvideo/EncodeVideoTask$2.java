package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class EncodeVideoTask$2
  implements EncodeVideoTask.EncodeProcessListener
{
  EncodeVideoTask$2(EncodeVideoTask paramEncodeVideoTask) {}
  
  public void a(int paramInt)
  {
    if (EncodeVideoTask.a(this.a) != null) {
      EncodeVideoTask.a(this.a).a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong)
  {
    if ((paramInt == 0) && (paramPublishVideoEntry != null) && (paramString2 != null))
    {
      EncodeVideoTask.a(this.a).a(paramPublishVideoEntry, paramString2);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, new Object[] { "composite error, fakeVid:", EncodeVideoTask.e(this.a), ", errorCode:", Integer.valueOf(paramInt), ", errorMsg:", paramString1 });
      }
      EncodeVideoTask.a(this.a).a(paramInt);
    }
    ThreadManager.excute(new EncodeVideoTask.2.2(this, paramInt, paramPublishVideoEntry, paramLong), 64, null, true);
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|onNext file: ");
      localStringBuilder.append(paramString);
      QLog.i("EncodeVideoTask", 2, localStringBuilder.toString());
    }
    if (EncodeVideoTask.b(this.a))
    {
      b(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (FileUtils.fileExistsAndNotEmpty(paramPublishVideoEntry.doodlePath)))
    {
      EncodeVideoTask.a(paramString, paramPublishVideoEntry, EncodeVideoTask.a(this.a));
      return;
    }
    b(paramPublishVideoEntry, paramString);
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ThreadManager.excute(new EncodeVideoTask.2.1(this, paramString, paramPublishVideoEntry), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2
 * JD-Core Version:    0.7.0.1
 */