package com.tencent.biz.videostory.network;

import android.content.Context;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tqg;
import xxf;
import yvm;
import yvn;
import yvs;

public class VSNetworkHelper
{
  private static volatile VSNetworkHelper jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper;
  private volatile yvm jdField_a_of_type_Yvm = new yvm();
  
  private VSNetworkHelper()
  {
    b();
    QCircleGlobalBroadcastHelper.a().a();
  }
  
  public static VSNetworkHelper a()
  {
    if (jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper == null) {
        jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper = new VSNetworkHelper();
      }
      return jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      return paramString.startsWith("_VSNetworkHelperCache");
    }
    return false;
  }
  
  private void b()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: registerObserver");
    BaseApplicationImpl.getApplication().getRuntime().registObserver(a());
  }
  
  public yvm a()
  {
    if (this.jdField_a_of_type_Yvm == null) {}
    try
    {
      if (this.jdField_a_of_type_Yvm == null) {
        this.jdField_a_of_type_Yvm = new yvm();
      }
      return this.jdField_a_of_type_Yvm;
    }
    finally {}
  }
  
  public void a()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(a());
    a().a();
    xxf.a();
    tqg.a();
    QCircleGlobalBroadcastHelper.a().b();
    jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper = null;
  }
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, yvn paramyvn)
  {
    if (paramVSBaseRequest == null) {
      return;
    }
    paramVSBaseRequest.setContextHashCode(paramInt);
    a().a(paramVSBaseRequest, paramyvn);
    paramyvn = new VSNetworkHelper.RequestIntent(this, BaseApplicationImpl.getApplication(), yvs.class);
    paramyvn.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramyvn);
    QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      a().a(paramContext);
    }
  }
  
  public void a(Context paramContext, VSBaseRequest paramVSBaseRequest, yvn paramyvn)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    a(localObject.hashCode(), paramVSBaseRequest, paramyvn);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, yvn paramyvn)
  {
    a(null, paramVSBaseRequest, paramyvn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */