package com.tencent.falco.base.libapi.qqsdk;

import android.os.Bundle;

public abstract class QQBaseShareData
{
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  public static final String SHARE_TO_QQ_TITLE = "title";
  public static final int SHARE_TO_QQ_TYPE_APP = 6;
  public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
  public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
  public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
  int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
  int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
  int SHARE_TO_QZONE_TYPE_APP = 6;
  int SHARE_TO_QZONE_TYPE_IMAGE = 5;
  int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
  public int extra;
  
  public abstract Bundle getBundle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.qqsdk.QQBaseShareData
 * JD-Core Version:    0.7.0.1
 */