package com.tencent.biz.qqstory.storyHome.discover.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetDiscoverCardInfoRequest;
import com.tencent.biz.qqstory.network.response.GetDiscoverCardInfoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import nuh;
import nui;

public class DiscoverPagerLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  private final int jdField_a_of_type_Int;
  public BasicLocation a;
  private String jdField_a_of_type_JavaLangString = "";
  private final long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  public DiscoverPagerLoader(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = paramLong;
  }
  
  private void e()
  {
    GetDiscoverCardInfoRequest localGetDiscoverCardInfoRequest = new GetDiscoverCardInfoRequest();
    localGetDiscoverCardInfoRequest.c = 30;
    localGetDiscoverCardInfoRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localGetDiscoverCardInfoRequest.d = this.jdField_a_of_type_Int;
    localGetDiscoverCardInfoRequest.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation != null)
    {
      localGetDiscoverCardInfoRequest.e = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.jdField_a_of_type_Int;
      localGetDiscoverCardInfoRequest.f = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation.b;
    }
    CmdTaskManger.a().a(localGetDiscoverCardInfoRequest, this);
  }
  
  public void a(@NonNull GetDiscoverCardInfoRequest paramGetDiscoverCardInfoRequest, @Nullable GetDiscoverCardInfoResponse paramGetDiscoverCardInfoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.a("Q.qqstory.discover:DiscoverPagerLoader", "get video list return:%s", paramErrorMessage.toString());
    if (this.jdField_c_of_type_Boolean)
    {
      SLog.c("Q.qqstory.discover:DiscoverPagerLoader", "don't nothing after terminate");
      return;
    }
    DiscoverPagerLoader.GetDiscoverCardsEvent localGetDiscoverCardsEvent = new DiscoverPagerLoader.GetDiscoverCardsEvent(paramErrorMessage, this.jdField_a_of_type_Int, this.jdField_c_of_type_Long);
    if ((paramGetDiscoverCardInfoResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(localGetDiscoverCardsEvent);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramGetDiscoverCardInfoResponse.jdField_a_of_type_JavaLangString;
    boolean bool = TextUtils.isEmpty(paramGetDiscoverCardInfoRequest.jdField_a_of_type_JavaLangString);
    localGetDiscoverCardsEvent.jdField_a_of_type_JavaUtilList = paramGetDiscoverCardInfoResponse.jdField_a_of_type_JavaUtilArrayList;
    localGetDiscoverCardsEvent.jdField_c_of_type_Boolean = bool;
    localGetDiscoverCardsEvent.jdField_a_of_type_Boolean = paramGetDiscoverCardInfoResponse.jdField_a_of_type_Boolean;
    try
    {
      this.b = true;
      Dispatchers.get().dispatch(localGetDiscoverCardsEvent);
      SLog.a("Q.qqstory.discover:DiscoverPagerLoader", "dispatch video list return from network: %s", localGetDiscoverCardsEvent);
      paramGetDiscoverCardInfoRequest = new nui(this, localGetDiscoverCardsEvent, bool);
      Bosses.get().postJob(paramGetDiscoverCardInfoRequest);
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
    this.jdField_a_of_type_JavaLangString = "";
    e();
  }
  
  public boolean a()
  {
    if (this.b)
    {
      SLog.d("Q.qqstory.discover:DiscoverPagerLoader", "don't need to load data from cache");
      return false;
    }
    Bosses.get().postLightWeightJob(new nuh(this), 0);
    return true;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_c_of_type_Boolean)
    {
      AssertUtils.a("don't call this method after terminate", new Object[0]);
      return;
    }
    e();
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader
 * JD-Core Version:    0.7.0.1
 */