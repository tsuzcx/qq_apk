package com.tencent.luggage.wxa.kd;

import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;

public class a
{
  private HashMap<String, o> a = new HashMap(5);
  
  public o a(String paramString)
  {
    return (o)this.a.get(paramString);
  }
  
  public void a(String paramString, o paramo)
  {
    this.a.put(paramString, paramo);
  }
  
  public void b(String paramString)
  {
    this.a.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.a
 * JD-Core Version:    0.7.0.1
 */