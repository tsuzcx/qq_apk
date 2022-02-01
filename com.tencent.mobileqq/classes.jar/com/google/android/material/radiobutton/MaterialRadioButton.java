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
  private static final int a = R.style.B;
  private static final int[][] b = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  @Nullable
  private ColorStateList c;
  private boolean d;
  
  public MaterialRadioButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.O);
  }
  
  public MaterialRadioButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.eI, paramInt, a, new int[0]);
    if (paramAttributeSet.hasValue(R.styleable.eJ)) {
      CompoundButtonCompat.setButtonTintList(this, MaterialResources.a(paramContext, paramAttributeSet, R.styleable.eJ));
    }
    this.d = paramAttributeSet.getBoolean(R.styleable.eK, false);
    paramAttributeSet.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsTintList()
  {
    if (this.c == null)
    {
      int i = MaterialColors.a(this, R.attr.n);
      int j = MaterialColors.a(this, R.attr.q);
      int k = MaterialColors.a(this, R.attr.t);
      int[] arrayOfInt = new int[b.length];
      arrayOfInt[0] = MaterialColors.a(k, i, 1.0F);
      arrayOfInt[1] = MaterialColors.a(k, j, 0.54F);
      arrayOfInt[2] = MaterialColors.a(k, j, 0.38F);
      arrayOfInt[3] = MaterialColors.a(k, j, 0.38F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.radiobutton.MaterialRadioButton
 * JD-Core Version:    0.7.0.1
 */