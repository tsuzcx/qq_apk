package com.tencent.luggage.wxa.sr;

import android.os.Bundle;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;

public class a
{
  WebResourceRequest a;
  
  public a(WebResourceRequest paramWebResourceRequest)
  {
    this.a = paramWebResourceRequest;
  }
  
  public Bundle a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((WebResourceRequest)localObject).d() != null) && (!this.a.b()) && (this.a.d().containsKey("Accept")))
    {
      localObject = (String)this.a.d().get("Accept");
      if ((localObject != null) && (((String)localObject).startsWith("text/html")))
      {
        i = 1;
        break label89;
      }
    }
    int i = 0;
    label89:
    if (i != 0)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("resourceType", 1);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sr.a
 * JD-Core Version:    0.7.0.1
 */