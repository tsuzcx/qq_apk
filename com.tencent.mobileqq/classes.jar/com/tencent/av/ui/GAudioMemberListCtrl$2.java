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
    if (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c)
    {
      if (this.a.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      } else if (this.a.jdField_a_of_type_Int == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      }
    }
    else if (this.a.jdField_a_of_type_Int == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
    } else if (this.a.jdField_a_of_type_Int == 2) {
      ReportController.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
    }
    if ((((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c) && (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).d))
    {
      QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695708, 1).a();
      if (this.a.jdField_a_of_type_Int == 1) {
        localObject = "0x8007CB5";
      } else {
        localObject = "0x8007CB6";
      }
      DoodleUtils.a((String)localObject);
    }
    else if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a(((GAudioMemberListCtrl.GAudioMemberInfo)localObject).a, ((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c ^ true)) && (((GAudioMemberListCtrl.GAudioMemberInfo)localObject).c))
    {
      QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131695547, 1).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMemberListCtrl.2
 * JD-Core Version:    0.7.0.1
 */