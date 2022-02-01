package com.tencent.mobileqq.activity.richmedia;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.RDMEtraMsgCollector;

class EditLocalVideoActivity$8
  implements ActionSheet.OnButtonClickListener
{
  EditLocalVideoActivity$8(EditLocalVideoActivity paramEditLocalVideoActivity, Bundle paramBundle) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = "[Actvity]" + getClass().getSimpleName() + " QQCustomDialog click :" + HardCodeUtil.a(2131703693);
    RDMEtraMsgCollector.getInstance().addUserAction(paramView);
    EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).dismiss();
    EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.8
 * JD-Core Version:    0.7.0.1
 */