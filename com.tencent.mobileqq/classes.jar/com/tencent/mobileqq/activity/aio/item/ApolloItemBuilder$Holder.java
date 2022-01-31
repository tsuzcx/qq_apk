package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.qphone.base.util.QLog;

public class ApolloItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
  implements URLDrawable.URLDrawableListener
{
  public SpannableStringBuilder a;
  public ImageSpan a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public URLImageView a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public int e;
  public int f;
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloItemBuilder", 2, "onLoadSuccessed,mDrawableCacheKey:" + paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */