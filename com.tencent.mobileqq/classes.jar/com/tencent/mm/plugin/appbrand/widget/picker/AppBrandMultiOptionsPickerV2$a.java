package com.tencent.mm.plugin.appbrand.widget.picker;

import androidx.annotation.NonNull;

public final class AppBrandMultiOptionsPickerV2$a
{
  private final String[] a;
  private final int b;
  
  public AppBrandMultiOptionsPickerV2$a(@NonNull String[] paramArrayOfString, int paramInt)
  {
    this.a = paramArrayOfString;
    this.b = Math.max(0, Math.min(paramInt, paramArrayOfString.length - 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a
 * JD-Core Version:    0.7.0.1
 */