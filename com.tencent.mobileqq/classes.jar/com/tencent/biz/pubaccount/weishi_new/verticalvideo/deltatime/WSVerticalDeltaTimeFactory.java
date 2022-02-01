package com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime;

import android.text.TextUtils;

public class WSVerticalDeltaTimeFactory
{
  public static IWSVerticalDeltaTimeCalculator a(String paramString)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new WSVerticalForGridDeltaTimeCalculator();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeFactory
 * JD-Core Version:    0.7.0.1
 */