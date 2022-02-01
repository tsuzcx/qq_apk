package com.tencent.crossengine;

public class GameMainThread
  extends Thread
  implements Runnable
{
  private CEApplication mApp;
  private boolean mExit = false;
  
  public GameMainThread(CEApplication paramCEApplication)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CEGame-Thread-");
    localStringBuilder.append(getId());
    setName(localStringBuilder.toString());
    this.mApp = paramCEApplication;
  }
  
  public void run()
  {
    this.mApp.gameLoop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.GameMainThread
 * JD-Core Version:    0.7.0.1
 */