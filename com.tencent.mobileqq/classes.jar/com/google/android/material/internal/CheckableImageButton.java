package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton
  extends AppCompatImageButton
  implements Checkable
{
  private static final int[] a = { 16842912 };
  private boolean b;
  private boolean c = true;
  private boolean d = true;
  
  public CheckableImageButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.imageButtonStyle);
  }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewCompat.setAccessibilityDelegate(this, new CheckableImageButton.1(this));
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean isChecked()
  {
    return this.b;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.b) {
      return mergeDrawableStates(super.onCreateDrawableState(paramInt + a.length), a);
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CheckableImageButton.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (CheckableImageButton.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setChecked(paramParcelable.a);
  }
  
  @NonNull
  protected Parcelable onSaveInstanceState()
  {
    CheckableImageButton.SavedState localSavedState = new CheckableImageButton.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.b;
    return localSavedState;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      sendAccessibilityEvent(0);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((this.c) && (this.b != paramBoolean))
    {
      this.b = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setPressable(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (this.d) {
      super.setPressed(paramBoolean);
    }
  }
  
  public void toggle()
  {
    setChecked(this.b ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */