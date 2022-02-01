package com.tencent.component.media.image.view;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.Options;

public class AsyncImageable$AsyncImageableImpl
  implements AsyncImageable
{
  private static final String[] EMPTY_STR_ARRAY = new String[0];
  private int mAsyncImageId;
  private AsyncImageable.AsyncImageListener mAsyncListener;
  private final AsyncImageable mAsyncListenerCallback;
  private AsyncImageable.AsyncOptions mAsyncOptions = new AsyncImageable.AsyncImageableImpl.1(this);
  private final AsyncImageable.AsyncImageableImpl.WeakImageLoadListener mImageLoadListener;
  private final ImageLoader mImageLoader;
  private final ImageView mImageView;
  private AsyncImageable.AsyncImageListener mInternalAsyncListener;
  private String mLatestUrl = null;
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private final Thread mMainThread = Looper.getMainLooper().getThread();
  private ImageLoader.Options mOptions = new ImageLoader.Options();
  private final AsyncImageable.AsyncImageableImpl.WeakStreamLoadListener mStreamLoadListener;
  private String mUrl = null;
  
  public AsyncImageable$AsyncImageableImpl(ImageView paramImageView, AsyncImageable paramAsyncImageable)
  {
    this.mImageView = paramImageView;
    this.mImageLoader = ImageLoader.getInstance(paramImageView.getContext());
    this.mImageLoadListener = new AsyncImageable.AsyncImageableImpl.WeakImageLoadListener(this);
    this.mStreamLoadListener = new AsyncImageable.AsyncImageableImpl.WeakStreamLoadListener(this);
    this.mAsyncListenerCallback = paramAsyncImageable;
    this.mOptions.useMainThread = true;
  }
  
  private void applyAsyncImage(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      if (!paramBoolean)
      {
        this.mImageView.setImageDrawable(paramDrawable);
      }
      else
      {
        Animation localAnimation1 = this.mAsyncOptions.inAnimation;
        Animation localAnimation2 = this.mAsyncOptions.outAnimation;
        if (localAnimation2 != null)
        {
          scheduleAnimation(this.mImageView, localAnimation2, new AsyncImageable.AsyncImageableImpl.3(this, paramDrawable, localAnimation1));
        }
        else if (localAnimation1 != null)
        {
          this.mImageView.setImageDrawable(paramDrawable);
          scheduleAnimation(this.mImageView, localAnimation1, null);
        }
        else
        {
          this.mImageView.setImageDrawable(paramDrawable);
        }
      }
      this.mAsyncImageId = paramDrawable.hashCode();
      return;
    }
    this.mAsyncImageId = 0;
  }
  
  private void applyDefaultImage()
  {
    Drawable localDrawable = this.mAsyncOptions.defaultImage;
    int i = this.mAsyncOptions.defaultImageId;
    if (localDrawable != null)
    {
      this.mImageView.setImageDrawable(localDrawable);
      return;
    }
    if (i != 0) {
      this.mImageView.setImageResource(i);
    }
  }
  
  private void applyFailImage()
  {
    Drawable localDrawable = this.mAsyncOptions.failImage;
    int i = this.mAsyncOptions.failImageId;
    if (localDrawable != null)
    {
      this.mImageView.setImageDrawable(localDrawable);
      return;
    }
    if (i != 0) {
      this.mImageView.setImageResource(i);
    }
  }
  
  private boolean checkAsyncChanged(String paramString)
  {
    return equalsString(this.mUrl, paramString) ^ true;
  }
  
  private void ensureDrawable()
  {
    int i = this.mAsyncImageId;
    if (i != 0)
    {
      Drawable localDrawable = this.mImageView.getDrawable();
      if ((localDrawable == null) || (localDrawable.hashCode() != i)) {
        resetAsyncImage();
      }
    }
  }
  
  private void ensureThread(String paramString)
  {
    if (Thread.currentThread() == this.mMainThread) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" can ONLY be called within main thread!");
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private static boolean equalsString(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      if (paramString1.equals(paramString2)) {
        return true;
      }
      if (paramString1 != null) {
        return ImageKey.getUrlKey(paramString1, true).equals(ImageKey.getUrlKey(paramString2, true));
      }
    }
    return false;
  }
  
  private static boolean equalsStringArray(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1 == paramArrayOfString2) {
      return true;
    }
    if (paramArrayOfString1 != null)
    {
      if (paramArrayOfString2 == null) {
        return false;
      }
      if (paramArrayOfString1.length != paramArrayOfString2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfString1.length)
      {
        if (!equalsString(paramArrayOfString1[i], paramArrayOfString2[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void notifyAsyncImageFailed()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
    Object localObject1 = this.mAsyncListenerCallback;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = this;
      }
      localAsyncImageListener.onImageFailed((AsyncImageable)localObject2);
    }
    Object localObject2 = this.mInternalAsyncListener;
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this;
      }
      ((AsyncImageable.AsyncImageListener)localObject2).onImageFailed((AsyncImageable)localObject1);
    }
  }
  
  private void notifyAsyncImageLoaded()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
    Object localObject1 = this.mAsyncListenerCallback;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = this;
      }
      localAsyncImageListener.onImageLoaded((AsyncImageable)localObject2);
    }
    Object localObject2 = this.mInternalAsyncListener;
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this;
      }
      ((AsyncImageable.AsyncImageListener)localObject2).onImageLoaded((AsyncImageable)localObject1);
    }
  }
  
  private void notifyAsyncImageProgress(float paramFloat)
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
    Object localObject1 = this.mAsyncListenerCallback;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = this;
      }
      localAsyncImageListener.onImageProgress((AsyncImageable)localObject2, paramFloat);
    }
    Object localObject2 = this.mInternalAsyncListener;
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this;
      }
      ((AsyncImageable.AsyncImageListener)localObject2).onImageProgress((AsyncImageable)localObject1, paramFloat);
    }
  }
  
  private void notifyAsyncImageStart()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
    Object localObject1 = this.mAsyncListenerCallback;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null) {
        localObject2 = localObject1;
      } else {
        localObject2 = this;
      }
      localAsyncImageListener.onImageStarted((AsyncImageable)localObject2);
    }
    Object localObject2 = this.mInternalAsyncListener;
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this;
      }
      ((AsyncImageable.AsyncImageListener)localObject2).onImageStarted((AsyncImageable)localObject1);
    }
  }
  
  private void resetAsyncImage()
  {
    this.mUrl = null;
  }
  
  private static void scheduleAnimation(View paramView, Animation paramAnimation, Runnable paramRunnable)
  {
    if ((paramView != null) && (paramAnimation != null))
    {
      paramView.clearAnimation();
      paramAnimation.setAnimationListener(new AsyncImageable.AsyncImageableImpl.4(paramRunnable));
      paramView.startAnimation(paramAnimation);
      return;
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  private void setAsyncImageInternal(String paramString, String... paramVarArgs)
  {
    if ((this.mUrl == null) && (paramString == null))
    {
      applyDefaultImage();
      return;
    }
    paramVarArgs = this.mUrl;
    ImageLoader.Options localOptions = this.mOptions;
    if ((paramString == null) && (paramVarArgs != null))
    {
      this.mUrl = null;
      this.mImageLoader.cancel(paramVarArgs, this.mImageLoadListener, localOptions);
      applyDefaultImage();
      return;
    }
    ensureThread("setAsyncImage");
    this.mUrl = paramString;
    this.mLatestUrl = paramString;
    this.mOptions = ImageLoader.Options.copy(this.mOptions);
    this.mAsyncOptions.fillOptions(this.mOptions);
    paramVarArgs = this.mOptions;
    paramVarArgs.needCallBackProcessPercent = true;
    paramVarArgs.useMainThread = true;
    paramVarArgs = this.mImageView.getLayoutParams();
    if ((paramVarArgs != null) && (paramVarArgs.width > 0) && (paramVarArgs.height > 0))
    {
      this.mOptions.clipWidth = paramVarArgs.width;
      this.mOptions.clipHeight = paramVarArgs.height;
    }
    notifyAsyncImageStart();
    if (this.mAsyncOptions.justMemoryCache) {
      paramString = this.mImageLoader.loadImageSync(paramString, this.mOptions);
    } else {
      paramString = this.mImageLoader.loadImage(paramString, this.mImageLoadListener, this.mOptions);
    }
    if (paramString != null)
    {
      applyAsyncImage(paramString, false);
      notifyAsyncImageLoaded();
      return;
    }
    applyDefaultImage();
  }
  
  public void finalize()
  {
    try
    {
      this.mImageLoader.cancel(this.mUrl, this.mImageLoadListener, this.mOptions);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String getAsyncImage()
  {
    return this.mLatestUrl;
  }
  
  public AsyncImageable.AsyncOptions getAsyncOptions()
  {
    return this.mAsyncOptions;
  }
  
  public void setAsyncImage(String paramString)
  {
    setAsyncImage(paramString, EMPTY_STR_ARRAY);
  }
  
  public void setAsyncImage(String paramString, String... paramVarArgs)
  {
    if (Thread.currentThread() != this.mMainThread)
    {
      this.mMainHandler.post(new AsyncImageable.AsyncImageableImpl.2(this, paramString, paramVarArgs));
      return;
    }
    setAsyncImageInternal(paramString, paramVarArgs);
  }
  
  public void setAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.mAsyncListener = paramAsyncImageListener;
  }
  
  public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.mInternalAsyncListener = paramAsyncImageListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl
 * JD-Core Version:    0.7.0.1
 */