package com.tencent.biz.pubaccount.readinjoy.biu;

import cooperation.readinjoy.ReadInJoyHelper;

public class BiuBehaviour
{
  public static int a()
  {
    return ((Integer)ReadInJoyHelper.a("sp_key_biu_button_click_behaviour", Integer.valueOf(0))).intValue();
  }
  
  public static void a()
  {
    ReadInJoyHelper.a("sp_key_biu_long_click_tips_count", Integer.valueOf(((Integer)ReadInJoyHelper.a("sp_key_biu_long_click_tips_count", Integer.valueOf(0))).intValue() + 1));
  }
  
  public static int b()
  {
    return ((Integer)ReadInJoyHelper.a("sp_key_biu_button_long_click_behaviour", Integer.valueOf(1))).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour
 * JD-Core Version:    0.7.0.1
 */