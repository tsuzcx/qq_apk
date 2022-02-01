package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ReadInJoyDeliverUGCActivity$8
  implements DialogInterface.OnDismissListener
{
  ReadInJoyDeliverUGCActivity$8(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ReadInJoyDeliverUGCActivity.b(this.a, false);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverUGCActivity.8.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.8
 * JD-Core Version:    0.7.0.1
 */