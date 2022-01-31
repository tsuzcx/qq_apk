package com.tencent.ark;

import java.util.Locale;

public class ark$NativeObject
{
  protected long mNative = 0L;
  
  protected void finalize()
  {
    if (this.mNative != 0L) {
      ArkEnvironmentManager.getInstance().logE("ark.leak", String.format(Locale.CHINA, "leak.obj.ark.%s.%h!!", new Object[] { getClass().getSimpleName(), this }));
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ark.NativeObject
 * JD-Core Version:    0.7.0.1
 */