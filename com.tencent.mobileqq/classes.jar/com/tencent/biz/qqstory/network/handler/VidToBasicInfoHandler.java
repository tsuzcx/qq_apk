package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VidToBasicInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetVideoFullInfoListRequest, GetVideoFullInfoListResponse>
{
  private static ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected List<String> a;
  private final boolean jdField_a_of_type_Boolean;
  
  public VidToBasicInfoHandler(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VidToBasicInfoHandler(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramList);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!StoryVideoItem.isFakeVid(str)) {
          this.jdField_a_of_type_JavaUtilList.add(str);
        }
      }
    }
  }
  
  public void a()
  {
    Bosses.get().postLightWeightJob(new VidToBasicInfoHandler.1(this), 0);
  }
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    VidToBasicInfoHandler.GetVideoBasicInfoListEvent localGetVideoBasicInfoListEvent = new VidToBasicInfoHandler.GetVideoBasicInfoListEvent();
    if ((paramGetVideoFullInfoListResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      localGetVideoBasicInfoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      StoryDispatcher.a().dispatch(localGetVideoBasicInfoListEvent);
      paramGetVideoFullInfoListRequest = paramGetVideoFullInfoListRequest.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (paramGetVideoFullInfoListRequest.hasNext())
    {
      paramGetVideoFullInfoListResponse = (String)paramGetVideoFullInfoListRequest.next();
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramGetVideoFullInfoListResponse);
      continue;
      paramGetVideoFullInfoListRequest = (StoryManager)SuperManager.a(5);
      if (paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList != null)
      {
        paramErrorMessage = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
        while (paramErrorMessage.hasNext()) {
          ((StoryVideoItem)paramErrorMessage.next()).mBasicInfoState = 1;
        }
      }
      paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList = paramGetVideoFullInfoListRequest.a(paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList);
      localGetVideoBasicInfoListEvent.jdField_a_of_type_JavaUtilList = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList;
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
      StoryDispatcher.a().dispatch(localGetVideoBasicInfoListEvent);
      b();
    }
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler
 * JD-Core Version:    0.7.0.1
 */