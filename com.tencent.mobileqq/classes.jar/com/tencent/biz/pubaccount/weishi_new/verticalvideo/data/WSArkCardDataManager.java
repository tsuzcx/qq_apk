package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stFeedStatus;
import UserGrowth.stGetPersonalFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.PersonalFeedListRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSArkCardDataManager
{
  private volatile String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
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
        if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
          localArrayList.add(localWSVerticalItemData.a().id);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, IVerticalRspListener paramIVerticalRspListener)
  {
    if ((paramIVerticalRspListener instanceof AbsWSVerticalPagePresenter))
    {
      paramIVerticalRspListener = ((AbsWSVerticalPagePresenter)paramIVerticalRspListener).a();
      if (!(paramIVerticalRspListener instanceof WSVerticalPageFragment)) {
        break label62;
      }
    }
    label62:
    for (paramIVerticalRspListener = (WSVerticalPageFragment)paramIVerticalRspListener;; paramIVerticalRspListener = null)
    {
      if ((paramIVerticalRspListener != null) && (paramIVerticalRspListener.getActivity() != null) && (!paramIVerticalRspListener.getActivity().isFinishing())) {
        WSGlobalConfig.a().a(10007, paramstGetPersonalFeedListRsp.config);
      }
      return;
    }
  }
  
  private void a(stGetPersonalFeedListRsp paramstGetPersonalFeedListRsp, WSArkCardDataManager.ExtParams paramExtParams)
  {
    if (paramstGetPersonalFeedListRsp.contextFeedStatus != null)
    {
      paramExtParams.jdField_a_of_type_JavaLangString = paramstGetPersonalFeedListRsp.contextFeedStatus.feedId;
      paramExtParams.b = paramstGetPersonalFeedListRsp.contextFeedStatus.msg;
      WSLog.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][setExtParams] extParams:" + paramExtParams);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, IVerticalRspListener paramIVerticalRspListener, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WSLog.e("WSArkCardDataManagerLog", "[WSArkCardDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramObject = a(paramList);
    WSArkCardDataManager.1 local1 = new WSArkCardDataManager.1(this, System.currentTimeMillis(), paramBoolean2, paramIVerticalRspListener, paramBoolean1);
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_Boolean = false;
    }
    paramIVerticalRspListener = "";
    paramList = paramIVerticalRspListener;
    if (paramObject != null)
    {
      paramList = paramIVerticalRspListener;
      if (paramObject.size() > 0) {
        paramList = (String)paramObject.get(0);
      }
    }
    WSLog.d("WSArkCardDataManagerLog", "[WSArkCardDataManager.java] PersonalFeedListRequest isFirst = " + paramBoolean2 + " feedId = " + paramList + " attachInfo = " + this.jdField_a_of_type_JavaLangString);
    paramString = new WeishiTask(new PersonalFeedListRequest(paramString, this.jdField_a_of_type_JavaLangString, paramBoolean2, paramObject, paramInt), null, local1, 4013);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSArkCardDataManager
 * JD-Core Version:    0.7.0.1
 */