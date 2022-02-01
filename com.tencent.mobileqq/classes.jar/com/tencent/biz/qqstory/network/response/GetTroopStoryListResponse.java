package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupStoryItem;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupStoryVideoNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupVideoList;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetTroopStoryListResponse
  extends BaseResponse
{
  public ArrayList<TroopStoryItemInfo> a;
  public boolean a;
  public int b;
  public int c;
  
  public GetTroopStoryListResponse(qqstory_group.RspGetGroupVideoList paramRspGetGroupVideoList)
  {
    super(paramRspGetGroupVideoList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramRspGetGroupVideoList.is_end.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.b = paramRspGetGroupVideoList.next.get();
      this.c = paramRspGetGroupVideoList.seq.get();
      long l = paramRspGetGroupVideoList.group_id.get();
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      paramRspGetGroupVideoList = paramRspGetGroupVideoList.node_list.get().iterator();
      while (paramRspGetGroupVideoList.hasNext())
      {
        qqstory_group.GroupStoryItem localGroupStoryItem = (qqstory_group.GroupStoryItem)paramRspGetGroupVideoList.next();
        TroopStoryItemInfo localTroopStoryItemInfo = new TroopStoryItemInfo();
        localTroopStoryItemInfo.troopId = l;
        localTroopStoryItemInfo.itemType = localGroupStoryItem.type.get();
        localTroopStoryItemInfo.publishTime = (localGroupStoryItem.ts.get() * 1000L);
        localTroopStoryItemInfo.publishCount = localGroupStoryItem.count.get();
        localTroopStoryItemInfo.storyId = localGroupStoryItem.video_info.story_id.get().toStringUtf8();
        localTroopStoryItemInfo.vid = localGroupStoryItem.video_info.vid.get().toStringUtf8();
        String str1 = String.valueOf(localGroupStoryItem.video_info.uin.get());
        String str2 = localGroupStoryItem.video_info.union_id.get().toStringUtf8();
        localTroopStoryItemInfo.uin = str1;
        localTroopStoryItemInfo.unionId = str2;
        localTroopStoryItemInfo.unionIdRole = localGroupStoryItem.video_info.union_id_role.get();
        localUserManager.a(str2, str1);
        localTroopStoryItemInfo.videoThumbUrl = localGroupStoryItem.video_info.cover_url.get().toStringUtf8();
        localTroopStoryItemInfo.likeCount = localGroupStoryItem.video_info.like_count.get();
        localTroopStoryItemInfo.commentCount = localGroupStoryItem.video_info.comment_count.get();
        if (localTroopStoryItemInfo.itemType == 1) {
          localTroopStoryItemInfo.feedId = localGroupStoryItem.feed_id.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localTroopStoryItemInfo);
      }
    }
  }
  
  public String toString()
  {
    return "GetTroopStoryListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.b + '\'' + ", seq=" + this.c + ", troopStoryItemInfoList=" + this.jdField_a_of_type_JavaUtilArrayList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetTroopStoryListResponse
 * JD-Core Version:    0.7.0.1
 */