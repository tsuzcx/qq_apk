package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$5
  extends ArkQQAPIIPCModule.MethodGetNickname
{
  ArkQQAPIIPCModule$5(String paramString, ArrayList paramArrayList)
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
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.5
 * JD-Core Version:    0.7.0.1
 */