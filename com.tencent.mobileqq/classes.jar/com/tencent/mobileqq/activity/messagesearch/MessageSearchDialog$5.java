package com.tencent.mobileqq.activity.messagesearch;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class MessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  MessageSearchDialog$5(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramAbsListView = MessageSearchDialog.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged, scrollState = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", lastItem = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", totalItemCount = ");
      localStringBuilder.append(this.b);
      QLog.i(paramAbsListView, 2, localStringBuilder.toString());
    }
    int i = this.b;
    if (i == 0) {
      return;
    }
    if ((this.jdField_a_of_type_Int == i) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        paramAbsListView = MessageSearchDialog.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged, reach bottom, lastItem = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", totalItemCount = ");
        localStringBuilder.append(this.b);
        QLog.i(paramAbsListView, 2, localStringBuilder.toString());
      }
      MessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */