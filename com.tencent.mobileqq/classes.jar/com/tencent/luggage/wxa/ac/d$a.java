package com.tencent.luggage.wxa.ac;

import java.io.BufferedReader;
import java.util.Queue;

class d$a
{
  private final BufferedReader a;
  private final Queue<String> b;
  private String c;
  
  public d$a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
  {
    this.b = paramQueue;
    this.a = paramBufferedReader;
  }
  
  public boolean a()
  {
    if (this.c != null) {
      return true;
    }
    if (!this.b.isEmpty())
    {
      this.c = ((String)this.b.poll());
      return true;
    }
    do
    {
      String str = this.a.readLine();
      this.c = str;
      if (str == null) {
        break;
      }
      this.c = this.c.trim();
    } while (this.c.isEmpty());
    return true;
    return false;
  }
  
  public String b()
  {
    if (a())
    {
      String str = this.c;
      this.c = null;
      return str;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.d.a
 * JD-Core Version:    0.7.0.1
 */