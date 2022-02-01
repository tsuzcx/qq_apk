package com.tencent.component.animation.rebound;

public abstract class SpringLooper
{
  protected BaseSpringSystem mSpringSystem;
  
  public void setSpringSystem(BaseSpringSystem paramBaseSpringSystem)
  {
    this.mSpringSystem = paramBaseSpringSystem;
  }
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringLooper
 * JD-Core Version:    0.7.0.1
 */