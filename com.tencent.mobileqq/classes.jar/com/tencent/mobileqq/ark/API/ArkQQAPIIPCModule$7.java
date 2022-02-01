package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$7
  extends ArkQQAPIIPCModule.MethodGetSKey
{
  ArkQQAPIIPCModule$7(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("SKey", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.7
 * JD-Core Version:    0.7.0.1
 */