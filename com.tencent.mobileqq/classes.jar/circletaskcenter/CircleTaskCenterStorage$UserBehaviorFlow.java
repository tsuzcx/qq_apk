package circletaskcenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CircleTaskCenterStorage$UserBehaviorFlow
  extends MessageMicro<UserBehaviorFlow>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, UserBehaviorFlow.class);
  public final PBRepeatMessageField<CircleTaskCenterStorage.UserBehaviorRecord> records = PBField.initRepeatMessage(CircleTaskCenterStorage.UserBehaviorRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     circletaskcenter.CircleTaskCenterStorage.UserBehaviorFlow
 * JD-Core Version:    0.7.0.1
 */