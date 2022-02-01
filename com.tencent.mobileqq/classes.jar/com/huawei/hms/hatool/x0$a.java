package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.SHA;

public class x0$a
  extends y0
{
  public String a;
  public String b;
  
  public x0$a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a()
  {
    return a.d(this.a, this.b);
  }
  
  public String a(String paramString)
  {
    return SHA.sha256Encrypt(paramString);
  }
  
  public String b()
  {
    return a.g(this.a, this.b);
  }
  
  public String c()
  {
    return a.j(this.a, this.b);
  }
  
  public int d()
  {
    boolean bool = a.k(this.a, this.b);
    int j = 0;
    int i;
    if (bool) {
      i = 4;
    } else {
      i = 0;
    }
    if (a.e(this.a, this.b)) {
      j = 2;
    }
    return i | 0x0 | j | a.h(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.x0.a
 * JD-Core Version:    0.7.0.1
 */