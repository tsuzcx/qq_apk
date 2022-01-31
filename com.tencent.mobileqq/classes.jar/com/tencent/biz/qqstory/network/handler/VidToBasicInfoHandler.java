package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetVideoFullInfoListResponse;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VidToBasicInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  protected List a;
  
  public VidToBasicInfoHandler(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
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
    GetVideoFullInfoListRequest localGetVideoFullInfoListRequest = new GetVideoFullInfoListRequest();
    localGetVideoFullInfoListRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a(localGetVideoFullInfoListRequest, this);
  }
  
  public void a(@NonNull GetVideoFullInfoListRequest paramGetVideoFullInfoListRequest, @Nullable GetVideoFullInfoListResponse paramGetVideoFullInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetVideoFullInfoListRequest = new VidToBasicInfoHandler.GetVideoBasicInfoListEvent();
    if ((paramGetVideoFullInfoListResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      paramGetVideoFullInfoListRequest.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      Dispatchers.get().dispatch(paramGetVideoFullInfoListRequest);
      return;
    }
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    if (paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((StoryVideoItem)localIterator.next()).mBasicInfoState = 1;
      }
    }
    paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList = paramErrorMessage.a(paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList);
    paramGetVideoFullInfoListRequest.jdField_a_of_type_JavaUtilList = paramGetVideoFullInfoListResponse.jdField_a_of_type_JavaUtilList;
    ((DownloadUrlManager)SuperManager.a(28)).a(paramGetVideoFullInfoListResponse.b);
    Dispatchers.get().dispatch(paramGetVideoFullInfoListRequest);
    b();
  }
  
  public String toString()
  {
    return "VidToBasicInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler
 * JD-Core Version:    0.7.0.1
 */