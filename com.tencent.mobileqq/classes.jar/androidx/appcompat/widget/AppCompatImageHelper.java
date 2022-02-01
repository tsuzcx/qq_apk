package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper
{
  private TintInfo mImageTint;
  private TintInfo mInternalImageTint;
  private TintInfo mTmpInfo;
  @NonNull
  private final ImageView mView;
  
  public AppCompatImageHelper(@NonNull ImageView paramImageView)
  {
    this.mView = paramImageView;
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable)
  {
    if (this.mTmpInfo == null) {
      this.mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    Object localObject = ImageViewCompat.getImageTintList(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = ((ColorStateList)localObject);
    }
    localObject = ImageViewCompat.getImageTintMode(this.mView);
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
      return this.mInternalImageTint != null;
    }
    return i == 21;
  }
  
  void applySupportImageTint()
  {
    Drawable localDrawable = this.mView.getDrawable();
    if (localDrawable != null) {
      DrawableUtils.fixDrawable(localDrawable);
    }
    if (localDrawable != null)
    {
      if ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))) {
        return;
      }
      TintInfo localTintInfo = this.mImageTint;
      if (localTintInfo != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
        return;
      }
      localTintInfo = this.mInternalImageTint;
      if (localTintInfo != null) {
        AppCompatDrawableManager.tintDrawable(localDrawable, localTintInfo, this.mView.getDrawableState());
      }
    }
  }
  
  ColorStateList getSupportImageTintList()
  {
    TintInfo localTintInfo = this.mImageTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintList;
    }
    return null;
  }
  
  PorterDuff.Mode getSupportImageTintMode()
  {
    TintInfo localTintInfo = this.mImageTint;
    if (localTintInfo != null) {
      return localTintInfo.mTintMode;
    }
    return null;
  }
  
  boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.mView.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    Object localObject = this.mView;
    ViewCompat.saveAttributeDataForStyleable((View)localObject, ((ImageView)localObject).getContext(), R.styleable.AppCompatImageView, paramAttributeSet, localTintTypedArray.getWrappedTypeArray(), paramInt, 0);
    try
    {
      localObject = this.mView.getDrawable();
      paramAttributeSet = (AttributeSet)localObject;
      if (localObject == null)
      {
        paramInt = localTintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = (AttributeSet)localObject;
        if (paramInt != -1)
        {
          localObject = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
          paramAttributeSet = (AttributeSet)localObject;
          if (localObject != null)
          {
            this.mView.setImageDrawable((Drawable)localObject);
            paramAttributeSet = (AttributeSet)localObject;
          }
        }
      }
      if (paramAttributeSet != null) {
        DrawableUtils.fixDrawable(paramAttributeSet);
      }
      if (localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tint)) {
        ImageViewCompat.setImageTintList(this.mView, localTintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint));
      }
      if (localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode)) {
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localTintTypedArray.recycle();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
      if (localDrawable != null) {
        DrawableUtils.fixDrawable(localDrawable);
      }
      this.mView.setImageDrawable(localDrawable);
    }
    else
    {
      this.mView.setImageDrawable(null);
    }
    applySupportImageTint();
  }
  
  void setInternalImageTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalImageTint == null) {
        this.mInternalImageTint = new TintInfo();
      }
      TintInfo localTintInfo = this.mInternalImageTint;
      localTintInfo.mTintList = paramColorStateList;
      localTintInfo.mHasTintList = true;
    }
    else
    {
      this.mInternalImageTint = null;
    }
    applySupportImageTint();
  }
  
  void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mImageTint;
    localTintInfo.mTintList = paramColorStateList;
    localTintInfo.mHasTintList = true;
    applySupportImageTint();
  }
  
  void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    TintInfo localTintInfo = this.mImageTint;
    localTintInfo.mTintMode = paramMode;
    localTintInfo.mHasTintMode = true;
    applySupportImageTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageHelper
 * JD-Core Version:    0.7.0.1
 */