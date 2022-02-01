package com.huawei.secure.android.common.xml;

import javax.xml.parsers.SAXParserFactory;

public class SAXParserFactorySecurity
{
  public static SAXParserFactory getInstance()
  {
    SAXParserFactory localSAXParserFactory = SAXParserFactory.newInstance();
    localSAXParserFactory.setFeature("http://xml.org/sax/features/namespaces", true);
    localSAXParserFactory.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
    localSAXParserFactory.setFeature("http://xml.org/sax/features/validation", false);
    localSAXParserFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    localSAXParserFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    localSAXParserFactory.setFeature("http://xml.org/sax/features/string-interning", true);
    return localSAXParserFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.xml.SAXParserFactorySecurity
 * JD-Core Version:    0.7.0.1
 */