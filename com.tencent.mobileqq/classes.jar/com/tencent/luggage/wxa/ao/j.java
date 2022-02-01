package com.tencent.luggage.wxa.ao;

import android.text.TextUtils;

public final class j
{
  public static boolean a(String paramString)
  {
    return "audio".equals(i(paramString));
  }
  
  public static boolean b(String paramString)
  {
    return "video".equals(i(paramString));
  }
  
  public static boolean c(String paramString)
  {
    return "text".equals(i(paramString));
  }
  
  public static String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = f(paramString[i]);
      if ((str != null) && (b(str))) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split(",");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = f(paramString[i]);
      if ((str != null) && (a(str))) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static String f(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.trim();
    if ((!paramString.startsWith("avc1")) && (!paramString.startsWith("avc3")))
    {
      if ((!paramString.startsWith("hev1")) && (!paramString.startsWith("hvc1")))
      {
        if ((!paramString.startsWith("vp9")) && (!paramString.startsWith("vp09")))
        {
          if ((!paramString.startsWith("vp8")) && (!paramString.startsWith("vp08")))
          {
            if (paramString.startsWith("mp4a")) {
              return "audio/mp4a-latm";
            }
            if ((!paramString.startsWith("ac-3")) && (!paramString.startsWith("dac3")))
            {
              if ((!paramString.startsWith("ec-3")) && (!paramString.startsWith("dec3")))
              {
                if ((!paramString.startsWith("dtsc")) && (!paramString.startsWith("dtse")))
                {
                  if ((!paramString.startsWith("dtsh")) && (!paramString.startsWith("dtsl")))
                  {
                    if (paramString.startsWith("opus")) {
                      return "audio/opus";
                    }
                    if (paramString.startsWith("vorbis")) {
                      return "audio/vorbis";
                    }
                    return null;
                  }
                  return "audio/vnd.dts.hd";
                }
                return "audio/vnd.dts";
              }
              return "audio/eac3";
            }
            return "audio/ac3";
          }
          return "video/x-vnd.on2.vp8";
        }
        return "video/x-vnd.on2.vp9";
      }
      return "video/hevc";
    }
    return "video/avc";
  }
  
  public static int g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (a(paramString)) {
      return 1;
    }
    if (b(paramString)) {
      return 2;
    }
    if ((!c(paramString)) && (!"application/cea-608".equals(paramString)) && (!"application/cea-708".equals(paramString)) && (!"application/x-mp4-cea-608".equals(paramString)) && (!"application/x-subrip".equals(paramString)) && (!"application/ttml+xml".equals(paramString)) && (!"application/x-quicktime-tx3g".equals(paramString)) && (!"application/x-mp4-vtt".equals(paramString)) && (!"application/x-rawcc".equals(paramString)) && (!"application/vobsub".equals(paramString)) && (!"application/pgs".equals(paramString)) && (!"application/dvbsubs".equals(paramString)))
    {
      if ((!"application/id3".equals(paramString)) && (!"application/x-emsg".equals(paramString)) && (!"application/x-scte35".equals(paramString)) && (!"application/x-camera-motion".equals(paramString))) {
        return -1;
      }
      return 4;
    }
    return 3;
  }
  
  public static int h(String paramString)
  {
    return g(f(paramString));
  }
  
  private static String i(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf('/');
    if (i != -1) {
      return paramString.substring(0, i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid mime type: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.j
 * JD-Core Version:    0.7.0.1
 */