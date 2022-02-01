package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import java.util.ArrayList;

final class ArkQQAPIIPCModule$8
  extends ArkQQAPIIPCModule.MethodGetAudioOutputMode
{
  ArkQQAPIIPCModule$8(ArrayList paramArrayList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      int i = paramBundle.getInt("mode", -1);
      this.a.add(Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.8
 * JD-Core Version:    0.7.0.1
 */