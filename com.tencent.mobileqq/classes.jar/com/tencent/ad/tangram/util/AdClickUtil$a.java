package com.tencent.ad.tangram.util;

import android.text.TextUtils;

public final class AdClickUtil$a
{
  public static final int TYPE_CLICK_URL = 1;
  public static final int TYPE_LANDING_PAGE = 2;
  public static final int TYPE_OFFLINE = 3;
  public static final int TYPE_UNKNOWN = 0;
  int type = 0;
  String url;
  
  boolean isValid()
  {
    return (!TextUtils.isEmpty(this.url)) && (this.type != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil.a
 * JD-Core Version:    0.7.0.1
 */