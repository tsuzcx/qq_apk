package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;

final class ArkQQAPIIPCModule$9
  extends ArkQQAPIIPCModule.MethodGetPSKeyAsync
{
  ArkQQAPIIPCModule$9(String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = null;
    if (paramBoolean) {
      str = paramBundle.getString("pskey", null);
    }
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.9
 * JD-Core Version:    0.7.0.1
 */