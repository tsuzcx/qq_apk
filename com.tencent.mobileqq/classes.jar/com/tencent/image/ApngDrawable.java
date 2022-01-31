package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ApngDrawable
  extends Drawable
  implements AnimationCallback
{
  private static final byte[] SIGNATURE = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private static final String TAG = "ApngImage_able";
  int chatWindowHeight;
  private int mApngHeight;
  private ApngState mApngState;
  private int mApngWidth;
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public ApngDrawable(ApngState paramApngState, Resources paramResources)
  {
    this.mApngState = paramApngState;
    paramApngState.mApng.addCallBack(this);
    if (paramApngState.mApng.mGetResetLoop) {
      paramApngState.mApng.currentApngLoop = 0;
    }
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramApngState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public ApngDrawable(ApngImage paramApngImage)
  {
    this(paramApngImage, null);
  }
  
  public ApngDrawable(ApngImage paramApngImage, Resources paramResources)
  {
    this(new ApngState(paramApngImage), paramResources);
    this.mApngState.mTargetDensity = this.mTargetDensity;
  }
  
  public ApngDrawable(File paramFile, Resources paramResources)
    throws IOException
  {
    this(paramFile, paramResources, false);
  }
  
  public ApngDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
    throws IOException
  {
    this(new ApngImage(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mApngWidth = this.mApngState.mApng.getScaledWidth(this.mTargetDensity);
    this.mApngHeight = this.mApngState.mApng.getScaledHeight(this.mTargetDensity);
  }
  
  public static boolean isApngFile(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[SIGNATURE.length];
    paramFile.read(arrayOfByte);
    paramFile.close();
    int i = 0;
    while (i < SIGNATURE.length)
    {
      if (arrayOfByte[i] != SIGNATURE[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i;
    int j;
    Rect localRect;
    int k;
    if ((!QLog.isColorLevel()) || (this.mApplyGravity)) {
      if (this.mApngState.mApng.useRect)
      {
        i = this.mApngState.mApng.width;
        j = this.mApngState.mApng.height;
        if ((j <= 0) || (i <= 0)) {
          break label304;
        }
        localRect = getBounds();
        if (this.chatWindowHeight < localRect.height()) {
          this.chatWindowHeight = localRect.height();
        }
        if (this.chatWindowHeight / localRect.width() < j / i) {
          break label241;
        }
        k = localRect.width() * j / this.chatWindowHeight;
        int m = (int)((i - k) * 0.5D);
        i = j;
        if (this.chatWindowHeight > localRect.height()) {
          i = localRect.height() * j / this.chatWindowHeight;
        }
        this.mApngState.mApng.drawRect = new Rect(m, 0, m + k, i);
      }
    }
    for (;;)
    {
      Gravity.apply(this.mApngState.mGravity, this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
      this.mApngState.mApng.draw(paramCanvas, this.mDstRect, this.mApngState.mPaint, this.mUseAnimation);
      return;
      label241:
      k = localRect.height() * i / localRect.width();
      j = (int)((j - this.chatWindowHeight * i / localRect.width()) * 0.5D);
      this.mApngState.mApng.drawRect = new Rect(0, j, i, j + k);
      continue;
      label304:
      this.mApngState.mApng.drawRect = null;
    }
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
    this.mApplyGravity = true;
  }
  
  public void removeOnPlayRepeatListener(OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if ((this.mApngState != null) && (this.mApngState.mApng != null)) {
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
    this.mApplyGravity = true;
  }
  
  public void setOnPlayRepeatListener(OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if ((this.mApngState != null) && (this.mApngState.mApng != null)) {
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
  
  static final class ApngState
    extends Drawable.ConstantState
  {
    ApngImage mApng;
    int mChangingConfigurations;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    
    public ApngState(ApngImage paramApngImage)
    {
      this.mApng = paramApngImage;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new ApngDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new ApngDrawable(this, paramResources);
    }
  }
  
  public static abstract interface OnPlayRepeatListener
  {
    public abstract void onPlayRepeat(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.ApngDrawable
 * JD-Core Version:    0.7.0.1
 */