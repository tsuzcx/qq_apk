package com.tencent.mobileqq.activity.aio.core;

import ahus;
import android.content.res.Resources;
import bdla;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class BaseChatPie$89
  implements ahus
{
  BaseChatPie$89(BaseChatPie paramBaseChatPie) {}
  
  public boolean onOverMaxSelectCount(int paramInt)
  {
    String str = String.format(this.this$0.getActivity().getString(2131698234), new Object[] { Integer.valueOf(paramInt) });
    QQToast.a(this.this$0.getActivity(), str, 0).b(this.this$0.getActivity().getResources().getDimensionPixelSize(2131299080));
    bdla.b(this.this$0.app, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.89
 * JD-Core Version:    0.7.0.1
 */