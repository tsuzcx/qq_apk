package com.tencent.mobileqq.activity.messagesearch;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class MessageSearchDialog$5
  implements AbsListView.OnScrollListener
{
  int a = 0;
  int b = 0;
  
  MessageSearchDialog$5(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.c.b.getAdapter() == this.c.o) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramAbsListView = MessageSearchDialog.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged, scrollState = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", lastItem = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", totalItemCount = ");
      localStringBuilder.append(this.b);
      QLog.i(paramAbsListView, 2, localStringBuilder.toString());
    }
    int i = this.b;
    if (i == 0) {
      return;
    }
    if ((this.a == i) && (paramInt == 0))
    {
      if (QLog.isColorLevel())
      {
        paramAbsListView = MessageSearchDialog.m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged, reach bottom, lastItem = ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", totalItemCount = ");
        localStringBuilder.append(this.b);
        QLog.i(paramAbsListView, 2, localStringBuilder.toString());
      }
      MessageSearchDialog.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */