package com.tencent.av.redpacket.ui;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class RedPacketShareFragment$3$1
  implements Runnable
{
  RedPacketShareFragment$3$1(RedPacketShareFragment.3 param3, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0.getActivity() == null) || (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0);
      QRUtils.a(1, 2131696460);
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0.a(false);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.a == 2)
    {
      localObject = new RedPacketShareFragment.3.1.1(this);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0.a, 0, true, RedPacketShareFragment.d(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0));
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.a == 3)
    {
      localObject = new RedPacketShareFragment.3.1.2(this);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0, String.valueOf(System.currentTimeMillis()));
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0.a, 1, true, RedPacketShareFragment.d(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0));
      return;
    }
    RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$3.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.3.1
 * JD-Core Version:    0.7.0.1
 */