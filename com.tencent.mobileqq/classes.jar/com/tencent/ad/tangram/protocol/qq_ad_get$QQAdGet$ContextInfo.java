package com.tencent.ad.tangram.protocol;

public final class qq_ad_get$QQAdGet$ContextInfo
{
  public static final int CALL_TYPE_EXTERNAL_CALL = 3;
  public static final int CALL_TYPE_ICON = 1;
  public static final int CALL_TYPE_PUSH = 2;
  public static final int CALL_TYPE_UNKNOWN = 0;
  public static final int LOAD_TYPE_DEFAULT = 0;
  public static final int LOAD_TYPE_PRELOAD = 3;
  public static final int LOAD_TYPE_REAR = 4;
  public static final int LOAD_TYPE_TIMEOUT = 2;
  public static final int LOAD_TYPE_TOP = 1;
  public long article_id = 0L;
  public String call_from;
  public long[] existed_mini_program_ids;
  public int launch_channel = 0;
  public int load_type = 0;
  public int mini_program_status = 0;
  public long public_id = 0L;
  public qq_ad_get.QQAdGet.QQPublicCategoryInfo[] qq_public_category;
  public qq_ad_get.QQAdGet.SessionInfo session_info = new qq_ad_get.QQAdGet.SessionInfo();
  public int source_from = 0;
  public String str_source_from;
  public int tribe_id_tag = 0;
  public int tribe_tag = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.ContextInfo
 * JD-Core Version:    0.7.0.1
 */