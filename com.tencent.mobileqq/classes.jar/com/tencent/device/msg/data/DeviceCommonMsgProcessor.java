package com.tencent.device.msg.data;

import com.tencent.litetransfersdk.Session;
import qbd;
import qbe;

public class DeviceCommonMsgProcessor
{
  public static String a(qbd paramqbd1, qbd paramqbd2)
  {
    if ((paramqbd1 == null) || (paramqbd2 == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramqbd1.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramqbd1.b);
    localStringBuilder.append("\"");
    localStringBuilder.append(",");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramqbd2.a);
    localStringBuilder.append("\"");
    localStringBuilder.append(":");
    localStringBuilder.append("\"");
    localStringBuilder.append(paramqbd2.b);
    localStringBuilder.append("\"");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static void a(Session paramSession, boolean paramBoolean)
  {
    try
    {
      new qbe(paramSession, paramBoolean).a();
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