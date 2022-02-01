package com.tencent.luggage.wxa.rk;

public class b<_Callback>
  implements com.tencent.luggage.wxa.rm.a
{
  private a a;
  private int b = -1;
  private _Callback c;
  private int d;
  
  public b(_Callback param_Callback, a parama)
  {
    junit.framework.a.a("Callback should not be null!", param_Callback);
    this.d = param_Callback.hashCode();
    this.c = param_Callback;
    this.a = parama;
  }
  
  public void a()
  {
    junit.framework.a.a(this.a);
    this.a.b(this);
  }
  
  public _Callback b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.hashCode() == this.d);
  }
  
  public int hashCode()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rk.b
 * JD-Core Version:    0.7.0.1
 */