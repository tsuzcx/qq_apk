package com.tencent.luggage.wxa.ct;

import com.tencent.xweb.JsResult;
import java.util.concurrent.ConcurrentSkipListSet;

class h$2
  extends JsResult
{
  private boolean c;
  
  h$2(h paramh, JsResult paramJsResult)
  {
    h.a(this.b).add(this);
    this.c = false;
  }
  
  public void cancel()
  {
    if (!this.c)
    {
      this.a.cancel();
      this.c = true;
    }
    h.a(this.b).remove(this);
  }
  
  public void confirm()
  {
    if (!this.c)
    {
      this.a.confirm();
      this.c = true;
    }
    h.a(this.b).remove(this);
  }
  
  public void confirmWithResult(String paramString)
  {
    if (!this.c)
    {
      this.a.confirmWithResult(paramString);
      this.c = true;
    }
    h.a(this.b).remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.h.2
 * JD-Core Version:    0.7.0.1
 */