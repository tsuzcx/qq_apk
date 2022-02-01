package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;

public final class XmlPullParserUtil
{
  public static String getAttributeValue(XmlPullParser paramXmlPullParser, String paramString)
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
  
  public static boolean isEndTag(XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getEventType() == 3;
  }
  
  public static boolean isEndTag(XmlPullParser paramXmlPullParser, String paramString)
  {
    return (isEndTag(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }
  
  public static boolean isStartTag(XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getEventType() == 2;
  }
  
  public static boolean isStartTag(XmlPullParser paramXmlPullParser, String paramString)
  {
    return (isStartTag(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.XmlPullParserUtil
 * JD-Core Version:    0.7.0.1
 */