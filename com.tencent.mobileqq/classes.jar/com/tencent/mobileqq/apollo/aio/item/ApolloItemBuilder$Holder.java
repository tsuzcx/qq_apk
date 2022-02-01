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
import com.tencent.mobileqq.apollo.player.api.IApolloBrickPlayer;
import com.tencent.qphone.base.util.QLog;

public class ApolloItemBuilder$Holder
  extends BaseBubbleBuilder.ViewHolder
  implements URLDrawable.URLDrawableListener, IApolloItemBuilder.Holder
{
  public SpannableStringBuilder a;
  public ImageSpan a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public URLImageView a;
  public IApolloBrickPlayer a;
  public boolean a;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public int e;
  public TextView e;
  public int f;
  
  public ApolloItemBuilder$Holder()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    IApolloBrickPlayer localIApolloBrickPlayer = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiIApolloBrickPlayer;
    if (localIApolloBrickPlayer != null) {
      localIApolloBrickPlayer.pause();
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = this.d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.Holder
 * JD-Core Version:    0.7.0.1
 */