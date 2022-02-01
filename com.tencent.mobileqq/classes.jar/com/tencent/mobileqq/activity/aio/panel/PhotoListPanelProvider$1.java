package com.tencent.mobileqq.activity.aio.panel;

import android.content.Intent;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageCountChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class PhotoListPanelProvider$1
  implements PhotoListPanel.ImageCountChangedListener
{
  PhotoListPanelProvider$1(PhotoListPanelProvider paramPhotoListPanelProvider) {}
  
  public void a(Intent paramIntent)
  {
    PhotoListPanelProvider.a(this.a).a(PhotoListPanelProvider.a(this.a).hashCode(), paramIntent);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = PhotoListPanelProvider.a(this.a).a(PhotoListPanelProvider.a(this.a).hashCode());
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
    PanelIconLinearLayout localPanelIconLinearLayout;
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    if ((PhotoListPanelProvider.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!PhotoListPanelProvider.a(this.a).F))
    {
      boolean bool = AnonymousChatHelper.a().a(PhotoListPanelProvider.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (PhotoListPanelProvider.a(this.a).g() == 4) {}
      localPanelIconLinearLayout = PhotoListPanelProvider.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      localQQAppInterface = PhotoListPanelProvider.a(this.a);
      localSessionInfo = PhotoListPanelProvider.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (!bool) {
        break label207;
      }
    }
    label207:
    for (localObject = AIOPanelUtiles.m;; localObject = AIOPanelUtiles.l)
    {
      localPanelIconLinearLayout.a(localQQAppInterface, localSessionInfo, (int[])localObject, i);
      if ((i > 0) && (!PhotoListPanelProvider.a(this.a).z())) {
        PhotoListPanelProvider.a(this.a).a(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider.1
 * JD-Core Version:    0.7.0.1
 */