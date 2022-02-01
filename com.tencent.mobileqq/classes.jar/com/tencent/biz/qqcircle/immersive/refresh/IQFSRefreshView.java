package com.tencent.biz.qqcircle.immersive.refresh;

import android.view.View;

public abstract interface IQFSRefreshView
{
  public abstract void a(QFSPullRefreshLayout paramQFSPullRefreshLayout);
  
  public abstract void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, float paramFloat);
  
  public abstract void a(QFSPullRefreshLayout paramQFSPullRefreshLayout, boolean paramBoolean);
  
  public abstract void b(QFSPullRefreshLayout paramQFSPullRefreshLayout);
  
  public abstract View getRefreshView();
  
  public abstract int getStartRefreshDistance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.refresh.IQFSRefreshView
 * JD-Core Version:    0.7.0.1
 */