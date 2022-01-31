package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetLabelListRequest;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class RecommendLabelListPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  public String a;
  public String b;
  
  private void d()
  {
    GetLabelListRequest localGetLabelListRequest = new GetLabelListRequest();
    localGetLabelListRequest.b = this.jdField_a_of_type_JavaLangString;
    localGetLabelListRequest.jdField_c_of_type_JavaLangString = this.b;
    localGetLabelListRequest.jdField_c_of_type_Int = 10;
    CmdTaskManger.a().a(localGetLabelListRequest, this);
  }
  
  public void a(@NonNull GetLabelListRequest paramGetLabelListRequest, @Nullable GetLabelListResponse paramGetLabelListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "get recommend label list return %s", paramErrorMessage.toString());
    RecommendLabelListPagerLoader.GetRecommendLabelListEvent localGetRecommendLabelListEvent = new RecommendLabelListPagerLoader.GetRecommendLabelListEvent(paramErrorMessage);
    if ((paramGetLabelListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetRecommendLabelListEvent);
      return;
    }
    localGetRecommendLabelListEvent.jdField_a_of_type_JavaUtilList = paramGetLabelListResponse.jdField_a_of_type_JavaUtilList;
    localGetRecommendLabelListEvent.jdField_a_of_type_JavaLangString = paramGetLabelListRequest.b;
    localGetRecommendLabelListEvent.jdField_a_of_type_Boolean = paramGetLabelListResponse.jdField_a_of_type_Boolean;
    localGetRecommendLabelListEvent.c = TextUtils.isEmpty(paramGetLabelListRequest.jdField_c_of_type_JavaLangString);
    this.b = paramGetLabelListResponse.jdField_a_of_type_JavaLangString;
    localGetRecommendLabelListEvent.d = this.jdField_a_of_type_Boolean;
    Dispatchers.get().dispatch(localGetRecommendLabelListEvent);
    SLog.a("Q.qqstory.record.label.RecommendLabelListPagerLoader", "dispatch recommend label result %s", localGetRecommendLabelListEvent.toString());
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    this.b = "";
    d();
  }
  
  public void c()
  {
    super.c();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecommendLabelListPagerLoader
 * JD-Core Version:    0.7.0.1
 */