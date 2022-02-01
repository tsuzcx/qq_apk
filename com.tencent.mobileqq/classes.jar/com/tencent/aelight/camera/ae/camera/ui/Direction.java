package com.tencent.aelight.camera.ae.camera.ui;

public abstract class Direction
{
  public static Direction c(int paramInt)
  {
    if (paramInt > 0) {
      return new Direction.End();
    }
    return new Direction.Start();
  }
  
  public abstract int a(int paramInt);
  
  public abstract boolean b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.Direction
 * JD-Core Version:    0.7.0.1
 */