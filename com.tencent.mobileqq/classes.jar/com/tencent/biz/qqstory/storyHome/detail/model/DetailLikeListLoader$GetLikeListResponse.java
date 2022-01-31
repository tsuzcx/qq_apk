package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;

public class DetailLikeListLoader$GetLikeListResponse
  extends BaseResponse
{
  public List a;
  public int b;
  public int c;
  
  public DetailLikeListLoader$GetLikeListResponse(qqstory_service.RspFeedLikeList paramRspFeedLikeList)
  {
    super(paramRspFeedLikeList.result);
    paramRspFeedLikeList = (qqstory_struct.FeedLikeInfo)paramRspFeedLikeList.feed_like_info.get();
    this.a = a(paramRspFeedLikeList);
    this.b = paramRspFeedLikeList.like_total_count.get();
    this.c = paramRspFeedLikeList.has_like.get();
  }
  
  public List a(qqstory_struct.FeedLikeInfo paramFeedLikeInfo)
  {
    paramFeedLikeInfo = paramFeedLikeInfo.like_list.get();
    ArrayList localArrayList1 = new ArrayList();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramFeedLikeInfo.size())
    {
      LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)paramFeedLikeInfo.get(i));
      if (localUserManager.b(localLikeEntry.unionId) == null) {
        localArrayList2.add(new QQUserUIItem.UserID("", localLikeEntry.unionId));
      }
      localArrayList1.add(localLikeEntry);
      i += 1;
    }
    if (!localArrayList2.isEmpty()) {
      new GetUserInfoHandler().a(1, localArrayList2);
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListResponse
 * JD-Core Version:    0.7.0.1
 */