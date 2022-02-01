package com.tencent.biz.qqcircle.datacenter;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.datacenter.convert.QCircleFeedConverter;
import com.tencent.biz.qqcircle.datacenter.convert.QFSUserFollowDataConverter;
import com.tencent.biz.qqcircle.datacenter.impl.QCircleLoadInfoCall;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.extendpb.FeedStateData;
import com.tencent.biz.qqcircle.immersive.bean.QFSRecentlyFeedStateData;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.BaseDataCenter;
import com.tencent.richframework.data.base.DataObserverWrapper;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleFeedDataCenter
  extends BaseDataCenter<FeedBlockData>
{
  private static volatile QCircleFeedDataCenter g;
  private final Map<String, MutableLiveData<FeedStateData>> h = new ConcurrentHashMap();
  private final MutableLiveData<QFSRecentlyFeedStateData> i = new MutableLiveData();
  private final Set<Integer> j = new HashSet();
  
  private QCircleFeedDataCenter()
  {
    this.a.put("QCircleSealRawDataStore", new QCircleSealRawFeedStore(this));
    this.a.put("QCircleFeedStore", new QCircleFeedStore(this));
    f();
    a(new QCircleFeedConverter());
    a(new QFSUserFollowDataConverter());
  }
  
  public static QCircleFeedDataCenter a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new QCircleFeedDataCenter();
        }
      }
      finally {}
    }
    return g;
  }
  
  private void f()
  {
    this.b.add(new QCircleSimpleEventFeedWorker(this));
  }
  
  public int a(String paramString, List<FeedBlockData> paramList)
  {
    int k = 0;
    while (k < paramList.size())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)paramList.get(k);
      if ((localFeedBlockData != null) && (localFeedBlockData.b() != null) && (TextUtils.equals(paramString, localFeedBlockData.b().id.get()))) {
        return k;
      }
      k += 1;
    }
    return -1;
  }
  
  public MutableLiveData<FeedStateData> a(String paramString)
  {
    MutableLiveData localMutableLiveData2 = (MutableLiveData)this.h.get(paramString);
    MutableLiveData localMutableLiveData1;
    if (localMutableLiveData2 != null)
    {
      localMutableLiveData1 = localMutableLiveData2;
      if (localMutableLiveData2.getValue() != null) {}
    }
    else
    {
      localMutableLiveData1 = new MutableLiveData();
      localMutableLiveData1.setValue(new FeedStateData(paramString));
      this.h.put(paramString, localMutableLiveData1);
    }
    return localMutableLiveData1;
  }
  
  public String a(FeedBlockData paramFeedBlockData)
  {
    if ((paramFeedBlockData != null) && (paramFeedBlockData.b() != null)) {
      return paramFeedBlockData.b().id.get();
    }
    return "";
  }
  
  public void a(Observer<QFSRecentlyFeedStateData> paramObserver)
  {
    if (!this.j.contains(Integer.valueOf(paramObserver.hashCode())))
    {
      this.j.add(Integer.valueOf(paramObserver.hashCode()));
      this.i.observeForever(new DataObserverWrapper(paramObserver));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    FeedStateData localFeedStateData = (FeedStateData)paramString.getValue();
    localFeedStateData.a(paramInt);
    paramString.postValue(localFeedStateData);
  }
  
  public void a(String paramString, Observer<? super FeedStateData> paramObserver)
  {
    paramString = a(paramString);
    if (!paramObserver.getClass().isAnonymousClass())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("observe feedStateData :");
      localStringBuilder.append(paramObserver.getClass().getName());
      QLog.i("QCircleFeedDataCenter", 1, localStringBuilder.toString());
      paramString.observeForever(paramObserver);
      return;
    }
    if (HostAppSettingUtil.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("observe feedStateData error not support anonymousClass :");
      paramString.append(paramObserver.getClass().getName());
      QLog.e("QCircleFeedDataCenter", 1, paramString.toString());
      QCircleToast.a(2131892175, 1);
    }
  }
  
  public int b(String paramString)
  {
    return ((FeedStateData)a(paramString).getValue()).a();
  }
  
  public QCircleLoadInfoCall b()
  {
    return new QCircleLoadInfoCall();
  }
  
  public MutableLiveData<QFSRecentlyFeedStateData> c()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter
 * JD-Core Version:    0.7.0.1
 */