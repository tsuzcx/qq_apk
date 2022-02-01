package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.EmptyStatusInfo;

public class EmptyStatusInfo
{
  public String a;
  
  public static EmptyStatusInfo a(oidb_0xcf4.EmptyStatusInfo paramEmptyStatusInfo)
  {
    if (paramEmptyStatusInfo == null) {
      return null;
    }
    EmptyStatusInfo localEmptyStatusInfo = new EmptyStatusInfo();
    if (paramEmptyStatusInfo.bytes_jump_url.has()) {
      localEmptyStatusInfo.a = paramEmptyStatusInfo.bytes_jump_url.get().toStringUtf8();
    }
    return localEmptyStatusInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmptyStatusInfo{jumpUrl=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.EmptyStatusInfo
 * JD-Core Version:    0.7.0.1
 */