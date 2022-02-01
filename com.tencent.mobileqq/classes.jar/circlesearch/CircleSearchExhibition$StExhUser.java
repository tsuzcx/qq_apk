package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CircleSearchExhibition$StExhUser
  extends MessageMicro<StExhUser>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "id", "name", "desc", "isVip", "fans_num", "feeds_num", "isFollow", "isBigV", "isQQFriend", "isBlueVip", "relationType" }, new Object[] { "", "", "", Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0) }, StExhUser.class);
  public final PBStringField desc = PBField.initString("");
  public final PBInt64Field fans_num = PBField.initInt64(0L);
  public final PBInt64Field feeds_num = PBField.initInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBBoolField isBigV = PBField.initBool(false);
  public final PBBoolField isBlueVip = PBField.initBool(false);
  public final PBBoolField isFollow = PBField.initBool(false);
  public final PBBoolField isQQFriend = PBField.initBool(false);
  public final PBBoolField isVip = PBField.initBool(false);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field relationType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StExhUser
 * JD-Core Version:    0.7.0.1
 */