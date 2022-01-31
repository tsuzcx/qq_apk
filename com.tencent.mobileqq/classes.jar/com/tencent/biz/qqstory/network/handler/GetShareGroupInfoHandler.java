package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetShareGroupInfoRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupInfoResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupInfoHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  private GetShareGroupInfoHandler.OnGetShareGroupInfoCallback jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetShareGroupInfoHandler$OnGetShareGroupInfoCallback;
  protected String a;
  private final List jdField_a_of_type_JavaUtilList;
  
  public GetShareGroupInfoHandler(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public GetShareGroupInfoHandler(List paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GetShareGroupInfoHandler a(GetShareGroupInfoHandler.OnGetShareGroupInfoCallback paramOnGetShareGroupInfoCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetShareGroupInfoHandler$OnGetShareGroupInfoCallback = paramOnGetShareGroupInfoCallback;
    return this;
  }
  
  public void a()
  {
    GetShareGroupInfoRequest localGetShareGroupInfoRequest = new GetShareGroupInfoRequest();
    localGetShareGroupInfoRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a(localGetShareGroupInfoRequest, this);
  }
  
  public void a(@NonNull GetShareGroupInfoRequest paramGetShareGroupInfoRequest, @Nullable GetShareGroupInfoResponse paramGetShareGroupInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetShareGroupInfoRequest = new GetShareGroupInfoHandler.GetShareGroupInfoEvent();
    paramGetShareGroupInfoRequest.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramGetShareGroupInfoRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramGetShareGroupInfoResponse != null))
    {
      paramErrorMessage = new ArrayList();
      ShareGroupManager localShareGroupManager = (ShareGroupManager)SuperManager.a(7);
      if ((paramGetShareGroupInfoResponse.jdField_a_of_type_JavaUtilList != null) && (!paramGetShareGroupInfoResponse.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramGetShareGroupInfoResponse = paramGetShareGroupInfoResponse.jdField_a_of_type_JavaUtilList.iterator();
        while (paramGetShareGroupInfoResponse.hasNext()) {
          paramErrorMessage.add(localShareGroupManager.a((ShareGroupItem)paramGetShareGroupInfoResponse.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramGetShareGroupInfoRequest.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramGetShareGroupInfoRequest.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      Dispatchers.get().dispatch(paramGetShareGroupInfoRequest);
      paramGetShareGroupInfoResponse = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetShareGroupInfoHandler$OnGetShareGroupInfoCallback;
      if (paramGetShareGroupInfoResponse != null) {
        paramGetShareGroupInfoResponse.a(paramGetShareGroupInfoRequest);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler
 * JD-Core Version:    0.7.0.1
 */