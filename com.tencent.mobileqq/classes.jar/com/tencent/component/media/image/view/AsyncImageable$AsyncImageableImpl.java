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
import pgp;
import pgq;
import pgr;
import pgs;
import pgt;
import pgu;

public class AsyncImageable$AsyncImageableImpl
  implements AsyncImageable
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  private int jdField_a_of_type_Int;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ImageLoader.Options jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options = new ImageLoader.Options();
  private final ImageLoader jdField_a_of_type_ComTencentComponentMediaImageImageLoader;
  private AsyncImageable.AsyncImageListener jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
  private AsyncImageable.AsyncOptions jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions = new pgp(this);
  private final AsyncImageable jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable;
  private String jdField_a_of_type_JavaLangString = null;
  private final Thread jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
  private final pgt jdField_a_of_type_Pgt;
  private final pgu jdField_a_of_type_Pgu;
  private AsyncImageable.AsyncImageListener jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
  private String jdField_b_of_type_JavaLangString = null;
  
  public AsyncImageable$AsyncImageableImpl(ImageView paramImageView, AsyncImageable paramAsyncImageable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader = ImageLoader.getInstance(paramImageView.getContext());
    this.jdField_a_of_type_Pgt = new pgt(this);
    this.jdField_a_of_type_Pgu = new pgu(this);
    this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable = paramAsyncImageable;
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.useMainThread = true;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(float paramFloat)
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
    Object localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable;
    Object localObject2;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        localAsyncImageListener.onImageProgress((AsyncImageable)localObject2, paramFloat);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label58;
        }
      }
    }
    for (;;)
    {
      ((AsyncImageable.AsyncImageListener)localObject2).onImageProgress((AsyncImageable)localObject1, paramFloat);
      return;
      localObject2 = this;
      break;
      label58:
      localObject1 = this;
    }
  }
  
  private void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = paramDrawable.hashCode();
        return;
        Animation localAnimation1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.jdField_a_of_type_AndroidViewAnimationAnimation;
        Animation localAnimation2 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.jdField_b_of_type_AndroidViewAnimationAnimation;
        if (localAnimation2 != null)
        {
          b(this.jdField_a_of_type_AndroidWidgetImageView, localAnimation2, new pgr(this, paramDrawable, localAnimation1));
        }
        else if (localAnimation1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
          b(this.jdField_a_of_type_AndroidWidgetImageView, localAnimation1, null);
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        }
      }
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(String paramString)
  {
    if (Thread.currentThread() != this.jdField_a_of_type_JavaLangThread) {
      throw new RuntimeException(paramString + " can ONLY be called within main thread!");
    }
  }
  
  private void a(String paramString, String... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) && (paramString == null))
    {
      b();
      return;
    }
    paramVarArgs = this.jdField_a_of_type_JavaLangString;
    ImageLoader.Options localOptions = this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options;
    if ((paramString == null) && (paramVarArgs != null))
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader.cancel(paramVarArgs, this.jdField_a_of_type_Pgt, localOptions);
      b();
      return;
    }
    a("setAsyncImage");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramString;
    paramVarArgs = this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options;
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options = ImageLoader.Options.copy(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
    this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.fillOptions(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.needCallBackProcessPercent = true;
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.useMainThread = true;
    paramVarArgs = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if ((paramVarArgs != null) && (paramVarArgs.width > 0) && (paramVarArgs.height > 0))
    {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipWidth = paramVarArgs.width;
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipHeight = paramVarArgs.height;
    }
    d();
    if (this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.g) {}
    for (paramString = this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader.loadImageSync(paramString, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options); paramString != null; paramString = this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader.loadImage(paramString, this.jdField_a_of_type_Pgt, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options))
    {
      a(paramString, false);
      e();
      return;
    }
    b();
  }
  
  private boolean a(String paramString)
  {
    return !a(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool = false;
    }
    while (paramString1.equals(paramString2)) {
      return bool;
    }
    if (paramString1 != null) {
      return ImageKey.getUrlKey(paramString1, true).equals(ImageKey.getUrlKey(paramString2, true));
    }
    return false;
  }
  
  private void b()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int i = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.c;
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    while (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
  }
  
  private static void b(View paramView, Animation paramAnimation, Runnable paramRunnable)
  {
    if ((paramView == null) || (paramAnimation == null))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    paramView.clearAnimation();
    paramAnimation.setAnimationListener(new pgs(paramRunnable));
    paramView.startAnimation(paramAnimation);
  }
  
  private void c()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    int i = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions.d;
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    while (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
  }
  
  private void d()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
    Object localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable;
    Object localObject2;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        localAsyncImageListener.onImageStarted((AsyncImageable)localObject2);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label53;
        }
      }
    }
    for (;;)
    {
      ((AsyncImageable.AsyncImageListener)localObject2).onImageStarted((AsyncImageable)localObject1);
      return;
      localObject2 = this;
      break;
      label53:
      localObject1 = this;
    }
  }
  
  private void e()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
    Object localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable;
    Object localObject2;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        localAsyncImageListener.onImageLoaded((AsyncImageable)localObject2);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label53;
        }
      }
    }
    for (;;)
    {
      ((AsyncImageable.AsyncImageListener)localObject2).onImageLoaded((AsyncImageable)localObject1);
      return;
      localObject2 = this;
      break;
      label53:
      localObject1 = this;
    }
  }
  
  private void f()
  {
    AsyncImageable.AsyncImageListener localAsyncImageListener = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
    Object localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable;
    Object localObject2;
    if (localAsyncImageListener != null)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        localAsyncImageListener.onImageFailed((AsyncImageable)localObject2);
      }
    }
    else
    {
      localObject2 = this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener;
      if (localObject2 != null) {
        if (localObject1 == null) {
          break label53;
        }
      }
    }
    for (;;)
    {
      ((AsyncImageable.AsyncImageListener)localObject2).onImageFailed((AsyncImageable)localObject1);
      return;
      localObject2 = this;
      break;
      label53:
      localObject1 = this;
    }
  }
  
  public void finalize()
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader.cancel(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Pgt, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public String getAsyncImage()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public AsyncImageable.AsyncOptions getAsyncOptions()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncOptions;
  }
  
  public void setAsyncImage(String paramString)
  {
    setAsyncImage(paramString, jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public void setAsyncImage(String paramString, String... paramVarArgs)
  {
    if (Thread.currentThread() != this.jdField_a_of_type_JavaLangThread)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new pgq(this, paramString, paramVarArgs));
      return;
    }
    a(paramString, paramVarArgs);
  }
  
  public void setAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener = paramAsyncImageListener;
  }
  
  public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
  {
    this.jdField_b_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageListener = paramAsyncImageListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl
 * JD-Core Version:    0.7.0.1
 */