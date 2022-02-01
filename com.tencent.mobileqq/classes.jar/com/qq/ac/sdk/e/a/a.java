package com.qq.ac.sdk.e.a;

import com.b.a.a.k;
import com.b.a.a.l;
import com.b.a.b.a;
import com.b.a.n;
import com.qq.ac.sdk.e.b;

public final class a
  extends com.qq.ac.sdk.e.a
{
  private n a = b.a.b();
  
  public final void a(b paramb)
  {
    paramb = new a.3(this, 1, paramb.a(), new a.1(this, paramb), new a.2(this, paramb), paramb);
    paramb.a(false);
    this.a.a(paramb);
  }
  
  public final String b(b paramb)
  {
    k localk = k.a();
    paramb = new a.4(this, 1, paramb.a(), localk, localk, paramb);
    paramb.a(false);
    this.a.a(paramb);
    try
    {
      paramb = (String)localk.get();
      return paramb;
    }
    catch (Exception paramb)
    {
      label46:
      break label46;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.ac.sdk.e.a.a
 * JD-Core Version:    0.7.0.1
 */