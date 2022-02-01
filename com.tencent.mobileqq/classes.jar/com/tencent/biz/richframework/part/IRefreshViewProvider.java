package com.tencent.biz.richframework.part;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract interface IRefreshViewProvider
{
  public abstract void a(MotionEvent paramMotionEvent);
  
  public abstract void a(RecyclerView paramRecyclerView);
  
  public abstract View getRefreshView();
  
  public abstract boolean i();
  
  public abstract void j();
  
  public abstract void setOnRefreshListener(IRefreshViewProvider.OnRefreshListener paramOnRefreshListener);
  
  public abstract void setRefreshing(boolean paramBoolean);
  
  public abstract void setState(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.IRefreshViewProvider
 * JD-Core Version:    0.7.0.1
 */