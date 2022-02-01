package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

class ChatSettingActivity$25
  implements IIconListener
{
  ChatSettingActivity$25(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.h != null) && (this.a.a != null) && (this.a.a.actionId == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      ChatSettingActivity.a(this.a, this.a.a, this.a.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.25
 * JD-Core Version:    0.7.0.1
 */