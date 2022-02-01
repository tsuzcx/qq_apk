package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;

class BaseChatPie$65
  implements DialogInterface.OnClickListener
{
  BaseChatPie$65(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.this$0.mContext, FavEmosmManageActivity.class);
    this.this$0.mContext.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.65
 * JD-Core Version:    0.7.0.1
 */