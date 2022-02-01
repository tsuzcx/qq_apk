package com.tencent.biz.qcircleshadow.delegateimpl;

import android.app.Application;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.delegate.IConfigDelegate;
import com.tencent.biz.richframework.delegate.ILogDelegate;
import com.tencent.biz.richframework.delegate.IThreadManagerDelegate;
import com.tencent.biz.richframework.network.MobileQQVSNetworkImpl;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QCircleApplicationImpl
  implements IApplicationDelegate
{
  public String getAccountId()
  {
    return QCircleServiceImpl.getAccountApi().getAccount();
  }
  
  public Application getApplication()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public ConcurrentHashMap<Class, Class> getClassImplMap()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put(VSBaseNetwork.class, MobileQQVSNetworkImpl.class);
    localConcurrentHashMap.put(ILogDelegate.class, QCircleLogImpl.class);
    localConcurrentHashMap.put(IThreadManagerDelegate.class, QCircleThreadManagerImpl.class);
    localConcurrentHashMap.put(IConfigDelegate.class, QCircleConfigImpl.class);
    return localConcurrentHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleApplicationImpl
 * JD-Core Version:    0.7.0.1
 */