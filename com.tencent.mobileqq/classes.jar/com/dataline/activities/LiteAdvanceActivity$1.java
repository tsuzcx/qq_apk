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
    if (!LiteAdvanceActivity.a(this.a, paramBoolean))
    {
      LiteAdvanceActivity.a(this.a).setChecked(paramBoolean ^ true);
      QQToast.makeText(this.a, 1, HardCodeUtil.a(2131904133), 0).show(this.a.getTitleBarHeight());
    }
    else
    {
      LiteAdvanceActivity.b(this.a, paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.1
 * JD-Core Version:    0.7.0.1
 */