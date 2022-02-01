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
  qqstory_service.RspFeedLikeList a;
  boolean b;
  
  public FeedLikeDataProvider$GetLikeListResponse(FeedLikeDataProvider paramFeedLikeDataProvider) {}
  
  public FeedLikeDataProvider$GetLikeListResponse(FeedLikeDataProvider paramFeedLikeDataProvider, qqstory_service.RspFeedLikeList paramRspFeedLikeList, boolean paramBoolean)
  {
    super(paramRspFeedLikeList.result);
    this.a = paramRspFeedLikeList;
    this.b = paramBoolean;
  }
  
  public List<LikeEntry> a(qqstory_struct.FeedLikeInfo paramFeedLikeInfo)
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
    qqstory_struct.FeedLikeInfo localFeedLikeInfo = (qqstory_struct.FeedLikeInfo)this.a.feed_like_info.get();
    List localList = a(localFeedLikeInfo);
    this.c.c.b.mLikeCount = localFeedLikeInfo.like_total_count.get();
    this.c.c.e = localList;
    this.c.c.f.a(localList, this.c.d, this.b, true);
    this.c.c.a(localList);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.c.c.e();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, new Object[] { "GetLikeListResponse NetWork ErrorCode:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.c.c.e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetLikeListResponse fails: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      QLog.e("Q.qqstory:FeedLikeDataProvider", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedLikeDataProvider.GetLikeListResponse
 * JD-Core Version:    0.7.0.1
 */