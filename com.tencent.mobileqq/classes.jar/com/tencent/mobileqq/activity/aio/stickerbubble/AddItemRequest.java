package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.graphics.Point;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Acceleration;
import com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus.Velocity;

public class AddItemRequest
{
  public Point a;
  public String b;
  public boolean c;
  public ItemStatus.Velocity d;
  public ItemStatus.Acceleration e;
  public int f;
  public int g = 229;
  
  public AddItemRequest a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public AddItemRequest a(Point paramPoint)
  {
    this.a = paramPoint;
    return this;
  }
  
  public AddItemRequest a(ItemStatus.Acceleration paramAcceleration)
  {
    this.e = paramAcceleration;
    return this;
  }
  
  public AddItemRequest a(ItemStatus.Velocity paramVelocity)
  {
    this.d = paramVelocity;
    return this;
  }
  
  public AddItemRequest a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public AddItemRequest a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.AddItemRequest
 * JD-Core Version:    0.7.0.1
 */