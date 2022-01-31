package com.tencent.mobileqq.armap.map;

public class ARMapEngine$TextureCreator
  extends Thread
{
  boolean pauseFlag;
  boolean stopFlag;
  
  public ARMapEngine$TextureCreator(ARMapEngine paramARMapEngine, boolean paramBoolean) {}
  
  private boolean loadMapResource()
  {
    boolean bool = false;
    synchronized (this.this$0.mEglContextLock)
    {
      if (this.this$0.mGameplayHandler != 0L) {
        bool = false | ARMapEngine.access$000(this.this$0, this.this$0.mGameplayHandler);
      }
      return bool;
    }
  }
  
  public void pauseRun()
  {
    this.pauseFlag = true;
  }
  
  public void resumeRun()
  {
    this.pauseFlag = false;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void run()
  {
    super.run();
    for (;;)
    {
      if (!this.stopFlag) {
        if (!this.pauseFlag)
        {
          if (!loadMapResource()) {
            try
            {
              sleep(160L);
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
            }
          }
        }
        else {
          try
          {
            try
            {
              wait();
            }
            finally {}
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public void stopRun()
  {
    this.stopFlag = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapEngine.TextureCreator
 * JD-Core Version:    0.7.0.1
 */