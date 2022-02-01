package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import znl;

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
      znl.a(1, 2131696208);
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a(false);
    String str = String.format(BaseApplication.getContext().getString(2131695549), new Object[] { RedPacketShareFragment.b(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0), RedPacketShareFragment.c(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0) });
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a != null)
    {
      localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getAccount();
      localUserInfo.nickname = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getDisplayName(0, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.a.getCurrentAccountUin(), null);
    }
    QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$2.this$0.getActivity(), localUserInfo, this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getString(2131692048), str, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.2.1
 * JD-Core Version:    0.7.0.1
 */