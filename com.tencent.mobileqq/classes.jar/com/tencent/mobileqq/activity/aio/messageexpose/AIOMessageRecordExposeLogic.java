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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportListItemMessage : exposeItemIndex -> ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AIOMessageRecordExposeLogic", 2, ((StringBuilder)localObject).toString());
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
          localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqActivityAioMessageexposeOnAIOMessageExposeListener;
          int i = localObject.length;
          paramInt = 0;
          while (paramInt < i)
          {
            localObject[paramInt].a(paramQQAppInterface, paramListView);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportExposeOnShowFirst : curFirstPosition -> ");
      localStringBuilder.append(j);
      localStringBuilder.append(", childCount -> ");
      localStringBuilder.append(k);
      QLog.d("AIOMessageRecordExposeLogic", 2, localStringBuilder.toString());
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
    int m = this.jdField_a_of_type_Int;
    if (j < m)
    {
      i = j;
    }
    else
    {
      int n = j + k;
      if (n > m + this.b) {
        i = n - 1;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleListViewScroll : curExposeItemIndex -> ");
      localStringBuilder.append(i);
      localStringBuilder.append(", curFirstPosition -> ");
      localStringBuilder.append(j);
      localStringBuilder.append(", childCount -> ");
      localStringBuilder.append(k);
      QLog.d("AIOMessageRecordExposeLogic", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = j;
    this.b = k;
    a(paramQQAppInterface, paramListView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeLogic
 * JD-Core Version:    0.7.0.1
 */