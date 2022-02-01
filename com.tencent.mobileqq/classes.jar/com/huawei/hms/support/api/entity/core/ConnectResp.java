package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectResp
  implements IMessageEntity
{
  @Packed
  public List<Integer> protocolVersion = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
  @Packed
  public String sessionId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("protocol version:");
    Iterator localIterator = this.protocolVersion.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((Integer)localIterator.next());
      localStringBuilder.append(',');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.ConnectResp
 * JD-Core Version:    0.7.0.1
 */