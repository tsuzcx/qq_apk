package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;

class ReadInJoyDeliverVideoActivity$3$1
  implements DialogInterface.OnClickListener
{
  ReadInJoyDeliverVideoActivity$3$1(ReadInJoyDeliverVideoActivity.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardSdkShareOption.a(this.a.this$0, true, "shareToQQ", ReadInJoyDeliverVideoActivity.a(this.a.this$0));
    this.a.this$0.moveTaskToBack(true);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.3.1
 * JD-Core Version:    0.7.0.1
 */