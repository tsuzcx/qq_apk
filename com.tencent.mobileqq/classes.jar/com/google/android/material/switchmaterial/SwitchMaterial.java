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
  private static final int a = R.style.C;
  private static final int[][] b = { { 16842910, 16842912 }, { 16842910, -16842912 }, { -16842910, 16842912 }, { -16842910, -16842912 } };
  @NonNull
  private final ElevationOverlayProvider c;
  @Nullable
  private ColorStateList d;
  @Nullable
  private ColorStateList e;
  private boolean f;
  
  public SwitchMaterial(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchMaterial(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.Y);
  }
  
  public SwitchMaterial(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.c = new ElevationOverlayProvider(paramContext);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.he, paramInt, a, new int[0]);
    this.f = paramContext.getBoolean(R.styleable.hf, false);
    paramContext.recycle();
  }
  
  private ColorStateList getMaterialThemeColorsThumbTintList()
  {
    if (this.d == null)
    {
      int i = MaterialColors.a(this, R.attr.t);
      int j = MaterialColors.a(this, R.attr.n);
      float f2 = getResources().getDimension(R.dimen.aq);
      float f1 = f2;
      if (this.c.a()) {
        f1 = f2 + ViewUtils.d(this);
      }
      int k = this.c.a(i, f1);
      int[] arrayOfInt = new int[b.length];
      arrayOfInt[0] = MaterialColors.a(i, j, 1.0F);
      arrayOfInt[1] = k;
      arrayOfInt[2] = MaterialColors.a(i, j, 0.38F);
      arrayOfInt[3] = k;
      this.d = new ColorStateList(b, arrayOfInt);
    }
    return this.d;
  }
  
  private ColorStateList getMaterialThemeColorsTrackTintList()
  {
    if (this.e == null)
    {
      int[] arrayOfInt = new int[b.length];
      int i = MaterialColors.a(this, R.attr.t);
      int j = MaterialColors.a(this, R.attr.n);
      int k = MaterialColors.a(this, R.attr.q);
      arrayOfInt[0] = MaterialColors.a(i, j, 0.54F);
      arrayOfInt[1] = MaterialColors.a(i, k, 0.32F);
      arrayOfInt[2] = MaterialColors.a(i, j, 0.12F);
      arrayOfInt[3] = MaterialColors.a(i, k, 0.12F);
      this.e = new ColorStateList(b, arrayOfInt);
    }
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.f) && (getThumbTintList() == null)) {
      setThumbTintList(getMaterialThemeColorsThumbTintList());
    }
    if ((this.f) && (getTrackTintList() == null)) {
      setTrackTintList(getMaterialThemeColorsTrackTintList());
    }
  }
  
  public void setUseMaterialThemeColors(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean)
    {
      setThumbTintList(getMaterialThemeColorsThumbTintList());
      setTrackTintList(getMaterialThemeColorsTrackTintList());
      return;
    }
    setThumbTintList(null);
    setTrackTintList(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.switchmaterial.SwitchMaterial
 * JD-Core Version:    0.7.0.1
 */