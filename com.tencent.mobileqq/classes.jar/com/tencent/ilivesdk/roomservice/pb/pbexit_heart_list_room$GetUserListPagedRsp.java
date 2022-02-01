package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class pbexit_heart_list_room$GetUserListPagedRsp
  extends MessageMicro<GetUserListPagedRsp>
{
  public static final int IS_FINISH_FIELD_NUMBER = 2;
  public static final int USER_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "user_list", "is_finish" }, new Object[] { null, Boolean.valueOf(false) }, GetUserListPagedRsp.class);
  public final PBBoolField is_finish = PBField.initBool(false);
  public pbexit_heart_list_room.UserList user_list = new pbexit_heart_list_room.UserList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.GetUserListPagedRsp
 * JD-Core Version:    0.7.0.1
 */