package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtils;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MoveToGroupActivity$3
  implements View.OnClickListener
{
  MoveToGroupActivity$3(MoveToGroupActivity paramMoveToGroupActivity, GroupManagerInputTextWatcher paramGroupManagerInputTextWatcher) {}
  
  public void onClick(View paramView)
  {
    int k = 0;
    int i;
    int j;
    label37:
    QQToast localQQToast;
    if (MoveToGroupActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity) == null)
    {
      i = 0;
      int m = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity.app, null);
      if ((m & 0x2) == 0) {
        break label120;
      }
      j = 1;
      if ((m & 0x4) != 0) {
        k = 1;
      }
      if ((j == 0) && (k == 0)) {
        break label125;
      }
      if (30 != i) {
        break label168;
      }
      localQQToast = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity);
      localQQToast.d(2000);
      localQQToast.c(2131719975);
      localQQToast.a();
    }
    label168:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = MoveToGroupActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity).size();
      break;
      label120:
      j = 0;
      break label37;
      label125:
      if (16 == i)
      {
        localQQToast = new QQToast(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity);
        localQQToast.d(2000);
        localQQToast.c(2131719974);
        localQQToast.a();
      }
      else
      {
        MoveToGroupActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity, DialogUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity, 2131693127, 2131693133, null, this.jdField_a_of_type_ComTencentMobileqqUtilsGroupManagerInputTextWatcher, MoveToGroupActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity), null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.3
 * JD-Core Version:    0.7.0.1
 */