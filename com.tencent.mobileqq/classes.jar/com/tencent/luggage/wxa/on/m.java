package com.tencent.luggage.wxa.on;

import android.content.Context;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.a;
import com.tencent.luggage.wxa.jj.a.e;
import com.tencent.luggage.wxa.jj.l;
import java.util.Arrays;
import java.util.List;

public class m
{
  private static final List<String> a = Arrays.asList(new String[] { "scope.userLocation", "scope.camera" });
  
  public static String a(String paramString, d paramd)
  {
    int i;
    if ((paramString.hashCode() == -21617665) && (paramString.equals("scope.camera"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0)
    {
      paramString = paramd.aj().b(paramString);
      if (paramString == null) {
        return null;
      }
      return paramString.b;
    }
    return paramd.ag().getString(2131886925);
  }
  
  public static boolean a(String paramString, l paraml)
  {
    if (!a.contains(paramString)) {
      return false;
    }
    int i = -1;
    int j = paramString.hashCode();
    if (j != -653473286)
    {
      if ((j == -21617665) && (paramString.equals("scope.camera"))) {
        i = 1;
      }
    }
    else if (paramString.equals("scope.userLocation")) {
      i = 0;
    }
    if (i != 0) {
      return i == 1;
    }
    return paraml.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.m
 * JD-Core Version:    0.7.0.1
 */