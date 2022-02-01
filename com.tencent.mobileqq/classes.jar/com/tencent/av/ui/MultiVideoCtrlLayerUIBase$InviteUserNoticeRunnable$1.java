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
    if (this.a.jdField_a_of_type_Int == 1)
    {
      str1 = String.format(BaseApplication.getContext().getString(2131695495), new Object[] { this.a.jdField_a_of_type_JavaLangString });
    }
    else
    {
      str1 = BaseApplication.getContext().getString(2131695496);
      String str2 = this.a.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.jdField_a_of_type_Int);
      localStringBuilder.append("");
      str1 = String.format(str1, new Object[] { str2, localStringBuilder.toString() });
    }
    TipsUtil.a(this.a.this$0.a, 3010, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.InviteUserNoticeRunnable.1
 * JD-Core Version:    0.7.0.1
 */