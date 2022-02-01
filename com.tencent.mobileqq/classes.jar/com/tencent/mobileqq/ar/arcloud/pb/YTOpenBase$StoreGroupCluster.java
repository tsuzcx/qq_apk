package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StoreGroupCluster
  extends MessageMicro<StoreGroupCluster>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "size", "cur_group" }, new Object[] { "", "" }, StoreGroupCluster.class);
  public final PBStringField cur_group = PBField.initString("");
  public final PBStringField size = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StoreGroupCluster
 * JD-Core Version:    0.7.0.1
 */