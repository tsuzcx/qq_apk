package com.peterlmeng.animate_image.support.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.peterlmeng.animate_image.renderer.RenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorker.OnResourceLoadListener;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory.CreateRenderWorkerParams;
import com.peterlmeng.animate_image.support.log.LogUtils;

public class CanvasConsumerAnimatorRenderWorker
  implements RenderWorker, IInvalidateCallback<Bitmap>, ILoadAnimatorCallback
{
  public static final String TAG = "CanvasConsumerAnimatorRenderWorker";
  private IBitmapAnimator mAnimator;
  private final IBitmapAnimatorFactory mAnimatorFactory;
  private final SurfaceRenderer mFlutterSurface;
  private final RenderWorkerFactory.CreateRenderWorkerParams mImageParams;
  private boolean mIsAnimatorLoaded = false;
  private RenderWorker.OnResourceLoadListener mListener;
  
  public CanvasConsumerAnimatorRenderWorker(RenderWorkerFactory.CreateRenderWorkerParams paramCreateRenderWorkerParams, IBitmapAnimatorFactory paramIBitmapAnimatorFactory)
  {
    DeviceUtils.sDensity = paramCreateRenderWorkerParams.context.getResources().getDisplayMetrics().density;
    this.mImageParams = paramCreateRenderWorkerParams;
    this.mFlutterSurface = new SurfaceRenderer(paramCreateRenderWorkerParams.context, paramCreateRenderWorkerParams.entry, paramCreateRenderWorkerParams.size);
    this.mAnimatorFactory = paramIBitmapAnimatorFactory;
    this.mAnimator = this.mAnimatorFactory.create(new BitmapAnimatorParams(paramCreateRenderWorkerParams.url, paramCreateRenderWorkerParams.size));
    this.mAnimator.setInvalidateCallback(this);
    this.mAnimator.setLoadResultCallback(this);
    this.mFlutterSurface.init(new _..Lambda.CanvasConsumerAnimatorRenderWorker.gR65bSS8NeN3D9_FQLovmygrutQ(this));
  }
  
  public void dispose()
  {
    LogUtils.a("CanvasConsumerAnimatorRenderWorker", "dispose()");
    this.mAnimator.stop();
    this.mFlutterSurface.unInit();
  }
  
  public void doStartPlay()
  {
    this.mAnimator.play();
  }
  
  public String getUrl()
  {
    return this.mImageParams.url;
  }
  
  public boolean isResourceLoaded()
  {
    return this.mIsAnimatorLoaded;
  }
  
  public void onInvalidate(Bitmap paramBitmap, int paramInt)
  {
    this.mFlutterSurface.invalidate();
  }
  
  public void onLoaded(Object paramObject)
  {
    this.mIsAnimatorLoaded = true;
    this.mListener.onResourceLoaded(this.mImageParams.size);
    if ((paramObject instanceof IBitmapAnimator)) {
      this.mAnimator = ((IBitmapAnimator)paramObject);
    }
    this.mAnimator.play();
  }
  
  public void pause()
  {
    this.mAnimator.stop();
  }
  
  public void replaceImage(int paramInt, String paramString) {}
  
  public void replay()
  {
    this.mAnimator.stop();
    this.mAnimator.play();
  }
  
  public void setOnResourceLoadListener(RenderWorker.OnResourceLoadListener paramOnResourceLoadListener)
  {
    this.mListener = paramOnResourceLoadListener;
  }
  
  public void startLoadResource()
  {
    this.mAnimator.load();
  }
  
  public void stop()
  {
    this.mAnimator.stop();
  }
  
  public void updateFile(String paramString)
  {
    Object localObject = this.mAnimator;
    if (localObject != null)
    {
      ((IBitmapAnimator)localObject).stop();
      this.mAnimator.setLoadResultCallback(null);
      this.mAnimator.setInvalidateCallback(null);
      this.mAnimator = null;
    }
    localObject = this.mImageParams;
    ((RenderWorkerFactory.CreateRenderWorkerParams)localObject).url = paramString;
    this.mAnimator = this.mAnimatorFactory.create(new BitmapAnimatorParams(((RenderWorkerFactory.CreateRenderWorkerParams)localObject).url, this.mImageParams.size));
    this.mAnimator.setInvalidateCallback(this);
    this.mAnimator.setLoadResultCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.support.common.CanvasConsumerAnimatorRenderWorker
 * JD-Core Version:    0.7.0.1
 */