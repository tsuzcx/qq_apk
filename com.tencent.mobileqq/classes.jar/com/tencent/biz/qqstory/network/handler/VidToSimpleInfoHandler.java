package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetSimpleInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetSimpleInfoListResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VidToSimpleInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetSimpleInfoListRequest, GetSimpleInfoListResponse>
{
  protected String a;
  protected List<String> a;
  
  public VidToSimpleInfoHandler(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    GetSimpleInfoListRequest localGetSimpleInfoListRequest = new GetSimpleInfoListRequest();
    localGetSimpleInfoListRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a(localGetSimpleInfoListRequest, this);
  }
  
  public void a(@NonNull GetSimpleInfoListRequest paramGetSimpleInfoListRequest, @Nullable GetSimpleInfoListResponse paramGetSimpleInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetSimpleInfoListRequest = new VidToSimpleInfoHandler.GetSimpleInfoListEvent();
    if ((paramGetSimpleInfoListResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      StoryDispatcher.a().dispatch(paramGetSimpleInfoListRequest);
      return;
    }
    b();
    paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList);
    paramGetSimpleInfoListRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramGetSimpleInfoListResponse = paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetSimpleInfoListResponse.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramGetSimpleInfoListResponse.next();
      paramErrorMessage = new VideoCollectionItem.FakeVideoUIItem(paramErrorMessage.mVid, paramErrorMessage);
      paramGetSimpleInfoListRequest.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    StoryDispatcher.a().dispatch(paramGetSimpleInfoListRequest);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler
 * JD-Core Version:    0.7.0.1
 */