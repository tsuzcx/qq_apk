package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ExpeDataAcc$UserActionInfo
  extends MessageMicro<UserActionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "accountInfo", "eventInfo", "deviceInfo", "appInfo", "networkInfo", "expeInfo", "taskInfo", "algorithmInfo" }, new Object[] { null, null, null, null, null, null, null, null }, UserActionInfo.class);
  public ExpeDataAcc.AccountInfo accountInfo = new ExpeDataAcc.AccountInfo();
  public ExpeDataAcc.SvrAlgorithmInfo algorithmInfo = new ExpeDataAcc.SvrAlgorithmInfo();
  public ExpeDataAcc.AppInfo appInfo = new ExpeDataAcc.AppInfo();
  public ExpeDataAcc.DeviceInfo deviceInfo = new ExpeDataAcc.DeviceInfo();
  public ExpeDataAcc.EventInfo eventInfo = new ExpeDataAcc.EventInfo();
  public ExpeDataAcc.ExpeInfo expeInfo = new ExpeDataAcc.ExpeInfo();
  public ExpeDataAcc.NetworkInfo networkInfo = new ExpeDataAcc.NetworkInfo();
  public ExpeDataAcc.PushTaskInfo taskInfo = new ExpeDataAcc.PushTaskInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.UserActionInfo
 * JD-Core Version:    0.7.0.1
 */