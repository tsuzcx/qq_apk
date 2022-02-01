package circletaskcenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CircleTaskCenterStorage$FuelList
  extends MessageMicro<FuelList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, FuelList.class);
  public final PBRepeatMessageField<CircleTaskCenterStorage.FuelRecord> records = PBField.initRepeatMessage(CircleTaskCenterStorage.FuelRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circletaskcenter.CircleTaskCenterStorage.FuelList
 * JD-Core Version:    0.7.0.1
 */