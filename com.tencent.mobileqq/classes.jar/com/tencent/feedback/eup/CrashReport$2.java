package com.tencent.feedback.eup;

import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.t;
import com.tencent.feedback.upload.UploadHandleListener;

final class CrashReport$2
  implements t
{
  CrashReport$2(UploadHandleListener paramUploadHandleListener) {}
  
  public final void a(int paramInt)
  {
    this.a.onUploadStart(paramInt);
  }
  
  public final void a(int paramInt, aq paramaq, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    if (paramaq == null) {}
    for (int i = -1;; i = paramaq.b)
    {
      this.a.onUploadEnd(paramInt, i, paramLong1, paramLong2, paramBoolean, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport.2
 * JD-Core Version:    0.7.0.1
 */