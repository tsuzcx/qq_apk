package com.tencent.avgame.qav;

import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class AVGameVideoPreLoadMgr
  implements ISPlayerPreDownloader.Listener
{
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private final ConcurrentHashMap<Integer, AVGameVideoPreLoadMgr.PreLoadInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public void a()
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "destroy");
    b();
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null)
    {
      localISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("stopPreLoad url:=");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("AVGameVideoPreLoadMgr", 1, ((StringBuilder)localObject1).toString());
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      return;
    }
    Object localObject2 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (AVGameVideoPreLoadMgr.PreLoadInfo)((Map.Entry)localIterator.next()).getValue();
    } while (!((AVGameVideoPreLoadMgr.PreLoadInfo)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString));
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopPreDownload(((AVGameVideoPreLoadMgr.PreLoadInfo)localObject1).jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(((AVGameVideoPreLoadMgr.PreLoadInfo)localObject1).jdField_a_of_type_Int));
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preLoadUrl url:=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AVGameVideoPreLoadMgr", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(MobileQQ.sMobileQQ.getApplicationContext(), 107);
    }
    localObject = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, MD5Utils.toMD5(paramString));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.setOnPreDownloadListener(this);
    int i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)localObject, paramLong1, paramLong2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), new AVGameVideoPreLoadMgr.PreLoadInfo(i, paramString));
  }
  
  public void b()
  {
    QLog.d("AVGameVideoPreLoadMgr", 1, "cancelALLPreDoload");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopPreDownload(i);
    }
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {}
  
  public void onPrepareError(int paramInt)
  {
    Object localObject = (AVGameVideoPreLoadMgr.PreLoadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepareSuccess content:=");
    if (localObject != null) {
      localObject = ((AVGameVideoPreLoadMgr.PreLoadInfo)localObject).toString();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    QLog.d("AVGameVideoPreLoadMgr", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    Object localObject = (AVGameVideoPreLoadMgr.PreLoadInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepareSuccess content:=");
    if (localObject != null) {
      localObject = ((AVGameVideoPreLoadMgr.PreLoadInfo)localObject).toString();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    QLog.d("AVGameVideoPreLoadMgr", 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameVideoPreLoadMgr
 * JD-Core Version:    0.7.0.1
 */