package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.request.GetVidListRequest;
import com.tencent.biz.qqstory.network.response.GetVidListResponse;
import com.tencent.biz.qqstory.network.response.GetVidListResponse.UserVidList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UidToVidHandler
  extends BatchNetHandler
  implements CmdTaskManger.CommandCallback
{
  protected List a;
  protected int b;
  
  public UidToVidHandler(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.b = paramInt;
  }
  
  public void a()
  {
    GetVidListRequest localGetVidListRequest = new GetVidListRequest();
    localGetVidListRequest.c = this.b;
    localGetVidListRequest.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    CmdTaskManger.a().a(localGetVidListRequest, this);
  }
  
  public void a(@NonNull GetVidListRequest paramGetVidListRequest, @Nullable GetVidListResponse paramGetVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    UidToVidHandler.GetUserVidListEvent localGetUserVidListEvent = new UidToVidHandler.GetUserVidListEvent();
    localGetUserVidListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localGetUserVidListEvent.jdField_a_of_type_JavaUtilList = paramGetVidListRequest.jdField_a_of_type_JavaUtilList;
    localGetUserVidListEvent.jdField_a_of_type_Int = paramGetVidListRequest.c;
    if ((paramGetVidListResponse == null) || (paramErrorMessage.isFail()))
    {
      c();
      Dispatchers.get().dispatch(localGetUserVidListEvent);
      return;
    }
    b();
    paramGetVidListRequest = (StoryManager)SuperManager.a(5);
    paramErrorMessage = paramGetVidListResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramErrorMessage.hasNext())
    {
      GetVidListResponse.UserVidList localUserVidList = (GetVidListResponse.UserVidList)paramErrorMessage.next();
      switch (this.b)
      {
      default: 
        break;
      case 3: 
        paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 1, localUserVidList.jdField_a_of_type_JavaUtilList, true);
        StoryItem localStoryItem = paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 1);
        if (localStoryItem != null)
        {
          int i = localUserVidList.jdField_a_of_type_JavaUtilList.size();
          SLog.a("Q.qqstory.net:UidToVidHandler", "update %s unread count , old : %d , new : %d", localUserVidList.jdField_a_of_type_JavaLangString, Integer.valueOf(localStoryItem.unReadCount), Integer.valueOf(i));
          localStoryItem.unReadCount = i;
          paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 1, localStoryItem);
        }
        break;
      case 5: 
      case 7: 
        paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 0, localUserVidList.jdField_a_of_type_JavaUtilList, true);
        break;
      case 6: 
        paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 3, localUserVidList.jdField_a_of_type_JavaUtilList, true);
        break;
      case 4: 
        paramGetVidListRequest.a(localUserVidList.jdField_a_of_type_JavaLangString, 0, localUserVidList.jdField_a_of_type_JavaUtilList, true);
      }
    }
    localGetUserVidListEvent.b = paramGetVidListResponse.jdField_a_of_type_JavaUtilList;
    Dispatchers.get().dispatch(localGetUserVidListEvent);
  }
  
  public String toString()
  {
    return "UidToVidHandler{mUidList=" + this.jdField_a_of_type_JavaUtilList + ", mPullType=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.UidToVidHandler
 * JD-Core Version:    0.7.0.1
 */