package com.etrump.mixlayout;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;

public class FontSoLoader
{
  public static boolean a()
  {
    try
    {
      boolean bool = ((IFontSoLoaderAdapter)QRoute.api(IFontSoLoaderAdapter.class)).isVipFontSoDownloaded();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = ((IFontSoLoaderAdapter)QRoute.api(IFontSoLoaderAdapter.class)).isVipFontSoLoaded();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean c()
  {
    try
    {
      boolean bool = ((IFontSoLoaderAdapter)QRoute.api(IFontSoLoaderAdapter.class)).loadSo();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontSoLoader
 * JD-Core Version:    0.7.0.1
 */