package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class EncodeVideoTask$2
  implements EncodeVideoTask.EncodeProcessListener
{
  EncodeVideoTask$2(EncodeVideoTask paramEncodeVideoTask) {}
  
  public void onError(int paramInt)
  {
    if (EncodeVideoTask.access$1400(this.this$0) != null) {
      EncodeVideoTask.access$1400(this.this$0).onError(paramInt);
    }
  }
  
  public void onNext(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "generate files|onNext file: " + paramString);
    }
    if (EncodeVideoTask.access$200(this.this$0))
    {
      onSend(paramPublishVideoEntry, paramString);
      return;
    }
    if ((paramPublishVideoEntry != null) && (!TextUtils.isEmpty(paramPublishVideoEntry.doodlePath)) && (FileUtils.fileExistsAndNotEmpty(paramPublishVideoEntry.doodlePath)))
    {
      EncodeVideoTask.access$300(paramString, paramPublishVideoEntry, EncodeVideoTask.access$100(this.this$0));
      return;
    }
    onSend(paramPublishVideoEntry, paramString);
  }
  
  public void onSend(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    ThreadManager.excute(new EncodeVideoTask.2.1(this, paramString, paramPublishVideoEntry), 64, null, true);
  }
  
  public void onStoryMergeCompleted(int paramInt, String paramString1, PublishVideoEntry paramPublishVideoEntry, String paramString2, long paramLong)
  {
    if ((paramInt == 0) && (paramPublishVideoEntry != null) && (paramString2 != null)) {
      EncodeVideoTask.access$100(this.this$0).onNext(paramPublishVideoEntry, paramString2);
    }
    for (;;)
    {
      ThreadManager.excute(new EncodeVideoTask.2.2(this, paramInt, paramPublishVideoEntry, paramLong), 64, null, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, new Object[] { "composite error, fakeVid:", EncodeVideoTask.access$1500(this.this$0), ", errorCode:", Integer.valueOf(paramInt), ", errorMsg:", paramString1 });
      }
      EncodeVideoTask.access$100(this.this$0).onError(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2
 * JD-Core Version:    0.7.0.1
 */