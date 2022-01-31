package com.tencent.mobileqq.activity.aio.stickerbubble;

public class ItemStatus$Acceleration
{
  public double a;
  public double b;
  
  public ItemStatus$Acceleration(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public ItemStatus$Acceleration(Acceleration paramAcceleration)
  {
    a(paramAcceleration);
  }
  
  public void a(Acceleration paramAcceleration)
  {
    this.a = paramAcceleration.a;
    this.b = paramAcceleration.b;
  }
  
  public String toString()
  {
    return "Acceleration{ax=" + this.a + ", ay=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.ItemStatus.Acceleration
 * JD-Core Version:    0.7.0.1
 */