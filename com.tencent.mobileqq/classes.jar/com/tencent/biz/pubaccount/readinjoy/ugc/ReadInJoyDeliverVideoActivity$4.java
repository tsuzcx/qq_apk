package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyDeliverVideoActivity$4
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyDeliverVideoActivity", 2, "qbShowShareResultDialog back");
      }
      ForwardSdkShareOption.a(this.a, true, "shareToQQ", ReadInJoyDeliverVideoActivity.a(this.a));
      Util.a(this.a, 0, "", "");
      this.a.finish();
      return;
    }
    ReadInJoyDeliverVideoActivity.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.4
 * JD-Core Version:    0.7.0.1
 */