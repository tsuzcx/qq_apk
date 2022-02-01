package com.tencent.mobileqq.activity.aio.core;

import amip;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class BaseChatPie$15
  implements DialogInterface.OnClickListener
{
  BaseChatPie$15(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.this$0.mActivity, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", amip.Y);
    this.this$0.mActivity.startActivityForResult(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.15
 * JD-Core Version:    0.7.0.1
 */