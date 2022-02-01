package com.tencent.mobileqq.activity.history;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class ChatHistoryTroopMediaFragment$1
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopMediaFragment$1(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, ActionSheet paramActionSheet, ArrayList paramArrayList) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView)) {
        if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getBaseActivity().getResources().getString(2131689887)))
        {
          paramView = this.jdField_a_of_type_JavaUtilArrayList;
          if ((paramView != null) && (paramView.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a.h();
          }
        }
        else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getBaseActivity().getResources().getString(2131693257)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.a(this.jdField_a_of_type_JavaUtilArrayList);
        }
        else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getBaseActivity().getResources().getString(2131693263)))
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.getBaseActivity(), 2131692653, 0).a();
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMediaFragment.b(this.jdField_a_of_type_JavaUtilArrayList);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment.1
 * JD-Core Version:    0.7.0.1
 */