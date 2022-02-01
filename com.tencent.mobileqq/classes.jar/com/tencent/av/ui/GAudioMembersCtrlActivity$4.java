package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GAudioMembersCtrlActivity$4
  implements View.OnClickListener
{
  GAudioMembersCtrlActivity$4(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.4
 * JD-Core Version:    0.7.0.1
 */