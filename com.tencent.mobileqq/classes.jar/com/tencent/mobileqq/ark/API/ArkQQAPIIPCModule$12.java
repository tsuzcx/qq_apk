package com.tencent.mobileqq.ark.API;

import android.os.Bundle;

final class ArkQQAPIIPCModule$12
  extends ArkQQAPIIPCModule.MethodGetPSKeyAsync
{
  ArkQQAPIIPCModule$12(String paramString, ArkQQAPIIPCModule.GetPSKeyAsyncHandler.OnGetPSKeyHandler paramOnGetPSKeyHandler)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = null;
    if (paramBoolean) {
      str = paramBundle.getString("pskey", null);
    }
    if (this.a != null) {
      this.a.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.12
 * JD-Core Version:    0.7.0.1
 */