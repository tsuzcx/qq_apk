package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;

class ReadInJoyDeliverUGCActivity$17
  implements DialogInterface.OnDismissListener
{
  ReadInJoyDeliverUGCActivity$17(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ReadInJoyDeliverUGCActivity.f(this.a))
    {
      ReadInJoyDeliverUGCActivity.e(this.a, false);
      ReadInJoyDeliverUGCActivity.e(this.a);
      if (!ReadInJoyDeliverUGCActivity.g(this.a)) {
        ReadInJoyDeliverUGCActivity.d(this.a, 1, this.a.getString(2131718210));
      }
      if (ReadInJoyDeliverUGCActivity.a(this.a) != null) {
        ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.17
 * JD-Core Version:    0.7.0.1
 */