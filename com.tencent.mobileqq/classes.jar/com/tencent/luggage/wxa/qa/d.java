package com.tencent.luggage.wxa.qa;

import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.qz.o;

public class d
{
  @CallSuper
  public void a(String paramString, e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTabBarFail: ");
    localStringBuilder.append(paramString);
    o.e("IconLoadErrorHandler ", localStringBuilder.toString());
    if (parame.b() != null) {
      parame.b().a(parame.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.d
 * JD-Core Version:    0.7.0.1
 */