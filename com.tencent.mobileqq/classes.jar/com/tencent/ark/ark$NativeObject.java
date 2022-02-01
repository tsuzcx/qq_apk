package com.tencent.ark;

public class ark$NativeObject
{
  protected long mNative = 0L;
  
  protected void finalize()
  {
    if (this.mNative != 0L) {
      Logger.logW("ark.leak", StringUtil.format("leak.obj.ark.%s.%h!!", new Object[] { getClass().getSimpleName(), this }));
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ark.NativeObject
 * JD-Core Version:    0.7.0.1
 */