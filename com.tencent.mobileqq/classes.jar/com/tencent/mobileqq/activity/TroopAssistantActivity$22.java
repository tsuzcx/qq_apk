package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAssistantActivity$22
  implements ActionSheet.OnButtonClickListener
{
  TroopAssistantActivity$22(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity;
        paramView.a = new QQProgressNotifier(paramView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a.b(2, 2131694424, 1500);
    }
    else
    {
      int i = -1;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              paramInt = i;
            } else {
              paramInt = 3;
            }
          }
          else {
            paramInt = 2;
          }
        }
        else {
          paramInt = 4;
        }
      }
      else {
        paramInt = 1;
      }
      if (paramInt != this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.app.setTroopMsgFilterToServer(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, paramView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.22
 * JD-Core Version:    0.7.0.1
 */