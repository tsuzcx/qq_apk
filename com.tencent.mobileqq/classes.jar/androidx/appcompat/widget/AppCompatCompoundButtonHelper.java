package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  @NonNull
  private final CompoundButton mView;
  
  AppCompatCompoundButtonHelper(@NonNull CompoundButton paramCompoundButton)
  {
    this.mView = paramCompoundButton;
  }
  
  void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
    if ((localDrawable != null) && ((this.mHasButtonTint) || (this.mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.mHasButtonTint) {
        DrawableCompat.setTintList(localDrawable, this.mButtonTintList);
      }
      if (this.mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, this.mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.mView.getDrawableState());
      }
      this.mView.setButtonDrawable(localDrawable);
    }
  }
  
  int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList getSupportButtonTintList()
  {
    return this.mButtonTintList;
  }
  
  PorterDuff.Mode getSupportButtonTintMode()
  {
    return this.mButtonTintMode;
  }
  
  void loadFromAttributes(@Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    CompoundButton localCompoundButton = this.mView;
    ViewCompat.saveAttributeDataForStyleable(localCompoundButton, localCompoundButton.getContext(), R.styleable.CompoundButton, paramAttributeSet, localTintTypedArray.getWrappedTypeArray(), paramInt, 0);
    try
    {
      if (localTintTypedArray.hasValue(R.styleable.CompoundButton_buttonCompat))
      {
        paramInt = localTintTypedArray.getResourceId(R.styleable.CompoundButton_buttonCompat, 0);
        if (paramInt == 0) {}
      }
    }
    finally
    {
      label89:
      localTintTypedArray.recycle();
    }
    try
    {
      this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), paramInt));
      paramInt = 1;
    }
    catch (Resources.NotFoundException paramAttributeSet)
    {
      break label89;
    }
    paramInt = 0;
    if ((paramInt == 0) && (localTintTypedArray.hasValue(R.styleable.CompoundButton_android_button)))
    {
      paramInt = localTintTypedArray.getResourceId(R.styleable.CompoundButton_android_button, 0);
      if (paramInt != 0) {
        this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), paramInt));
      }
    }
    if (localTintTypedArray.hasValue(R.styleable.CompoundButton_buttonTint)) {
      CompoundButtonCompat.setButtonTintList(this.mView, localTintTypedArray.getColorStateList(R.styleable.CompoundButton_buttonTint));
    }
    if (localTintTypedArray.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
      CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
    }
    localTintTypedArray.recycle();
  }
  
  void onSetButtonDrawable()
  {
    if (this.mSkipNextApply)
    {
      this.mSkipNextApply = false;
      return;
    }
    this.mSkipNextApply = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.mButtonTintList = paramColorStateList;
    this.mHasButtonTint = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mButtonTintMode = paramMode;
    this.mHasButtonTintMode = true;
    applyButtonTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCompoundButtonHelper
 * JD-Core Version:    0.7.0.1
 */