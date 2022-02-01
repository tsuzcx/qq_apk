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
    localHashMap = new HashMap();
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
      localXmlPullParser.setInput(paramReader);
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next()) {
        if (localXmlPullParser.getEventType() == 0)
        {
          Log.d("SimpleParser", "parseContentXml: START_DOCUMENT");
        }
        else if (localXmlPullParser.getEventType() == 2)
        {
          Log.d("SimpleParser", "parseContentXml: START_TAG");
          paramReader = localXmlPullParser.getName();
          if ("configs".equals(paramReader))
          {
            readConfigs(localXmlPullParser, localHashMap);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parseContentXml: unknown tag: ");
            localStringBuilder.append(paramReader);
            Log.e("SimpleParser", localStringBuilder.toString());
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramReader)
    {
      Log.e("SimpleParser", "parseContentXml: ", paramReader);
    }
  }
  
  private static void readConfigs(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    paramXmlPullParser.require(2, null, "configs");
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
      if (i == 2)
      {
        readTag(paramXmlPullParser, paramMap);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readConfigs: unknown event type: ");
        localStringBuilder.append(i);
        Log.e("SimpleParser", localStringBuilder.toString());
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  private static void readTag(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      String str = paramXmlPullParser.getName();
      for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
        if (paramXmlPullParser.getEventType() == 4)
        {
          paramMap.put(str, paramXmlPullParser.getText());
        }
        else if (paramXmlPullParser.getEventType() == 2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("readTag: unexpected nested tag: ");
          localStringBuilder.append(paramXmlPullParser.getName());
          localStringBuilder.append(", skip.");
          Log.d("SimpleParser", localStringBuilder.toString());
          skip(paramXmlPullParser);
        }
      }
      return;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      int i = 1;
      while (i != 0)
      {
        int j = paramXmlPullParser.next();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              i -= 1;
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("skip: ");
            localStringBuilder.append(paramXmlPullParser.getName());
            Log.d("SimpleParser", localStringBuilder.toString());
            i += 1;
          }
        }
        else {
          throw new IllegalStateException();
        }
      }
      return;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  public Map<String, ?> parse(Reader paramReader)
  {
    return parseContentXml(paramReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.parse.SimpleParser
 * JD-Core Version:    0.7.0.1
 */