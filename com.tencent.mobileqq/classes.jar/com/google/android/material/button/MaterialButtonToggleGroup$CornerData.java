package com.google.android.material.button;

import android.view.View;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;

class MaterialButtonToggleGroup$CornerData
{
  private static final CornerSize e = new AbsoluteCornerSize(0.0F);
  CornerSize a;
  CornerSize b;
  CornerSize c;
  CornerSize d;
  
  MaterialButtonToggleGroup$CornerData(CornerSize paramCornerSize1, CornerSize paramCornerSize2, CornerSize paramCornerSize3, CornerSize paramCornerSize4)
  {
    this.a = paramCornerSize1;
    this.b = paramCornerSize3;
    this.c = paramCornerSize4;
    this.d = paramCornerSize2;
  }
  
  public static CornerData a(CornerData paramCornerData)
  {
    CornerSize localCornerSize1 = paramCornerData.a;
    paramCornerData = paramCornerData.d;
    CornerSize localCornerSize2 = e;
    return new CornerData(localCornerSize1, paramCornerData, localCornerSize2, localCornerSize2);
  }
  
  public static CornerData a(CornerData paramCornerData, View paramView)
  {
    if (ViewUtils.a(paramView)) {
      return b(paramCornerData);
    }
    return a(paramCornerData);
  }
  
  public static CornerData b(CornerData paramCornerData)
  {
    CornerSize localCornerSize = e;
    return new CornerData(localCornerSize, localCornerSize, paramCornerData.b, paramCornerData.c);
  }
  
  public static CornerData b(CornerData paramCornerData, View paramView)
  {
    if (ViewUtils.a(paramView)) {
      return a(paramCornerData);
    }
    return b(paramCornerData);
  }
  
  public static CornerData c(CornerData paramCornerData)
  {
    CornerSize localCornerSize1 = paramCornerData.a;
    CornerSize localCornerSize2 = e;
    return new CornerData(localCornerSize1, localCornerSize2, paramCornerData.b, localCornerSize2);
  }
  
  public static CornerData d(CornerData paramCornerData)
  {
    CornerSize localCornerSize = e;
    return new CornerData(localCornerSize, paramCornerData.d, localCornerSize, paramCornerData.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.button.MaterialButtonToggleGroup.CornerData
 * JD-Core Version:    0.7.0.1
 */