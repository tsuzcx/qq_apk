package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;

public class ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo
{
  public int a;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo b;
  public ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.IntimatePushInfo c;
  public byte[] d;
  
  public static RelationalChainPushInfo a(submsgtype0xc7.RelationalChainInfo paramRelationalChainInfo)
  {
    if (paramRelationalChainInfo != null)
    {
      RelationalChainPushInfo localRelationalChainPushInfo = new RelationalChainPushInfo();
      localRelationalChainPushInfo.a = paramRelationalChainInfo.uint64_type.get();
      if (paramRelationalChainInfo.bytes_attr.has()) {
        localRelationalChainPushInfo.b = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo.a(localRelationalChainPushInfo.a, paramRelationalChainInfo.bytes_attr.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_intimate_info.has()) {
        localRelationalChainPushInfo.c = ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.IntimatePushInfo.a(paramRelationalChainInfo.bytes_intimate_info.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_mutualmark_alienation.has()) {
        localRelationalChainPushInfo.d = paramRelationalChainInfo.bytes_mutualmark_alienation.get().toByteArray();
      }
      return localRelationalChainPushInfo;
    }
    return null;
  }
  
  public int a()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo localMutualMarkPushInfo = this.b;
    if (localMutualMarkPushInfo != null) {
      return (int)localMutualMarkPushInfo.b;
    }
    if ((this.c != null) && (IntimateUtil.a(this.a))) {
      return this.c.a;
    }
    return 0;
  }
  
  public int b()
  {
    ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo localMutualMarkPushInfo = this.b;
    if (localMutualMarkPushInfo != null) {
      return (int)localMutualMarkPushInfo.k;
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationalChainPushInfo{");
    localStringBuilder.append("relation_type:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("mutualMarkInfo:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("intimateInfo:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ");
    localStringBuilder.append("relationIconFlag:");
    byte[] arrayOfByte = this.d;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      int i = 0;
      for (;;)
      {
        arrayOfByte = this.d;
        if ((i >= arrayOfByte.length) || (i >= 10)) {
          break;
        }
        localStringBuilder.append(arrayOfByte[i]);
        localStringBuilder.append(" ");
        i += 1;
      }
    }
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo
 * JD-Core Version:    0.7.0.1
 */