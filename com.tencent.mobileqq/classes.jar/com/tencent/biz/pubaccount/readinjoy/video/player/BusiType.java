package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;

public class BusiType
{
  public static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 7);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == 2) || ((paramInt == 6) && (!TextUtils.isEmpty(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.BusiType
 * JD-Core Version:    0.7.0.1
 */