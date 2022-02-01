package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class DrawableContainer
  extends Drawable
  implements Drawable.Callback
{
  private static final boolean DEBUG = false;
  private static final boolean DEFAULT_DITHER = true;
  private static final String TAG = "DrawableContainer";
  private int mAlpha = 255;
  private Runnable mAnimationRunnable;
  private DrawableContainer.BlockInvalidateCallback mBlockInvalidateCallback;
  private int mCurIndex = -1;
  private Drawable mCurrDrawable;
  private DrawableContainer.DrawableContainerState mDrawableContainerState;
  private long mEnterAnimationEnd;
  private long mExitAnimationEnd;
  private boolean mHasAlpha;
  private Rect mHotspotBounds;
  private Drawable mLastDrawable;
  private boolean mMutated;
  
  private void initializeDrawableForDisplay(Drawable paramDrawable)
  {
    if (this.mBlockInvalidateCallback == null) {
      this.mBlockInvalidateCallback = new DrawableContainer.BlockInvalidateCallback();
    }
    paramDrawable.setCallback(this.mBlockInvalidateCallback.wrap(paramDrawable.getCallback()));
    try
    {
      if ((this.mDrawableContainerState.mEnterFadeDuration <= 0) && (this.mHasAlpha)) {
        paramDrawable.setAlpha(this.mAlpha);
      }
      if (this.mDrawableContainerState.mHasColorFilter)
      {
        paramDrawable.setColorFilter(this.mDrawableContainerState.mColorFilter);
      }
      else
      {
        if (this.mDrawableContainerState.mHasTintList) {
          DrawableCompat.setTintList(paramDrawable, this.mDrawableContainerState.mTintList);
        }
        if (this.mDrawableContainerState.mHasTintMode) {
          DrawableCompat.setTintMode(paramDrawable, this.mDrawableContainerState.mTintMode);
        }
      }
      paramDrawable.setVisible(isVisible(), true);
      paramDrawable.setDither(this.mDrawableContainerState.mDither);
      paramDrawable.setState(getState());
      paramDrawable.setLevel(getLevel());
      paramDrawable.setBounds(getBounds());
      if (Build.VERSION.SDK_INT >= 23) {
        paramDrawable.setLayoutDirection(getLayoutDirection());
      }
      if (Build.VERSION.SDK_INT >= 19) {
        paramDrawable.setAutoMirrored(this.mDrawableContainerState.mAutoMirrored);
      }
      Rect localRect = this.mHotspotBounds;
      if ((Build.VERSION.SDK_INT >= 21) && (localRect != null)) {
        paramDrawable.setHotspotBounds(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
      return;
    }
    finally
    {
      paramDrawable.setCallback(this.mBlockInvalidateCallback.unwrap());
    }
  }
  
  private boolean needsMirroring()
  {
    return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
  }
  
  static int resolveDensity(@Nullable Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 160;
    }
    return i;
  }
  
  void animate(boolean paramBoolean)
  {
    int j = 1;
    this.mHasAlpha = true;
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable = this.mCurrDrawable;
    long l2;
    if (localDrawable != null)
    {
      l2 = this.mEnterAnimationEnd;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setAlpha(this.mAlpha);
          this.mEnterAnimationEnd = 0L;
        }
        else
        {
          i = (int)((l2 - l1) * 255L) / this.mDrawableContainerState.mEnterFadeDuration;
          this.mCurrDrawable.setAlpha((255 - i) * this.mAlpha / 255);
          i = 1;
          break label113;
        }
      }
    }
    else
    {
      this.mEnterAnimationEnd = 0L;
    }
    int i = 0;
    label113:
    localDrawable = this.mLastDrawable;
    if (localDrawable != null)
    {
      l2 = this.mExitAnimationEnd;
      if (l2 != 0L) {
        if (l2 <= l1)
        {
          localDrawable.setVisible(false, false);
          this.mLastDrawable = null;
          this.mExitAnimationEnd = 0L;
        }
        else
        {
          i = (int)((l2 - l1) * 255L) / this.mDrawableContainerState.mExitFadeDuration;
          this.mLastDrawable.setAlpha(i * this.mAlpha / 255);
          i = j;
        }
      }
    }
    else
    {
      this.mExitAnimationEnd = 0L;
    }
    if ((paramBoolean) && (i != 0)) {
      scheduleSelf(this.mAnimationRunnable, l1 + 16L);
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    this.mDrawableContainerState.applyTheme(paramTheme);
  }
  
  @RequiresApi(21)
  public boolean canApplyTheme()
  {
    return this.mDrawableContainerState.canApplyTheme();
  }
  
  void clearMutated()
  {
    this.mDrawableContainerState.clearMutated();
    this.mMutated = false;
  }
  
  DrawableContainer.DrawableContainerState cloneConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (this.mDrawableContainerState.canConstantState())
    {
      this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
      return this.mDrawableContainerState;
    }
    return null;
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    return this.mCurrDrawable;
  }
  
  int getCurrentIndex()
  {
    return this.mCurIndex;
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    Rect localRect = this.mHotspotBounds;
    if (localRect != null)
    {
      paramRect.set(localRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantHeight();
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantWidth();
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumHeight();
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    if (this.mDrawableContainerState.isConstantSize()) {
      return this.mDrawableContainerState.getConstantMinimumWidth();
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && (localDrawable.isVisible())) {
      return this.mDrawableContainerState.getOpacity();
    }
    return -2;
  }
  
  @RequiresApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    Object localObject = this.mDrawableContainerState.getConstantPadding();
    int i;
    boolean bool;
    if (localObject != null)
    {
      paramRect.set((Rect)localObject);
      i = ((Rect)localObject).left;
      int j = ((Rect)localObject).top;
      int k = ((Rect)localObject).bottom;
      if ((((Rect)localObject).right | i | j | k) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        bool = ((Drawable)localObject).getPadding(paramRect);
      } else {
        bool = super.getPadding(paramRect);
      }
    }
    if (needsMirroring())
    {
      i = paramRect.left;
      paramRect.left = paramRect.right;
      paramRect.right = i;
    }
    return bool;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    DrawableContainer.DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    if (localDrawableContainerState != null) {
      localDrawableContainerState.invalidateCache();
    }
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.mDrawableContainerState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    return this.mDrawableContainerState.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    Drawable localDrawable = this.mLastDrawable;
    int i;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      this.mLastDrawable = null;
      i = 1;
    }
    else
    {
      i = 0;
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      if (this.mHasAlpha) {
        this.mCurrDrawable.setAlpha(this.mAlpha);
      }
    }
    if (this.mExitAnimationEnd != 0L)
    {
      this.mExitAnimationEnd = 0L;
      i = 1;
    }
    if (this.mEnterAnimationEnd != 0L)
    {
      this.mEnterAnimationEnd = 0L;
      i = 1;
    }
    if (i != 0) {
      invalidateSelf();
    }
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      DrawableContainer.DrawableContainerState localDrawableContainerState = cloneConstantState();
      localDrawableContainerState.mutate();
      setConstantState(localDrawableContainerState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    return this.mDrawableContainerState.setLayoutDirection(paramInt, getCurrentIndex());
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  boolean selectDrawable(int paramInt)
  {
    if (paramInt == this.mCurIndex) {
      return false;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject;
    if (this.mDrawableContainerState.mExitFadeDuration > 0)
    {
      localObject = this.mLastDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      localObject = this.mCurrDrawable;
      if (localObject != null)
      {
        this.mLastDrawable = ((Drawable)localObject);
        this.mExitAnimationEnd = (this.mDrawableContainerState.mExitFadeDuration + l);
      }
      else
      {
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0L;
      }
    }
    else
    {
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
    }
    if ((paramInt >= 0) && (paramInt < this.mDrawableContainerState.mNumChildren))
    {
      localObject = this.mDrawableContainerState.getChild(paramInt);
      this.mCurrDrawable = ((Drawable)localObject);
      this.mCurIndex = paramInt;
      if (localObject != null)
      {
        if (this.mDrawableContainerState.mEnterFadeDuration > 0) {
          this.mEnterAnimationEnd = (l + this.mDrawableContainerState.mEnterFadeDuration);
        }
        initializeDrawableForDisplay((Drawable)localObject);
      }
    }
    else
    {
      this.mCurrDrawable = null;
      this.mCurIndex = -1;
    }
    if ((this.mEnterAnimationEnd != 0L) || (this.mExitAnimationEnd != 0L))
    {
      localObject = this.mAnimationRunnable;
      if (localObject == null) {
        this.mAnimationRunnable = new DrawableContainer.1(this);
      } else {
        unscheduleSelf((Runnable)localObject);
      }
      animate(true);
    }
    invalidateSelf();
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.mHasAlpha) || (this.mAlpha != paramInt))
    {
      this.mHasAlpha = true;
      this.mAlpha = paramInt;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null)
      {
        if (this.mEnterAnimationEnd == 0L)
        {
          localDrawable.setAlpha(paramInt);
          return;
        }
        animate(false);
      }
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mAutoMirrored != paramBoolean)
    {
      DrawableContainer.DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
      localDrawableContainerState.mAutoMirrored = paramBoolean;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        DrawableCompat.setAutoMirrored(localDrawable, localDrawableContainerState.mAutoMirrored);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = this.mDrawableContainerState;
    ((DrawableContainer.DrawableContainerState)localObject).mHasColorFilter = true;
    if (((DrawableContainer.DrawableContainerState)localObject).mColorFilter != paramColorFilter)
    {
      this.mDrawableContainerState.mColorFilter = paramColorFilter;
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
    }
  }
  
  void setConstantState(DrawableContainer.DrawableContainerState paramDrawableContainerState)
  {
    this.mDrawableContainerState = paramDrawableContainerState;
    int i = this.mCurIndex;
    if (i >= 0)
    {
      this.mCurrDrawable = paramDrawableContainerState.getChild(i);
      paramDrawableContainerState = this.mCurrDrawable;
      if (paramDrawableContainerState != null) {
        initializeDrawableForDisplay(paramDrawableContainerState);
      }
    }
    this.mLastDrawable = null;
  }
  
  void setCurrentIndex(int paramInt)
  {
    selectDrawable(paramInt);
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mDither != paramBoolean)
    {
      DrawableContainer.DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
      localDrawableContainerState.mDither = paramBoolean;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        localDrawable.setDither(localDrawableContainerState.mDither);
      }
    }
  }
  
  public void setEnterFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mEnterFadeDuration = paramInt;
  }
  
  public void setExitFadeDuration(int paramInt)
  {
    this.mDrawableContainerState.mExitFadeDuration = paramInt;
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mHotspotBounds;
    if (localObject == null) {
      this.mHotspotBounds = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      ((Rect)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.mCurrDrawable;
    if (localObject != null) {
      DrawableCompat.setHotspotBounds((Drawable)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    DrawableContainer.DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    localDrawableContainerState.mHasTintList = true;
    if (localDrawableContainerState.mTintList != paramColorStateList)
    {
      this.mDrawableContainerState.mTintList = paramColorStateList;
      DrawableCompat.setTintList(this.mCurrDrawable, paramColorStateList);
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    DrawableContainer.DrawableContainerState localDrawableContainerState = this.mDrawableContainerState;
    localDrawableContainerState.mHasTintMode = true;
    if (localDrawableContainerState.mTintMode != paramMode)
    {
      this.mDrawableContainerState.mTintMode = paramMode;
      DrawableCompat.setTintMode(this.mCurrDrawable, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.mLastDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    if ((paramDrawable == this.mCurrDrawable) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
  
  final void updateDensity(Resources paramResources)
  {
    this.mDrawableContainerState.updateDensity(paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.DrawableContainer
 * JD-Core Version:    0.7.0.1
 */