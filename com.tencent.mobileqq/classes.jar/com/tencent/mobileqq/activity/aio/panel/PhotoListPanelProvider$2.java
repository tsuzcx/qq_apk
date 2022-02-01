package com.tencent.mobileqq.activity.aio.panel;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.widget.XEditTextEx;

class PhotoListPanelProvider$2
  implements PhotoListPanel.BottomBtnClickListener
{
  PhotoListPanelProvider$2(PhotoListPanelProvider paramPhotoListPanelProvider) {}
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    return false;
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    if (PhotoListPanelProvider.a(this.a).F) {}
    while ((PhotoListPanelProvider.a(this.a).m()) || (PhotoListPanelProvider.a(this.a).a == null) || (PhotoListPanelProvider.a(this.a).a.getText() == null) || (PhotoListPanelProvider.a(this.a).a.getText().length() <= 0)) {
      return false;
    }
    PhotoListPanelProvider.a(this.a).ap();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider.2
 * JD-Core Version:    0.7.0.1
 */