package com.tencent.luggage.wxa.sw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class a
{
  public static int a(int paramInt, double paramDouble)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramDouble);
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramFloat);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return com.tencent.luggage.wxa.tb.a.c(paramInt1, paramInt2);
  }
  
  public static int a(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int j = 0;
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new StringBuilder("The data type was not found, the id used was ");
        paramLinkedList.append(paramInt2);
        throw new IllegalArgumentException(paramLinkedList.toString());
      case 8: 
        i = 0;
        paramInt2 = j;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += c(paramInt1, ((com.tencent.luggage.wxa.qu.a)paramLinkedList.get(paramInt2)).d());
          paramInt2 += 1;
        }
      case 7: 
        i = 0;
        paramInt2 = k;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
          paramInt2 += 1;
        }
      case 6: 
        i = 0;
        paramInt2 = m;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, (b)paramLinkedList.get(paramInt2));
          paramInt2 += 1;
        }
      case 5: 
        i = 0;
        paramInt2 = n;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
          paramInt2 += 1;
        }
      case 4: 
        i = 0;
        paramInt2 = i1;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
          paramInt2 += 1;
        }
      case 3: 
        i = 0;
        paramInt2 = i2;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
          paramInt2 += 1;
        }
      case 2: 
        i = 0;
        paramInt2 = i3;
        for (;;)
        {
          if (paramInt2 >= paramLinkedList.size()) {
            return i;
          }
          i += a(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
          paramInt2 += 1;
        }
      }
      int i = 0;
      paramInt2 = i4;
      for (;;)
      {
        if (paramInt2 >= paramLinkedList.size()) {
          return i;
        }
        i += a(paramInt1, (String)paramLinkedList.get(paramInt2));
        paramInt2 += 1;
      }
    }
    return 0;
  }
  
  public static int a(int paramInt, long paramLong)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramLong);
  }
  
  public static int a(int paramInt, b paramb)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramb);
  }
  
  public static int a(int paramInt, String paramString)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramString);
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    return com.tencent.luggage.wxa.tb.a.b(paramInt, paramBoolean);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return com.tencent.luggage.wxa.tb.a.a(paramInt1) + com.tencent.luggage.wxa.tb.a.c(paramInt2) + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sw.a
 * JD-Core Version:    0.7.0.1
 */