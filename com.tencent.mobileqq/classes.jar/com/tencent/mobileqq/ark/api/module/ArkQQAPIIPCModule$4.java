package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$4
  extends ArkQQAPIIPCModule.MethodGetSKey
{
  ArkQQAPIIPCModule$4(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {
      this.a.add(paramBundle.getString("SKey", ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.4
 * JD-Core Version:    0.7.0.1
 */