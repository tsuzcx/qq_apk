package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Vector;

public abstract class AbstractVideoImage
{
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final String TAG = AbstractVideoImage.class.getSimpleName();
  public static boolean loopEnable = true;
  protected static Object sPauseLock;
  protected static volatile boolean sPaused = false;
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
    sPauseLock = new Object();
  }
  
  public static final void pauseAll()
  {
    if (!sPaused)
    {
      sPaused = true;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, " pauseAll ");
      }
    }
  }
  
  public static final void resumeAll()
  {
    if (sPaused)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, " resumeAll ");
      }
      synchronized (sPauseLock)
      {
        sPaused = false;
        sPauseLock.notifyAll();
        int i = sPendingActions.size() - 1;
        if (i >= 0)
        {
          ??? = (AbstractVideoImage)((WeakReference)sPendingActions.get(i)).get();
          if (??? != null) {
            ((AbstractVideoImage)???).reDraw();
          }
          i -= 1;
        }
      }
      sPendingActions.clear();
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
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
    if (paramVideoDrawable != null)
    {
      Vector localVector = this.mDrawableList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < this.mDrawableList.size())
          {
            Object localObject = (WeakReference)this.mDrawableList.get(i);
            if ((localObject == null) || (((WeakReference)localObject).get() == paramVideoDrawable))
            {
              localObject = this.mDrawableList;
              int j = i - 1;
              ((Vector)localObject).remove(i);
              i = j;
            }
            else if (((WeakReference)localObject).get() == paramVideoDrawable)
            {
              this.mDrawableList.remove(i);
            }
          }
          else
          {
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
  }
  
  public abstract void disableGlobalPause();
  
  protected void doApplyNextFrame(int paramInt)
  {
    applyNextFrame();
    if (this.mSupportGlobalPause)
    {
      if (!sPaused) {
        invalidateSelf();
      }
      while (this.mIsInPendingAction) {
        return;
      }
      sPendingActions.add(new WeakReference(this));
      this.mIsInPendingAction = true;
      return;
    }
    invalidateSelf();
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
          Object localObject1 = (WeakReference)this.mDrawableList.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.mDrawableList;
            int j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
          else
          {
            ((VideoDrawable)((WeakReference)localObject1).get()).invalidateSelf();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
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
    if (paramOnPlayRepeatListener != null) {
      for (;;)
      {
        int i;
        synchronized (this.mListener)
        {
          i = this.mListener.size() - 1;
          if (i >= 0)
          {
            if (((WeakReference)this.mListener.get(i)).get() == paramOnPlayRepeatListener) {
              this.mListener.remove(i);
            }
          }
          else {
            return;
          }
        }
        i -= 1;
      }
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
    int i;
    if (paramOnPlayRepeatListener != null)
    {
      localArrayList = this.mListener;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mListener.size())
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label78;
          }
          i = 1;
          if (i == 0) {
            this.mListener.add(new WeakReference(paramOnPlayRepeatListener));
          }
          return;
        }
      }
      finally {}
      i = 0;
      continue;
      return;
      label78:
      i += 1;
    }
  }
  
  public abstract void stopPlayAudio();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.AbstractVideoImage
 * JD-Core Version:    0.7.0.1
 */