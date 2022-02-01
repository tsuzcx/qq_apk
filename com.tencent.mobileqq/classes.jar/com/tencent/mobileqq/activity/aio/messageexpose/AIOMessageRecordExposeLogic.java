package com.tencent.mobileqq.activity.aio.messageexpose;

import android.widget.ListAdapter;
import com.tencent.biz.officialaccount.OfficialAccountExposeBusiness;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceExposeBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.AnonymousExposeBusiness;
import com.tencent.mobileqq.troop.data.TroopGrayTipsMsgExpose;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class AIOMessageRecordExposeLogic
{
  private int jdField_a_of_type_Int = -1;
  private OnAIOMessageExposeListener[] jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioMessageexposeOnAIOMessageExposeListener = { new ECommerceExposeBusiness(), new MessageFoldExposeBusiness(), new WriteTogetherMsgExposeBusi(), new OfficialAccountExposeBusiness(), new TroopGrayTipsMsgExpose(), new AnonymousExposeBusiness() };
  private int b = -1;
  
  private void a(QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOMessageRecordExposeLogic", 2, "reportListItemMessage : exposeItemIndex -> " + paramInt);
    }
    if (paramInt >= 0)
    {
      paramListView = paramListView.getAdapter();
      if ((paramListView != null) && (paramInt < paramListView.getCount()))
      {
        paramListView = paramListView.getItem(paramInt);
        if ((paramListView instanceof MessageRecord))
        {
          paramListView = (MessageRecord)paramListView;
          OnAIOMessageExposeListener[] arrayOfOnAIOMessageExposeListener = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioMessageexposeOnAIOMessageExposeListener;
          int i = arrayOfOnAIOMessageExposeListener.length;
          paramInt = 0;
          while (paramInt < i)
          {
            arrayOfOnAIOMessageExposeListener[paramInt].a(paramQQAppInterface, paramListView);
            paramInt += 1;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.d("AIOMessageRecordExposeLogic", 2, "reportExposeOnShowFirst : curFirstPosition -> " + j + ", childCount -> " + k);
    }
    int i = j;
    while (i < j + k)
    {
      a(paramQQAppInterface, paramListView, i);
      i += 1;
    }
    this.jdField_a_of_type_Int = paramListView.mFirstPosition;
    this.b = paramListView.getChildCount();
  }
  
  public void b(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if ((j == this.jdField_a_of_type_Int) && (this.b == k)) {
      return;
    }
    int i = -1;
    if (j < this.jdField_a_of_type_Int) {
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOMessageRecordExposeLogic", 2, "handleListViewScroll : curExposeItemIndex -> " + i + ", curFirstPosition -> " + j + ", childCount -> " + k);
      }
      this.jdField_a_of_type_Int = j;
      this.b = k;
      a(paramQQAppInterface, paramListView, i);
      return;
      if (j + k > this.jdField_a_of_type_Int + this.b) {
        i = j + k - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeLogic
 * JD-Core Version:    0.7.0.1
 */