package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoCoverFragment$5
  extends URLDrawableDownListener.Adapter
{
  VideoCoverFragment$5(VideoCoverFragment paramVideoCoverFragment) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      int i = paramURLDrawable.getIntrinsicWidth();
      int j = paramURLDrawable.getIntrinsicHeight();
      localLayoutParams.width = (AIOUtils.b(23.0F, VideoCoverFragment.i(this.a).getResources()) * i / j);
      paramView.setLayoutParams(localLayoutParams);
      ((URLImageView)paramView).setImageDrawable(paramURLDrawable);
      paramView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.5
 * JD-Core Version:    0.7.0.1
 */