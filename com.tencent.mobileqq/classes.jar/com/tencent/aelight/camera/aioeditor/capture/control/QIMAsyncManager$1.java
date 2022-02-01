package com.tencent.aelight.camera.aioeditor.capture.control;

class QIMAsyncManager$1
  implements Runnable
{
  QIMAsyncManager$1(QIMAsyncManager paramQIMAsyncManager) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QIMAsyncManager.a(this.this$0)) {
        return;
      }
      this.this$0.b();
      QIMAsyncManager.a(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */