package com.tencent.TMG.ptt;

public abstract interface Recorder$OnQQRecorderListener
{
  public abstract void onBeginReceiveData();
  
  public abstract void onRecorderAbnormal(int paramInt);
  
  public abstract void onRecorderEnd();
  
  public abstract void onRecorderError(String paramString1, String paramString2);
  
  public abstract void onRecorderFailed(String paramString, int paramInt);
  
  public abstract void onRecorderPrepare(String paramString);
  
  public abstract void onRecorderStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.ptt.Recorder.OnQQRecorderListener
 * JD-Core Version:    0.7.0.1
 */