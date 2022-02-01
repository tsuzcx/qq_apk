package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.UpdateCollectionViewCountRequest;
import com.tencent.biz.qqstory.network.response.UpdateCollectionViewCountResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateCollectionViewCountHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<UpdateCollectionViewCountRequest, UpdateCollectionViewCountResponse>
{
  protected List<UpdateCollectionViewCountHandler.CollectionID> c = new ArrayList();
  protected String d;
  
  public UpdateCollectionViewCountHandler(String paramString)
  {
    this.d = paramString;
  }
  
  public void a()
  {
    UpdateCollectionViewCountRequest localUpdateCollectionViewCountRequest = new UpdateCollectionViewCountRequest();
    localUpdateCollectionViewCountRequest.g = this.c;
    localUpdateCollectionViewCountRequest.f = this.d;
    CmdTaskManger.a().a(localUpdateCollectionViewCountRequest, this);
  }
  
  public void a(@NonNull UpdateCollectionViewCountRequest paramUpdateCollectionViewCountRequest, @Nullable UpdateCollectionViewCountResponse paramUpdateCollectionViewCountResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramUpdateCollectionViewCountResponse != null))
    {
      paramUpdateCollectionViewCountRequest = new DeleteStoryVideoHandler.UpdateMemoriesEvent(1);
      paramErrorMessage = (MemoryManager)SuperManager.a(19);
      paramUpdateCollectionViewCountResponse = paramUpdateCollectionViewCountResponse.a;
      Object localObject1 = paramUpdateCollectionViewCountResponse.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = new DeleteStoryVideoHandler.StateVideoCollectionItem(2, paramErrorMessage.a((VideoCollectionItem)((Iterator)localObject1).next()));
        paramUpdateCollectionViewCountRequest.a.add(localObject2);
      }
      paramErrorMessage = (FeedManager)SuperManager.a(11);
      localObject1 = new ArrayList(paramUpdateCollectionViewCountResponse.size());
      paramUpdateCollectionViewCountResponse = paramUpdateCollectionViewCountResponse.iterator();
      while (paramUpdateCollectionViewCountResponse.hasNext())
      {
        localObject2 = (VideoCollectionItem)paramUpdateCollectionViewCountResponse.next();
        if (!TextUtils.isEmpty(((VideoCollectionItem)localObject2).feedId))
        {
          VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramErrorMessage.b(((VideoCollectionItem)localObject2).feedId);
          if (localVideoListFeedItem != null)
          {
            localVideoListFeedItem.mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
            ((ArrayList)localObject1).add(localVideoListFeedItem);
          }
        }
      }
      paramErrorMessage.a((List)localObject1);
      StoryDispatcher.a().dispatch(paramUpdateCollectionViewCountRequest);
    }
  }
  
  public void a(List<UpdateCollectionViewCountHandler.CollectionID> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler
 * JD-Core Version:    0.7.0.1
 */