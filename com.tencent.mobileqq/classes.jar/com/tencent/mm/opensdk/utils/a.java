package com.tencent.mm.opensdk.utils;

import android.os.Bundle;

public final class a
{
  public static int a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return -1;
    }
    try
    {
      int i = paramBundle.getInt(paramString, -1);
      return i;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + paramBundle.getMessage());
    }
    return -1;
  }
  
  public static String b(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return null;
    }
    try
    {
      paramBundle = paramBundle.getString(paramString);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + paramBundle.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.a
 * JD-Core Version:    0.7.0.1
 */