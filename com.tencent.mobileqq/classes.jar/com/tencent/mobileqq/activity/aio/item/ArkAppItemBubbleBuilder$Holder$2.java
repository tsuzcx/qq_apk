package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.ArkAppCenter;

class ArkAppItemBubbleBuilder$Holder$2
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppItemBubbleBuilder$Holder$2(ArkAppItemBubbleBuilder.Holder paramHolder1, String paramString, ArkAppItemBubbleBuilder.Holder paramHolder2) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null))
    {
      ArkAppCacheMgr.getAppIcon(this.jdField_a_of_type_JavaLangString, new ArkAppItemBubbleBuilder.Holder.2.1(this));
      paramString = ArkAppCacheMgr.getApplicationDesc(this.jdField_a_of_type_JavaLangString);
      ArkAppCenter.a().postToMainThread(new ArkAppItemBubbleBuilder.Holder.2.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder.2
 * JD-Core Version:    0.7.0.1
 */