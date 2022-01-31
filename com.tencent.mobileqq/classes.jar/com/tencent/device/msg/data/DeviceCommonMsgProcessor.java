package com.tencent.device.msg.data;

import com.tencent.litetransfersdk.Session;
import yeo;

public class DeviceCommonMsgProcessor
{
  static String a(yeo paramyeo1, yeo paramyeo2)
  {
    if ((paramyeo1 == null) || (paramyeo2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramyeo1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramyeo1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramyeo2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramyeo2.b);
    localStringBuilder.append("\"");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor
 * JD-Core Version:    0.7.0.1
 */