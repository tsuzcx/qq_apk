package com.tencent.av.ui.effect.toolbar.newversion;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Avatar2dToolbarV2$5
  implements View.OnClickListener
{
  Avatar2dToolbarV2$5(Avatar2dToolbarV2 paramAvatar2dToolbarV2) {}
  
  public void onClick(View paramView)
  {
    this.a.requestCameraPermission(AudioHelper.c());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2.5
 * JD-Core Version:    0.7.0.1
 */