package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class CardItem$NearbyCardInfo
{
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private qqstory_struct.NearbyCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo;
  private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  
  public CardItem$NearbyCardInfo(qqstory_struct.NearbyCardInfo paramNearbyCardInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = paramNearbyCardInfo;
  }
  
  public CardItem$NearbyCardInfo(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo = new qqstory_struct.NearbyCardInfo();
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("Q.qqstory.discover.CardItem", paramArrayOfByte.toString());
    }
  }
  
  public QQUserUIItem a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = new QQUserUIItem();
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.convertFrom(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.owner);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  }
  
  public CardItem.CardVideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.size() == 0) {
        return null;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.card_info.story_video_info.get(0));
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NearbyCardInfo.distance.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NearbyCardInfo
 * JD-Core Version:    0.7.0.1
 */