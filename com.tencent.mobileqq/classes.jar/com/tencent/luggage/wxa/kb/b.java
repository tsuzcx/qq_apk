package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

public class b
  extends ah
{
  private static final int CTRL_INDEX = 856;
  public static final String NAME = "onTextViewLinkClick";
  private String a;
  
  public b a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(c paramc)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", this.a);
    o.d("MicroMsg.JsApiEventTextViewLinkClick", "onTextViewLinkClick, url:%s", new Object[] { this.a });
    b(localHashMap).b(paramc).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.b
 * JD-Core Version:    0.7.0.1
 */