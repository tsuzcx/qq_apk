package com.tencent.mobileqq.ark;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ArkTipsManager$2
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkTipsManager$2(ArkTipsManager paramArkTipsManager, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.2
 * JD-Core Version:    0.7.0.1
 */