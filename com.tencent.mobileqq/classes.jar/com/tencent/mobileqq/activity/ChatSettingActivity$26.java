package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

class ChatSettingActivity$26
  implements IIconListener
{
  ChatSettingActivity$26(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.E != null) && (this.a.F != null) && (this.a.F.actionId == paramInt1) && (paramBitmap != null) && (paramInt2 == 200))
    {
      paramBitmap = this.a;
      ChatSettingActivity.a(paramBitmap, paramBitmap.F, this.a.E);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.26
 * JD-Core Version:    0.7.0.1
 */