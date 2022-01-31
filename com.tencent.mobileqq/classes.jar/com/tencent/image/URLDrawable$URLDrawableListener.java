package com.tencent.image;

public abstract interface URLDrawable$URLDrawableListener
{
  public abstract void onLoadCanceled(URLDrawable paramURLDrawable);
  
  public abstract void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable);
  
  public abstract void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt);
  
  public abstract void onLoadSuccessed(URLDrawable paramURLDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable.URLDrawableListener
 * JD-Core Version:    0.7.0.1
 */