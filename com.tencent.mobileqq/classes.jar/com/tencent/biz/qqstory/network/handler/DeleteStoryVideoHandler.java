package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.DeleteVideoRequest;
import com.tencent.biz.qqstory.network.response.DeleteVideoRespond;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeleteStoryVideoHandler
  implements CmdTaskManger.CommandCallback
{
  public void a(@NonNull DeleteVideoRequest paramDeleteVideoRequest, @Nullable DeleteVideoRespond paramDeleteVideoRespond, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramDeleteVideoRespond = (StoryManager)SuperManager.a(5);
    DeleteStoryVideoEvent localDeleteStoryVideoEvent = new DeleteStoryVideoEvent(paramErrorMessage, paramDeleteVideoRequest.a, false);
    StoryVideoItem localStoryVideoItem = paramDeleteVideoRespond.a(paramDeleteVideoRequest.a);
    if (localStoryVideoItem != null)
    {
      localDeleteStoryVideoEvent.b = localStoryVideoItem.mOwnerUid;
      localDeleteStoryVideoEvent.a = localStoryVideoItem.mVideoIndex;
      if (localDeleteStoryVideoEvent.a == 0L) {
        localDeleteStoryVideoEvent.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      Dispatchers.get().dispatch(localDeleteStoryVideoEvent);
      return;
    }
    b(paramDeleteVideoRequest.a);
    paramDeleteVideoRespond.a(paramDeleteVideoRequest.a);
    Dispatchers.get().dispatch(localDeleteStoryVideoEvent);
  }
  
  public void a(String paramString)
  {
    paramString = new DeleteVideoRequest(paramString);
    CmdTaskManger.a().a(paramString, this);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    DeleteStoryVideoHandler.UpdateMemoriesEvent localUpdateMemoriesEvent = new DeleteStoryVideoHandler.UpdateMemoriesEvent(0);
    MemoryManager localMemoryManager = (MemoryManager)SuperManager.a(19);
    Object localObject = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localMemoryManager.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      Dispatchers.get().dispatch(localUpdateMemoriesEvent);
      return;
    }
    Collections.sort((List)localObject, new VideoCollectionItem.DataSortedComparator());
    Iterator localIterator = ((List)localObject).iterator();
    localObject = null;
    VideoCollectionItem localVideoCollectionItem;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        if (localVideoCollectionItem.collectionType == 0) {
          localObject = localVideoCollectionItem;
        } else {
          if (!localVideoCollectionItem.videoVidList.contains(paramString)) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Dispatchers.get().dispatch(localUpdateMemoriesEvent);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localMemoryManager.a((VideoCollectionItem)localObject);
          localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new VideoCollectionItem.FakeVideoUIItem(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localMemoryManager.a(localVideoCollectionItem);
        localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(1, localVideoCollectionItem));
      }
      for (;;)
      {
        SLog.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localUpdateMemoriesEvent }));
        Dispatchers.get().dispatch(localUpdateMemoriesEvent);
        return;
        localMemoryManager.a((VideoCollectionItem)localObject);
        localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localMemoryManager.a(localVideoCollectionItem);
        localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler
 * JD-Core Version:    0.7.0.1
 */