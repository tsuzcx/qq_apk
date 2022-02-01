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
      paramString = new StringBuilder("getIntExtra exception:");
      paramString.append(paramBundle.getMessage());
      Log.e("MicroMsg.IntentUtil", paramString.toString());
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
      paramString = new StringBuilder("getStringExtra exception:");
      paramString.append(paramBundle.getMessage());
      Log.e("MicroMsg.IntentUtil", paramString.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.a
 * JD-Core Version:    0.7.0.1
 */