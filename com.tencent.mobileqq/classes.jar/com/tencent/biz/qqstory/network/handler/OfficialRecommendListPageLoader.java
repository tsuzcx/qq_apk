package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.RecommendItem;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.request.GetOfficialRecommendStoryListRequest;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import neh;

public class OfficialRecommendListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback
{
  private LbsManager.LbsUpdateListener a = new neh(this);
  
  public void a(BasicLocation paramBasicLocation)
  {
    GetOfficialRecommendStoryListRequest localGetOfficialRecommendStoryListRequest = new GetOfficialRecommendStoryListRequest();
    localGetOfficialRecommendStoryListRequest.a = paramBasicLocation;
    CmdTaskManger.a().a(localGetOfficialRecommendStoryListRequest, this);
  }
  
  public void a(@NonNull GetOfficialRecommendStoryListRequest paramGetOfficialRecommendStoryListRequest, @Nullable GetOfficialRecommendStoryListResponse paramGetOfficialRecommendStoryListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b(":OfficialRecommendListPageLoader", "OfficialRecommendListPageLoader onCmdRespond return :" + paramErrorMessage);
    paramGetOfficialRecommendStoryListRequest = new OfficialRecommendListPageLoader.GetOfficialRecommendListEvent(paramErrorMessage);
    if ((paramGetOfficialRecommendStoryListResponse == null) || (paramErrorMessage.isFail()))
    {
      Dispatchers.get().dispatch(paramGetOfficialRecommendStoryListRequest);
      return;
    }
    paramErrorMessage = (StoryManager)SuperManager.a(5);
    ArrayList localArrayList = paramErrorMessage.a();
    if (QLog.isColorLevel())
    {
      QLog.e(":OfficialRecommendListPageLoader", 2, "GetOfficialRecommendStoryListRequest: onCmdRespond markReadItems: " + localArrayList);
      QLog.e(":OfficialRecommendListPageLoader", 2, "GetOfficialRecommendStoryListRequest: onCmdRespond response: " + paramGetOfficialRecommendStoryListResponse.a);
    }
    int i = 0;
    while (i < paramGetOfficialRecommendStoryListResponse.a.size())
    {
      RecommendItem localRecommendItem1 = (RecommendItem)paramGetOfficialRecommendStoryListResponse.a.get(i);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        RecommendItem localRecommendItem2 = (RecommendItem)localIterator.next();
        if (localRecommendItem1.mID == localRecommendItem2.mID) {
          localRecommendItem1.mIsMarkRead = true;
        }
      }
      i += 1;
    }
    paramErrorMessage.a(paramGetOfficialRecommendStoryListResponse.a);
    paramGetOfficialRecommendStoryListRequest.jdField_a_of_type_JavaUtilList = paramGetOfficialRecommendStoryListResponse.a;
    paramGetOfficialRecommendStoryListRequest.jdField_a_of_type_Boolean = true;
    Dispatchers.get().dispatch(paramGetOfficialRecommendStoryListRequest);
    SLog.b(":OfficialRecommendListPageLoader", "dispatch OfficialRecommendListPageLoader onCmdRespond GetOfficialRecommendStoryListRequest result: " + paramGetOfficialRecommendStoryListRequest);
  }
  
  public void a(@Nullable TencentLocation paramTencentLocation, int paramInt)
  {
    super.a(paramTencentLocation, paramInt);
    d();
  }
  
  public void d()
  {
    GetOfficialRecommendStoryListRequest localGetOfficialRecommendStoryListRequest = new GetOfficialRecommendStoryListRequest();
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = localLbsManager.b();
    if (localBasicLocation != null)
    {
      localGetOfficialRecommendStoryListRequest.a = localBasicLocation;
      CmdTaskManger.a().a(localGetOfficialRecommendStoryListRequest, this);
      return;
    }
    localLbsManager.a(this.a);
    localLbsManager.a(2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader
 * JD-Core Version:    0.7.0.1
 */