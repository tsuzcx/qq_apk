package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.FeedTagInfoList;
import com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.GetFeedTagInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TagManager$1
  implements CmdTaskManger.CommandCallback<GetFeedTagInfoListRequest, GetFeedTagInfoListRequest.GetFeedTagInfoListResponse>
{
  TagManager$1(TagManager paramTagManager) {}
  
  public void a(@NonNull GetFeedTagInfoListRequest paramGetFeedTagInfoListRequest, @Nullable GetFeedTagInfoListRequest.GetFeedTagInfoListResponse paramGetFeedTagInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetFeedTagInfoListRequest = paramGetFeedTagInfoListRequest.e.iterator();
    Object localObject;
    while (paramGetFeedTagInfoListRequest.hasNext())
    {
      localObject = (String)paramGetFeedTagInfoListRequest.next();
      TagManager.a(this.a).remove(localObject);
    }
    paramGetFeedTagInfoListRequest = new TagManager.FeedTagListUpdateEvent();
    paramGetFeedTagInfoListRequest.g = paramErrorMessage;
    if ((!paramErrorMessage.isFail()) && (paramGetFeedTagInfoListResponse != null))
    {
      paramErrorMessage = paramGetFeedTagInfoListRequest.a;
      localObject = (TagManager)SuperManager.a(27);
      paramGetFeedTagInfoListResponse = paramGetFeedTagInfoListResponse.a.iterator();
      while (paramGetFeedTagInfoListResponse.hasNext())
      {
        GetFeedTagInfoListRequest.FeedTagInfoList localFeedTagInfoList = (GetFeedTagInfoListRequest.FeedTagInfoList)paramGetFeedTagInfoListResponse.next();
        ((TagManager)localObject).b(localFeedTagInfoList.a, localFeedTagInfoList.b);
        paramErrorMessage.put(localFeedTagInfoList.a, localFeedTagInfoList);
        SLog.a("Q.qqstory:TagManager", "save feedId :%s , %s", localFeedTagInfoList.a, localFeedTagInfoList.b);
      }
      StoryDispatcher.a().dispatch(paramGetFeedTagInfoListRequest);
      return;
    }
    SLog.d("Q.qqstory:TagManager", "request fail for get tag request");
    StoryDispatcher.a().dispatch(paramGetFeedTagInfoListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TagManager.1
 * JD-Core Version:    0.7.0.1
 */