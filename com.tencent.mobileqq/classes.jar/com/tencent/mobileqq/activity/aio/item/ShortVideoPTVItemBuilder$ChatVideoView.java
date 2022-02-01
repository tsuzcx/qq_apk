package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.CircleBubbleImageView;
import java.net.URL;

class ShortVideoPTVItemBuilder$ChatVideoView
  extends CircleBubbleImageView
{
  URLDrawable a;
  URLDrawable b;
  
  public ShortVideoPTVItemBuilder$ChatVideoView(Context paramContext)
  {
    super(paramContext);
    a(true);
  }
  
  public void a(URLDrawable paramURLDrawable)
  {
    URLDrawable localURLDrawable = this.a;
    if (localURLDrawable != null) {
      localURLDrawable.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.a = paramURLDrawable;
    paramURLDrawable.startDownload();
  }
  
  public boolean a(String paramString)
  {
    URLDrawable localURLDrawable = this.b;
    return (localURLDrawable == null) || (!localURLDrawable.getURL().getPath().equals(paramString));
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    setImageDrawable(paramURLDrawable);
    if (this.b != paramURLDrawable) {
      this.b = paramURLDrawable;
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.a)
    {
      b(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.a) {
      b(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null)
    {
      paramDrawable.setURLDrawableListener(null);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.ChatVideoView
 * JD-Core Version:    0.7.0.1
 */