package com.getkeepsafe.relinker;

import android.os.Build;
import android.os.Build.VERSION;

final class SystemLibraryLoader
  implements ReLinker.LibraryLoader
{
  public void a(String paramString)
  {
    System.loadLibrary(paramString);
  }
  
  public String[] a()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0)) {
      return Build.SUPPORTED_ABIS;
    }
    if (!TextUtils.a(Build.CPU_ABI2)) {
      return new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
    }
    return new String[] { Build.CPU_ABI };
  }
  
  public void b(String paramString)
  {
    System.load(paramString);
  }
  
  public String c(String paramString)
  {
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so"))) {
      return paramString;
    }
    return System.mapLibraryName(paramString);
  }
  
  public String d(String paramString)
  {
    return paramString.substring(3, paramString.length() - 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.SystemLibraryLoader
 * JD-Core Version:    0.7.0.1
 */