package com.tencent.mobileqq.activity.qwallet;

import ajjy;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import awqx;
import babp;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

class RedPacketVoiceFragment$3
  implements Runnable
{
  RedPacketVoiceFragment$3(RedPacketVoiceFragment paramRedPacketVoiceFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.c()) {
      return;
    }
    label51:
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.b.setText(ajjy.a(2131647509));
      RedPacketVoiceFragment.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      this.this$0.o();
      if (RedPacketVoiceFragment.a(this.this$0))
      {
        localQQAppInterface = this.this$0.getActivity().app;
        if (!this.jdField_a_of_type_Boolean) {
          break label233;
        }
      }
    }
    label233:
    for (int i = 1;; i = 0)
    {
      awqx.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.result", 0, i, this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title.length() + "", this.this$0.getActivity().app.getCurrentAccountUin(), babp.e() + "|" + babp.i(), "");
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
      if (RedPacketVoiceFragment.a(this.this$0) == null) {
        break;
      }
      RedPacketVoiceFragment.a(this.this$0).removeCallbacksAndMessages(null);
      return;
      this.this$0.b.setText(this.this$0.getResources().getString(2131629962));
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment.3
 * JD-Core Version:    0.7.0.1
 */