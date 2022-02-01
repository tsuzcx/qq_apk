package com.tencent.mobileqq.activity.aio.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.widget.QQToast;

class TogetherControlHelper$4
  implements DialogInterface.OnClickListener
{
  TogetherControlHelper$4(TogetherControlHelper paramTogetherControlHelper, TogetherControlManager paramTogetherControlManager, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a("video_tab", "clk_joinframe_join", 0, TogetherControlHelper.a(this.c).ae());
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.a(2, 1, TogetherControlHelper.a(this.c).ae());
    if ((paramDialogInterface != null) && (paramDialogInterface.p != 3))
    {
      TogetherControlHelper.i(this.c);
      return;
    }
    QQToast.makeText(TogetherControlHelper.h(this.c), 0, this.b, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.4
 * JD-Core Version:    0.7.0.1
 */