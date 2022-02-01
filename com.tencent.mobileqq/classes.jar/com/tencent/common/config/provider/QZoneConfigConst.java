package com.tencent.common.config.provider;

import android.net.Uri;

public abstract interface QZoneConfigConst
{
  public static final Uri a = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_configs");
  public static final Uri b = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_cookie");
  public static final Uri c = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_update");
  public static final Uri d = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_delete");
  public static final Uri e = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_isp_config");
  public static final Uri f = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_check_time");
  public static final Uri g = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/qz_navigator_bar");
  public static final Uri h = Uri.parse("content://com.tencent.common.config.provider.QZoneConfigProvider/table_qz_unread");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.config.provider.QZoneConfigConst
 * JD-Core Version:    0.7.0.1
 */