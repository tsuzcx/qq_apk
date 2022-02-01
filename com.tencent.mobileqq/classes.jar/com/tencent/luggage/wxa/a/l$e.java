package com.tencent.luggage.wxa.a;

import org.xml.sax.Attributes;
import org.xml.sax.ext.DefaultHandler2;

class l$e
  extends DefaultHandler2
{
  private l$e(l paraml) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    l.a(this.a, new String(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public void endDocument()
  {
    l.b(this.a);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    l.a(this.a, paramString1, paramString2, paramString3);
  }
  
  public void processingInstruction(String paramString1, String paramString2)
  {
    paramString2 = new l.h(paramString2);
    paramString2 = l.a(this.a, paramString2);
    l.a(this.a, paramString1, paramString2);
  }
  
  public void startDocument()
  {
    l.a(this.a);
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    l.a(this.a, paramString1, paramString2, paramString3, paramAttributes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.e
 * JD-Core Version:    0.7.0.1
 */