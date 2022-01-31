package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

public class VideoFeedsTopBarJumpUtils
{
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
      ReadInJoyUtils.a(paramContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.VideoFeedsTopBarJumpUtils
 * JD-Core Version:    0.7.0.1
 */