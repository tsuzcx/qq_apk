package com.tencent.component.media.image.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.utils.ImageManagerLog;

public class ExtendImageView
  extends ImageView
{
  private static final ThreadLocal<Rect> sLocalTmpRect = new ExtendImageView.1();
  private boolean mAdjustViewBounds = false;
  private boolean mBlockMeasurement = false;
  private ViewForeground mForeground = new ViewForeground(this, null);
  private int mForegroundResource = 0;
  private boolean mIgnoreContentBounds = false;
  private boolean mMeasuredExactly = false;
  
  public ExtendImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean isBackgroundHasPadding(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Rect localRect = (Rect)sLocalTmpRect.get();
    boolean bool;
    if ((paramDrawable1 != null) && (paramDrawable1.getPadding(localRect))) {
      bool = true;
    }
    while (!bool) {
      if ((paramDrawable2 != null) && (paramDrawable2.getPadding(localRect)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  private boolean isMeasuredExactly(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    return (paramInt1 == 1073741824) && (paramInt2 == 1073741824);
  }
  
  private void scheduleAnimation(Animation paramAnimation, Runnable paramRunnable)
  {
    if (paramAnimation == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    clearAnimation();
    paramAnimation.setAnimationListener(new ExtendImageView.6(this, paramRunnable));
    startAnimation(paramAnimation);
  }
  
  private void setForegroundInternal(Drawable paramDrawable)
  {
    this.mBlockMeasurement = true;
    this.mForeground.setDrawable(paramDrawable);
    this.mBlockMeasurement = false;
  }
  
  private void setImageBitmapInternal(Bitmap paramBitmap)
  {
    this.mBlockMeasurement = true;
    super.setImageBitmap(paramBitmap);
    this.mBlockMeasurement = false;
  }
  
  private void setImageDrawableInternal(Drawable paramDrawable)
  {
    this.mBlockMeasurement = true;
    super.setImageDrawable(paramDrawable);
    this.mBlockMeasurement = false;
  }
  
  private void setImageResourceInternal(int paramInt)
  {
    this.mBlockMeasurement = true;
    try
    {
      super.setImageResource(paramInt);
      this.mBlockMeasurement = false;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageManagerLog.e("ExtendImageView", "out of memory " + localOutOfMemoryError.toString());
    }
  }
  
  private void setImageURIInternal(Uri paramUri)
  {
    this.mBlockMeasurement = true;
    super.setImageURI(paramUri);
    this.mBlockMeasurement = false;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ViewForeground localViewForeground = this.mForeground;
    if (localViewForeground != null) {
      localViewForeground.drawableStateChanged();
    }
  }
  
  public boolean getAdjustViewBounds()
  {
    return this.mAdjustViewBounds;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ViewForeground localViewForeground = this.mForeground;
    if (localViewForeground != null) {
      localViewForeground.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewForeground localViewForeground = this.mForeground;
    if (localViewForeground != null) {
      localViewForeground.boundsChanged();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.mMeasuredExactly = isMeasuredExactly(paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mIgnoreContentBounds) && (!this.mAdjustViewBounds)) {
      setMeasuredDimension(getDefaultSize(getMeasuredWidth(), paramInt1), getDefaultSize(getMeasuredHeight(), paramInt2));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ViewForeground localViewForeground = this.mForeground;
    if (localViewForeground != null) {
      localViewForeground.boundsChanged();
    }
  }
  
  public void requestLayout()
  {
    if ((this.mBlockMeasurement) && (this.mMeasuredExactly)) {
      return;
    }
    super.requestLayout();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.mAdjustViewBounds = paramBoolean;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBlockMeasurement = true;
    super.setBackgroundColor(paramInt);
    this.mBlockMeasurement = false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (!isBackgroundHasPadding(getBackground(), paramDrawable)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mBlockMeasurement = bool;
      super.setBackgroundDrawable(paramDrawable);
      this.mBlockMeasurement = false;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.mBlockMeasurement = true;
    super.setBackgroundResource(paramInt);
    this.mBlockMeasurement = false;
  }
  
  public void setForeground(int paramInt)
  {
    if ((paramInt != 0) && (paramInt == this.mForegroundResource)) {
      return;
    }
    this.mForegroundResource = paramInt;
    if (paramInt != 0) {}
    for (Drawable localDrawable = getResources().getDrawable(paramInt);; localDrawable = null)
    {
      setForegroundInternal(localDrawable);
      return;
    }
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (paramDrawable == this.mForeground.getDrawable()) {
      return;
    }
    this.mForegroundResource = 0;
    setForegroundInternal(paramDrawable);
  }
  
  public void setIgnoreContentBounds(boolean paramBoolean)
  {
    if (this.mIgnoreContentBounds != paramBoolean)
    {
      this.mIgnoreContentBounds = paramBoolean;
      requestLayout();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageBitmapInternal(paramBitmap);
  }
  
  public void setImageBitmap(Bitmap paramBitmap, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      scheduleAnimation(paramAnimation2, new ExtendImageView.2(this, paramBitmap, paramAnimation1));
    }
    do
    {
      return;
      setImageBitmapInternal(paramBitmap);
    } while (paramAnimation1 == null);
    scheduleAnimation(paramAnimation1, null);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    setImageDrawableInternal(paramDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      scheduleAnimation(paramAnimation2, new ExtendImageView.3(this, paramDrawable, paramAnimation1));
    }
    do
    {
      return;
      setImageDrawableInternal(paramDrawable);
    } while (paramAnimation1 == null);
    scheduleAnimation(paramAnimation1, null);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageResourceInternal(paramInt);
  }
  
  public void setImageResource(int paramInt, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      scheduleAnimation(paramAnimation2, new ExtendImageView.4(this, paramInt, paramAnimation1));
    }
    do
    {
      return;
      setImageResourceInternal(paramInt);
    } while (paramAnimation1 == null);
    scheduleAnimation(paramAnimation1, null);
  }
  
  public void setImageURI(Uri paramUri)
  {
    setImageURIInternal(paramUri);
  }
  
  public void setImageURI(Uri paramUri, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      scheduleAnimation(paramAnimation2, new ExtendImageView.5(this, paramUri, paramAnimation1));
    }
    do
    {
      return;
      setImageURIInternal(paramUri);
    } while (paramAnimation1 == null);
    scheduleAnimation(paramAnimation1, null);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    Object localObject = this.mForeground;
    if (localObject == null) {}
    for (localObject = null; (localObject == paramDrawable) || (super.verifyDrawable(paramDrawable)); localObject = ((ViewForeground)localObject).getDrawable()) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.ExtendImageView
 * JD-Core Version:    0.7.0.1
 */