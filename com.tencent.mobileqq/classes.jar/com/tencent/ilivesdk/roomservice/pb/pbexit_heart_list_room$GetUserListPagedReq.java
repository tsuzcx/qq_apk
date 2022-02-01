package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbexit_heart_list_room$GetUserListPagedReq
  extends MessageMicro<GetUserListPagedReq>
{
  public static final int INDEX_FIELD_NUMBER = 2;
  public static final int ROOMID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "roomid", "index" }, new Object[] { localInteger, localInteger }, GetUserListPagedReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.GetUserListPagedReq
 * JD-Core Version:    0.7.0.1
 */