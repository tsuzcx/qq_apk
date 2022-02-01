package com.tencent.aelight.camera.ae.play;

import com.tencent.ttpic.openapi.filter.SimpleGLThread;

final class FaceChangeUtils$5
  implements Runnable
{
  FaceChangeUtils$5(Runnable paramRunnable, SimpleGLThread paramSimpleGLThread) {}
  
  public void run()
  {
    try
    {
      this.val$runnable.run();
      return;
    }
    finally
    {
      this.val$glThread.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceChangeUtils.5
 * JD-Core Version:    0.7.0.1
 */