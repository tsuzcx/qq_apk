package com.tencent.mobileqq.ark.module;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkModuleAPIAuthority$1$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkModuleAPIAuthority$1$1(ArkModuleAPIAuthority.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.a.findViewById(2131431831)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority.1.1
 * JD-Core Version:    0.7.0.1
 */