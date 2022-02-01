package com.tencent.luggage.wxa.tc;

import com.tencent.luggage.wxa.qu.b;
import java.io.OutputStream;
import java.util.LinkedList;

public class a
{
  private final byte[] a;
  private final OutputStream b;
  private final com.tencent.luggage.wxa.tb.a c;
  
  public a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = null;
    this.c = com.tencent.luggage.wxa.tb.a.a(paramArrayOfByte);
  }
  
  public void a()
  {
    OutputStream localOutputStream = this.b;
    if (localOutputStream != null)
    {
      localOutputStream.write(this.a);
      this.b.flush();
    }
  }
  
  public void a(int paramInt, double paramDouble)
  {
    this.c.a(paramInt, paramDouble);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.c.a(paramInt, paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i = 0;
      switch (paramInt2)
      {
      default: 
        paramLinkedList = new StringBuilder("The data type was not found, the id used was ");
        paramLinkedList.append(paramInt2);
        throw new IllegalArgumentException(paramLinkedList.toString());
      case 8: 
        for (;;)
        {
          if (i >= paramLinkedList.size()) {
            return;
          }
          com.tencent.luggage.wxa.qu.a locala = (com.tencent.luggage.wxa.qu.a)paramLinkedList.get(i);
          c(paramInt1, locala.d());
          locala.a(this);
          i += 1;
        }
      case 7: 
        for (;;)
        {
          if (j >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, ((Boolean)paramLinkedList.get(j)).booleanValue());
          j += 1;
        }
      case 6: 
        for (;;)
        {
          if (k >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, (b)paramLinkedList.get(k));
          k += 1;
        }
      case 5: 
        for (;;)
        {
          if (m >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, ((Float)paramLinkedList.get(m)).floatValue());
          m += 1;
        }
      case 4: 
        for (;;)
        {
          if (n >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, ((Double)paramLinkedList.get(n)).doubleValue());
          n += 1;
        }
      case 3: 
        for (;;)
        {
          if (i1 >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, ((Long)paramLinkedList.get(i1)).longValue());
          i1 += 1;
        }
      case 2: 
        for (;;)
        {
          if (i2 >= paramLinkedList.size()) {
            return;
          }
          a(paramInt1, ((Integer)paramLinkedList.get(i2)).intValue());
          i2 += 1;
        }
      }
      for (;;)
      {
        if (i3 >= paramLinkedList.size()) {
          return;
        }
        a(paramInt1, (String)paramLinkedList.get(i3));
        i3 += 1;
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.c.a(paramInt, paramLong);
  }
  
  public void a(int paramInt, b paramb)
  {
    this.c.a(paramInt, paramb);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c.a(paramInt, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.a(paramInt, paramBoolean);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.c.b(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.tc.a
 * JD-Core Version:    0.7.0.1
 */