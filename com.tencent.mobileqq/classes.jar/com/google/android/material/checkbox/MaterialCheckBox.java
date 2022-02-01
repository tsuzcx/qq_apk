package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialCheckBox
  extends AppCompatCheckBox
{
  private static final int jdField_a_of_type_Int = R.style.y;
  private static final int[][] jdField_a_of_type_Array2dOfInt;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    int[] arrayOfInt1 = { -16842910, 16842912 };
    int[] arrayOfInt2 = { -16842910, -16842912 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 16842910, 16842912 }, { 16842910, -16842912 }, arrayOfInt1, arrayOfInt2 };
  }
  
  public MaterialCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCheckBox(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public MaterialCheckBox(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.U, paramInt, jdField_a_of_type_Int, new int[0]);
    if (paramAttributeSet.hasValue(R.styleable.de)) {
      CompoundButtonCompat.setButtonTintList(this, MaterialResources.a(paramContext, paramAttributeSet, R.styleable.de));
    }
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(R.styleable.df, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList a()
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null)
    {
      int[] arrayOfInt = new int[jdField_a_of_type_Array2dOfInt.length];
      int i = MaterialColors.a(this, R.attr.colorControlActivated);
      int j = MaterialColors.a(this, R.attr.n);
      int k = MaterialColors.a(this, R.attr.l);
      arrayOfInt[0] = MaterialColors.a(j, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(j, k, 0.54F);
      arrayOfInt[2] = MaterialColors.a(j, k, 0.38F);
      arrayOfInt[3] = MaterialColors.a(j, k, 0.38F);
      this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(jdField_a_of_type_Array2dOfInt, arrayOfInt);
    }
    return this.jdField_a_of_type_AndroidContentResColorStateList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_Boolean) && (CompoundButtonCompat.getButtonTintList(this) == null)) {
      setUseMaterialThemeColors(true);
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      CompoundButtonCompat.setButtonTintList(this, a());
      return;
    }
    CompoundButtonCompat.setButtonTintList(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.checkbox.MaterialCheckBox
 * JD-Core Version:    0.7.0.1
 */