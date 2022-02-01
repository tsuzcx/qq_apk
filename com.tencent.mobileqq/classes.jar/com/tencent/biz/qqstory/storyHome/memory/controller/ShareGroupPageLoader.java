package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetShareGroupListRequest;
import com.tencent.biz.qqstory.network.response.GetShareGroupListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class ShareGroupPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetShareGroupListRequest, GetShareGroupListResponse>
{
  public String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  
  private void d()
  {
    GetShareGroupListRequest localGetShareGroupListRequest = new GetShareGroupListRequest();
    localGetShareGroupListRequest.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localGetShareGroupListRequest.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localGetShareGroupListRequest.jdField_b_of_type_Long = 0L;
    localGetShareGroupListRequest.c = 10;
    localGetShareGroupListRequest.d = 10;
    CmdTaskManger.a().a(localGetShareGroupListRequest, this);
    SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "send share group list request. request=%s.", localGetShareGroupListRequest.toString());
  }
  
  public void a(@NonNull GetShareGroupListRequest paramGetShareGroupListRequest, @Nullable GetShareGroupListResponse paramGetShareGroupListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "get share group list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      SLog.c("Q.qqstory.memories:ShareGroupPageLoader", "don't nothing after terminate");
      return;
    }
    ShareGroupPageLoader.GetShareGroupListEvent localGetShareGroupListEvent = new ShareGroupPageLoader.GetShareGroupListEvent(paramErrorMessage, this.d);
    localGetShareGroupListEvent.jdField_b_of_type_Boolean = false;
    if ((paramGetShareGroupListResponse == null) || (paramErrorMessage.isFail()))
    {
      StoryDispatcher.a().dispatch(localGetShareGroupListEvent);
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramGetShareGroupListResponse.jdField_a_of_type_JavaLangString;
    localGetShareGroupListEvent.jdField_a_of_type_JavaUtilList = paramGetShareGroupListResponse.jdField_a_of_type_JavaUtilArrayList;
    localGetShareGroupListEvent.jdField_a_of_type_Int = paramGetShareGroupListResponse.b;
    localGetShareGroupListEvent.jdField_a_of_type_Boolean = paramGetShareGroupListResponse.jdField_a_of_type_Boolean;
    localGetShareGroupListEvent.jdField_c_of_type_Boolean = TextUtils.isEmpty(paramGetShareGroupListRequest.jdField_a_of_type_JavaLangString);
    paramGetShareGroupListResponse = paramGetShareGroupListResponse.jdField_a_of_type_JavaUtilArrayList;
    ((MemoryManager)SuperManager.a(19)).b(paramGetShareGroupListResponse, paramGetShareGroupListRequest.jdField_b_of_type_JavaLangString, localGetShareGroupListEvent.jdField_c_of_type_Boolean);
    try
    {
      this.jdField_b_of_type_Boolean = true;
      StoryDispatcher.a().dispatch(localGetShareGroupListEvent);
      SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from network: %s", localGetShareGroupListEvent);
      return;
    }
    finally {}
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = "";
    d();
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader
 * JD-Core Version:    0.7.0.1
 */