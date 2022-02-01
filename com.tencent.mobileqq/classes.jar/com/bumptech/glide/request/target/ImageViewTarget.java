package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public abstract class ImageViewTarget<Z>
  extends ViewTarget<ImageView, Z>
  implements Transition.ViewAdapter
{
  @Nullable
  private Animatable b;
  
  public ImageViewTarget(ImageView paramImageView)
  {
    super(paramImageView);
  }
  
  private void b(@Nullable Z paramZ)
  {
    a(paramZ);
    c(paramZ);
  }
  
  private void c(@Nullable Z paramZ)
  {
    if ((paramZ instanceof Animatable))
    {
      this.b = ((Animatable)paramZ);
      this.b.start();
      return;
    }
    this.b = null;
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    super.a(paramDrawable);
    Animatable localAnimatable = this.b;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
    b(null);
    e(paramDrawable);
  }
  
  protected abstract void a(@Nullable Z paramZ);
  
  public void a(@NonNull Z paramZ, @Nullable Transition<? super Z> paramTransition)
  {
    if ((paramTransition != null) && (paramTransition.a(paramZ, this)))
    {
      c(paramZ);
      return;
    }
    b(paramZ);
  }
  
  @Nullable
  public Drawable b()
  {
    return ((ImageView)this.a).getDrawable();
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    super.b(paramDrawable);
    b(null);
    e(paramDrawable);
  }
  
  public void c()
  {
    Animatable localAnimatable = this.b;
    if (localAnimatable != null) {
      localAnimatable.start();
    }
  }
  
  public void c(@Nullable Drawable paramDrawable)
  {
    super.c(paramDrawable);
    b(null);
    e(paramDrawable);
  }
  
  public void d()
  {
    Animatable localAnimatable = this.b;
    if (localAnimatable != null) {
      localAnimatable.stop();
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    ((ImageView)this.a).setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ImageViewTarget
 * JD-Core Version:    0.7.0.1
 */