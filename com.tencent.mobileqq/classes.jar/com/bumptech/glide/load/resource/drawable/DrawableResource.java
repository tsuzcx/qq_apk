package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable>
  implements Initializable, Resource<T>
{
  protected final T a;
  
  public DrawableResource(T paramT)
  {
    this.a = ((Drawable)Preconditions.a(paramT));
  }
  
  public void a()
  {
    Drawable localDrawable = this.a;
    if ((localDrawable instanceof BitmapDrawable))
    {
      ((BitmapDrawable)localDrawable).getBitmap().prepareToDraw();
      return;
    }
    if ((localDrawable instanceof GifDrawable)) {
      ((GifDrawable)localDrawable).b().prepareToDraw();
    }
  }
  
  @NonNull
  public final T b()
  {
    Drawable.ConstantState localConstantState = this.a.getConstantState();
    if (localConstantState == null) {
      return this.a;
    }
    return localConstantState.newDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.drawable.DrawableResource
 * JD-Core Version:    0.7.0.1
 */