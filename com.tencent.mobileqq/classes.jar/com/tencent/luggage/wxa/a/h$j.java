package com.tencent.luggage.wxa.a;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;

abstract class h$j
  extends h.al
  implements h.aj
{
  List<h.an> a = new ArrayList();
  Boolean b;
  Matrix c;
  h.k d;
  String e;
  
  public void a(h.an paraman)
  {
    if ((paraman instanceof h.ad))
    {
      this.a.add(paraman);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Gradient elements cannot contain ");
    localStringBuilder.append(paraman);
    localStringBuilder.append(" elements.");
    throw new k(localStringBuilder.toString());
  }
  
  public List<h.an> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.h.j
 * JD-Core Version:    0.7.0.1
 */