package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;

public class LoadingMoreHelper
{
  protected int a = 5;
  protected ILoadMoreLayout b;
  protected LoadingMoreHelper.OnLoadMoreListener c;
  protected boolean d = false;
  Context e;
  
  public LoadingMoreHelper(ILoadMoreLayout paramILoadMoreLayout, Context paramContext)
  {
    this.b = paramILoadMoreLayout;
    this.e = paramContext;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(LoadingMoreHelper.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.c = paramOnLoadMoreListener;
    if (paramOnLoadMoreListener != null)
    {
      a(true);
      a(true, false);
    }
    this.b.setOnClickListener(new LoadingMoreHelper.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == paramBoolean) {
      return;
    }
    this.d = paramBoolean;
    if (paramBoolean)
    {
      this.b.setState(3);
      return;
    }
    this.b.setState(0);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.d) {
      return;
    }
    if (!paramBoolean1)
    {
      this.b.setState(5);
      return;
    }
    int i;
    if (paramBoolean2) {
      i = 3;
    } else {
      i = 4;
    }
    this.b.setState(i);
    if (!this.b.checkState(i)) {
      return;
    }
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.c;
    if (localOnLoadMoreListener != null) {
      localOnLoadMoreListener.bx_();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    if (this.b.getState() == 0) {
      return;
    }
    if (!this.b.checkState(2)) {
      return;
    }
    boolean bool = true;
    LoadingMoreHelper.OnLoadMoreListener localOnLoadMoreListener = this.c;
    if (localOnLoadMoreListener != null) {
      bool = localOnLoadMoreListener.a(paramBoolean);
    }
    if (bool) {
      this.b.setState(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.LoadingMoreHelper
 * JD-Core Version:    0.7.0.1
 */