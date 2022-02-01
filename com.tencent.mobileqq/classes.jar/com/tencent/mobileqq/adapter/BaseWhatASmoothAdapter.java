package com.tencent.mobileqq.adapter;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;

public abstract class BaseWhatASmoothAdapter
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  String a;
  protected Handler b;
  
  private final void a(View paramView, Object paramObject, int paramInt, BaseWhatASmoothAdapter.RunningMark paramRunningMark)
  {
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new BaseWhatASmoothAdapter.1(this, paramView, localObject, paramObject, paramInt, paramRunningMark);
    BaseWhatASmoothAdapter.RunningMark.a(paramRunningMark, true);
    BaseWhatASmoothAdapter.RunningMark.a(paramRunningMark, paramView);
    this.b.post(paramView);
  }
  
  protected abstract Object a(int paramInt);
  
  protected abstract void a(View paramView, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter
 * JD-Core Version:    0.7.0.1
 */