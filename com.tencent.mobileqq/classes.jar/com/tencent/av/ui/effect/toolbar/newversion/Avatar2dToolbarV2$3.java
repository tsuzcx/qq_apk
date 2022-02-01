package com.tencent.av.ui.effect.toolbar.newversion;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Avatar2dToolbarV2$3
  implements View.OnClickListener
{
  Avatar2dToolbarV2$3(Avatar2dToolbarV2 paramAvatar2dToolbarV2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.hasCameraPermission()) {
      Avatar2dToolbarV2.access$100(this.a).setVisibility(8);
    } else {
      this.a.showPermissionTip();
    }
    Avatar2dToolbarV2.access$200(this.a).u();
    ReportController.b(null, "dc00898", "", "", "0X800BCE0", "0X800BCE0", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2.3
 * JD-Core Version:    0.7.0.1
 */