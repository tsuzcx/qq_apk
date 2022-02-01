package com.tencent.aelight.camera.ae.control;

class AEQIMAsyncManager$1
  implements Runnable
{
  AEQIMAsyncManager$1(AEQIMAsyncManager paramAEQIMAsyncManager) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (AEQIMAsyncManager.access$000(this.this$0)) {
        return;
      }
      this.this$0.initIndeed();
      AEQIMAsyncManager.access$002(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.control.AEQIMAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */