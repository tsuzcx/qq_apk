package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$3
  extends ArkQQAPIIPCModule.MethodGetNicknameByView
{
  ArkQQAPIIPCModule$3(String paramString, long paramLong, ArrayList paramArrayList)
  {
    super(paramString, paramLong);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("Nickname", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.3
 * JD-Core Version:    0.7.0.1
 */