package com.tencent.av.ui;

import com.tencent.av.tips.TipsUtil;
import com.tencent.qphone.base.util.BaseApplication;

class MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable$1
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable$1(MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable paramInviteUserNoticeRunnable) {}
  
  public void run()
  {
    String str1;
    if (this.a.a == 1)
    {
      str1 = String.format(BaseApplication.getContext().getString(2131893254), new Object[] { this.a.b });
    }
    else
    {
      str1 = BaseApplication.getContext().getString(2131893255);
      String str2 = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a);
      localStringBuilder.append("");
      str1 = String.format(str1, new Object[] { str2, localStringBuilder.toString() });
    }
    TipsUtil.a(this.a.this$0.al, 3010, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1
 * JD-Core Version:    0.7.0.1
 */