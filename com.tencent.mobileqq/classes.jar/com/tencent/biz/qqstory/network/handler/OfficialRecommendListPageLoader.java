package com.tencent.biz.qqstory.network.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import java.util.ArrayList;
import java.util.Iterator;

public class OfficialRecommendListPageLoader
  extends INetPageLoader
  implements CmdTaskManger.CommandCallback<GetOfficialRecommendStoryListRequest, GetOfficialRecommendStoryListResponse>
{
  private LbsManager.LbsUpdateListener g = new OfficialRecommendListPageLoader.1(this);
  
  public void a(BasicLocation paramBasicLocation)
  {
    GetOfficialRecommendStoryListRequest localGetOfficialRecommendStoryListRequest = new GetOfficialRecommendStoryListRequest();
    localGetOfficialRecommendStoryListRequest.g = paramBasicLocation;
    CmdTaskManger.a().a(localGetOfficialRecommendStoryListRequest, this);
  }
  
  public void a(@NonNull GetOfficialRecommendStoryListRequest paramGetOfficialRecommendStoryListRequest, @Nullable GetOfficialRecommendStoryListResponse paramGetOfficialRecommendStoryListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramGetOfficialRecommendStoryListRequest = new StringBuilder();
    paramGetOfficialRecommendStoryListRequest.append("OfficialRecommendListPageLoader onCmdRespond return :");
    paramGetOfficialRecommendStoryListRequest.append(paramErrorMessage);
    SLog.b(":OfficialRecommendListPageLoader", paramGetOfficialRecommendStoryListRequest.toString());
    paramGetOfficialRecommendStoryListRequest = new OfficialRecommendListPageLoader.GetOfficialRecommendListEvent(paramErrorMessage);
    if ((paramGetOfficialRecommendStoryListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramErrorMessage = (StoryManager)SuperManager.a(5);
      ArrayList localArrayList = paramErrorMessage.e();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetOfficialRecommendStoryListRequest: onCmdRespond markReadItems: ");
        ((StringBuilder)localObject).append(localArrayList);
        QLog.e(":OfficialRecommendListPageLoader", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetOfficialRecommendStoryListRequest: onCmdRespond response: ");
        ((StringBuilder)localObject).append(paramGetOfficialRecommendStoryListResponse.f);
        QLog.e(":OfficialRecommendListPageLoader", 2, ((StringBuilder)localObject).toString());
      }
      int i = 0;
      while (i < paramGetOfficialRecommendStoryListResponse.f.size())
      {
        localObject = (RecommendItem)paramGetOfficialRecommendStoryListResponse.f.get(i);
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          RecommendItem localRecommendItem = (RecommendItem)localIterator.next();
          if (((RecommendItem)localObject).mID == localRecommendItem.mID) {
            ((RecommendItem)localObject).mIsMarkRead = true;
          }
        }
        i += 1;
      }
      paramErrorMessage.a(paramGetOfficialRecommendStoryListResponse.f);
      paramGetOfficialRecommendStoryListRequest.e = paramGetOfficialRecommendStoryListResponse.f;
      paramGetOfficialRecommendStoryListRequest.a = true;
      StoryDispatcher.a().dispatch(paramGetOfficialRecommendStoryListRequest);
      paramGetOfficialRecommendStoryListResponse = new StringBuilder();
      paramGetOfficialRecommendStoryListResponse.append("dispatch OfficialRecommendListPageLoader onCmdRespond GetOfficialRecommendStoryListRequest result: ");
      paramGetOfficialRecommendStoryListResponse.append(paramGetOfficialRecommendStoryListRequest);
      SLog.b(":OfficialRecommendListPageLoader", paramGetOfficialRecommendStoryListResponse.toString());
      return;
    }
    StoryDispatcher.a().dispatch(paramGetOfficialRecommendStoryListRequest);
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
    BasicLocation localBasicLocation = localLbsManager.d();
    if (localBasicLocation != null)
    {
      localGetOfficialRecommendStoryListRequest.g = localBasicLocation;
      CmdTaskManger.a().a(localGetOfficialRecommendStoryListRequest, this);
      return;
    }
    localLbsManager.a(this.g);
    localLbsManager.a(2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader
 * JD-Core Version:    0.7.0.1
 */