package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import java.util.ArrayList;
import java.util.HashMap;

class HotchatPlugin$5
  implements ITroopMemberApiClientApi.Callback
{
  HotchatPlugin$5(HotchatPlugin paramHotchatPlugin) {}
  
  public void callback(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("uins");
      paramBundle = paramBundle.getStringArrayList("tinyIds");
      int i = 0;
      while (i < localArrayList.size())
      {
        HotchatPlugin.a(this.a).put(paramBundle.get(i), localArrayList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.HotchatPlugin.5
 * JD-Core Version:    0.7.0.1
 */