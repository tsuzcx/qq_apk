package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory
{
  public static final int MAX_SUPPORTED_VERSION = 1;
  private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
  public static final int VERSION_1 = 1;
  private static IDiffDevOAuth v1Instance = null;
  
  public static IDiffDevOAuth getDiffDevOAuth()
  {
    return getDiffDevOAuth(1);
  }
  
  public static IDiffDevOAuth getDiffDevOAuth(int paramInt)
  {
    Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = " + paramInt);
    if (paramInt > 1)
    {
      Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = " + paramInt);
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (v1Instance == null) {
      v1Instance = new a();
    }
    return v1Instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory
 * JD-Core Version:    0.7.0.1
 */