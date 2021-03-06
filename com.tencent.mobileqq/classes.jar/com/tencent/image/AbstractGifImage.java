package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Vector;

public abstract class AbstractGifImage
{
  public static final int DENSITY_NONE = 0;
  private static final int PENDING_ACTION_CAPACITY = 100;
  protected static ArgumentsRunnable<WeakReference<AbstractGifImage>> sAccumulativeRunnable;
  protected static boolean sPaused = false;
  protected static final ArrayList<WeakReference<AbstractGifImage>> sPendingActions = new AbstractGifImage.1(105);
  protected static Handler sUIThreadHandler;
  public float mDefaultRoundCorner = 0.0F;
  protected int mDensity = 160;
  protected Vector<WeakReference<GifDrawable>> mDrawableList = new Vector();
  protected boolean mIsInPendingAction = false;
  protected WeakReference<GifDrawable.OnGIFPlayOnceListener> mPlayOnceListener;
  protected GifDrawable.OnGIFPlayOnceListener mStrongPlayOnceListener;
  
  public static final void pauseAll()
  {
    sPaused = true;
  }
  
  public static final void resumeAll()
  {
    sPaused = false;
    int i = sPendingActions.size() - 1;
    while (i >= 0)
    {
      AbstractGifImage localAbstractGifImage = (AbstractGifImage)((WeakReference)sPendingActions.get(i)).get();
      if (localAbstractGifImage != null) {
        localAbstractGifImage.reDraw();
      }
      i -= 1;
    }
    sPendingActions.clear();
  }
  
  private static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  protected abstract void applyNextFrame();
  
  public void attachDrawable(GifDrawable paramGifDrawable)
  {
    if (paramGifDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramGifDrawable)) {
          this.mDrawableList.add(new WeakReference(paramGifDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(GifDrawable paramGifDrawable)
  {
    Vector localVector;
    if (paramGifDrawable != null) {
      localVector = this.mDrawableList;
    }
    int j;
    for (int i = 0;; i = j + 1)
    {
      try
      {
        if (i < this.mDrawableList.size())
        {
          WeakReference localWeakReference = (WeakReference)this.mDrawableList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            j = i;
            if (localWeakReference.get() != paramGifDrawable) {
              continue;
            }
            this.mDrawableList.remove(i);
            return;
          }
          this.mDrawableList.remove(i);
          j = i - 1;
          continue;
        }
        return;
      }
      finally {}
      return;
    }
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    if (!sPaused)
    {
      invalidateSelf();
      return;
    }
    if (!this.mIsInPendingAction)
    {
      sPendingActions.add(new WeakReference(this));
      this.mIsInPendingAction = true;
    }
  }
  
  protected abstract void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean);
  
  protected abstract void executeNewTask();
  
  public abstract int getByteSize();
  
  public abstract int getHeight();
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public abstract int getWidth();
  
  protected final void initHandlerAndRunnable()
  {
    if (sUIThreadHandler == null)
    {
      sUIThreadHandler = new Handler(Looper.getMainLooper());
      sAccumulativeRunnable = new AbstractGifImage.DoAccumulativeRunnable();
    }
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mDrawableList.size())
        {
          WeakReference localWeakReference = (WeakReference)this.mDrawableList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((GifDrawable)localWeakReference.get()).invalidateSelf();
          }
          else
          {
            this.mDrawableList.remove(i);
            i -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  protected void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  public void reset() {}
  
  public void setDensity(int paramInt)
  {
    this.mDensity = paramInt;
  }
  
  public void setGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    this.mPlayOnceListener = new WeakReference(paramOnGIFPlayOnceListener);
  }
  
  public void setStrongGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    this.mStrongPlayOnceListener = paramOnGIFPlayOnceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.AbstractGifImage
 * JD-Core Version:    0.7.0.1
 */