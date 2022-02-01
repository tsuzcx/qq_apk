package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetGroupVidListRequest;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse;
import com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

public class TroopUidToVidListHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback<GetGroupVidListRequest, GetGroupVidListResponse>
{
  protected String a;
  protected int b;
  
  public TroopUidToVidListHandler(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt;
  }
  
  public void a()
  {
    GetGroupVidListRequest localGetGroupVidListRequest = new GetGroupVidListRequest();
    localGetGroupVidListRequest.c = this.b;
    localGetGroupVidListRequest.b = this.jdField_a_of_type_JavaLangString;
    CmdTaskManger.a().a(localGetGroupVidListRequest, this);
  }
  
  public void a(@NonNull GetGroupVidListRequest paramGetGroupVidListRequest, @Nullable GetGroupVidListResponse paramGetGroupVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    TroopUidToVidListHandler.GetTroopVidListEvent localGetTroopVidListEvent = new TroopUidToVidListHandler.GetTroopVidListEvent();
    localGetTroopVidListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localGetTroopVidListEvent.jdField_a_of_type_JavaLangString = paramGetGroupVidListRequest.b;
    localGetTroopVidListEvent.jdField_a_of_type_Int = paramGetGroupVidListRequest.c;
    if ((paramGetGroupVidListResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      StoryDispatcher.a().dispatch(localGetTroopVidListEvent);
      return;
    }
    b();
    paramGetGroupVidListRequest = (StoryManager)SuperManager.a(5);
    switch (this.b)
    {
    }
    for (;;)
    {
      localGetTroopVidListEvent.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList = paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList;
      StoryDispatcher.a().dispatch(localGetTroopVidListEvent);
      return;
      paramGetGroupVidListRequest.a(paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaLangString, 1, paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaUtilList, true);
      paramErrorMessage = paramGetGroupVidListRequest.a(paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaLangString, 1);
      if (paramErrorMessage != null)
      {
        int i = paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaUtilList.size();
        SLog.a("Q.qqstory.net:TroopUidToVidListHandler", "update %s unread count , old : %d , new : %d", paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.unReadCount), Integer.valueOf(i));
        paramErrorMessage.unReadCount = i;
        paramGetGroupVidListRequest.a(paramGetGroupVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkResponseGetGroupVidListResponse$UserVidList.jdField_a_of_type_JavaLangString, 1, paramErrorMessage);
      }
    }
  }
  
  public String toString()
  {
    return "TroopUnionIdToVidHandler{mUin=" + this.jdField_a_of_type_JavaLangString + ", mPullType=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler
 * JD-Core Version:    0.7.0.1
 */