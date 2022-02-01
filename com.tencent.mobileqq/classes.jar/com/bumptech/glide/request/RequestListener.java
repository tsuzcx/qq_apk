package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

public abstract interface RequestListener<R>
{
  public abstract boolean a(@Nullable GlideException paramGlideException, Object paramObject, Target<R> paramTarget, boolean paramBoolean);
  
  public abstract boolean a(R paramR, Object paramObject, Target<R> paramTarget, DataSource paramDataSource, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.RequestListener
 * JD-Core Version:    0.7.0.1
 */