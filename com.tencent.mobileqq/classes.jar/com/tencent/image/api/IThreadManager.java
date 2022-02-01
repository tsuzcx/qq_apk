package com.tencent.image.api;

import android.os.HandlerThread;

public abstract interface IThreadManager
{
  public abstract void executeOnFileThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean);
  
  public abstract void executeOnNetThreadExcutor(Runnable paramRunnable, IThreadListener paramIThreadListener, boolean paramBoolean);
  
  public abstract HandlerThread getFileThread();
  
  public abstract HandlerThread getSubThread();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.api.IThreadManager
 * JD-Core Version:    0.7.0.1
 */