package com.tencent.aladdin.config.parse;

import android.util.Log;
import android.util.Xml;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SimpleParser
  implements AladdinConfigParser
{
  private static final String TAG = "SimpleParser";
  
  private static Map<String, String> parseContentXml(Reader paramReader)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        localXmlPullParser.setInput(paramReader);
        int i = localXmlPullParser.getEventType();
        if (i != 1)
        {
          if (localXmlPullParser.getEventType() == 0)
          {
            Log.d("SimpleParser", "parseContentXml: START_DOCUMENT");
            i = localXmlPullParser.next();
            continue;
          }
          if (localXmlPullParser.getEventType() != 2) {
            continue;
          }
          Log.d("SimpleParser", "parseContentXml: START_TAG");
          paramReader = localXmlPullParser.getName();
          if ("configs".equals(paramReader))
          {
            readConfigs(localXmlPullParser, localHashMap);
            continue;
          }
        }
        else
        {
          return localHashMap;
        }
      }
      catch (Exception paramReader)
      {
        Log.e("SimpleParser", "parseContentXml: ", paramReader);
      }
      Log.e("SimpleParser", "parseContentXml: unknown tag: " + paramReader);
    }
  }
  
  private static void readConfigs(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    paramXmlPullParser.require(2, null, "configs");
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2) {
        readTag(paramXmlPullParser, paramMap);
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        Log.e("SimpleParser", "readConfigs: unknown event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  private static void readTag(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    String str = paramXmlPullParser.getName();
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (paramXmlPullParser.getEventType() == 4) {
        paramMap.put(str, paramXmlPullParser.getText());
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        if (paramXmlPullParser.getEventType() == 2)
        {
          Log.d("SimpleParser", "readTag: unexpected nested tag: " + paramXmlPullParser.getName() + ", skip.");
          skip(paramXmlPullParser);
        }
      }
    }
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    int i = 1;
    while (i != 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 1: 
        throw new IllegalStateException();
      case 3: 
        i -= 1;
        break;
      case 2: 
        Log.d("SimpleParser", "skip: " + paramXmlPullParser.getName());
        i += 1;
      }
    }
  }
  
  public Map<String, ?> parse(Reader paramReader)
  {
    return parseContentXml(paramReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.parse.SimpleParser
 * JD-Core Version:    0.7.0.1
 */