package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyBaseListView$MultiScrollListener
  implements AbsListView.OnScrollListener
{
  List a = new ArrayList();
  
  void a()
  {
    this.a.clear();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.add(paramOnScrollListener);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
      try
      {
        localOnScrollListener.a(paramAbsListView, paramInt);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
      try
      {
        localOnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyBaseListView", 2, "onScroll exp", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.MultiScrollListener
 * JD-Core Version:    0.7.0.1
 */