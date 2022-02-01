package com.huawei.secure.android.common.xml;

import javax.xml.parsers.DocumentBuilderFactory;

public class DocumentBuilderFactorySecurity
{
  public static DocumentBuilderFactory getInstance()
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localDocumentBuilderFactory.setFeature("http://xml.org/sax/features/namespaces", true);
    localDocumentBuilderFactory.setFeature("http://xml.org/sax/features/validation", false);
    localDocumentBuilderFactory.setExpandEntityReferences(false);
    return localDocumentBuilderFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.xml.DocumentBuilderFactorySecurity
 * JD-Core Version:    0.7.0.1
 */