package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$2
  extends ArkQQAPIIPCModule.MethodGetNickname
{
  ArkQQAPIIPCModule$2(String paramString, ArrayList paramArrayList)
  {
    super(paramString);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("Nickname", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.2
 * JD-Core Version:    0.7.0.1
 */