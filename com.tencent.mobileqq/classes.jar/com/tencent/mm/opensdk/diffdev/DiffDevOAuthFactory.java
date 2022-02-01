package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory
{
  public static final int MAX_SUPPORTED_VERSION = 1;
  private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
  public static final int VERSION_1 = 1;
  private static IDiffDevOAuth v1Instance;
  
  public static IDiffDevOAuth getDiffDevOAuth()
  {
    return getDiffDevOAuth(1);
  }
  
  public static IDiffDevOAuth getDiffDevOAuth(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDiffDevOAuth, version = ");
    localStringBuilder.append(paramInt);
    Log.v("MicroMsg.SDK.DiffDevOAuthFactory", localStringBuilder.toString());
    if (paramInt > 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiffDevOAuth fail, unsupported version = ");
      localStringBuilder.append(paramInt);
      Log.e("MicroMsg.SDK.DiffDevOAuthFactory", localStringBuilder.toString());
      return null;
    }
    if (paramInt != 1) {
      return null;
    }
    if (v1Instance == null) {
      v1Instance = new a();
    }
    return v1Instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory
 * JD-Core Version:    0.7.0.1
 */