package com.tencent.device.msg.data;

import abyy;
import com.tencent.litetransfersdk.Session;

public class DeviceCommonMsgProcessor
{
  static String a(abyy paramabyy1, abyy paramabyy2)
  {
    if ((paramabyy1 == null) || (paramabyy2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabyy1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabyy1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabyy2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabyy2.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceCommonMsgProcessor
 * JD-Core Version:    0.7.0.1
 */