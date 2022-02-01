package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stFeedStatus;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.PersonalFeedListRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSArkCardDataManager
{
  private volatile String a = "";
  private boolean b;
  
  public static WSArkCardDataManager a()
  {
    return WSArkCardDataManager.SingletonHolder.a();
  }
  
  private ArrayList<String> a(List<WSVerticalItemData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)paramList.next();
        if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
          localArrayList.add(localWSVerticalItemData.b().id);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if ((paramIFetchDataRspListener instanceof AbsWSVerticalPagePresenter))
    {
      WSVerticalPageContract.View localView = ((AbsWSVerticalPagePresenter)paramIFetchDataRspListener).z();
      paramIFetchDataRspListener = null;
      if ((localView instanceof WSVerticalPageFragment)) {
        paramIFetchDataRspListener = (WSVerticalPageFragment)localView;
      }
      if ((paramIFetchDataRspListener != null) && (paramIFetchDataRspListener.getBaseActivity() != null) && (!paramIFetchDataRspListener.getBaseActivity().isFinishing())) {
        WSGlobalConfig.a().a(10007, paramstGetPersonalFeedListRsp.config);
      }
    }
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, WSArkCardDataManager.ExtParams paramExtParams)
  {
    if (paramstGetPersonalFeedListRsp.contextFeedStatus != null)
    {
      paramExtParams.a = paramstGetPersonalFeedListRsp.contextFeedStatus.feedId;
      paramExtParams.b = paramstGetPersonalFeedListRsp.contextFeedStatus.msg;
      paramstGetPersonalFeedListRsp = new StringBuilder();
      paramstGetPersonalFeedListRsp.append("[WSArkCardDataManager.java][setExtParams] extParams:");
      paramstGetPersonalFeedListRsp.append(paramExtParams);
      WSLog.e("WSArkCardDataManagerLog", paramstGetPersonalFeedListRsp.toString());
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener, Object paramObject)
  {
    paramObject = "";
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.a = "";
      this.b = false;
    }
    if (this.b)
    {
      WSLog.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    ArrayList localArrayList = a(paramList);
    paramIFetchDataRspListener = new WSArkCardDataManager.1(this, System.currentTimeMillis(), paramBoolean2, paramIFetchDataRspListener, paramBoolean1);
    paramList = paramObject;
    if (localArrayList != null)
    {
      paramList = paramObject;
      if (localArrayList.size() > 0) {
        paramList = (String)localArrayList.get(0);
      }
    }
    paramObject = new StringBuilder();
    paramObject.append("[WSArkCardDataManager.java] PersonalFeedListRequest isFirst = ");
    paramObject.append(paramBoolean2);
    paramObject.append(" feedId = ");
    paramObject.append(paramList);
    paramObject.append(" attachInfo = ");
    paramObject.append(this.a);
    WSLog.d("WSArkCardDataManagerLog", paramObject.toString());
    paramString = new WeishiTask(new PersonalFeedListRequest(paramString, this.a, paramBoolean2, localArrayList, paramInt), null, paramIFetchDataRspListener, 4013);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager
 * JD-Core Version:    0.7.0.1
 */