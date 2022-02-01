package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jn.e.a;
import org.apache.http.client.methods.HttpPost;

public class i$a
  extends HttpPost
{
  private e.a a;
  
  public i$a(String paramString, e.a parama)
  {
    super(paramString);
    this.a = parama;
  }
  
  public String getMethod()
  {
    return this.a.name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.i.a
 * JD-Core Version:    0.7.0.1
 */