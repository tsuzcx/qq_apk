package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory
  implements TransitionFactory<Drawable>
{
  private final int a;
  private final boolean b;
  private DrawableCrossFadeTransition c;
  
  protected DrawableCrossFadeFactory(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  private Transition<Drawable> a()
  {
    if (this.c == null) {
      this.c = new DrawableCrossFadeTransition(this.a, this.b);
    }
    return this.c;
  }
  
  public Transition<Drawable> a(DataSource paramDataSource, boolean paramBoolean)
  {
    if (paramDataSource == DataSource.MEMORY_CACHE) {
      return NoTransition.b();
    }
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.DrawableCrossFadeFactory
 * JD-Core Version:    0.7.0.1
 */