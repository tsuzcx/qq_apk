package com.tencent.biz.qqstory.view;

import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

public class WeShiGuideDialog$WeakViewDownloadListener
  implements URLDrawable.URLDrawableListener
{
  private final WeakReference a;
  
  public WeShiGuideDialog$WeakViewDownloadListener(TextView paramTextView)
  {
    this.a = new WeakReference(paramTextView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (TextView)this.a.get();
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.WeShiGuideDialog.WeakViewDownloadListener
 * JD-Core Version:    0.7.0.1
 */