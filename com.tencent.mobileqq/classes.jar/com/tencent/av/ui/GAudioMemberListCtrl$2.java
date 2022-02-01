package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class GAudioMemberListCtrl$2
  implements View.OnClickListener
{
  GAudioMemberListCtrl$2(GAudioMemberListCtrl paramGAudioMemberListCtrl) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (GAudioMemberListCtrl.GAudioMemberInfo)paramView.getTag();
    if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).i)
    {
      if (this.a.c == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      } else if (this.a.c == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      }
    }
    else if (this.a.c == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
    } else if (this.a.c == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
    }
    if ((((GAudioMemberListCtrl.GAudioMemberInfo)localObject).i) && (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).j))
    {
      QQToast.makeText((Context)this.a.a.get(), 2131893467, 1).show();
      if (this.a.c == 1) {
        localObject = "0x8007CB5";
      } else {
        localObject = "0x8007CB6";
      }
      DoodleUtils.a((String)localObject);
    }
    else if ((this.a.d.a(((GAudioMemberListCtrl.GAudioMemberInfo)localObject).a, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).i ^ true)) && (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).i))
    {
      QQToast.makeText((Context)this.a.a.get(), 2131893306, 1).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.2
 * JD-Core Version:    0.7.0.1
 */