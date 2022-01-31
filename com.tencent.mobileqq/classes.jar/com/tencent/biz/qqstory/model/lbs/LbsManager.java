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
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import ndw;
import ndx;
import ndy;

public class LbsManager
  implements IManager
{
  public static BasicLocation a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public boolean a;
  public BasicLocation b;
  private boolean b;
  
  public static BasicLocation a()
  {
    return jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
  }
  
  public void a()
  {
    SLog.b("LbsManager", "onInit");
  }
  
  public void a(int paramInt)
  {
    c();
    new Handler().postDelayed(new ndx(this, paramInt), paramInt);
  }
  
  public void a(@NonNull BasicLocation paramBasicLocation, LbsManager.POIListRequestSession paramPOIListRequestSession, LbsManager.POIListRequestCallback paramPOIListRequestCallback)
  {
    SLog.a("LbsManager", "requestPOIList([lat]%d, [lng]%d, [mars]%d, %s)", Integer.valueOf(paramBasicLocation.jdField_a_of_type_Int), Integer.valueOf(paramBasicLocation.b), Integer.valueOf(paramBasicLocation.c), paramPOIListRequestSession);
    WeakReference localWeakReference = new WeakReference(paramPOIListRequestCallback);
    if (paramPOIListRequestSession == null) {
      paramPOIListRequestCallback = LbsManager.POIListRequestSession.a();
    }
    for (;;)
    {
      SLog.b("LbsManager", "requestPoiList");
      paramPOIListRequestSession = StoryApi.a("StorySvc.get_poi_list");
      qqstory_service.ReqGetPOIList localReqGetPOIList = new qqstory_service.ReqGetPOIList();
      if (!TextUtils.isEmpty(paramPOIListRequestCallback.jdField_a_of_type_JavaLangString)) {
        localReqGetPOIList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.jdField_a_of_type_JavaLangString));
      }
      localReqGetPOIList.coordinate.set(paramBasicLocation.c);
      localReqGetPOIList.count.set(paramPOIListRequestCallback.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramPOIListRequestCallback.jdField_b_of_type_JavaLangString)) {
        localReqGetPOIList.keyword.set(ByteStringMicro.copyFromUtf8(paramPOIListRequestCallback.jdField_b_of_type_JavaLangString));
      }
      localReqGetPOIList.gps.lat.set(paramBasicLocation.jdField_a_of_type_Int);
      localReqGetPOIList.gps.lng.set(paramBasicLocation.b);
      localReqGetPOIList.gps.setHasFlag(true);
      paramBasicLocation = new Bundle();
      CmdTaskManger.a().a(new CommonRequest(paramPOIListRequestSession, localReqGetPOIList, paramBasicLocation), new ndy(this, localWeakReference, paramPOIListRequestCallback));
      return;
      paramPOIListRequestCallback = paramPOIListRequestSession;
      if (!TextUtils.isEmpty(paramPOIListRequestSession.jdField_a_of_type_JavaLangString))
      {
        paramPOIListRequestSession.jdField_b_of_type_Boolean = false;
        paramPOIListRequestCallback = paramPOIListRequestSession;
      }
    }
  }
  
  public void a(@NonNull LbsManager.LbsUpdateListener paramLbsUpdateListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramLbsUpdateListener))
    {
      SLog.a("LbsManager", "registerLbsListener:%s", paramLbsUpdateListener.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.add(paramLbsUpdateListener);
    }
  }
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((LbsManager.LbsUpdateListener)localIterator.next()).a(paramBoolean, paramBasicLocation);
    }
  }
  
  public BasicLocation b()
  {
    return this.jdField_b_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
  }
  
  public void b()
  {
    SLog.b("LbsManager", "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void b(@NonNull LbsManager.LbsUpdateListener paramLbsUpdateListener)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramLbsUpdateListener))
    {
      SLog.a("LbsManager", "unregisterLbsListener:%s", paramLbsUpdateListener.getClass().getName());
      this.jdField_a_of_type_JavaUtilList.remove(paramLbsUpdateListener);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.d("LbsManager", "is locating..... return directly.");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        SLog.d("LbsManager", "is locating..... return directly.");
        return;
      }
    }
    SLog.b("LbsManager", "requestLbs...");
    this.jdField_a_of_type_Boolean = true;
    SosoInterface.a(new ndw(this, 0, true, false, 60000L, false, false, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager
 * JD-Core Version:    0.7.0.1
 */