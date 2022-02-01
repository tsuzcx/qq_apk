package com.tencent.biz.qrcode.logindev;

import com.tencent.mobileqq.app.HardCodeUtil;

public class LoginDevItem
{
  public long a;
  public int b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public int h;
  
  public LoginDevItem(int paramInt)
  {
    this.b = paramInt;
    this.f = "QQ";
    this.h = 1;
    switch (paramInt)
    {
    default: 
      return;
    case 77313: 
      this.d = 6;
      this.e = "Windows";
      this.f = "TIM";
      this.a = 1L;
      this.c = 1;
      return;
    case 75023: 
    case 78082: 
    case 78096: 
      this.d = 5;
      this.e = HardCodeUtil.a(2131904269);
      this.c = 3;
      this.h = 3;
      return;
    case 68361: 
    case 72194: 
      this.d = 3;
      this.e = "iPad";
      this.c = 2;
      this.h = 2;
      return;
    case 66818: 
    case 66831: 
    case 81154: 
      this.d = 2;
      this.e = "Mac";
      this.c = 1;
      return;
    case 65805: 
    case 68104: 
      this.d = 4;
      this.e = "aPad";
      this.c = 2;
      this.h = 2;
      return;
    }
    this.d = 1;
    this.e = "Windows";
    this.a = 1L;
    this.c = 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginDevItem[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevItem
 * JD-Core Version:    0.7.0.1
 */