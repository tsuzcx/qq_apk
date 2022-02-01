package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.io.RandomAccessFile;

public class ApngDrawable
  extends Drawable
  implements AnimationCallback
{
  private static final byte[] SIGNATURE = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private static final String TAG = "ApngImage_able";
  private int chatWindowHeight;
  private Rect drawRect;
  private int mApngHeight;
  private ApngDrawable.ApngState mApngState;
  private int mApngWidth;
  private final Rect mDstRect = new Rect();
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  private boolean reCalculateRects = true;
  private boolean useRect;
  
  public ApngDrawable(ApngDrawable.ApngState paramApngState, Resources paramResources)
  {
    this.mApngState = paramApngState;
    paramApngState.mApng.addCallBack(this);
    if (paramApngState.mApng.mGetResetLoop) {
      paramApngState.mApng.currentApngLoop = 0;
    }
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramApngState.mTargetDensity;
    }
    computeImageSize();
  }
  
  public ApngDrawable(ApngImage paramApngImage)
  {
    this(paramApngImage, null);
  }
  
  public ApngDrawable(ApngImage paramApngImage, Resources paramResources)
  {
    this(new ApngDrawable.ApngState(paramApngImage), paramResources);
    this.mApngState.mTargetDensity = this.mTargetDensity;
  }
  
  public ApngDrawable(File paramFile, Resources paramResources)
  {
    this(paramFile, paramResources, false);
  }
  
  public ApngDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
  {
    this(new ApngImage(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mApngWidth = this.mApngState.mApng.getScaledWidth(this.mTargetDensity);
    this.mApngHeight = this.mApngState.mApng.getScaledHeight(this.mTargetDensity);
  }
  
  public static boolean isApngFile(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    Object localObject = new RandomAccessFile(paramFile, "r");
    paramFile = new byte[SIGNATURE.length];
    ((RandomAccessFile)localObject).read(paramFile);
    ((RandomAccessFile)localObject).close();
    int i = 0;
    for (;;)
    {
      localObject = SIGNATURE;
      if (i >= localObject.length) {
        break;
      }
      if (paramFile[i] != localObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    URLDrawable.depImp.mLog.isColorLevel();
    boolean bool = this.reCalculateRects;
    Rect localRect = null;
    if (bool)
    {
      if (this.useRect)
      {
        int i = this.mApngState.mApng.width;
        int j = this.mApngState.mApng.height;
        if ((j > 0) && (i > 0))
        {
          localObject = getBounds();
          if (this.chatWindowHeight < ((Rect)localObject).height()) {
            this.chatWindowHeight = ((Rect)localObject).height();
          }
          int k;
          double d;
          if (this.chatWindowHeight / ((Rect)localObject).width() >= j / i)
          {
            int m = ((Rect)localObject).width();
            k = this.chatWindowHeight;
            m = m * j / k;
            d = i - m;
            Double.isNaN(d);
            int n = (int)(d * 0.5D);
            i = j;
            if (k > ((Rect)localObject).height()) {
              i = j * ((Rect)localObject).height() / this.chatWindowHeight;
            }
            this.drawRect = new Rect(n, 0, m + n, i);
          }
          else
          {
            k = ((Rect)localObject).height() * i / ((Rect)localObject).width();
            d = j - this.chatWindowHeight * i / ((Rect)localObject).width();
            Double.isNaN(d);
            j = (int)(d * 0.5D);
            this.drawRect = new Rect(0, j, i, k + j);
          }
        }
        else
        {
          this.drawRect = null;
        }
      }
      Gravity.apply(this.mApngState.mGravity, this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
      this.reCalculateRects = false;
    }
    Object localObject = this.mApngState.mApng;
    if (this.useRect) {
      localRect = this.drawRect;
    }
    ((ApngImage)localObject).draw(paramCanvas, localRect, this.mDstRect, this.mApngState.mPaint, this.mUseAnimation);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mApngState;
  }
  
  public int getGravity()
  {
    return this.mApngState.mGravity;
  }
  
  public ApngImage getImage()
  {
    return this.mApngState.mApng;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mApngHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mApngWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.reCalculateRects = true;
  }
  
  public void pause()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.pause();
    }
  }
  
  public void removeOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if ((localApngState != null) && (localApngState.mApng != null)) {
      this.mApngState.mApng.removeOnPlayRepeatListener(paramOnPlayRepeatListener);
    }
  }
  
  public void repaly()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.replay();
    }
  }
  
  public void resume()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.resume();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.mApngState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mApngState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mApngState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mApngState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.mApngState.mGravity = paramInt;
    this.reCalculateRects = true;
  }
  
  public void setOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if ((localApngState != null) && (localApngState.mApng != null)) {
      this.mApngState.mApng.setOnPlayRepeatListener(paramOnPlayRepeatListener);
    }
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  public void setUseRect(Object paramObject)
  {
    if (paramObject != null)
    {
      this.useRect = ((Bundle)paramObject).getBoolean("key_use_rect", false);
      this.reCalculateRects = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.ApngDrawable
 * JD-Core Version:    0.7.0.1
 */