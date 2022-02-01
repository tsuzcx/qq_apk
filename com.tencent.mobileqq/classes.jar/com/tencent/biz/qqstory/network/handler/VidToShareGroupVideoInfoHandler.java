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
import com.tencent.biz.qqstory.network.request.GetShareGroupVideoInfoRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupVideoInfoResponse;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VidToShareGroupVideoInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetShareGroupVideoInfoRequest, GetShareGroupVideoInfoResponse>
{
  protected String a;
  protected List<String> a;
  
  public VidToShareGroupVideoInfoHandler(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    GetShareGroupVideoInfoRequest localGetShareGroupVideoInfoRequest = new GetShareGroupVideoInfoRequest();
    localGetShareGroupVideoInfoRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a(localGetShareGroupVideoInfoRequest, this);
  }
  
  public void a(@NonNull GetShareGroupVideoInfoRequest paramGetShareGroupVideoInfoRequest, @Nullable GetShareGroupVideoInfoResponse paramGetShareGroupVideoInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    VidToSimpleInfoHandler.GetSimpleInfoListEvent localGetSimpleInfoListEvent = new VidToSimpleInfoHandler.GetSimpleInfoListEvent();
    if ((paramGetShareGroupVideoInfoResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
      return;
    }
    SLog.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramGetShareGroupVideoInfoRequest.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramGetShareGroupVideoInfoRequest.jdField_a_of_type_JavaUtilList.toString());
    SLog.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramGetShareGroupVideoInfoResponse.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramGetShareGroupVideoInfoResponse.toString());
    b();
    paramGetShareGroupVideoInfoResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetShareGroupVideoInfoResponse.jdField_a_of_type_JavaUtilList);
    localGetSimpleInfoListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramGetShareGroupVideoInfoRequest = paramGetShareGroupVideoInfoResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramGetShareGroupVideoInfoRequest.hasNext())
    {
      paramGetShareGroupVideoInfoResponse = (StoryVideoItem)paramGetShareGroupVideoInfoRequest.next();
      paramGetShareGroupVideoInfoResponse = new VideoCollectionItem.FakeVideoUIItem(paramGetShareGroupVideoInfoResponse.mVid, paramGetShareGroupVideoInfoResponse);
      localGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList.add(paramGetShareGroupVideoInfoResponse);
    }
    StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToShareGroupVideoInfoHandler
 * JD-Core Version:    0.7.0.1
 */