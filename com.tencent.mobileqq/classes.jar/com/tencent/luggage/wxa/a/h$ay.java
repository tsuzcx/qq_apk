package com.tencent.luggage.wxa.a;

import java.util.List;

abstract class h$ay
  extends h.ah
{
  public void a(h.an paraman)
  {
    if ((paraman instanceof h.ax))
    {
      this.i.add(paraman);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text content elements cannot contain ");
    localStringBuilder.append(paraman);
    localStringBuilder.append(" elements.");
    throw new k(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.ay
 * JD-Core Version:    0.7.0.1
 */