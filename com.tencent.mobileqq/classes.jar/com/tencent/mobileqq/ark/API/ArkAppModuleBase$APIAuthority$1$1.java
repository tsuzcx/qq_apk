package com.tencent.mobileqq.ark.API;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppModuleBase$APIAuthority$1$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkAppModuleBase$APIAuthority$1$1(ArkAppModuleBase.APIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131365763)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleBase.APIAuthority.1.1
 * JD-Core Version:    0.7.0.1
 */