package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bfpr;
import bfpy;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import vvp;

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
      vvp.a(1, 2131631056);
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a(false);
    String str = String.format(BaseApplication.getContext().getString(2131630405), new Object[] { RedPacketShareFragment.b(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0), RedPacketShareFragment.c(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0) });
    bfpy localbfpy = bfpy.a();
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a != null)
    {
      localbfpy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getAccount();
      localbfpy.b = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getDisplayName(0, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getCurrentAccountUin(), null);
    }
    bfpr.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.getActivity(), localbfpy, this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getString(2131626640), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.2.1
 * JD-Core Version:    0.7.0.1
 */