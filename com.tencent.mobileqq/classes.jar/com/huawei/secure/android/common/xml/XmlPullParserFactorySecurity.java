package com.huawei.secure.android.common.xml;

import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParserFactorySecurity
{
  public static XmlPullParserFactory getInstance()
  {
    XmlPullParserFactory localXmlPullParserFactory = XmlPullParserFactory.newInstance();
    localXmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
    localXmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
    localXmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);
    localXmlPullParserFactory.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
    return localXmlPullParserFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.xml.XmlPullParserFactorySecurity
 * JD-Core Version:    0.7.0.1
 */