package com.tencent.av.business.handler;

import android.os.Bundle;
import com.tencent.av.business.handler.receiver.BaseProtocolReceiver;
import com.tencent.av.business.handler.receiver.EffectMaterialReceiver;
import com.tencent.av.business.servlet.EffectMaterialService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EffectMaterialHandler
  extends BusinessHandler
{
  private EffectMaterialService jdField_a_of_type_ComTencentAvBusinessServletEffectMaterialService;
  private List<BaseProtocolReceiver<EffectMaterialHandler>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  protected EffectMaterialHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessServletEffectMaterialService = new EffectMaterialService(paramAppInterface);
    a();
  }
  
  public EffectMaterialService a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessServletEffectMaterialService;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilList.add(new EffectMaterialReceiver(this.appRuntime, this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestEffectMaterials service id ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.i("EffectMaterialHandler", 1, ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetworkAvailable())
    {
      QLog.i("EffectMaterialHandler", 1, "requestEffectMaterials no network");
      return;
    }
    localObject = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetCatMatTree");
    Bundle localBundle = ((ToServiceMsg)localObject).extraData;
    localBundle.putString("ServiceId", paramString1);
    localBundle.putString("GroupId", paramString2);
    this.jdField_a_of_type_ComTencentAvBusinessServletEffectMaterialService.a((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("ShadowBackendSvc.GetCatMatTree");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive cmd: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.i("EffectMaterialHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseProtocolReceiver localBaseProtocolReceiver = (BaseProtocolReceiver)((Iterator)localObject).next();
        if (localBaseProtocolReceiver.a(paramToServiceMsg.getServiceCmd())) {
          localBaseProtocolReceiver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      return;
    }
    QLog.e("EffectMaterialHandler", 1, "onReceive req == null || res == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.EffectMaterialHandler
 * JD-Core Version:    0.7.0.1
 */