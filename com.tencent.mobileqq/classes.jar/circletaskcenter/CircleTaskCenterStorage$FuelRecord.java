package circletaskcenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CircleTaskCenterStorage$FuelRecord
  extends MessageMicro<FuelRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "optTime", "behaviorType", "fuelValue", "leftFuelValue" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FuelRecord.class);
  public final PBUInt32Field behaviorType = PBField.initUInt32(0);
  public final PBInt32Field fuelValue = PBField.initInt32(0);
  public final PBUInt32Field leftFuelValue = PBField.initUInt32(0);
  public final PBUInt32Field optTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circletaskcenter.CircleTaskCenterStorage.FuelRecord
 * JD-Core Version:    0.7.0.1
 */