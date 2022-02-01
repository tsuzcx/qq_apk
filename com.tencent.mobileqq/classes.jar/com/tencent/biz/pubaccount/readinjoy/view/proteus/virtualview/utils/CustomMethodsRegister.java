package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

public class CustomMethodsRegister
{
  public static final String CMD_DECODE_EMOTION = "decodeEmotion";
  public static final String CMD_HYPER_LINK_CLICK = "HyperLinkClick";
  public static CustomMethodsRegister.CustomMethodInterface customMethodInterface;
  
  public static void registerCustomMethod(CustomMethodsRegister.CustomMethodInterface paramCustomMethodInterface)
  {
    customMethodInterface = paramCustomMethodInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister
 * JD-Core Version:    0.7.0.1
 */