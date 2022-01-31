package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class CardItem$ActivityCardInfo
{
  private qqstory_struct.GatherCardInfo a;
  
  public CardItem$ActivityCardInfo(qqstory_struct.GatherCardInfo paramGatherCardInfo)
  {
    this.a = paramGatherCardInfo;
  }
  
  public CardItem$ActivityCardInfo(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.GatherCardInfo();
    try
    {
      this.a.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
  
  public int a()
  {
    return this.a.join_num.get();
  }
  
  public long a()
  {
    return this.a.topic_id.get();
  }
  
  public String a()
  {
    return this.a.topic_name.get().toStringUtf8();
  }
  
  public void a(int paramInt)
  {
    this.a.join_num.set(paramInt);
  }
  
  public int b()
  {
    return this.a.rsp_type.get();
  }
  
  public String b()
  {
    return this.a.topic_cover.get().toStringUtf8();
  }
  
  public String c()
  {
    return this.a.topic_label.get().toStringUtf8();
  }
  
  public String d()
  {
    return this.a.rsp_url.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo
 * JD-Core Version:    0.7.0.1
 */