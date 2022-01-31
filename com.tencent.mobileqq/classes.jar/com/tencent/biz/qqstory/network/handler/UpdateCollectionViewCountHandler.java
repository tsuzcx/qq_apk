package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
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
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateCollectionViewCountHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  protected String a;
  protected List a;
  
  public UpdateCollectionViewCountHandler(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    UpdateCollectionViewCountRequest localUpdateCollectionViewCountRequest = new UpdateCollectionViewCountRequest();
    localUpdateCollectionViewCountRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    localUpdateCollectionViewCountRequest.b = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a(localUpdateCollectionViewCountRequest, this);
  }
  
  public void a(@NonNull UpdateCollectionViewCountRequest paramUpdateCollectionViewCountRequest, @Nullable UpdateCollectionViewCountResponse paramUpdateCollectionViewCountResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isSuccess()) && (paramUpdateCollectionViewCountResponse != null))
    {
      paramUpdateCollectionViewCountRequest = new DeleteStoryVideoHandler.UpdateMemoriesEvent(1);
      paramErrorMessage = (MemoryManager)SuperManager.a(19);
      paramUpdateCollectionViewCountResponse = paramUpdateCollectionViewCountResponse.jdField_a_of_type_JavaUtilList;
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
          VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramErrorMessage.a(((VideoCollectionItem)localObject2).feedId);
          if (localVideoListFeedItem != null)
          {
            localVideoListFeedItem.mViewTotalTime = ((VideoCollectionItem)localObject2).viewTimes;
            ((ArrayList)localObject1).add(localVideoListFeedItem);
          }
        }
      }
      paramErrorMessage.a((List)localObject1);
      Dispatchers.get().dispatch(paramUpdateCollectionViewCountRequest);
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler
 * JD-Core Version:    0.7.0.1
 */