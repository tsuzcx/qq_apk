package com.tencent.biz.qqstory.comment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FeedCommentDataProvider$GetCommentListResponse
  extends LegoResponseBase
{
  qqstory_service.RspGetCommentList a;
  
  public FeedCommentDataProvider$GetCommentListResponse(FeedCommentDataProvider paramFeedCommentDataProvider) {}
  
  public FeedCommentDataProvider$GetCommentListResponse(FeedCommentDataProvider paramFeedCommentDataProvider, qqstory_service.RspGetCommentList paramRspGetCommentList)
  {
    super(paramRspGetCommentList.result);
    this.a = paramRspGetCommentList;
  }
  
  public void a()
  {
    Object localObject = this.a.comment_list.get();
    ArrayList localArrayList = new ArrayList();
    FeedCommentDataProvider.a(this.b, this.a.cookie.get().toStringUtf8());
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    boolean bool = false;
    int i = 0;
    while (i < ((List)localObject).size())
    {
      CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((List)localObject).get(i));
      QQUserUIItem localQQUserUIItem = localUserManager.c(localCommentEntry.authorUnionId);
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
        localCommentEntry.authorName = localQQUserUIItem.nickName;
      } else {
        localCommentEntry.authorName = PlayModeUtils.b;
      }
      if (!TextUtils.isEmpty(localCommentEntry.replyUin))
      {
        localQQUserUIItem = localUserManager.c(localCommentEntry.replierUnionId);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
          localCommentEntry.replierName = localQQUserUIItem.nickName;
        } else {
          localCommentEntry.replierName = PlayModeUtils.b;
        }
      }
      localArrayList.add(localCommentEntry);
      i += 1;
    }
    localObject = this.b;
    if (this.a.is_end.get() == 1) {
      bool = true;
    }
    ((FeedCommentDataProvider)localObject).e = bool;
    this.b.f = this.a.total_comment_num.get();
    this.b.d.a(localArrayList);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.b.d.f();
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory:FeedCommentDataProvider", 2, new Object[] { "ReqGetCommentList NetWork ErrorCode:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.b.d.f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReqGetCommentList fails: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      QLog.e("Q.qqstory:FeedCommentDataProvider", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentDataProvider.GetCommentListResponse
 * JD-Core Version:    0.7.0.1
 */