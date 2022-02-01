package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat.FontCallback;

class TextAppearance$1
  extends ResourcesCompat.FontCallback
{
  TextAppearance$1(TextAppearance paramTextAppearance, TextAppearanceFontCallback paramTextAppearanceFontCallback) {}
  
  public void onFontRetrievalFailed(int paramInt)
  {
    TextAppearance.a(this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance, true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback.a(paramInt);
  }
  
  public void onFontRetrieved(@NonNull Typeface paramTypeface)
  {
    TextAppearance localTextAppearance = this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance;
    TextAppearance.a(localTextAppearance, Typeface.create(paramTypeface, localTextAppearance.a));
    TextAppearance.a(this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance, true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback.a(TextAppearance.a(this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.resources.TextAppearance.1
 * JD-Core Version:    0.7.0.1
 */