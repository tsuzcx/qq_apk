package com.tencent.mobileqq.binhai;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

public class BinHaiConstants
{
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BinHaiConstants", 2, "tryParseInt: str=" + paramString + ", msg=" + localThrowable.getMessage(), localThrowable);
    }
    return paramInt;
  }
  
  public static BinHaiConstants.FrameAnimConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiConstants", 2, "parseFrameAnimConfig path=" + paramString);
    }
    BinHaiConstants.FrameAnimConfig localFrameAnimConfig = new BinHaiConstants.FrameAnimConfig();
    XmlPullParser localXmlPullParser = null;
    try
    {
      paramString = FileUtils.a(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("BinHaiConstants", 2, "parseFrameAnimConfig xmlConfigContent=" + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("BinHaiConstants", 1, "parseFrameAnimConfig, content is empty");
        localFrameAnimConfig.a = 0;
        return localFrameAnimConfig;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("BinHaiConstants", 1, "parseFrameAnimConfig, exception" + paramString.getMessage(), paramString);
        paramString = localXmlPullParser;
      }
      localXmlPullParser = Xml.newPullParser();
    }
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramString)
      {
        localFrameAnimConfig.a = 0;
        QLog.e("BinHaiConstants", 2, "parseFrameAnimConfig", paramString);
        return localFrameAnimConfig;
      }
      int i = localXmlPullParser.next();
      break label343;
      paramString = localXmlPullParser.getName();
      if (paramString.equalsIgnoreCase("enable"))
      {
        localFrameAnimConfig.a = a(localXmlPullParser.nextText(), 0);
      }
      else if (paramString.equalsIgnoreCase("fps"))
      {
        localFrameAnimConfig.b = a(localXmlPullParser.nextText(), 12);
      }
      else if (paramString.equalsIgnoreCase("count"))
      {
        localFrameAnimConfig.c = a(localXmlPullParser.nextText(), 0);
      }
      else if (paramString.equalsIgnoreCase("width"))
      {
        localFrameAnimConfig.d = a(localXmlPullParser.nextText(), 512);
      }
      else if (paramString.equalsIgnoreCase("height"))
      {
        localFrameAnimConfig.e = a(localXmlPullParser.nextText(), 512);
        continue;
        label343:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00.00";
    }
    int i = (int)(paramLong % 1000L) / 10;
    int j = (int)(paramLong / 1000L);
    int k = j / 60;
    return String.format(Locale.getDefault(), "%02d:%02d.%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j % 60), Integer.valueOf(i) });
  }
  
  public static ArrayList a(Resources paramResources, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 120;
    localOptions.inTargetDensity = ((int)(paramResources.getDisplayMetrics().density * 120.0F));
    localOptions.inScaled = true;
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    String str;
    Bitmap localBitmap;
    for (;;)
    {
      if (i > 20) {
        break label209;
      }
      paramResources = String.format(Locale.getDefault(), "/res/fudai/progress/loader_orange_images/loader_orange_%02d.png", new Object[] { Integer.valueOf(i) });
      str = paramString + paramResources;
      localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(paramResources);
      paramResources = localBitmap;
      if (localBitmap == null) {}
      try
      {
        paramResources = BitmapFactory.decodeFile(str, localOptions);
        if (paramResources != null) {
          localArrayList.add(paramResources);
        }
        i += 1;
      }
      catch (OutOfMemoryError paramResources)
      {
        if (!QLog.isColorLevel()) {
          break label180;
        }
      }
    }
    QLog.e("BinHaiConstants", 2, "getProgressBitmap oom " + str, paramResources);
    for (;;)
    {
      System.gc();
      paramResources = localBitmap;
      break;
      label180:
      QLog.d("BinHaiConstants", 1, "getProgressBitmap oom " + str);
    }
    label209:
    QLog.d("BinHaiConstants", 1, "getProgressBitmap add files " + localArrayList.size());
    return localArrayList;
  }
  
  public static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 48)
    {
      localArrayList.add(String.format(paramString + "321go/00100%02d.png", new Object[] { Integer.valueOf(i) }));
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList a(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(String.format(paramString + "0_%05d.png", new Object[] { Integer.valueOf(i) }));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiConstants
 * JD-Core Version:    0.7.0.1
 */