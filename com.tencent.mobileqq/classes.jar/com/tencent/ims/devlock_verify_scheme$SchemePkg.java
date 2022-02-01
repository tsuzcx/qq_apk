package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class devlock_verify_scheme$SchemePkg
  extends MessageMicro<SchemePkg>
{
  public static final int STR_BUTTON1_CAPTION_FIELD_NUMBER = 7;
  public static final int STR_BUTTON2_CAPTION_FIELD_NUMBER = 10;
  public static final int STR_SUBTEXT_FIELD_NUMBER = 5;
  public static final int STR_TEXT_FIELD_NUMBER = 4;
  public static final int STR_TITLE_FIELD_NUMBER = 3;
  public static final int U32_BUTTON1_AUTH_FIELD_NUMBER = 8;
  public static final int U32_BUTTON1_TYPE_FIELD_NUMBER = 6;
  public static final int U32_BUTTON2_AUTH_FIELD_NUMBER = 11;
  public static final int U32_BUTTON2_TYPE_FIELD_NUMBER = 9;
  public static final int U32_USE_LOCAL_SCHEME_FIELD_NUMBER = 2;
  public static final int U32_VERIFY_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 82, 88 }, new String[] { "u32_verify_type", "u32_use_local_scheme", "str_title", "str_text", "str_subtext", "u32_button1_type", "str_button1_caption", "u32_button1_auth", "u32_button2_type", "str_button2_caption", "u32_button2_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, SchemePkg.class);
  public final PBStringField str_button1_caption = PBField.initString("");
  public final PBStringField str_button2_caption = PBField.initString("");
  public final PBStringField str_subtext = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt32Field u32_button1_auth = PBField.initUInt32(0);
  public final PBUInt32Field u32_button1_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_button2_auth = PBField.initUInt32(0);
  public final PBUInt32Field u32_button2_type = PBField.initUInt32(0);
  public final PBUInt32Field u32_use_local_scheme = PBField.initUInt32(0);
  public final PBUInt32Field u32_verify_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.devlock_verify_scheme.SchemePkg
 * JD-Core Version:    0.7.0.1
 */