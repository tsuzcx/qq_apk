package com.tencent.mobileqq.activity.qwallet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class SendHbActivity$4
  implements DialogInterface.OnClickListener
{
  SendHbActivity$4(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("hb_id", SendHbActivity.access$100(this.a));
    paramDialogInterface.putExtra("send_uin", SendHbActivity.access$200(this.a));
    paramDialogInterface.putExtra("hb_type", "1");
    paramDialogInterface.putExtra("forward_text", this.a.getString(2131697026));
    if (SendHbActivity.access$300(this.a)) {
      paramDialogInterface.putExtra("item", 1);
    }
    paramDialogInterface.putExtra("forward_type", 17);
    paramDialogInterface.putExtra("invoke_from", "qwallet");
    ForwardBaseOption.a(this.a, paramDialogInterface);
    this.a.addUploadData(SendHbActivity.access$200(this.a), this.a.getProcessType(), "hongbao.wrapped.send", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity.4
 * JD-Core Version:    0.7.0.1
 */