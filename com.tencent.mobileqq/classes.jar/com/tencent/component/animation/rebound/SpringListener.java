package com.tencent.component.animation.rebound;

public abstract interface SpringListener
{
  public abstract void onSpringActivate(Spring paramSpring);
  
  public abstract void onSpringAtRest(Spring paramSpring);
  
  public abstract void onSpringEndStateChange(Spring paramSpring);
  
  public abstract void onSpringUpdate(Spring paramSpring);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringListener
 * JD-Core Version:    0.7.0.1
 */