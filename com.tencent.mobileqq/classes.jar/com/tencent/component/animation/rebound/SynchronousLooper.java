package com.tencent.component.animation.rebound;

public class SynchronousLooper
  extends SpringLooper
{
  public static double SIXTY_FPS = 16.666699999999999D;
  private boolean mRunning;
  private double mTimeStep = SIXTY_FPS;
  
  public double getTimeStep()
  {
    return this.mTimeStep;
  }
  
  public void setTimeStep(double paramDouble)
  {
    this.mTimeStep = paramDouble;
  }
  
  public void start()
  {
    this.mRunning = true;
    for (;;)
    {
      if (this.mSpringSystem.getIsIdle()) {}
      while (!this.mRunning) {
        return;
      }
      this.mSpringSystem.loop(this.mTimeStep);
    }
  }
  
  public void stop()
  {
    this.mRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SynchronousLooper
 * JD-Core Version:    0.7.0.1
 */