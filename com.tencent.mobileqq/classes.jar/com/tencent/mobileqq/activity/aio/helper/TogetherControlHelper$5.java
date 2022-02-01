package com.tencent.mobileqq.activity.aio.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.together.TogetherControlManager;

class TogetherControlHelper$5
  implements DialogInterface.OnClickListener
{
  TogetherControlHelper$5(TogetherControlHelper paramTogetherControlHelper, TogetherControlManager paramTogetherControlManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("video_tab", "clk_joinframe_cancel", 0, TogetherControlHelper.a(this.b).ae());
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.5
 * JD-Core Version:    0.7.0.1
 */