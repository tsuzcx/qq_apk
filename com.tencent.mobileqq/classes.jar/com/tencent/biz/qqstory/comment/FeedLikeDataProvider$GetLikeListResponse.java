package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FeedLikeDataProvider$GetLikeListResponse
  extends LegoResponseBase
{
  qqstory_service.RspFeedLikeList jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList;
  boolean jdField_a_of_type_Boolean;
  
  public FeedLikeDataProvider$GetLikeListResponse(FeedLikeDataProvider paramFeedLikeDataProvider) {}
  
  public FeedLikeDataProvider$GetLikeListResponse(FeedLikeDataProvider paramFeedLikeDataProvider, qqstory_service.RspFeedLikeList paramRspFeedLikeList, boolean paramBoolean)
  {
    super(paramRspFeedLikeList.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList = paramRspFeedLikeList;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
  
  public void a()
  {
    qqstory_struct.FeedLikeInfo localFeedLikeInfo = (qqstory_struct.FeedLikeInfo)this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspFeedLikeList.feed_like_info.get();
    List localList = a(localFeedLikeInfo);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount = localFeedLikeInfo.like_total_count.get();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.jdField_a_of_type_JavaUtilList = localList;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager.a(localList, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.c, this.jdField_a_of_type_Boolean, true);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.a(localList);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.c();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, new Object[] { "GetLikeListResponse NetWork ErrorCode:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedLikeDataProvider.a.c();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, "GetLikeListResponse fails: " + paramInt + "|" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.GetLikeListResponse
 * JD-Core Version:    0.7.0.1
 */