package com.tencent.mobileqq.ark;

import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ArkTipsManager$3$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkTipsManager$3$1(ArkTipsManager.3 param3) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ArkTipsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.3.1
 * JD-Core Version:    0.7.0.1
 */