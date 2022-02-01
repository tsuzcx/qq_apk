package com.tencent.biz.qqstory.shareGroup.model;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspLoadMoreVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupManager$GetFeedVidListObserver
  extends ProtoUtils.StoryProtocolObserver
{
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject4;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject4 = new qqstory_service.RspLoadMoreVideoList();
      localObject1 = (StoryManager)SuperManager.a(5);
      localObject3 = paramBundle.getString("extra_feedid");
      localObject2 = (MemoryManager)SuperManager.a(19);
    }
    for (;;)
    {
      try
      {
        ((qqstory_service.RspLoadMoreVideoList)localObject4).mergeFrom(paramArrayOfByte);
        paramBundle = (qqstory_struct.ErrorInfo)((qqstory_service.RspLoadMoreVideoList)localObject4).result.get();
        try
        {
          localObject3 = ((MemoryManager)localObject2).a((String)localObject3);
          if (localObject3 != null)
          {
            if (paramBundle.error_code.get() != 0) {
              return paramBundle;
            }
            if (!((qqstory_service.RspLoadMoreVideoList)localObject4).next_cookie.has()) {
              break label399;
            }
            paramArrayOfByte = ((qqstory_service.RspLoadMoreVideoList)localObject4).next_cookie.get().toStringUtf8();
            int i = ((qqstory_service.RspLoadMoreVideoList)localObject4).is_end.get();
            paramInt = 0;
            bool = true;
            if (i != 1) {
              break label405;
            }
            localObject4 = ((qqstory_service.RspLoadMoreVideoList)localObject4).video_list.get();
            ((VideoCollectionItem)localObject3).nextCookie = paramArrayOfByte;
            if (paramInt < ((List)localObject4).size())
            {
              paramArrayOfByte = (qqstory_struct.GroupStoryInfo)((List)localObject4).get(paramInt);
              StoryVideoItem localStoryVideoItem = new StoryVideoItem();
              localStoryVideoItem.convertFrom("dummy", paramArrayOfByte);
              paramArrayOfByte = ((StoryManager)localObject1).a(localStoryVideoItem.mVid, localStoryVideoItem);
              ((VideoCollectionItem)localObject3).videoVidList.add(paramArrayOfByte.mVid);
              paramArrayOfByte = new VideoCollectionItem.FakeVideoUIItem(paramArrayOfByte.mVid, paramArrayOfByte);
              ((VideoCollectionItem)localObject3).collectionVideoUIItemList.add(paramArrayOfByte);
              paramInt += 1;
              continue;
            }
            ((MemoryManager)localObject2).a((VideoCollectionItem)localObject3);
            a((VideoCollectionItem)localObject3, bool);
            return paramBundle;
          }
          return paramBundle;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
        if (!QLog.isColorLevel()) {
          break label324;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramBundle = null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doGetMoreVideoByVideoCollectionItem exception:");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      QLog.w("Q.qqstory.discover.ShareGroupManager", 2, ((StringBuilder)localObject1).toString());
      label324:
      return paramBundle;
      paramBundle = new qqstory_struct.ErrorInfo();
      paramBundle.error_code.set(paramInt);
      localObject1 = paramBundle.error_desc;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = ",data is null";
      } else {
        paramArrayOfByte = ", data is valid";
      }
      ((StringBuilder)localObject2).append(paramArrayOfByte);
      ((PBBytesField)localObject1).set(ByteStringMicro.copyFromUtf8(((StringBuilder)localObject2).toString()));
      return paramBundle;
      label399:
      paramArrayOfByte = "";
      continue;
      label405:
      boolean bool = false;
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager.GetFeedVidListObserver
 * JD-Core Version:    0.7.0.1
 */