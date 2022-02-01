package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialRadioButton
  extends AppCompatRadioButton
{
  private static final int jdField_a_of_type_Int = R.style.z;
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private boolean jdField_a_of_type_Boolean;
  
  public MaterialRadioButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.radioButtonStyle);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.V, paramInt, jdField_a_of_type_Int, new int[0]);
    if (paramAttributeSet.hasValue(R.styleable.dg)) {
      CompoundButtonCompat.setButtonTintList(this, MaterialResources.a(paramContext, paramAttributeSet, R.styleable.dg));
    }
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(R.styleable.dh, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList a()
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null)
    {
      int i = MaterialColors.a(this, R.attr.colorControlActivated);
      int j = MaterialColors.a(this, R.attr.l);
      int k = MaterialColors.a(this, R.attr.n);
      int[] arrayOfInt = new int[jdField_a_of_type_Array2dOfInt.length];
      arrayOfInt[0] = MaterialColors.a(k, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(k, j, 0.54F);
      arrayOfInt[2] = MaterialColors.a(k, j, 0.38F);
      arrayOfInt[3] = MaterialColors.a(k, j, 0.38F);
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
 * Qualified Name:     com.google.android.material.radiobutton.MaterialRadioButton
 * JD-Core Version:    0.7.0.1
 */