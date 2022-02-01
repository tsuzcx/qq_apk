package com.tencent.mobileqq.adapter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment.OnChangeSwitchListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AppletsListAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  AppletsListAdapter$1(AppletsListAdapter paramAppletsListAdapter) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = ((Integer)paramCompoundButton.getTag()).intValue();
    AppletItem localAppletItem = (AppletItem)this.a.a.get(i);
    AppletsListAdapter.a(this.a).a(paramCompoundButton, paramBoolean, localAppletItem);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AppletsListAdapter.1
 * JD-Core Version:    0.7.0.1
 */