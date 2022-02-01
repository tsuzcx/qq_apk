package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.QimVideoInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class QimVideoInfoItem
{
  public String a;
  public String b;
  public String c;
  
  public QimVideoInfoItem(qqstory_struct.QimVideoInfo paramQimVideoInfo)
  {
    this.a = paramQimVideoInfo.qim_unionid.get().toStringUtf8();
    this.b = paramQimVideoInfo.qim_feedID.get().toStringUtf8();
    this.c = paramQimVideoInfo.qim_vid.get().toStringUtf8();
  }
  
  public static QimVideoInfoItem a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
      try
      {
        localQimVideoInfo.mergeFrom(paramArrayOfByte);
        return new QimVideoInfoItem(localQimVideoInfo);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        SLog.c("QimVideoInfoItem", "Error: parse db bytes error.", paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] a()
  {
    qqstory_struct.QimVideoInfo localQimVideoInfo = new qqstory_struct.QimVideoInfo();
    localQimVideoInfo.qim_vid.set(ByteStringMicro.copyFromUtf8(this.c));
    localQimVideoInfo.qim_unionid.set(ByteStringMicro.copyFromUtf8(this.a));
    localQimVideoInfo.qim_feedID.set(ByteStringMicro.copyFromUtf8(this.b));
    return localQimVideoInfo.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QimVideoInfoItem{mOwnerUnionId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.QimVideoInfoItem
 * JD-Core Version:    0.7.0.1
 */