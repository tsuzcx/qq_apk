package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.OnAnimationPlayEndListener;

class NearbyTroopsPlugin$1
  implements AIOAnimationControlManager.OnAnimationPlayEndListener
{
  NearbyTroopsPlugin$1(NearbyTroopsPlugin paramNearbyTroopsPlugin, String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (AIOAnimationControlManager.b.equals(paramString2))
    {
      paramString1 = this.b;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"result\":1,\"id\":");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("}");
      paramString1.callJs(str, new String[] { localStringBuilder.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NearbyTroopsPlugin.1
 * JD-Core Version:    0.7.0.1
 */