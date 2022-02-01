package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class AccountDetailBaseAdapter$13
  extends URLDrawableDownListener.Adapter
{
  AccountDetailBaseAdapter$13(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (!this.a.f) {
      this.a.l();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "onLoadFailed ,cause = " + paramThrowable);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {}
    do
    {
      return;
      this.a.k();
      if ((paramView instanceof ImageView))
      {
        ((URLImageView)paramView).setImageDrawable(paramURLDrawable);
        paramView.requestLayout();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountDetailBaseAdapter", 2, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.13
 * JD-Core Version:    0.7.0.1
 */