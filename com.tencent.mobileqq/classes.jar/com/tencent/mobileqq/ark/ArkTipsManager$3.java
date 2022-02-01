package com.tencent.mobileqq.ark;

import android.content.Context;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;

class ArkTipsManager$3
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkTipsManager$3(ArkTipsManager paramArkTipsManager, String paramString, Context paramContext) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo.path != null)) {
      ArkAppCacheMgr.getAppIcon(this.jdField_a_of_type_JavaLangString, new ArkTipsManager.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.3
 * JD-Core Version:    0.7.0.1
 */