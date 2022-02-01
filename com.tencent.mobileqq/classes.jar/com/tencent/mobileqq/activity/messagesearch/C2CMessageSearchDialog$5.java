package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class C2CMessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b;
  int c = 0;
  
  C2CMessageSearchDialog$5(C2CMessageSearchDialog paramC2CMessageSearchDialog)
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
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d);
      paramAbsListView.append(", requesting:");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean);
      paramAbsListView.append(", mSearchMode: ");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_Int);
      paramAbsListView.append(", mCurrentKeyword: ");
      paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_JavaLangString);
      QLog.i("C2CMessageSearchDialog", 2, paramAbsListView.toString());
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return;
    }
    if ((this.jdField_a_of_type_Int == i) && (paramInt == 0))
    {
      if ((this.c != 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean))
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog;
        paramAbsListView.jdField_c_of_type_Boolean = true;
        if (paramAbsListView.jdField_b_of_type_Int == 0)
        {
          if (QLog.isColorLevel())
          {
            paramAbsListView = new StringBuilder();
            paramAbsListView.append("onScrollStateChanged searchRoamMessageLocal >>>>> isComplete: ");
            paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d);
            QLog.i("C2CMessageSearchDialog", 2, paramAbsListView.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_JavaLangString, 2);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131718614));
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("onScrollStateChanged searchRoamMessageInCloud >>>>> isComplete: ");
          paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d);
          QLog.i("C2CMessageSearchDialog", 2, paramAbsListView.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701501));
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_AndroidContentContext.getString(2131718613));
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.b(2);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatSearch", "Slip_resultup", 0, 0, new String[0]);
        return;
      }
      if ((this.c == 0) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.d) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701506));
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */