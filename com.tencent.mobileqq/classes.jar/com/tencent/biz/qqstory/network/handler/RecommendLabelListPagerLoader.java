package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetLabelListRequest;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;

public class RecommendLabelListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetLabelListRequest, GetLabelListResponse>
{
  public String b;
  public String c;
  
  private void d()
  {
    GetLabelListRequest localGetLabelListRequest = new GetLabelListRequest();
    localGetLabelListRequest.b = this.b;
    localGetLabelListRequest.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localGetLabelListRequest.jdField_c_of_type_Int = 10;
    CmdTaskManger.a().a(localGetLabelListRequest, this);
  }
  
  public void a(@NonNull GetLabelListRequest paramGetLabelListRequest, @Nullable GetLabelListResponse paramGetLabelListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "get recommend label list return %s", paramErrorMessage.toString());
    RecommendLabelListPagerLoader.GetRecommendLabelListEvent localGetRecommendLabelListEvent = new RecommendLabelListPagerLoader.GetRecommendLabelListEvent(paramErrorMessage);
    if ((paramGetLabelListResponse != null) && (!paramErrorMessage.isFail()))
    {
      localGetRecommendLabelListEvent.jdField_a_of_type_JavaUtilList = paramGetLabelListResponse.jdField_a_of_type_JavaUtilList;
      localGetRecommendLabelListEvent.jdField_a_of_type_JavaLangString = paramGetLabelListRequest.b;
      localGetRecommendLabelListEvent.jdField_a_of_type_Boolean = paramGetLabelListResponse.jdField_a_of_type_Boolean;
      localGetRecommendLabelListEvent.c = TextUtils.isEmpty(paramGetLabelListRequest.jdField_c_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = paramGetLabelListResponse.jdField_a_of_type_JavaLangString;
      localGetRecommendLabelListEvent.d = this.jdField_a_of_type_Boolean;
      StoryDispatcher.a().dispatch(localGetRecommendLabelListEvent);
      SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "dispatch recommend label result %s", localGetRecommendLabelListEvent.toString());
      return;
    }
    StoryDispatcher.a().dispatch(localGetRecommendLabelListEvent);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.jdField_c_of_type_JavaLangString = "";
    d();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecommendLabelListPagerLoader
 * JD-Core Version:    0.7.0.1
 */