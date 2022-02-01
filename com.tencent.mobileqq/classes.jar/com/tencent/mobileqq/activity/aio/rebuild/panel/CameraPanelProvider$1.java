package com.tencent.mobileqq.activity.aio.rebuild.panel;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class CameraPanelProvider$1
  implements QQPermissionCallback
{
  CameraPanelProvider$1(CameraPanelProvider paramCameraPanelProvider) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(CameraPanelProvider.a(this.a).b(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.CameraPanelProvider.1
 * JD-Core Version:    0.7.0.1
 */