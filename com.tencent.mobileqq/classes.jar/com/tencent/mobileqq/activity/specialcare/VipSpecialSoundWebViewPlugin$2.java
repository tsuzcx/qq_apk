package com.tencent.mobileqq.activity.specialcare;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;
import java.util.List;

class VipSpecialSoundWebViewPlugin$2
  implements CallBack
{
  VipSpecialSoundWebViewPlugin$2(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_special_sound_list");
      ((StringBuilder)localObject).append(this.b.mRuntime.b().getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      localObject = (List)QvipSpecialConstants.a.get(localObject);
      VipSpecialSoundWebViewPlugin.a(this.b, this.a, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        VipSpecialSoundWebViewPlugin.a(this.b, this.a, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    VipSpecialSoundWebViewPlugin.a(this.b, this.a, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.2
 * JD-Core Version:    0.7.0.1
 */