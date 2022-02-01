package com.tencent.luggage.wxa.l;

import com.tencent.luggage.wxa.v.a;
import com.tencent.luggage.wxa.x.e;
import com.tencent.luggage.wxa.x.g.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  public static final g.a a = new h.1();
  private static final Pattern d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public int b = -1;
  public int c = -1;
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!"iTunSMPB".equals(paramString1)) {
      return false;
    }
    paramString1 = d.matcher(paramString2);
    if (paramString1.find()) {}
    try
    {
      int i = Integer.parseInt(paramString1.group(1), 16);
      int j = Integer.parseInt(paramString1.group(2), 16);
      if ((i > 0) || (j > 0))
      {
        this.b = i;
        this.c = j;
        return true;
      }
      return false;
    }
    catch (NumberFormatException paramString1) {}
    return false;
  }
  
  public boolean a()
  {
    return (this.b != -1) && (this.c != -1);
  }
  
  public boolean a(int paramInt)
  {
    int i = paramInt >> 12;
    paramInt &= 0xFFF;
    if ((i <= 0) && (paramInt <= 0)) {
      return false;
    }
    this.b = i;
    this.c = paramInt;
    return true;
  }
  
  public boolean a(a parama)
  {
    int i = 0;
    while (i < parama.a())
    {
      Object localObject = parama.a(i);
      if ((localObject instanceof e))
      {
        localObject = (e)localObject;
        if (a(((e)localObject).b, ((e)localObject).c)) {
          return true;
        }
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.l.h
 * JD-Core Version:    0.7.0.1
 */