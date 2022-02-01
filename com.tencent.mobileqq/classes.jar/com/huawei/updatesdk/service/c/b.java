package com.huawei.updatesdk.service.c;

import com.huawei.updatesdk.service.e.a;
import java.io.Serializable;
import java.util.Comparator;

public class b
  implements Serializable, Comparator<b>
{
  private int a;
  private c.a b = c.a.a;
  private boolean c = false;
  private String d;
  private String e;
  private c.b f = c.b.a;
  private int g = -1;
  
  protected b() {}
  
  protected b(String paramString1, String paramString2)
  {
    b(paramString2);
    a(paramString1);
  }
  
  public int a(b paramb1, b paramb2)
  {
    if (paramb1.a()) {}
    while (paramb1.b() <= paramb2.b()) {
      return -1;
    }
    return 1;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(c.a parama)
  {
    this.b = ((c.a)a.a(parama));
  }
  
  public void a(c.b paramb)
  {
    this.f = paramb;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected boolean a()
  {
    return b() == -1;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public c.b e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.b
 * JD-Core Version:    0.7.0.1
 */