package com.tencent.aelight.camera.ae.play;

public abstract interface IProgressObserver
{
  public abstract void onDownloadFinish(String paramString, boolean paramBoolean);
  
  public abstract void onProgressUpdate(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.IProgressObserver
 * JD-Core Version:    0.7.0.1
 */