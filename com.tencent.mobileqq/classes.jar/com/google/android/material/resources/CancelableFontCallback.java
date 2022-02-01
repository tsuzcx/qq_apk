package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback
  extends TextAppearanceFontCallback
{
  private final Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private final CancelableFontCallback.ApplyFont jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback$ApplyFont;
  private boolean jdField_a_of_type_Boolean;
  
  public CancelableFontCallback(CancelableFontCallback.ApplyFont paramApplyFont, Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback$ApplyFont = paramApplyFont;
  }
  
  private void a(Typeface paramTypeface)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback$ApplyFont.a(paramTypeface);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidGraphicsTypeface);
  }
  
  public void a(Typeface paramTypeface, boolean paramBoolean)
  {
    a(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.resources.CancelableFontCallback
 * JD-Core Version:    0.7.0.1
 */