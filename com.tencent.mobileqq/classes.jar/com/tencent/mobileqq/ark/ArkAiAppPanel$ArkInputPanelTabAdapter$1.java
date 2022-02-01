package com.tencent.mobileqq.ark;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class ArkAiAppPanel$ArkInputPanelTabAdapter$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  ArkAiAppPanel$ArkInputPanelTabAdapter$1(ArkAiAppPanel.ArkInputPanelTabAdapter paramArkInputPanelTabAdapter, ArkAiAppPanel.ArkInputPanelTabAdapter.ViewHolder paramViewHolder) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter$ViewHolder.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.ArkInputPanelTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */