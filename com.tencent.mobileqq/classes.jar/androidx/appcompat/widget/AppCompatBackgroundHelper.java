package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper
{
  private int mBackgroundResId = -1;
  private TintInfo mBackgroundTint;
  private final AppCompatDrawableManager mDrawableManager;
  private TintInfo mInternalBackgroundTint;
  private TintInfo mTmpInfo;
  @NonNull
  private final View mView;
  
  AppCompatBackgroundHelper(@NonNull View paramView)
  {
    this.mView = paramView;
    this.mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable)
  {
    if (this.mTmpInfo == null) {
      this.mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    Object localObject = ViewCompat.getBackgroundTintList(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = ((ColorStateList)localObject);
    }
    localObject = ViewCompat.getBackgroundTintMode(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintMode = true;
      localTintInfo.mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((!localTintInfo.mHasTintList) && (!localTintInfo.mHasTintMode)) {
      return false;
    }
    AppCompatDrawableManager.tintDrawable(paramDrawable, localTintInfo, this.mView.getDrawableState());
    return true;
  }
  
  private boolean shouldApplyFrameworkTintUsingColorFilter()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      return this.mInternalBackgroundTint != null;
    }
    return i == 21;
  }
  
  void applySupportBackgroundTint()
  {
    Drawable localDrawable = this.mView.getBackground();
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = this.mBackgroundTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
        return;
      }
      localTintInfo = this.mInternalBackgroundTint;
      if (localTintInfo != null) {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
      }
    }
  }
  
  ColorStateList getSupportBackgroundTintList()
  {
    TintInfo localTintInfo = this.mBackgroundTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintList;
    }
    return null;
  }
  
  PorterDuff.Mode getSupportBackgroundTintMode()
  {
    TintInfo localTintInfo = this.mBackgroundTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintMode;
    }
    return null;
  }
  
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    View localView = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localView, localView.getContext(), R.styleable.ViewBackgroundHelper, paramAttributeSet, localTintTypedArray.getWrappedTypeArray(), paramInt, 0);
    try
    {
      if (localTintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background))
      {
        this.mBackgroundResId = localTintTypedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        paramAttributeSet = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
        if (paramAttributeSet != null) {
          setInternalBackgroundTint(paramAttributeSet);
        }
      }
      if (localTintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
        ViewCompat.setBackgroundTintList(this.mView, localTintTypedArray.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
      }
      if (localTintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
      }
      return;
    }
    finally
    {
      localTintTypedArray.recycle();
    }
  }
  
  void onSetBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackgroundResId = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  void onSetBackgroundResource(int paramInt)
  {
    this.mBackgroundResId = paramInt;
    Object localObject = this.mDrawableManager;
    if (localObject != null) {
      localObject = ((AppCompatDrawableManager)localObject).getTintList(this.mView.getContext(), paramInt);
    } else {
      localObject = null;
    }
    setInternalBackgroundTint((ColorStateList)localObject);
    applySupportBackgroundTint();
  }
  
  void setInternalBackgroundTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalBackgroundTint == null) {
        this.mInternalBackgroundTint = new TintInfo();
      }
      TintInfo localTintInfo = this.mInternalBackgroundTint;
      localTintInfo.mTintList = paramColorStateList;
      localTintInfo.mHasTintList = true;
    }
    else
    {
      this.mInternalBackgroundTint = null;
    }
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTint == null) {
      this.mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mBackgroundTint;
    localTintInfo.mTintList = paramColorStateList;
    localTintInfo.mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTint == null) {
      this.mBackgroundTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mBackgroundTint;
    localTintInfo.mTintMode = paramMode;
    localTintInfo.mHasTintMode = true;
    applySupportBackgroundTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatBackgroundHelper
 * JD-Core Version:    0.7.0.1
 */