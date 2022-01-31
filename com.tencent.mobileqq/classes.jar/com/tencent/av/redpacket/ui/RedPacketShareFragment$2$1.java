package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bgyp;
import bgyw;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import wij;

class RedPacketShareFragment$2$1
  implements Runnable
{
  RedPacketShareFragment$2$1(RedPacketShareFragment.2 param2, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.getActivity() == null) || (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0);
      wij.a(1, 2131696769);
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a(false);
    String str = String.format(BaseApplication.getContext().getString(2131696106), new Object[] { RedPacketShareFragment.b(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0), RedPacketShareFragment.c(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0) });
    bgyw localbgyw = bgyw.a();
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a != null)
    {
      localbgyw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getAccount();
      localbgyw.b = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getDisplayName(0, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getCurrentAccountUin(), null);
    }
    bgyp.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.getActivity(), localbgyw, this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getString(2131692226), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.2.1
 * JD-Core Version:    0.7.0.1
 */