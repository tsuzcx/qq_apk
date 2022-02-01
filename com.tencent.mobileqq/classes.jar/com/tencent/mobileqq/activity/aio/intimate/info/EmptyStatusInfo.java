package com.tencent.mobileqq.activity.aio.intimate.info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.EmptyStatusInfo;

public class EmptyStatusInfo
{
  public String a;
  
  public static EmptyStatusInfo a(oidb_0xcf4.EmptyStatusInfo paramEmptyStatusInfo)
  {
    Object localObject;
    if (paramEmptyStatusInfo == null) {
      localObject = null;
    }
    EmptyStatusInfo localEmptyStatusInfo;
    do
    {
      return localObject;
      localEmptyStatusInfo = new EmptyStatusInfo();
      localObject = localEmptyStatusInfo;
    } while (!paramEmptyStatusInfo.bytes_jump_url.has());
    localEmptyStatusInfo.a = paramEmptyStatusInfo.bytes_jump_url.get().toStringUtf8();
    return localEmptyStatusInfo;
  }
  
  public String toString()
  {
    return "EmptyStatusInfo{jumpUrl=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.info.EmptyStatusInfo
 * JD-Core Version:    0.7.0.1
 */