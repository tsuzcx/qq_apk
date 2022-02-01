package com.tencent.luggage.wxa.cg;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class a
{
  public static String a()
  {
    try
    {
      String str = af.b(a.a.b(a.a.a(new a.a())));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAllDeviceInfo, len = ");
      int i;
      if (str == null) {
        i = 0;
      } else {
        i = str.length();
      }
      localStringBuilder.append(i);
      o.d("AdDeviceInfo", localStringBuilder.toString());
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.a
 * JD-Core Version:    0.7.0.1
 */