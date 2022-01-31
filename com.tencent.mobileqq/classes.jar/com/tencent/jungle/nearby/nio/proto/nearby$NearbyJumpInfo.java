package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearby$NearbyJumpInfo
  extends MessageMicro<NearbyJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "tip_content", "tip_left_btn", "tip_right_btn_installed", "tip_right_btn_not_installed", "android_app_key", "ios_app_key", "jump_uri", "app_download_url" }, new Object[] { "", "", "", "", "", "", "", "" }, NearbyJumpInfo.class);
  public final PBStringField android_app_key = PBField.initString("");
  public final PBStringField app_download_url = PBField.initString("");
  public final PBStringField ios_app_key = PBField.initString("");
  public final PBStringField jump_uri = PBField.initString("");
  public final PBStringField tip_content = PBField.initString("");
  public final PBStringField tip_left_btn = PBField.initString("");
  public final PBStringField tip_right_btn_installed = PBField.initString("");
  public final PBStringField tip_right_btn_not_installed = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby.NearbyJumpInfo
 * JD-Core Version:    0.7.0.1
 */