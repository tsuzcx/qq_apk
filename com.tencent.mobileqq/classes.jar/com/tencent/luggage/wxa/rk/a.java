package com.tencent.luggage.wxa.rk;

import com.tencent.luggage.wxa.rp.d;
import com.tencent.luggage.wxa.rp.f;
import java.util.LinkedList;

public abstract class a<_Callback>
{
  private LinkedList<b> a = new LinkedList();
  protected d b;
  protected f c;
  
  public a(d paramd)
  {
    junit.framework.a.a(paramd);
    this.b = paramd;
    this.c = new f(paramd, null);
  }
  
  protected b a(b paramb)
  {
    if (paramb == null) {
      return null;
    }
    try
    {
      this.a.add(paramb);
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public LinkedList<b> a()
  {
    try
    {
      LinkedList localLinkedList = b();
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected LinkedList<b> b()
  {
    return new LinkedList(this.a);
  }
  
  protected void b(b paramb)
  {
    if (paramb == null) {
      return;
    }
    try
    {
      this.a.remove(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rk.a
 * JD-Core Version:    0.7.0.1
 */