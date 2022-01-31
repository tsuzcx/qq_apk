package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.util.Xml;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.LinkData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TextData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class HtmlChangeUtil
{
  private static String a;
  private static String b;
  private static String c;
  private static String d = "i";
  private static String e = "u";
  private static String f = "img";
  private static String g = "video";
  private static String h = "a";
  
  static
  {
    jdField_a_of_type_JavaLangString = "HtmlChangeUtil";
    jdField_b_of_type_JavaLangString = "p";
    jdField_c_of_type_JavaLangString = "strong";
  }
  
  public static BaseData a(XmlPullParser paramXmlPullParser)
  {
    ImageData localImageData = new ImageData();
    int i = paramXmlPullParser.getEventType();
    if (i != 1)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
        int j;
        do
        {
          i = paramXmlPullParser.next();
          break;
          if (!paramXmlPullParser.getName().equals(f)) {
            break label227;
          }
          j = paramXmlPullParser.getAttributeCount();
          i = 0;
        } while (i >= j);
        String str = paramXmlPullParser.getAttributeName(i);
        if (str.equals("src"))
        {
          localImageData.jdField_a_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(i);
          if (localImageData.jdField_a_of_type_JavaLangString.indexOf("http") == -1) {
            localImageData.jdField_a_of_type_JavaLangString = ("http::" + localImageData.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (str.equals("width")) {
            localImageData.jdField_a_of_type_Int = Integer.valueOf(paramXmlPullParser.getAttributeValue(i)).intValue();
          } else if (str.equals("height")) {
            localImageData.jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.getAttributeValue(i)).intValue();
          }
        }
        label227:
        throw new IllegalArgumentException("img tag error: has other start tag");
      }
      if (!f.equals(paramXmlPullParser.getName())) {}
    }
    else
    {
      return localImageData;
    }
    throw new IllegalArgumentException("img tag error: has other end tag");
  }
  
  private static CharSequence a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (paramString = Html.fromHtml(paramString, 0); (paramString == null) || (paramString.length() == 0); paramString = Html.fromHtml(paramString)) {
      return "";
    }
    int i = paramString.length() - 1;
    for (;;)
    {
      j = i;
      if (i < 0) {
        break label76;
      }
      if (paramString.charAt(i) != '\n') {
        break;
      }
      i -= 1;
    }
    int j = i + 1;
    label76:
    return paramString.subSequence(0, j);
  }
  
  public static String a(XmlPullParser paramXmlPullParser)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    int i = paramXmlPullParser.getEventType();
    localXmlSerializer.startTag("", jdField_b_of_type_JavaLangString);
    int j = paramXmlPullParser.getDepth();
    if ((paramXmlPullParser.getName() != null) && (!paramXmlPullParser.getName().equals(jdField_b_of_type_JavaLangString))) {
      j -= 1;
    }
    for (;;)
    {
      if (i != 1) {
        switch (i)
        {
        }
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        String str = paramXmlPullParser.getName();
        if ((str.equals(f)) || (str.equals(g))) {
          localXmlSerializer.endTag("", jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          localXmlSerializer.flush();
          return localStringWriter.toString();
          localXmlSerializer.startTag("", str);
          int k = paramXmlPullParser.getAttributeCount();
          i = 0;
          while (i < k)
          {
            localXmlSerializer.attribute("", paramXmlPullParser.getAttributeName(i), paramXmlPullParser.getAttributeValue(i));
            i += 1;
          }
          localXmlSerializer.text(paramXmlPullParser.getText());
          break;
          if ((!jdField_b_of_type_JavaLangString.equals(paramXmlPullParser.getName())) || (j != paramXmlPullParser.getDepth())) {
            break label304;
          }
          localXmlSerializer.endTag("", paramXmlPullParser.getName());
        }
        label304:
        localXmlSerializer.endTag("", paramXmlPullParser.getName());
      }
    }
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setInput(new StringReader(paramString));
    int i = localXmlPullParser.getEventType();
    while (i != 1)
    {
      switch (i)
      {
      }
      label244:
      do
      {
        for (;;)
        {
          i = localXmlPullParser.next();
          break;
          paramString = localXmlPullParser.getName();
          if (paramString.equals(jdField_b_of_type_JavaLangString))
          {
            a(localXmlPullParser, localArrayList);
          }
          else if (paramString.equals(h))
          {
            localArrayList.add(c(localXmlPullParser));
          }
          else
          {
            if (paramString.equals(jdField_c_of_type_JavaLangString))
            {
              paramString = new TextData();
              paramString.jdField_a_of_type_JavaLangString = a(localXmlPullParser);
              paramString.jdField_a_of_type_JavaLangCharSequence = a(paramString.jdField_a_of_type_JavaLangString);
              localArrayList.add(paramString);
              if (2 != localXmlPullParser.getEventType()) {
                continue;
              }
              i = localXmlPullParser.getEventType();
              break;
            }
            if (paramString.equals(f))
            {
              localArrayList.add(a(localXmlPullParser));
            }
            else
            {
              if (!paramString.equals(g)) {
                break label244;
              }
              localArrayList.add(b(localXmlPullParser));
            }
          }
        }
        throw new IllegalArgumentException("非法的标签: " + paramString);
        paramString = new TextData();
        paramString.jdField_a_of_type_JavaLangString = a(localXmlPullParser);
        paramString.jdField_a_of_type_JavaLangCharSequence = a(paramString.jdField_a_of_type_JavaLangString);
        localArrayList.add(paramString);
      } while (2 != localXmlPullParser.getEventType());
      i = localXmlPullParser.getEventType();
    }
    return localArrayList;
  }
  
  public static void a(XmlPullParser paramXmlPullParser, List paramList)
  {
    int i = paramXmlPullParser.getEventType();
    for (;;)
    {
      if (i != 1) {
        i = paramXmlPullParser.getEventType();
      }
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            i = paramXmlPullParser.next();
            break;
            localObject = paramXmlPullParser.getName();
            if ((((String)localObject).equals(jdField_c_of_type_JavaLangString)) || (((String)localObject).equals(d)) || (((String)localObject).equals(e)))
            {
              localObject = new TextData();
              ((TextData)localObject).jdField_a_of_type_JavaLangString = a(paramXmlPullParser);
              ((TextData)localObject).jdField_a_of_type_JavaLangCharSequence = a(((TextData)localObject).jdField_a_of_type_JavaLangString);
              paramList.add(localObject);
              break;
            }
            if (((String)localObject).equals(f))
            {
              paramList.add(a(paramXmlPullParser));
              break;
            }
            if (((String)localObject).equals(g))
            {
              paramList.add(b(paramXmlPullParser));
              break;
            }
            if (((String)localObject).equals(h))
            {
              paramList.add(c(paramXmlPullParser));
              break;
            }
          } while (((String)localObject).equals(jdField_b_of_type_JavaLangString));
          return;
        } while (!paramXmlPullParser.getName().equals(jdField_b_of_type_JavaLangString));
        return;
      }
      Object localObject = new TextData();
      ((TextData)localObject).jdField_a_of_type_JavaLangString = a(paramXmlPullParser);
      ((TextData)localObject).jdField_a_of_type_JavaLangCharSequence = a(((TextData)localObject).jdField_a_of_type_JavaLangString);
      ((TextData)localObject).jdField_a_of_type_JavaLangCharSequence = a(((TextData)localObject).jdField_a_of_type_JavaLangString);
      paramList.add(localObject);
    }
  }
  
  public static BaseData b(XmlPullParser paramXmlPullParser)
  {
    VideoData localVideoData = new VideoData();
    int i = paramXmlPullParser.getEventType();
    if (i != 1)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
        int j;
        do
        {
          i = paramXmlPullParser.next();
          break;
          if (!paramXmlPullParser.getName().equals(g)) {
            break label318;
          }
          j = paramXmlPullParser.getAttributeCount();
          i = 0;
        } while (i >= j);
        String str = paramXmlPullParser.getAttributeName(i);
        if (str.equals("vid")) {
          localVideoData.jdField_b_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(i);
        }
        for (;;)
        {
          i += 1;
          break;
          if (str.equals("width")) {
            localVideoData.jdField_a_of_type_Int = Integer.valueOf(paramXmlPullParser.getAttributeValue(i)).intValue();
          } else if (str.equals("height")) {
            localVideoData.jdField_b_of_type_Int = Integer.valueOf(paramXmlPullParser.getAttributeValue(i)).intValue();
          } else if (str.equals("cover")) {
            localVideoData.jdField_a_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(i);
          } else if (str.equals("tid")) {
            localVideoData.e = paramXmlPullParser.getAttributeValue(i);
          } else if (str.equals("appid")) {
            localVideoData.jdField_c_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(i);
          } else if (str.equals("appkey")) {
            localVideoData.d = paramXmlPullParser.getAttributeValue(i);
          } else if (str.equals("busitype")) {
            localVideoData.jdField_c_of_type_Int = Integer.valueOf(paramXmlPullParser.getAttributeValue(i)).intValue();
          }
        }
        label318:
        throw new IllegalArgumentException("video tag error: has other start tag");
      }
      if (!g.equals(paramXmlPullParser.getName())) {}
    }
    else
    {
      return localVideoData;
    }
    throw new IllegalArgumentException("video tag error: has other end tag");
  }
  
  private static BaseData c(XmlPullParser paramXmlPullParser)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(localStringWriter);
    LinkData localLinkData = new LinkData();
    int i = paramXmlPullParser.getEventType();
    if (i != 1)
    {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
      case 2: 
      case 4: 
        for (;;)
        {
          i = paramXmlPullParser.next();
          break;
          String str1 = paramXmlPullParser.getName();
          if (!str1.equals(h)) {
            throw new IllegalArgumentException(" a 标签不允许嵌套 ");
          }
          localXmlSerializer.startTag("", str1);
          int j = paramXmlPullParser.getAttributeCount();
          i = 0;
          while (i < j)
          {
            str1 = paramXmlPullParser.getAttributeName(i);
            String str2 = paramXmlPullParser.getAttributeValue(i);
            if (str1.equals("href")) {
              localLinkData.jdField_b_of_type_JavaLangString = str2;
            }
            localXmlSerializer.attribute("", str1, str2);
            i += 1;
          }
          localXmlSerializer.text(paramXmlPullParser.getText());
        }
      }
      if (h.equals(paramXmlPullParser.getName())) {
        localXmlSerializer.endTag("", h);
      }
    }
    else
    {
      localXmlSerializer.flush();
      localLinkData.jdField_a_of_type_JavaLangString = localStringWriter.toString();
      return localLinkData;
    }
    throw new IllegalArgumentException("a tag error: has other end tag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.HtmlChangeUtil
 * JD-Core Version:    0.7.0.1
 */