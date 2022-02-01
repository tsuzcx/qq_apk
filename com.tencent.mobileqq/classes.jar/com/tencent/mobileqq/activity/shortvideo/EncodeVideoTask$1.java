package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class EncodeVideoTask$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  EncodeVideoTask$1(EncodeVideoTask paramEncodeVideoTask, PublishVideoEntry paramPublishVideoEntry, String paramString, long paramLong) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    int i;
    if (EncodeVideoTask.a(this.d)) {
      i = -24;
    } else {
      i = paramInt;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onVideoCompositeFinish isCancel:");
      paramString2.append(EncodeVideoTask.a(this.d));
      paramString2.append(", errCode:");
      paramString2.append(paramInt);
      QLog.i("EncodeVideoTask", 2, paramString2.toString());
    }
    paramString2 = this.d;
    paramString2.d = true;
    EncodeVideoTask.b(paramString2).a(i, paramString1, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.1
 * JD-Core Version:    0.7.0.1
 */