package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.res.ColorStateList;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class ColorUtil
{
  public static ColorStateList getColorStateList(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString3 != null) {
      localArrayList.add(new Pair(Integer.valueOf(16842913), Integer.valueOf(Utils.parseColor(paramString3))));
    }
    if (paramString2 != null) {
      localArrayList.add(new Pair(Integer.valueOf(16842919), Integer.valueOf(Utils.parseColor(paramString2))));
    }
    if (paramString1 != null) {
      localArrayList.add(new Pair(Integer.valueOf(-2147483648), Integer.valueOf(Utils.parseColor(paramString1))));
    }
    paramString1 = new int[localArrayList.size()];
    paramString2 = new int[localArrayList.size()][];
    int i = 0;
    if (i < localArrayList.size())
    {
      paramString3 = (Pair)localArrayList.get(i);
      paramString1[i] = ((Integer)paramString3.second).intValue();
      if (((Integer)paramString3.first).intValue() != -2147483648) {
        paramString2[i] = { ((Integer)paramString3.first).intValue() };
      }
      for (;;)
      {
        i += 1;
        break;
        paramString2[i] = new int[0];
      }
    }
    return new ColorStateList(paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil
 * JD-Core Version:    0.7.0.1
 */