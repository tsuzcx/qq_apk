package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R.styleable;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance
{
  public final float a;
  public final int a;
  @Nullable
  public final ColorStateList a;
  private Typeface a;
  @Nullable
  public final String a;
  public final boolean a;
  public final float b;
  public final int b;
  @Nullable
  public final ColorStateList b;
  public final boolean b;
  public final float c;
  @FontRes
  private final int jdField_c_of_type_Int;
  @Nullable
  public final ColorStateList c;
  private boolean jdField_c_of_type_Boolean = false;
  public final float d;
  @Nullable
  public final ColorStateList d;
  public float e;
  
  public TextAppearance(@NonNull Context paramContext, @StyleRes int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    this.e = localTypedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColor);
    this.jdField_b_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorHint);
    this.jdField_c_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorLink);
    this.jdField_a_of_type_Int = localTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
    this.jdField_b_of_type_Int = localTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
    int i = MaterialResources.a(localTypedArray, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
    this.jdField_c_of_type_Int = localTypedArray.getResourceId(i, 0);
    this.jdField_a_of_type_JavaLangString = localTypedArray.getString(i);
    this.jdField_a_of_type_Boolean = localTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
    this.jdField_d_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_shadowColor);
    this.jdField_a_of_type_Float = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.jdField_b_of_type_Float = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.jdField_c_of_type_Float = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.X);
      this.jdField_b_of_type_Boolean = paramContext.hasValue(R.styleable.dk);
      this.jdField_d_of_type_Float = paramContext.getFloat(R.styleable.dk, 0.0F);
      paramContext.recycle();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Float = 0.0F;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsTypeface == null)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.create(str, this.jdField_a_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsTypeface == null)
    {
      int i = this.jdField_b_of_type_Int;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
          } else {
            this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.MONOSPACE;
          }
        }
        else {
          this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.SERIF;
        }
      }
      else {
        this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.SANS_SERIF;
      }
      this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.create(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_Int);
    }
  }
  
  private boolean a(Context paramContext)
  {
    return TextAppearanceConfig.a();
  }
  
  public Typeface a()
  {
    a();
    return this.jdField_a_of_type_AndroidGraphicsTypeface;
  }
  
  @NonNull
  @VisibleForTesting
  public Typeface a(@NonNull Context paramContext)
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_AndroidGraphicsTypeface;
    }
    if (!paramContext.isRestricted()) {}
    try
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsTypeface = ResourcesCompat.getFont(paramContext, this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
          this.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.create(this.jdField_a_of_type_AndroidGraphicsTypeface, this.jdField_a_of_type_Int);
        }
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error loading font ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      label92:
      break label92;
    }
    a();
    this.jdField_c_of_type_Boolean = true;
    return this.jdField_a_of_type_AndroidGraphicsTypeface;
  }
  
  public void a(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    a(paramTextPaint, a());
    a(paramContext, new TextAppearance.2(this, paramTextPaint, paramTextAppearanceFontCallback));
  }
  
  public void a(@NonNull Context paramContext, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    if (a(paramContext)) {
      a(paramContext);
    } else {
      a();
    }
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramTextAppearanceFontCallback.a(this.jdField_a_of_type_AndroidGraphicsTypeface, true);
      return;
    }
    try
    {
      ResourcesCompat.getFont(paramContext, this.jdField_c_of_type_Int, new TextAppearance.1(this, paramTextAppearanceFontCallback), null);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error loading font ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      this.jdField_c_of_type_Boolean = true;
      paramTextAppearanceFontCallback.a(-3);
      return;
      this.jdField_c_of_type_Boolean = true;
      paramTextAppearanceFontCallback.a(1);
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label117:
      break label117;
    }
  }
  
  public void a(@NonNull TextPaint paramTextPaint, @NonNull Typeface paramTypeface)
  {
    paramTextPaint.setTypeface(paramTypeface);
    int i = this.jdField_a_of_type_Int;
    i = (paramTypeface.getStyle() ^ 0xFFFFFFFF) & i;
    boolean bool;
    if ((i & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextPaint.setFakeBoldText(bool);
    float f;
    if ((i & 0x2) != 0) {
      f = -0.25F;
    } else {
      f = 0.0F;
    }
    paramTextPaint.setTextSkewX(f);
    paramTextPaint.setTextSize(this.e);
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_b_of_type_Boolean)) {
      paramTextPaint.setLetterSpacing(this.jdField_d_of_type_Float);
    }
  }
  
  public void b(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    c(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
    paramContext = this.jdField_a_of_type_AndroidContentResColorStateList;
    int i;
    if (paramContext != null) {
      i = paramContext.getColorForState(paramTextPaint.drawableState, this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor());
    } else {
      i = -16777216;
    }
    paramTextPaint.setColor(i);
    float f1 = this.jdField_c_of_type_Float;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_b_of_type_Float;
    paramContext = this.jdField_d_of_type_AndroidContentResColorStateList;
    if (paramContext != null) {
      i = paramContext.getColorForState(paramTextPaint.drawableState, this.jdField_d_of_type_AndroidContentResColorStateList.getDefaultColor());
    } else {
      i = 0;
    }
    paramTextPaint.setShadowLayer(f1, f2, f3, i);
  }
  
  public void c(@NonNull Context paramContext, @NonNull TextPaint paramTextPaint, @NonNull TextAppearanceFontCallback paramTextAppearanceFontCallback)
  {
    if (a(paramContext))
    {
      a(paramTextPaint, a(paramContext));
      return;
    }
    a(paramContext, paramTextPaint, paramTextAppearanceFontCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.resources.TextAppearance
 * JD-Core Version:    0.7.0.1
 */