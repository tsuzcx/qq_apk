package com.tencent.luggage.wxa.a;

import org.xml.sax.Attributes;
import org.xmlpull.v1.XmlPullParser;

class l$i
  implements Attributes
{
  private XmlPullParser b;
  
  public l$i(l paraml, XmlPullParser paramXmlPullParser)
  {
    this.b = paramXmlPullParser;
  }
  
  public int getIndex(String paramString)
  {
    return -1;
  }
  
  public int getIndex(String paramString1, String paramString2)
  {
    return -1;
  }
  
  public int getLength()
  {
    return this.b.getAttributeCount();
  }
  
  public String getLocalName(int paramInt)
  {
    return this.b.getAttributeName(paramInt);
  }
  
  public String getQName(int paramInt)
  {
    String str = this.b.getAttributeName(paramInt);
    Object localObject = str;
    if (this.b.getAttributePrefix(paramInt) != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.getAttributePrefix(paramInt));
      ((StringBuilder)localObject).append(':');
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public String getType(int paramInt)
  {
    return null;
  }
  
  public String getType(String paramString)
  {
    return null;
  }
  
  public String getType(String paramString1, String paramString2)
  {
    return null;
  }
  
  public String getURI(int paramInt)
  {
    return this.b.getAttributeNamespace(paramInt);
  }
  
  public String getValue(int paramInt)
  {
    return this.b.getAttributeValue(paramInt);
  }
  
  public String getValue(String paramString)
  {
    return null;
  }
  
  public String getValue(String paramString1, String paramString2)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.i
 * JD-Core Version:    0.7.0.1
 */