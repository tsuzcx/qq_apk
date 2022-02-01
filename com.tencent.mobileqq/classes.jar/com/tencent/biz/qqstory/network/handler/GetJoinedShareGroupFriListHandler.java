package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetJoinedShareGroupFriListRequest;
import com.tencent.biz.qqstory.network.response.GetJoinedShareGroupFriListResponse;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;

public class GetJoinedShareGroupFriListHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetJoinedShareGroupFriListRequest, GetJoinedShareGroupFriListResponse>
{
  public String a;
  public boolean a;
  public String b;
  
  public void a()
  {
    GetJoinedShareGroupFriListRequest localGetJoinedShareGroupFriListRequest = new GetJoinedShareGroupFriListRequest();
    localGetJoinedShareGroupFriListRequest.b = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a(localGetJoinedShareGroupFriListRequest, this);
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.shareGroup.GetJoinedShareGroupFriListHandler", 2, "GetJoinedShareGroupFriListHandler sendRequest groupID = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(@NonNull GetJoinedShareGroupFriListRequest paramGetJoinedShareGroupFriListRequest, @Nullable GetJoinedShareGroupFriListResponse paramGetJoinedShareGroupFriListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetJoinedShareGroupFriListRequest = new GetJoinedShareGroupFriListHandler.GetJoinedShareGroupFriListEvent();
    paramGetJoinedShareGroupFriListRequest.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramGetJoinedShareGroupFriListRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramGetJoinedShareGroupFriListRequest.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    paramGetJoinedShareGroupFriListRequest.b = this.b;
    if ((paramErrorMessage.isSuccess()) && (paramGetJoinedShareGroupFriListResponse != null))
    {
      paramGetJoinedShareGroupFriListRequest.jdField_a_of_type_JavaUtilArrayList = paramGetJoinedShareGroupFriListResponse.jdField_a_of_type_JavaUtilArrayList;
      b();
    }
    for (;;)
    {
      StoryDispatcher.a().dispatch(paramGetJoinedShareGroupFriListRequest);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetJoinedShareGroupFriListHandler
 * JD-Core Version:    0.7.0.1
 */