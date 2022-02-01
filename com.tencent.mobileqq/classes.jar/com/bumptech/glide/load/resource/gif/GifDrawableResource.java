package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource
  extends DrawableResource<GifDrawable>
  implements Initializable
{
  public GifDrawableResource(GifDrawable paramGifDrawable)
  {
    super(paramGifDrawable);
  }
  
  public void a()
  {
    ((GifDrawable)this.a).b().prepareToDraw();
  }
  
  @NonNull
  public Class<GifDrawable> c()
  {
    return GifDrawable.class;
  }
  
  public int e()
  {
    return ((GifDrawable)this.a).a();
  }
  
  public void f()
  {
    ((GifDrawable)this.a).stop();
    ((GifDrawable)this.a).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifDrawableResource
 * JD-Core Version:    0.7.0.1
 */