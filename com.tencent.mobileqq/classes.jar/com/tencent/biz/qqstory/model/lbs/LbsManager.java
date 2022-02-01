package com.tencent.biz.qqstory.model.lbs;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class LbsManager
  implements IManager
{
  public static BasicLocation a;
  protected boolean b;
  protected BasicLocation c;
  private boolean d = false;
  private List<LbsManager.LbsUpdateListener> e = new CopyOnWriteArrayList();
  private Object f = new Object();
  
  public static BasicLocation c()
  {
    return a;
  }
  
  public void a()
  {
    SLog.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    e();
    new Handler().postDelayed(new LbsManager.2(this, paramInt), paramInt);
  }
  
  public void a(@NonNull BasicLocation paramBasicLocation, LbsManager.POIListRequestSession paramPOIListRequestSession, LbsManager.POIListRequestCallback paramPOIListRequestCallback)
  {
    SLog.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramBasicLocation.a), Integer.valueOf(paramBasicLocation.b), Integer.valueOf(paramBasicLocation.c), paramPOIListRequestSession);
    WeakReference localWeakReference = new WeakReference(paramPOIListRequestCallback);
    if (paramPOIListRequestSession == null)
    {
      paramPOIListRequestCallback = LbsManager.POIListRequestSession.b();
    }
    else
    {
      paramPOIListRequestCallback = paramPOIListRequestSession;
      if (!TextUtils.isEmpty(paramPOIListRequestSession.d))
      {
        paramPOIListRequestSession.c = false;
        paramPOIListRequestCallback = paramPOIListRequestSession;
      }
    }
    SLog.b("LbsManager", "requestPoiList");
    paramPOIListRequestSession = StoryApi.a("StorySvc.get_poi_list");
    qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
    if (!TextUtils.isEmpty(paramPOIListRequestCallback.d)) {
      localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.d));
    }
    localReqGetPOIList.coordinate.set(paramBasicLocation.c);
    localReqGetPOIList.count.set(paramPOIListRequestCallback.a);
    if (!TextUtils.isEmpty(paramPOIListRequestCallback.e)) {
      localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.e));
    }
    localReqGetPOIList.gps.lat.set(paramBasicLocation.a);
    localReqGetPOIList.gps.lng.set(paramBasicLocation.b);
    localReqGetPOIList.gps.setHasFlag(true);
    paramBasicLocation = new Bundle();
    CmdTaskManger.a().a(new CommonRequest(paramPOIListRequestSession, localReqGetPOIList, paramBasicLocation), new LbsManager.3(this, localWeakReference, paramPOIListRequestCallback));
  }
  
  public void a(@NonNull LbsManager.LbsUpdateListener paramLbsUpdateListener)
  {
    if (!this.e.contains(paramLbsUpdateListener))
    {
      SLog.a("LbsManager", "registerLbsListener:%s", paramLbsUpdateListener.getClass().getName());
      this.e.add(paramLbsUpdateListener);
    }
  }
  
  protected void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((LbsManager.LbsUpdateListener)localIterator.next()).a(paramBoolean, paramBasicLocation);
    }
  }
  
  public void b()
  {
    SLog.b("LbsManager", "onDestroy");
    this.e.clear();
  }
  
  public void b(@NonNull LbsManager.LbsUpdateListener paramLbsUpdateListener)
  {
    if (this.e.contains(paramLbsUpdateListener))
    {
      SLog.a("LbsManager", "unregisterLbsListener:%s", paramLbsUpdateListener.getClass().getName());
      this.e.remove(paramLbsUpdateListener);
    }
  }
  
  public BasicLocation d()
  {
    return this.c;
  }
  
  public void e()
  {
    this.d = false;
    if (this.b)
    {
      SLog.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.f)
    {
      if (this.b)
      {
        SLog.d("LbsManager", "is locating..... return directly.");
        return;
      }
      SLog.b("LbsManager", "requestLbs...");
      this.b = true;
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new LbsManager.1(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager
 * JD-Core Version:    0.7.0.1
 */