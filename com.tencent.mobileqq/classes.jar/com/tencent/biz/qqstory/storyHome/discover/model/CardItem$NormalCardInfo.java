package com.tencent.biz.qqstory.storyHome.discover.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class CardItem$NormalCardInfo
{
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private qqstory_struct.NormalCardInfo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo;
  private CardItem.CardVideoInfo jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  
  public CardItem$NormalCardInfo(qqstory_struct.NormalCardInfo paramNormalCardInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo = paramNormalCardInfo;
  }
  
  public CardItem$NormalCardInfo(CardItem.CardVideoInfo paramCardVideoInfo, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramCardVideoInfo == null) || (paramQQUserUIItem == null)) {
      throw new IllegalArgumentException("parameter should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = paramCardVideoInfo;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = paramQQUserUIItem;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo = new qqstory_struct.NormalCardInfo();
  }
  
  public CardItem$NormalCardInfo(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo = new qqstory_struct.NormalCardInfo();
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.mergeFrom(paramArrayOfByte);
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
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.convertFrom(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.owner);
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  }
  
  public CardItem.CardVideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.story_video_info.size() == 0) {
        return null;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo = new CardItem.CardVideoInfo((qqstory_struct.CardVideoInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_struct$NormalCardInfo.story_video_info.get(0));
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverModelCardItem$CardVideoInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem.NormalCardInfo
 * JD-Core Version:    0.7.0.1
 */