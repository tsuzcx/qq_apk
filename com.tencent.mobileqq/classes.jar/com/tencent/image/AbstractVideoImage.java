package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Vector;

public abstract class AbstractVideoImage
{
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final String TAG = "AbstractVideoImage";
  public static boolean loopEnable;
  protected static Object sPauseLock = new Object();
  protected static volatile boolean sPaused;
  protected static final ArrayList<WeakReference<AbstractVideoImage>> sPendingActions = new AbstractVideoImage.1(105);
  public float mDefaultRoundCorner = 5.0F;
  private int mDensity = 160;
  private Vector<WeakReference<VideoDrawable>> mDrawableList = new Vector();
  protected boolean mIsInPendingAction = false;
  protected ArrayList<WeakReference<VideoDrawable.OnPlayRepeatListener>> mListener = new ArrayList();
  protected VideoDrawable.OnAudioPlayOnceListener mPlayOnceListener;
  public boolean mSupportGlobalPause = true;
  
  static
  {
    loopEnable = true;
    sPaused = false;
  }
  
  public static final void pauseAll()
  {
    if (!sPaused)
    {
      sPaused = true;
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(TAG, 2, " pauseAll ");
      }
    }
  }
  
  public static final void resumeAll()
  {
    if (sPaused)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(TAG, 2, " resumeAll ");
      }
      synchronized (sPauseLock)
      {
        sPaused = false;
        sPauseLock.notifyAll();
        int i = sPendingActions.size() - 1;
        while (i >= 0)
        {
          ??? = (AbstractVideoImage)((WeakReference)sPendingActions.get(i)).get();
          if (??? != null) {
            ((AbstractVideoImage)???).reDraw();
          }
          i -= 1;
        }
        sPendingActions.clear();
        return;
      }
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
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
  
  public void attachDrawable(VideoDrawable paramVideoDrawable)
  {
    if (paramVideoDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramVideoDrawable)) {
          this.mDrawableList.add(new WeakReference(paramVideoDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(VideoDrawable paramVideoDrawable)
  {
    Vector localVector;
    if (paramVideoDrawable != null) {
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
          if ((localWeakReference != null) && (localWeakReference.get() != paramVideoDrawable))
          {
            j = i;
            if (localWeakReference.get() != paramVideoDrawable) {
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
  
  public abstract void disableGlobalPause();
  
  protected void doApplyNextFrame(int paramInt)
  {
    applyNextFrame();
    if (this.mSupportGlobalPause)
    {
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
    else
    {
      invalidateSelf();
    }
  }
  
  protected abstract void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean);
  
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
            ((VideoDrawable)localWeakReference.get()).invalidateSelf();
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
  
  public abstract boolean isAudioPlaying();
  
  protected void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  public void removeOnPlayRepeatListener(VideoDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if (paramOnPlayRepeatListener != null) {}
    for (;;)
    {
      int i;
      synchronized (this.mListener)
      {
        i = this.mListener.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label64;
          }
          this.mListener.remove(i);
          break label64;
        }
        return;
      }
      return;
      label64:
      i -= 1;
    }
  }
  
  public abstract void resetAndPlayAudioCircle();
  
  public abstract void resetAndPlayAudioOnce();
  
  public void setOnAudioPlayOnceListener(VideoDrawable.OnAudioPlayOnceListener paramOnAudioPlayOnceListener)
  {
    this.mPlayOnceListener = paramOnAudioPlayOnceListener;
  }
  
  public void setOnPlayRepeatListener(VideoDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    ArrayList localArrayList;
    int k;
    int i;
    if (paramOnPlayRepeatListener != null)
    {
      localArrayList = this.mListener;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      int j = k;
      try
      {
        if (i < this.mListener.size())
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label86;
          }
          j = 1;
        }
        if (j == 0) {
          this.mListener.add(new WeakReference(paramOnPlayRepeatListener));
        }
        return;
      }
      finally {}
      return;
      label86:
      i += 1;
    }
  }
  
  public abstract void stopPlayAudio();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.AbstractVideoImage
 * JD-Core Version:    0.7.0.1
 */