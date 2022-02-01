package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetSimpleInfoListRequest;
import com.tencent.biz.qqstory.network.response.GetSimpleInfoListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class DateVideoSimpleInfoPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetSimpleInfoListRequest, GetSimpleInfoListResponse>
{
  protected final int a;
  protected List<String> a;
  
  private void d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      SLog.d("Q.qqstory.memories:DateVideoSimpleInfoPageLoader", "vid list has pulled to end!");
    }
    int i = Math.min(20, this.jdField_a_of_type_JavaUtilList.size());
    List localList = this.jdField_a_of_type_JavaUtilList.subList(0, i);
    GetSimpleInfoListRequest localGetSimpleInfoListRequest = new GetSimpleInfoListRequest();
    localGetSimpleInfoListRequest.jdField_a_of_type_JavaUtilList = localList;
    if (i == this.jdField_a_of_type_JavaUtilList.size()) {
      bool = true;
    }
    localGetSimpleInfoListRequest.jdField_a_of_type_Boolean = bool;
    CmdTaskManger.a().a(localGetSimpleInfoListRequest, this);
  }
  
  public void a(@NonNull GetSimpleInfoListRequest paramGetSimpleInfoListRequest, @Nullable GetSimpleInfoListResponse paramGetSimpleInfoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    DateVideoSimpleInfoPageLoader.GetSimpleInfoListEvent localGetSimpleInfoListEvent = new DateVideoSimpleInfoPageLoader.GetSimpleInfoListEvent(paramErrorMessage);
    if ((paramGetSimpleInfoListResponse == null) || (paramErrorMessage.isFail()))
    {
      StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
      return;
    }
    paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList = ((StoryManager)SuperManager.a(5)).a(paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList);
    localGetSimpleInfoListEvent.c = false;
    localGetSimpleInfoListEvent.jdField_a_of_type_Boolean = paramGetSimpleInfoListRequest.jdField_a_of_type_Boolean;
    localGetSimpleInfoListEvent.b = false;
    localGetSimpleInfoListEvent.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localGetSimpleInfoListEvent.jdField_a_of_type_JavaUtilList = paramGetSimpleInfoListResponse.jdField_a_of_type_JavaUtilList;
    paramGetSimpleInfoListResponse = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    paramGetSimpleInfoListResponse.removeAll(paramGetSimpleInfoListRequest.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList = paramGetSimpleInfoListResponse;
    StoryDispatcher.a().dispatch(localGetSimpleInfoListEvent);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    d();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.DateVideoSimpleInfoPageLoader
 * JD-Core Version:    0.7.0.1
 */