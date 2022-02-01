package com.tencent.component.animation.rebound;

public class SpringSystem
  extends BaseSpringSystem
{
  private SpringSystem(SpringLooper paramSpringLooper)
  {
    super(paramSpringLooper);
  }
  
  public static SpringSystem create()
  {
    return new SpringSystem(AndroidSpringLooperFactory.createSpringLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringSystem
 * JD-Core Version:    0.7.0.1
 */