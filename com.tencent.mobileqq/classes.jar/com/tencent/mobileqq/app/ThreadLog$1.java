package com.tencent.mobileqq.app;

final class ThreadLog$1
  implements Runnable
{
  ThreadLog$1(String paramString, IllegalArgumentException paramIllegalArgumentException) {}
  
  public void run()
  {
    ThreadLog.printQLog(this.val$tag, "ExceptinTracker", this.val$ex);
    throw new IllegalArgumentException(this.val$ex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadLog.1
 * JD-Core Version:    0.7.0.1
 */