package com.tencent.map.sdk.a;

public final class jq
  implements he
{
  public lw a = null;
  public jp b = null;
  public qe c = null;
  
  public jq(lw paramlw, qe paramqe)
  {
    this.a = paramlw;
    this.c = paramqe;
  }
  
  public final void a()
  {
    jp localjp = this.b;
    if (localjp != null) {
      try
      {
        this.b.notify();
        return;
      }
      finally {}
    }
  }
  
  public final void b()
  {
    jp localjp = this.b;
    if (localjp != null)
    {
      localjp.a = false;
      try
      {
        localjp.notifyAll();
        a();
        return;
      }
      finally {}
    }
  }
  
  public final void c()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    ((lw)localObject1).c.b(this);
    localObject1 = this.b;
    if (localObject1 != null)
    {
      ((jp)localObject1).b = true;
      try
      {
        localObject1.notifyAll();
        ((jp)localObject1).interrupt();
        this.b = null;
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jq
 * JD-Core Version:    0.7.0.1
 */