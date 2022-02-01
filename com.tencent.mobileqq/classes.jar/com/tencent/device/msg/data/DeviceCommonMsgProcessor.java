package com.tencent.device.msg.data;

import abkt;
import com.tencent.litetransfersdk.Session;

public class DeviceCommonMsgProcessor
{
  static String a(abkt paramabkt1, abkt paramabkt2)
  {
    if ((paramabkt1 == null) || (paramabkt2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabkt1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabkt1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabkt2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramabkt2.b);
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