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
  private static final int a = R.style.A;
  private static final int[][] b;
  @Nullable
  private ColorStateList c;
  private boolean d;
  
  static
  {
    int[] arrayOfInt = { -16842910, -16842912 };
    b = new int[][] { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, arrayOfInt };
  }
  
  public MaterialCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCheckBox(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.i);
  }
  
  public MaterialCheckBox(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.eF, paramInt, a, new int[0]);
    if (paramAttributeSet.hasValue(R.styleable.eG)) {
      CompoundButtonCompat.setButtonTintList(this, MaterialResources.a(paramContext, paramAttributeSet, R.styleable.eG));
    }
    this.d = paramAttributeSet.getBoolean(R.styleable.eH, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (this.c == null)
    {
      int[] arrayOfInt = new int[b.length];
      int i = MaterialColors.a(this, R.attr.n);
      int j = MaterialColors.a(this, R.attr.t);
      int k = MaterialColors.a(this, R.attr.q);
      arrayOfInt[0] = MaterialColors.a(j, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(j, k, 0.54F);
      arrayOfInt[2] = MaterialColors.a(j, k, 0.38F);
      arrayOfInt[3] = MaterialColors.a(j, k, 0.38F);
      this.c = new ColorStateList(b, arrayOfInt);
    }
    return this.c;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.d) && (CompoundButtonCompat.getButtonTintList(this) == null)) {
      setUseMaterialThemeColors(true);
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (paramBoolean)
    {
      CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
      return;
    }
    CompoundButtonCompat.setButtonTintList(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.checkbox.MaterialCheckBox
 * JD-Core Version:    0.7.0.1
 */