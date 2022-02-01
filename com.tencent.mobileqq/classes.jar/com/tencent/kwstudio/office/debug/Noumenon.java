package com.tencent.kwstudio.office.debug;

import android.text.TextUtils;
import com.tencent.kwstudio.office.preview.IHostInterface;
import java.util.HashMap;
import java.util.Map;

public final class Noumenon
{
  private static final String TAG = "Noumenon";
  private static final Map<String, String> VER_MAP = new HashMap();
  static volatile IHostInterface sHostInterface;
  
  static
  {
    setLibVersion("1", "1.1.1.rd4537a563e980d08d8e5db4bffa293a0319b1daf");
  }
  
  static String getLibVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (VER_MAP)
    {
      paramString = (String)VER_MAP.get(paramString);
      return paramString;
    }
  }
  
  public static void init(IHostInterface paramIHostInterface)
  {
    sHostInterface = paramIHostInterface;
    Debugger.active();
  }
  
  public static void setLibVersion(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    synchronized (VER_MAP)
    {
      VER_MAP.put(paramString1, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Noumenon
 * JD-Core Version:    0.7.0.1
 */