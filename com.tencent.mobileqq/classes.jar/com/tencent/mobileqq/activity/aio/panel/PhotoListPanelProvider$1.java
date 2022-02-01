package com.tencent.mobileqq.activity.aio.panel;

import android.content.Intent;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageCountChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import java.util.ArrayList;

class PhotoListPanelProvider$1
  implements PhotoListPanel.ImageCountChangedListener
{
  PhotoListPanelProvider$1(PhotoListPanelProvider paramPhotoListPanelProvider) {}
  
  public void a(Intent paramIntent)
  {
    PhotoListPanelProvider.b(this.a).a(PhotoListPanelProvider.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = PhotoListPanelProvider.b(this.a).a(PhotoListPanelProvider.a(this.a).hashCode());
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (((Intent)localObject).hasExtra("PhotoConst.SELECTED_PATHS"))
      {
        localObject = ((Intent)localObject).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        i = paramInt;
        if (localObject != null) {
          i = ((ArrayList)localObject).size();
        }
      }
    }
    if ((PhotoListPanelProvider.a(this.a).W != null) && (!((ReceiptHelper)PhotoListPanelProvider.a(this.a).q(118)).a))
    {
      boolean bool = AnonymousChatHelper.a().a(PhotoListPanelProvider.a(this.a).ah.b);
      PhotoListPanelProvider.a(this.a).aR();
      PanelIconLinearLayout localPanelIconLinearLayout = PhotoListPanelProvider.a(this.a).W;
      QQAppInterface localQQAppInterface = PhotoListPanelProvider.c(this.a);
      SessionInfo localSessionInfo = PhotoListPanelProvider.a(this.a).ah;
      if (bool) {
        localObject = AIOPanelUtiles.n;
      } else {
        localObject = AIOPanelUtiles.m;
      }
      localPanelIconLinearLayout.a(localQQAppInterface, localSessionInfo, (int[])localObject, i);
      if ((i > 0) && (!PhotoListPanelProvider.a(this.a).bn())) {
        PhotoListPanelProvider.a(this.a).bv().p().d().d().c(true);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider.1
 * JD-Core Version:    0.7.0.1
 */