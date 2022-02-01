package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public abstract interface TransitionFactory<R>
{
  public abstract Transition<R> a(DataSource paramDataSource, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.TransitionFactory
 * JD-Core Version:    0.7.0.1
 */