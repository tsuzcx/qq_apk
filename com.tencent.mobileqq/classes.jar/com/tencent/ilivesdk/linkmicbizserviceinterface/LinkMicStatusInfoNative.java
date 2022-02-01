package com.tencent.ilivesdk.linkmicbizserviceinterface;

import java.util.HashMap;
import java.util.Map;

public class LinkMicStatusInfoNative
{
  public Map<Long, LinkMicUserStatus> a = new HashMap();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LinkMicStatusInfoNative{userStatusMap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicStatusInfoNative
 * JD-Core Version:    0.7.0.1
 */