package com.tencent.device.msg.data;

import com.tencent.litetransfersdk.Session;
import zth;

public class DeviceCommonMsgProcessor
{
  static String a(zth paramzth1, zth paramzth2)
  {
    if ((paramzth1 == null) || (paramzth2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramzth1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramzth1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramzth2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramzth2.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor
 * JD-Core Version:    0.7.0.1
 */