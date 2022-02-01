package com.tencent.component.media.photogif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.Options;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QzoneAnimationDrawable
  extends Drawable
  implements Animatable
{
  public static int LOOP_INFINITE = 0;
  private static final String TAG = "QzoneAnimationDrawable";
  private QzoneAnimationDrawable.AnimationListener mAnimationListener;
  private volatile Drawable mCurrentFrame;
  private Drawable mDefaultFrame;
  private final Rect mDstRect = new Rect();
  private ScheduledThreadPoolExecutor mExecutor;
  private ImageLoader.Options mFrameOptions;
  private QzoneAnimationDrawable.FrameSwitcher mFrameSwitcher;
  private ImageKey mImageKey;
  private InvalidationHandler mInvalidationHandler;
  private volatile boolean mIsRunning = false;
  private volatile Drawable mNextFrame;
  private volatile int mNextFrameIndex = 0;
  private final Paint mPaint = new Paint();
  private QzoneAnimationDrawable.PhotoLoadListener mPhotoLoadListener;
  private int mPlayCount;
  private int mRepeatCount;
  private ScheduledFuture<?> mScheduledFuture;
  private volatile boolean mSwitchFrameWhenLoaded = true;
  
  public QzoneAnimationDrawable(ImageKey paramImageKey)
  {
    this.mImageKey = ImageKey.copy(paramImageKey);
    init();
  }
  
  public QzoneAnimationDrawable(ImageLoader.Options paramOptions)
  {
    this.mImageKey = ImageKey.obtain();
    this.mImageKey.options = ImageLoader.Options.copy(paramOptions);
    init();
  }
  
  private void doBeforeDraw()
  {
    if (this.mNextFrameIndex - 1 == 0)
    {
      localAnimationListener = this.mAnimationListener;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationStart(this);
      }
    }
    QzoneAnimationDrawable.AnimationListener localAnimationListener = this.mAnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationPlay(this, this.mNextFrameIndex - 1);
    }
  }
  
  private void init()
  {
    this.mFrameOptions = ImageLoader.Options.copy(this.mImageKey.options);
    ImageLoader.Options localOptions = this.mFrameOptions;
    localOptions.needShowPhotoGifAnimation = false;
    localOptions.photoList = null;
    this.mExecutor = GifRenderingExecutor.getInstance();
    this.mInvalidationHandler = new InvalidationHandler(this);
    this.mPhotoLoadListener = new QzoneAnimationDrawable.PhotoLoadListener(this, null);
    this.mFrameSwitcher = new QzoneAnimationDrawable.FrameSwitcher(this, null);
    this.mPaint.setARGB(255, 240, 240, 240);
  }
  
  private void loadNextFrame()
  {
    if (this.mNextFrameIndex < this.mImageKey.options.photoList.size())
    {
      localObject1 = (String)this.mImageKey.options.photoList.get(this.mNextFrameIndex);
      ImageLoader.getInstance().loadImageAsync((String)localObject1, this.mPhotoLoadListener, this.mFrameOptions);
      localObject2 = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadNextFrame:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",frameIndex:");
      localStringBuilder.append(this.mNextFrameIndex);
      ((ILog)localObject2).d("QzoneAnimationDrawable", new Object[] { localStringBuilder.toString() });
      if (this.mNextFrameIndex == getFrameCounts() - 1) {
        this.mPlayCount += 1;
      }
      this.mNextFrameIndex = ((this.mNextFrameIndex + 1) % this.mImageKey.options.photoList.size());
      return;
    }
    Object localObject1 = ImageManagerEnv.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadNextFrame: out of index,mNextFrameIndex:");
    ((StringBuilder)localObject2).append(this.mNextFrameIndex);
    ((StringBuilder)localObject2).append(",photosize:");
    ((StringBuilder)localObject2).append(this.mImageKey.options.photoList.size());
    ((ILog)localObject1).e("QzoneAnimationDrawable", new Object[] { ((StringBuilder)localObject2).toString() });
  }
  
  private void reset()
  {
    ScheduledFuture localScheduledFuture = this.mScheduledFuture;
    if ((localScheduledFuture != null) && (!localScheduledFuture.isDone())) {
      this.mScheduledFuture.cancel(true);
    }
    this.mIsRunning = true;
    this.mNextFrameIndex = 0;
    this.mCurrentFrame = null;
    this.mNextFrame = null;
    this.mSwitchFrameWhenLoaded = true;
    this.mPlayCount = 0;
    loadNextFrame();
  }
  
  private boolean switchFrame()
  {
    if (!this.mIsRunning) {
      return false;
    }
    boolean bool;
    if (this.mNextFrame != null)
    {
      if (canAnimate())
      {
        this.mCurrentFrame = this.mNextFrame;
        this.mNextFrame = null;
        doBeforeDraw();
        if (!this.mInvalidationHandler.hasMessages(0)) {
          this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        loadNextFrame();
      }
      else if (this.mCurrentFrame == null)
      {
        this.mCurrentFrame = this.mNextFrame;
        doBeforeDraw();
        if (!this.mInvalidationHandler.hasMessages(0)) {
          this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    Object localObject = this.mScheduledFuture;
    if ((localObject != null) && (!((ScheduledFuture)localObject).isDone())) {
      this.mScheduledFuture.cancel(true);
    }
    int i = this.mRepeatCount;
    if ((i != LOOP_INFINITE) && (this.mPlayCount >= i))
    {
      stop();
      localObject = this.mAnimationListener;
      if (localObject != null)
      {
        ((QzoneAnimationDrawable.AnimationListener)localObject).onAnimationEnd(this);
        return bool;
      }
    }
    else
    {
      this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
      localObject = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("------next index:");
      localStringBuilder.append(this.mNextFrameIndex);
      ((ILog)localObject).d("QzoneAnimationDrawable", new Object[] { localStringBuilder.toString() });
    }
    return bool;
  }
  
  public boolean canAnimate()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mCurrentFrame != null)
    {
      this.mCurrentFrame.setBounds(getBounds());
      this.mCurrentFrame.draw(paramCanvas);
      return;
    }
    Drawable localDrawable = this.mDefaultFrame;
    if (localDrawable != null)
    {
      localDrawable.setBounds(getBounds());
      this.mDefaultFrame.draw(paramCanvas);
      return;
    }
    paramCanvas.drawRect(this.mDstRect, this.mPaint);
  }
  
  public int getFrameCounts()
  {
    return this.mImageKey.options.photoList.size();
  }
  
  public long getFrameDuration()
  {
    return this.mImageKey.options.photoDelayTimeInMs;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getIntrinsicHeight();
    }
    Drawable localDrawable = this.mDefaultFrame;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return this.mFrameOptions.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getIntrinsicWidth();
    }
    Drawable localDrawable = this.mDefaultFrame;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.mFrameOptions.clipWidth;
  }
  
  public int getMinimumHeight()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getMinimumHeight();
    }
    Drawable localDrawable = this.mDefaultFrame;
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return this.mFrameOptions.clipHeight;
  }
  
  public int getMinimumWidth()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getMinimumWidth();
    }
    Drawable localDrawable = this.mDefaultFrame;
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return this.mFrameOptions.clipWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDstRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationListener(QzoneAnimationDrawable.AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = paramAnimationListener;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDrawableForDefaultFrame(Drawable paramDrawable)
  {
    this.mDefaultFrame = paramDrawable;
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.mRepeatCount = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        reset();
        return bool;
      }
      start();
      return bool;
    }
    if (bool) {
      stop();
    }
    return bool;
  }
  
  public void start()
  {
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    this.mSwitchFrameWhenLoaded = false;
    if (this.mNextFrame == null) {
      loadNextFrame();
    }
    ScheduledFuture localScheduledFuture = this.mScheduledFuture;
    if ((localScheduledFuture != null) && (!localScheduledFuture.isDone())) {
      this.mScheduledFuture.cancel(true);
    }
    this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
  }
  
  public void stop()
  {
    this.mIsRunning = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */