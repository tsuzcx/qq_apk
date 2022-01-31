package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common;

import java.util.HashMap;
import java.util.Map;

public class StringCommon
{
  private static Map a = new HashMap();
  
  static
  {
    a.put("width", Integer.valueOf(1));
    a.put("height", Integer.valueOf(2));
    a.put("margin_top", Integer.valueOf(3));
    a.put("margin_left", Integer.valueOf(4));
    a.put("margin_right", Integer.valueOf(5));
    a.put("margin_bottom", Integer.valueOf(6));
    a.put("padding", Integer.valueOf(7));
    a.put("padding_left", Integer.valueOf(8));
    a.put("padding_right", Integer.valueOf(9));
    a.put("direction", Integer.valueOf(10));
    a.put("setInnerMargin:", Integer.valueOf(11));
    a.put("setBackgroundColorString:", Integer.valueOf(12));
    a.put("setBorderWidthString:", Integer.valueOf(13));
    a.put("setBorderColorString:", Integer.valueOf(14));
    a.put("setCornerRadiusString:", Integer.valueOf(15));
    a.put("setTitle:", Integer.valueOf(16));
    a.put("setText:", Integer.valueOf(16));
    a.put("setFontSizeString:", Integer.valueOf(17));
    a.put("setTextColorString:", Integer.valueOf(18));
    a.put("setBoldFontSizeString:", Integer.valueOf(19));
    a.put("setNumberOfLinesString:", Integer.valueOf(20));
    a.put("setImageWithURLString:lineup:", Integer.valueOf(21));
    a.put("loadImageWithPath:", Integer.valueOf(22));
    a.put("right_of_view", Integer.valueOf(23));
    a.put("left_of_view", Integer.valueOf(24));
    a.put("above_of_view", Integer.valueOf(25));
    a.put("below_of_view", Integer.valueOf(26));
    a.put("align_parent_left", Integer.valueOf(27));
    a.put("align_parent_right", Integer.valueOf(28));
    a.put("align_parent_top", Integer.valueOf(29));
    a.put("align_parent_bottom", Integer.valueOf(30));
    a.put("align_parent_center_vertical", Integer.valueOf(31));
    a.put("align_parent_center_horizontal", Integer.valueOf(32));
    a.put("align_parent_center", Integer.valueOf(33));
    a.put("event_type", Integer.valueOf(34));
    a.put("visibility", Integer.valueOf(35));
    a.put("setAttatchInfo:", Integer.valueOf(36));
    a.put("setBackgroundImages:forStates:", Integer.valueOf(37));
    a.put("setTitles:forStates:", Integer.valueOf(38));
    a.put("setAndroidGravity", Integer.valueOf(39));
    a.put("setImages:colors:direction:forStates:", Integer.valueOf(40));
    a.put("setImages:forStates:", Integer.valueOf(41));
    a.put("setTitleColors:forStates:", Integer.valueOf(42));
    a.put("setSelectedString:", Integer.valueOf(43));
    a.put("setImage:", Integer.valueOf(44));
    a.put("setBackgroundColor:forStates:", Integer.valueOf(45));
  }
  
  public static int a(String paramString)
  {
    paramString = (Integer)a.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (paramInt <= 1000) {
      throw new IllegalArgumentException("can't use the key <= 1000 : " + paramString);
    }
    if ((Integer)a.put(paramString, Integer.valueOf(paramInt)) != null) {
      throw new IllegalArgumentException("duplicate : " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon
 * JD-Core Version:    0.7.0.1
 */