package com.tencent.mmkv;

public abstract interface MMKVHandler
{
  public abstract void mmkvLog(MMKVLogLevel paramMMKVLogLevel, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract MMKVRecoverStrategic onMMKVCRCCheckFail(String paramString);
  
  public abstract MMKVRecoverStrategic onMMKVFileLengthError(String paramString);
  
  public abstract boolean wantLogRedirecting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mmkv.MMKVHandler
 * JD-Core Version:    0.7.0.1
 */