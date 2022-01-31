package com.tencent.component.media.image.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;

public class AsyncImageView
  extends ExtendImageView
  implements AsyncImageable
{
  private final AsyncImageable.AsyncImageableImpl a = new AsyncImageable.AsyncImageableImpl(this, this);
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String getAsyncImage()
  {
    return this.a.getAsyncImage();
  }
  
  public AsyncImageable.AsyncOptions getAsyncOptions()
  {
    return this.a.getAsyncOptions();
  }
  
  public void setAsyncAlwaysLoad(boolean paramBoolean)
  {
    getAsyncOptions().setAlwaysLoad(paramBoolean);
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    getAsyncOptions().setClipSize(paramInt1, paramInt2);
  }
  
  public void setAsyncDefaultImage(int paramInt)
  {
    getAsyncOptions().setDefaultImage(paramInt);
  }
  
  public void setAsyncDefaultImage(Drawable paramDrawable)
  {
    getAsyncOptions().setDefaultImage(paramDrawable);
  }
  
  public void setAsyncFailImage(int paramInt)
  {
    getAsyncOptions().setFailImage(paramInt);
  }
  
  public void setAsyncFailImage(Drawable paramDrawable)
  {
    getAsyncOptions().setFailImage(paramDrawable);
  }
  
  public void setAsyncImage(String paramString)
  {
    this.a.setAsyncImage(paramString);
  }
  
  public void setAsyncImage(String paramString, String... paramVarArgs)
  {
    this.a.setAsyncImage(paramString, paramVarArgs);
  }
  
  public void setAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.a.setAsyncImageListener(paramAsyncImageListener);
  }
  
  public void setAsyncImageProcessor(ImageProcessor paramImageProcessor)
  {
    getAsyncOptions().setImageProcessor(paramImageProcessor);
  }
  
  public void setAsyncJustCover(boolean paramBoolean)
  {
    getAsyncOptions().setJustCover(paramBoolean);
  }
  
  public void setAsyncPreferQuality(boolean paramBoolean)
  {
    getAsyncOptions().setPreferQuality(paramBoolean);
  }
  
  public void setAsyncPriority(boolean paramBoolean)
  {
    getAsyncOptions().setPriority(paramBoolean);
  }
  
  public void setAsyncRawImageProcessor(RawImageProcessor paramRawImageProcessor)
  {
    getAsyncOptions().setRawImageProcessor(paramRawImageProcessor);
  }
  
  public void setAsyncRootFilePath(String paramString)
  {
    getAsyncOptions().setFileRootPath(paramString);
  }
  
  public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.a.setInternalAsyncImageListener(paramAsyncImageListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */