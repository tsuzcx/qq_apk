package com.tencent.mobileqq.activity.aio.stickerbubble;

public class ItemStatus$Velocity
{
  public double a;
  public double b;
  
  public ItemStatus$Velocity(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public ItemStatus$Velocity(Velocity paramVelocity)
  {
    a(paramVelocity);
  }
  
  public void a(Velocity paramVelocity)
  {
    this.a = paramVelocity.a;
    this.b = paramVelocity.b;
  }
  
  public String toString()
  {
    return "Velocity{vx=" + this.a + ", vy=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.ItemStatus.Velocity
 * JD-Core Version:    0.7.0.1
 */