package com.tencent.feedback.eup;

import com.tencent.bugly.crashreport.crash.f;

final class CrashReport$1
  implements f
{
  CrashReport$1(CrashHandleListener paramCrashHandleListener) {}
  
  public final void a(boolean paramBoolean)
  {
    this.a.onCrashHandleStart(paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return this.a.onCrashSaving(paramBoolean, paramString1, paramString2, paramString3, -1234567890, paramLong, paramString4, paramString5, paramString6, paramString7);
  }
  
  public final byte[] a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return this.a.getCrashExtraData(paramBoolean, paramString1, paramString2, paramString3, -1234567890, paramLong);
  }
  
  public final String b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return this.a.getCrashExtraMessage(paramBoolean, paramString1, paramString2, paramString3, -1234567890, paramLong);
  }
  
  public final boolean b(boolean paramBoolean)
  {
    return this.a.onCrashHandleEnd(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashReport.1
 * JD-Core Version:    0.7.0.1
 */