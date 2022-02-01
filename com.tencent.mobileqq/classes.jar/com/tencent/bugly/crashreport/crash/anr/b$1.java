package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.x;

final class b$1
  extends FileObserver
{
  b$1(b paramb, String paramString, int paramInt)
  {
    super(paramString, 8);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("/data/anr/");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (!paramString.contains("trace"))
    {
      x.d("not anr file %s", new Object[] { paramString });
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b.1
 * JD-Core Version:    0.7.0.1
 */