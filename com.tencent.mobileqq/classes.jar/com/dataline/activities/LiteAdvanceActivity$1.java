package com.dataline.activities;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class LiteAdvanceActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  LiteAdvanceActivity$1(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      Switch localSwitch = LiteAdvanceActivity.a(this.a);
      if (!paramBoolean)
      {
        bool = true;
        localSwitch.setChecked(bool);
        QQToast.a(this.a, 1, HardCodeUtil.a(2131706220), 0).b(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      LiteAdvanceActivity.b(this.a, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.1
 * JD-Core Version:    0.7.0.1
 */