package com.tencent.mobileqq.activity.qwallet;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class RedPacketKuaKuaFragment$3
  implements Runnable
{
  RedPacketKuaKuaFragment$3(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void run()
  {
    if (this.this$0.b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "ContactUtils.getBuddyNickName:getActivity() == null || getActivity().isFinishing()");
      }
      return;
    }
    ContactUtils.getBuddyNickName(this.this$0.getActivity().app, RedPacketKuaKuaFragment.a(this.this$0).senderuin, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment.3
 * JD-Core Version:    0.7.0.1
 */