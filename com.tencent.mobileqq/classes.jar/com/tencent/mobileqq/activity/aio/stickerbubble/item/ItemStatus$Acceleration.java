package com.tencent.mobileqq.activity.aio.stickerbubble.item;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Acceleration{ax=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ay=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Acceleration
 * JD-Core Version:    0.7.0.1
 */