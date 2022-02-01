package com.tencent.component.media.image.view;

public abstract interface AsyncImageable
{
  public static final int GL_MAX_TEXTURE_SIZE = 2048;
  
  public abstract String getAsyncImage();
  
  public abstract AsyncImageable.AsyncOptions getAsyncOptions();
  
  public abstract void setAsyncImage(String paramString);
  
  public abstract void setAsyncImage(String paramString, String... paramVarArgs);
  
  public abstract void setAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener);
  
  public abstract void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable
 * JD-Core Version:    0.7.0.1
 */