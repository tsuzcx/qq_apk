package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkAppItemBubbleBuilder$Holder$2
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppItemBubbleBuilder$Holder$2(ArkAppItemBubbleBuilder.Holder paramHolder1, String paramString, ArkAppItemBubbleBuilder.Holder paramHolder2) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null))
    {
      ArkAppCacheMgr.getAppIcon(this.a, new ArkAppItemBubbleBuilder.Holder.2.1(this));
      paramString = ArkAppCacheMgr.getApplicationDesc(this.a);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppItemBubbleBuilder.Holder.2.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder.2
 * JD-Core Version:    0.7.0.1
 */