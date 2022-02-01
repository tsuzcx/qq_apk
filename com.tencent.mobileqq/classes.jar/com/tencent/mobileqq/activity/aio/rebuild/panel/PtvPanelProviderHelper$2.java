package com.tencent.mobileqq.activity.aio.rebuild.panel;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class PtvPanelProviderHelper$2
  implements QQPermissionCallback
{
  PtvPanelProviderHelper$2(PtvPanelProviderHelper paramPtvPanelProviderHelper) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(PtvPanelProviderHelper.a(this.a).a());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.PtvPanelProviderHelper.2
 * JD-Core Version:    0.7.0.1
 */