package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.widget.pull2refresh.BaseViewHolder;

public abstract class WSVerticalBaseHolder<T>
  extends BaseViewHolder<T>
{
  public IWSItemView<T> c;
  public WSVerticalPageFragment d;
  public T e;
  
  public WSVerticalBaseHolder(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1);
    this.d = paramWSVerticalPageFragment;
    this.c = a(paramInt2);
  }
  
  public abstract IWSItemView<T> a(int paramInt);
  
  public abstract FrameLayout b();
  
  public void bindData(T paramT)
  {
    super.bindData(paramT);
    this.e = paramT;
  }
  
  public abstract void c(int paramInt);
  
  public abstract void d(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalBaseHolder
 * JD-Core Version:    0.7.0.1
 */