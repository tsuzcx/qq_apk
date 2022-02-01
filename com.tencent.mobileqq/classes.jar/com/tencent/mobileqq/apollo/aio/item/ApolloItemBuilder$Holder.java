package com.tencent.mobileqq.apollo.aio.item;

import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer;
import com.tencent.qphone.base.util.QLog;

public class ApolloItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
  implements URLDrawable.URLDrawableListener, IApolloItemBuilder.Holder
{
  public View A;
  public TextView B;
  public boolean C = false;
  public int a;
  public TextView b;
  public TextView c;
  public ImageView d;
  public RelativeLayout e;
  public SpannableStringBuilder f;
  public ImageSpan g;
  public int s;
  public URLImageView t;
  public ImageView u;
  public TextView v;
  public TextView w;
  public ImageView x;
  public ImageView y;
  public IApolloBrickPlayer z;
  
  public void a()
  {
    IApolloBrickPlayer localIApolloBrickPlayer = this.z;
    if (localIApolloBrickPlayer != null) {
      localIApolloBrickPlayer.pause();
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadSuccessed,mDrawableCacheKey:");
      ((StringBuilder)localObject).append(paramURLDrawable);
      QLog.d("[cmshow]ApolloItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */