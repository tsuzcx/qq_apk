package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class TroopAllMessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b;
  int c = 0;
  
  TroopAllMessageSearchDialog$5(TroopAllMessageSearchDialog paramTroopAllMessageSearchDialog)
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.jdField_b_of_type_Int = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScrollStateChanged, reach bottom, scrollState ");
      paramAbsListView.append(paramInt);
      paramAbsListView.append(" firstVisibleItem: ");
      paramAbsListView.append(this.c);
      paramAbsListView.append(", lastItem:");
      paramAbsListView.append(this.jdField_a_of_type_Int);
      paramAbsListView.append(", totalItemCount = ");
      paramAbsListView.append(this.jdField_b_of_type_Int);
      paramAbsListView.append(", mIsComplete: ");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.d);
      paramAbsListView.append(", requesting:");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_Boolean);
      paramAbsListView.append(", mSearchMode: ");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_Int);
      paramAbsListView.append(", mCurrentKeyword: ");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_JavaLangString);
      QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return;
    }
    if ((this.jdField_a_of_type_Int == i) && (paramInt == 0))
    {
      if ((this.c != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_Boolean))
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog;
        paramAbsListView.jdField_c_of_type_Boolean = true;
        if (paramAbsListView.jdField_b_of_type_Int == 0)
        {
          if (QLog.isColorLevel())
          {
            paramAbsListView = new StringBuilder();
            paramAbsListView.append("onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: ");
            paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.d);
            QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_JavaLangString, 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131718614));
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: ");
          paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.d);
          QLog.i("LinkMessageSearchDialog", 2, paramAbsListView.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.d)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714961));
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131718613));
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      if ((this.c == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.d) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714965));
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchTroopAllMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */