package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.res.ColorStateList;

public class ColorUtil
{
  public static ColorStateList a(String paramString1, String paramString2, String paramString3)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -16777216;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = -16777216;
    int[] tmp15_10 = tmp10_5;
    tmp15_10[2] = -16777216;
    tmp15_10;
    if (paramString3 != null) {
      arrayOfInt[0] = Utils.a(paramString3);
    }
    if (paramString2 != null) {
      arrayOfInt[1] = Utils.a(paramString2);
    }
    if (paramString1 != null) {
      arrayOfInt[2] = Utils.a(paramString1);
    }
    paramString1 = new int[] { 16842919 };
    paramString2 = new int[0];
    return new ColorStateList(new int[][] { { 16842913 }, paramString1, paramString2 }, arrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil
 * JD-Core Version:    0.7.0.1
 */