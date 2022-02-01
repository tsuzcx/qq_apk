package com.tencent.mobileqq.activity.aio.core;

import ahbs;
import android.content.res.Resources;
import bcef;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class BaseChatPie$90
  implements ahbs
{
  BaseChatPie$90(BaseChatPie paramBaseChatPie) {}
  
  public boolean onOverMaxSelectCount(int paramInt)
  {
    String str = String.format(this.this$0.getActivity().getString(2131697950), new Object[] { Integer.valueOf(paramInt) });
    QQToast.a(this.this$0.getActivity(), str, 0).b(this.this$0.getActivity().getResources().getDimensionPixelSize(2131299076));
    bcef.b(this.this$0.app, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.90
 * JD-Core Version:    0.7.0.1
 */