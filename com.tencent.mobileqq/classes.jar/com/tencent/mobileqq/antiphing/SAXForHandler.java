package com.tencent.mobileqq.antiphing;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class SAXForHandler
  extends DefaultHandler
{
  private ArrayList<String> a;
  private int b = 0;
  
  public int a()
  {
    return this.b;
  }
  
  public ArrayList<String> b()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = paramArrayOfChar.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("characters: ");
    localStringBuilder.append(paramArrayOfChar);
    QLog.d("SAXForHandler", 4, localStringBuilder.toString());
  }
  
  public void endDocument()
  {
    QLog.d("SAXForHandler", 4, "endDocument");
    super.endDocument();
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endElement uri:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" localName:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" qName:");
    localStringBuilder.append(paramString3);
    QLog.d("SAXForHandler", 4, localStringBuilder.toString());
  }
  
  public void startDocument()
  {
    QLog.d("SAXForHandler", 4, "startDocument");
    this.a = null;
    this.a = new ArrayList();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startElement: uri:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" localName:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" qName:");
    localStringBuilder.append(paramString3);
    QLog.d("SAXForHandler", 4, localStringBuilder.toString());
    boolean bool = "config".equals(paramString2);
    int j = 0;
    int i = 0;
    if (bool) {
      while (i < paramAttributes.getLength())
      {
        this.b = Integer.valueOf(paramAttributes.getValue(i)).intValue();
        paramString1 = new StringBuilder();
        paramString1.append("startElement: localName:");
        paramString1.append(paramString2);
        paramString1.append(" value: ");
        paramString1.append(this.b);
        QLog.d("SAXForHandler", 4, paramString1.toString());
        i += 1;
      }
    }
    if ("Elem".equals(paramString2))
    {
      i = j;
      while (i < paramAttributes.getLength())
      {
        paramString1 = paramAttributes.getValue(i);
        paramString3 = paramAttributes.getLocalName(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startElement: localName:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("name: ");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(" url: ");
        localStringBuilder.append(paramString1);
        QLog.d("SAXForHandler", 4, localStringBuilder.toString());
        this.a.add(paramString1);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.SAXForHandler
 * JD-Core Version:    0.7.0.1
 */