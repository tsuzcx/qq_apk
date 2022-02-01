package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeleteStoryVideoHandler
  implements CmdTaskManger.CommandCallback<DeleteVideoRequest, DeleteVideoRespond>
{
  public void a(@NonNull DeleteVideoRequest paramDeleteVideoRequest, @Nullable DeleteVideoRespond paramDeleteVideoRespond, @NonNull ErrorMessage paramErrorMessage)
  {
    paramDeleteVideoRespond = new StringBuilder();
    paramDeleteVideoRespond.append("delete story video return:");
    paramDeleteVideoRespond.append(paramErrorMessage);
    SLog.c("Q.qqstory.player:DeleteStoryVideoHandler", paramDeleteVideoRespond.toString());
    paramDeleteVideoRespond = (StoryManager)SuperManager.a(5);
    DeleteStoryVideoEvent localDeleteStoryVideoEvent = new DeleteStoryVideoEvent(paramErrorMessage, paramDeleteVideoRequest.e, false);
    StoryVideoItem localStoryVideoItem = paramDeleteVideoRespond.a(paramDeleteVideoRequest.e);
    if (localStoryVideoItem != null)
    {
      localDeleteStoryVideoEvent.b = localStoryVideoItem.mOwnerUid;
      localDeleteStoryVideoEvent.e = localStoryVideoItem.mVideoIndex;
      if (localDeleteStoryVideoEvent.e == 0L) {
        localDeleteStoryVideoEvent.e = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      StoryDispatcher.a().dispatch(localDeleteStoryVideoEvent);
      return;
    }
    b(paramDeleteVideoRequest.e);
    paramDeleteVideoRespond.j(paramDeleteVideoRequest.e);
    StoryDispatcher.a().dispatch(localDeleteStoryVideoEvent);
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
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      Collections.sort((List)localObject, new VideoCollectionItem.DataSortedComparator());
      Iterator localIterator = ((List)localObject).iterator();
      localObject = null;
      while (localIterator.hasNext())
      {
        localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        if (localVideoCollectionItem.collectionType == 0)
        {
          localObject = localVideoCollectionItem;
        }
        else if (localVideoCollectionItem.videoVidList.contains(paramString))
        {
          i = 1;
          break label160;
        }
      }
      VideoCollectionItem localVideoCollectionItem = null;
      int i = 0;
      label160:
      if (i == 0)
      {
        StoryDispatcher.a().dispatch(localUpdateMemoriesEvent);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localMemoryManager.b((VideoCollectionItem)localObject);
          localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(1, (VideoCollectionItem)localObject));
        }
        else
        {
          localMemoryManager.a((VideoCollectionItem)localObject);
          localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(2, (VideoCollectionItem)localObject));
        }
      }
      localVideoCollectionItem.collectionCount -= 1;
      localVideoCollectionItem.videoVidList.remove(paramString);
      localVideoCollectionItem.collectionVideoUIItemList.remove(new VideoCollectionItem.FakeVideoUIItem(paramString, null));
      if (localVideoCollectionItem.collectionCount <= 0)
      {
        localMemoryManager.b(localVideoCollectionItem);
        localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(1, localVideoCollectionItem));
      }
      else
      {
        localMemoryManager.a(localVideoCollectionItem);
        localUpdateMemoriesEvent.a.add(new DeleteStoryVideoHandler.StateVideoCollectionItem(2, localVideoCollectionItem));
      }
      SLog.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localUpdateMemoriesEvent }));
      StoryDispatcher.a().dispatch(localUpdateMemoriesEvent);
      return;
    }
    StoryDispatcher.a().dispatch(localUpdateMemoriesEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler
 * JD-Core Version:    0.7.0.1
 */