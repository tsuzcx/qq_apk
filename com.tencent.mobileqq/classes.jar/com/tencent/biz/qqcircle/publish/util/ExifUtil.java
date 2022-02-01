package com.tencent.biz.qqcircle.publish.util;

import android.annotation.SuppressLint;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.tencent.image.JpegExifReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ExifUtil
{
  public static String a = "ExifUtil";
  private static HashMap<String, String> b = new HashMap();
  private static final String[] c = { "MT788", "M9" };
  
  static
  {
    a();
  }
  
  public static final String a(String paramString)
  {
    return (String)b.get(paramString);
  }
  
  public static HashMap<String, String> a(ExtendExifInterface paramExtendExifInterface)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = paramExtendExifInterface.getAttribute((String)localEntry.getKey());
      if (str != null) {
        localHashMap.put(localEntry.getKey(), str);
      }
    }
    return localHashMap;
  }
  
  @SuppressLint({"InlinedApi"})
  private static void a()
  {
    b.put("Orientation", "0x0112");
    b.put("DateTime", "0x0132");
    b.put("Make", "0x010f");
    b.put("Model", "0x0110");
    b.put("Flash", "0x9209");
    b.put("ImageWidth", "0x0100");
    b.put("ImageLength", "0x0101");
    b.put("GPSLatitude", "0x0002");
    b.put("GPSLongitude", "0x0004");
    b.put("GPSLatitudeRef", "0x0001");
    b.put("GPSLongitudeRef", "0x0003");
    b.put("WhiteBalance", "0xa403");
    b.put("UserComment", "0x9286");
    if (Build.VERSION.SDK_INT >= 11)
    {
      b.put("ExposureTime", "0x829a");
      b.put("FNumber", "0x829d");
      b.put("ISOSpeedRatings", "0x8827");
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      b.put("GPSAltitude", "0x0006");
      b.put("GPSAltitudeRef", "0x0005");
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      b.put("GPSTimeStamp", "0x0007");
      b.put("GPSDateStamp", "0x001d");
      b.put("FocalLength", "0x920a");
      b.put("GPSProcessingMethod", "0x001b");
    }
  }
  
  public static ExifInterface b(String paramString)
  {
    try
    {
      if (JpegExifReader.isCrashJpeg(paramString)) {
        return null;
      }
      paramString = new ExifInterface(paramString);
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static HashMap<String, String> b(ExtendExifInterface paramExtendExifInterface)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = paramExtendExifInterface.getAttribute(str1);
      if (str2 != null) {
        localHashMap.put(str1, str2);
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.ExifUtil
 * JD-Core Version:    0.7.0.1
 */