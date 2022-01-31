package com.tencent.av.redpacket.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import wim;

class RedPacketShareFragment$4$1
  implements Runnable
{
  RedPacketShareFragment$4$1(RedPacketShareFragment.4 param4, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.getActivity() == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.getActivity().sendBroadcast(localIntent);
      bcpw.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.getString(2131717236, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$4.this$0.b = true;
      return;
      wim.a(1, 2131717235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.4.1
 * JD-Core Version:    0.7.0.1
 */