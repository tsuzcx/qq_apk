package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$10
  extends ArkQQAPIIPCModule.MethodGetUserInformation
{
  ArkQQAPIIPCModule$10(String paramString, ArrayList paramArrayList)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("userInfo", null);
      if (!TextUtils.isEmpty(paramBundle)) {
        this.a.add(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.10
 * JD-Core Version:    0.7.0.1
 */