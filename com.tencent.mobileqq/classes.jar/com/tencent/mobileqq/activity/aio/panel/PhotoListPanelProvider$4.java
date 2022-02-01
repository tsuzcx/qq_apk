package com.tencent.mobileqq.activity.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

class PhotoListPanelProvider$4
  implements QQPermissionCallback
{
  PhotoListPanelProvider$4(PhotoListPanelProvider paramPhotoListPanelProvider, XPanelContainer paramXPanelContainer) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(PhotoListPanelProvider.a(this.b).aX());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PhotoListPanelProvider.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider.4
 * JD-Core Version:    0.7.0.1
 */