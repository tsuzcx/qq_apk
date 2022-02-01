package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class CardItem$NearbyCardInfo
{
  private qqstory_struct.NearbyCardInfo a;
  private CardItem.CardVideoInfo b;
  
  public CardItem$NearbyCardInfo(qqstory_struct.NearbyCardInfo paramNearbyCardInfo)
  {
    this.a = paramNearbyCardInfo;
  }
  
  public CardItem$NearbyCardInfo(byte[] paramArrayOfByte)
  {
    this.a = new qqstory_struct.NearbyCardInfo();
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
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NearbyCardInfo
 * JD-Core Version:    0.7.0.1
 */