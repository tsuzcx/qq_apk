package com.tencent.mobileqq.activity.aio.stickerbubble.item;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Velocity{vx=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vy=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Velocity
 * JD-Core Version:    0.7.0.1
 */