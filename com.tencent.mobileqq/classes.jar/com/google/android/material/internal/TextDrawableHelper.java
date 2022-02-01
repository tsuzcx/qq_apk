package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper
{
  private float jdField_a_of_type_Float;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  @Nullable
  private TextAppearance jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance;
  private final TextAppearanceFontCallback jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback = new TextDrawableHelper.1(this);
  @Nullable
  private WeakReference<TextDrawableHelper.TextDrawableDelegate> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
  private boolean jdField_a_of_type_Boolean = true;
  
  public TextDrawableHelper(@Nullable TextDrawableHelper.TextDrawableDelegate paramTextDrawableDelegate)
  {
    a(paramTextDrawableDelegate);
  }
  
  private float a(@Nullable CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public float a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_Float;
    }
    this.jdField_a_of_type_Float = a(paramString);
    this.jdField_a_of_type_Boolean = false;
    return this.jdField_a_of_type_Float;
  }
  
  @NonNull
  public TextPaint a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint;
  }
  
  @Nullable
  public TextAppearance a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance.b(paramContext, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback);
  }
  
  public void a(@Nullable TextDrawableHelper.TextDrawableDelegate paramTextDrawableDelegate)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTextDrawableDelegate);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance, Context paramContext)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance != paramTextAppearance)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearance = paramTextAppearance;
      if (paramTextAppearance != null)
      {
        paramTextAppearance.c(paramContext, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback);
        TextDrawableHelper.TextDrawableDelegate localTextDrawableDelegate = (TextDrawableHelper.TextDrawableDelegate)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localTextDrawableDelegate != null) {
          this.jdField_a_of_type_AndroidTextTextPaint.drawableState = localTextDrawableDelegate.getState();
        }
        paramTextAppearance.b(paramContext, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesTextAppearanceFontCallback);
        this.jdField_a_of_type_Boolean = true;
      }
      paramTextAppearance = (TextDrawableHelper.TextDrawableDelegate)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramTextAppearance != null)
      {
        paramTextAppearance.a();
        paramTextAppearance.onStateChange(paramTextAppearance.getState());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.TextDrawableHelper
 * JD-Core Version:    0.7.0.1
 */