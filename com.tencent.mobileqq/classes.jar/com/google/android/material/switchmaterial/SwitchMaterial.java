package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class SwitchMaterial
  extends SwitchCompat
{
  private static final int jdField_a_of_type_Int = R.style.A;
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @NonNull
  private final ElevationOverlayProvider jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private ColorStateList b;
  
  public SwitchMaterial(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchMaterial(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchMaterial(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider = new ElevationOverlayProvider(paramContext);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.aw, paramInt, jdField_a_of_type_Int, new int[0]);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.eP, false);
    paramContext.recycle();
  }
  
  private ColorStateList a()
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null)
    {
      int i = MaterialColors.a(this, R.attr.n);
      int j = MaterialColors.a(this, R.attr.colorControlActivated);
      float f2 = getResources().getDimension(R.dimen.aq);
      float f1 = f2;
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider.a()) {
        f1 = f2 + ViewUtils.a(this);
      }
      int k = this.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider.a(i, f1);
      int[] arrayOfInt = new int[jdField_a_of_type_Array2dOfInt.length];
      arrayOfInt[0] = MaterialColors.a(i, j, 1.0F);
      arrayOfInt[1] = k;
      arrayOfInt[2] = MaterialColors.a(i, j, 0.38F);
      arrayOfInt[3] = k;
      this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(jdField_a_of_type_Array2dOfInt, arrayOfInt);
    }
    return this.jdField_a_of_type_AndroidContentResColorStateList;
  }
  
  private ColorStateList b()
  {
    if (this.b == null)
    {
      int[] arrayOfInt = new int[jdField_a_of_type_Array2dOfInt.length];
      int i = MaterialColors.a(this, R.attr.n);
      int j = MaterialColors.a(this, R.attr.colorControlActivated);
      int k = MaterialColors.a(this, R.attr.l);
      arrayOfInt[0] = MaterialColors.a(i, j, 0.54F);
      arrayOfInt[1] = MaterialColors.a(i, k, 0.32F);
      arrayOfInt[2] = MaterialColors.a(i, j, 0.12F);
      arrayOfInt[3] = MaterialColors.a(i, k, 0.12F);
      this.b = new ColorStateList(jdField_a_of_type_Array2dOfInt, arrayOfInt);
    }
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_a_of_type_Boolean) && (getThumbTintList() == null)) {
      setThumbTintList(a());
    }
    if ((this.jdField_a_of_type_Boolean) && (getTrackTintList() == null)) {
      setTrackTintList(b());
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      setThumbTintList(a());
      setTrackTintList(b());
      return;
    }
    setThumbTintList(null);
    setTrackTintList(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.switchmaterial.SwitchMaterial
 * JD-Core Version:    0.7.0.1
 */