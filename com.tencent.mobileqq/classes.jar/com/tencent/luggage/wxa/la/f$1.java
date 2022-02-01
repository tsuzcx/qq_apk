package com.tencent.luggage.wxa.la;

import android.text.TextUtils;
import com.tencent.luggage.wxa.iu.b;

class f$1
  implements c.c
{
  f$1(f paramf, b paramb, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = "ok";
    }
    else
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("fail");
      if (TextUtils.isEmpty(paramString))
      {
        paramString = "";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" ");
        localStringBuilder2.append(paramString);
        paramString = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramString);
      paramString = localStringBuilder1.toString();
    }
    this.a.a(this.b, this.c.b(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.f.1
 * JD-Core Version:    0.7.0.1
 */