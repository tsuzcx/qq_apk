package com.tencent.device.msg.data;

import com.tencent.litetransfersdk.Session;

public class DeviceCommonMsgProcessor
{
  static String a(DeviceCommonMsgProcessor.KeyValue paramKeyValue1, DeviceCommonMsgProcessor.KeyValue paramKeyValue2)
  {
    if ((paramKeyValue1 != null) && (paramKeyValue2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("\"");
      localStringBuilder.append(paramKeyValue1.a);
      localStringBuilder.append("\"");
      localStringBuilder.append(":");
      localStringBuilder.append("\"");
      localStringBuilder.append(paramKeyValue1.b);
      localStringBuilder.append("\"");
      localStringBuilder.append(",");
      localStringBuilder.append("\"");
      localStringBuilder.append(paramKeyValue2.a);
      localStringBuilder.append("\"");
      localStringBuilder.append(":");
      localStringBuilder.append("\"");
      localStringBuilder.append(paramKeyValue2.b);
      localStringBuilder.append("\"");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void a(Session paramSession, boolean paramBoolean)
  {
    try
    {
      new DeviceCommonMsgProcessor.TaskRunnable(paramSession, paramBoolean).a();
      return;
    }
    catch (Throwable paramSession)
    {
      paramSession.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor
 * JD-Core Version:    0.7.0.1
 */