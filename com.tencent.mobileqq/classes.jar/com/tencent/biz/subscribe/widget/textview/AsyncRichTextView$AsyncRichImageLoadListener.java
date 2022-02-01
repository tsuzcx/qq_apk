package com.tencent.biz.subscribe.widget.textview;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AsyncRichTextView$AsyncRichImageLoadListener
  implements URLDrawable.URLDrawableListener
{
  private WeakReference<AsyncRichTextView> a;
  
  public AsyncRichTextView$AsyncRichImageLoadListener(AsyncRichTextView paramAsyncRichTextView)
  {
    this.a = new WeakReference(paramAsyncRichTextView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AsyncRichTextView", 4, "onLoadSuccessed ");
    }
    paramURLDrawable = this.a;
    if ((paramURLDrawable != null) && (paramURLDrawable.get() != null)) {
      ((AsyncRichTextView)this.a.get()).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView.AsyncRichImageLoadListener
 * JD-Core Version:    0.7.0.1
 */