package com.tencent.mobileqq.activity.aio.panel;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.receipt.ReceiptHelper;
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
    if (((ReceiptHelper)PhotoListPanelProvider.a(this.a).q(118)).a) {
      return false;
    }
    if (((ReplyHelper)PhotoListPanelProvider.a(this.a).q(119)).b()) {
      return false;
    }
    if ((PhotoListPanelProvider.a(this.a).Y != null) && (PhotoListPanelProvider.a(this.a).Y.getText() != null) && (PhotoListPanelProvider.a(this.a).Y.getText().length() > 0))
    {
      PhotoListPanelProvider.a(this.a).ay();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider.2
 * JD-Core Version:    0.7.0.1
 */