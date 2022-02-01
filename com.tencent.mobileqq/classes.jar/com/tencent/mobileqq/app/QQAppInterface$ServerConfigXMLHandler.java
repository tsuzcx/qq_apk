package com.tencent.mobileqq.app;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class QQAppInterface$ServerConfigXMLHandler
  extends DefaultHandler
{
  private HashMap<String, String> elements = new HashMap();
  private String preTAG;
  
  public QQAppInterface$ServerConfigXMLHandler(QQAppInterface paramQQAppInterface) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (this.preTAG != null) {
      this.elements.put(this.preTAG, paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.preTAG = null;
  }
  
  public HashMap<String, String> getElements()
  {
    return this.elements;
  }
  
  public void startDocument()
  {
    super.startDocument();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.preTAG = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.ServerConfigXMLHandler
 * JD-Core Version:    0.7.0.1
 */