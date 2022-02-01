package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIORevokeMsgHelper$1
  implements ActionSheet.OnButtonClickListener
{
  AIORevokeMsgHelper$1(AIORevokeMsgHelper paramAIORevokeMsgHelper, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        AIORevokeMsgHelper.a(this.c, "0X800A7F6", this.a);
      }
    }
    else
    {
      if (AIORevokeMsgHelper.a(this.c) != null)
      {
        paramView = this.c;
        AIORevokeMsgHelper.a(paramView, AIORevokeMsgHelper.a(paramView));
      }
      AIORevokeMsgHelper.a(this.c, "0X800A7F5", this.a);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */