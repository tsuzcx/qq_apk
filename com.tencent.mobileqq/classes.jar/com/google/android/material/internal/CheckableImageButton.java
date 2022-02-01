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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c = true;
  
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
    return this.b;
  }
  
  public boolean isChecked()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return mergeDrawableStates(super.onCreateDrawableState(paramInt + jdField_a_of_type_ArrayOfInt.length), jdField_a_of_type_ArrayOfInt);
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
    setChecked(paramParcelable.jdField_a_of_type_Boolean);
  }
  
  @NonNull
  protected Parcelable onSaveInstanceState()
  {
    CheckableImageButton.SavedState localSavedState = new CheckableImageButton.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    return localSavedState;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      sendAccessibilityEvent(0);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((this.b) && (this.jdField_a_of_type_Boolean != paramBoolean))
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setPressable(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (this.c) {
      super.setPressed(paramBoolean);
    }
  }
  
  public void toggle()
  {
    setChecked(this.jdField_a_of_type_Boolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.CheckableImageButton
 * JD-Core Version:    0.7.0.1
 */