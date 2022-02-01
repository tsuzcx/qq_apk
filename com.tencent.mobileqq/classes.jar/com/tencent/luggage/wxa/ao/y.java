package com.tencent.luggage.wxa.ao;

import org.xmlpull.v1.XmlPullParser;

public final class y
{
  public static boolean a(XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getEventType() == 3;
  }
  
  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
  {
    return (a(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }
  
  public static boolean b(XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getEventType() == 2;
  }
  
  public static boolean b(XmlPullParser paramXmlPullParser, String paramString)
  {
    return (b(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }
  
  public static String c(XmlPullParser paramXmlPullParser, String paramString)
  {
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramXmlPullParser.getAttributeName(i))) {
        return paramXmlPullParser.getAttributeValue(i);
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.y
 * JD-Core Version:    0.7.0.1
 */