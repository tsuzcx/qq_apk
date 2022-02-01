package com.tencent.luggage.wxa.qz;

public class ab<T>
{
  private Object[] a;
  private int b;
  
  public ab(int paramInt)
  {
    if (paramInt <= 0)
    {
      o.b("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
      return;
    }
    this.a = new Object[paramInt];
  }
  
  private boolean b(T paramT)
  {
    if (this.a == null) {
      return false;
    }
    int i = 0;
    while (i < this.b)
    {
      if (this.a[i] == paramT) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public T a()
  {
    Object[] arrayOfObject = this.a;
    if (arrayOfObject == null) {
      return null;
    }
    int i = this.b;
    if (i > 0)
    {
      int j = i - 1;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.b = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public boolean a(T paramT)
  {
    if (this.a == null) {
      return false;
    }
    if (b(paramT)) {
      return false;
    }
    int i = this.b;
    Object[] arrayOfObject = this.a;
    if ((i < arrayOfObject.length) && (i >= 0))
    {
      arrayOfObject[i] = paramT;
      this.b = (i + 1);
      return true;
    }
    o.b("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.a.length) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.ab
 * JD-Core Version:    0.7.0.1
 */