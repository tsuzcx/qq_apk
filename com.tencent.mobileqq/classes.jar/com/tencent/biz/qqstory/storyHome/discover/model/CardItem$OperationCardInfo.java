package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.OperationCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class CardItem$OperationCardInfo
{
  private qqstory_struct.OperationCardInfo a;
  private CardItem.CardVideoInfo b;
  
  public CardItem$OperationCardInfo(qqstory_struct.OperationCardInfo paramOperationCardInfo)
  {
    this.a = paramOperationCardInfo;
  }
  
  public CardItem$OperationCardInfo(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.OperationCardInfo();
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
  
  public CardItem.CardVideoInfo a()
  {
    if (this.b == null)
    {
      if (this.a.card_info.story_video_info.size() == 0) {
        return null;
      }
      this.b = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.a.card_info.story_video_info.get(0));
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.OperationCardInfo
 * JD-Core Version:    0.7.0.1
 */