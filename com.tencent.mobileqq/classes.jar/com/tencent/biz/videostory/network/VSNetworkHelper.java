package com.tencent.biz.videostory.network;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import vvt;
import wxw;
import wxx;
import wyc;

public class VSNetworkHelper
{
  private static volatile VSNetworkHelper jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper;
  private volatile wxw jdField_a_of_type_Wxw = new wxw();
  
  private VSNetworkHelper()
  {
    b();
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
  
  public wxw a()
  {
    if (this.jdField_a_of_type_Wxw == null) {}
    try
    {
      if (this.jdField_a_of_type_Wxw == null) {
        this.jdField_a_of_type_Wxw = new wxw();
      }
      return this.jdField_a_of_type_Wxw;
    }
    finally {}
  }
  
  public void a()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(a());
    a().a();
    vvt.a();
    jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper = null;
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, wxx paramwxx)
  {
    if (paramVSBaseRequest == null) {
      return;
    }
    a().a(paramVSBaseRequest, paramwxx);
    paramwxx = new VSNetworkHelper.RequestIntent(this, BaseApplicationImpl.getApplication(), wyc.class);
    paramwxx.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramwxx);
    QLog.i("VSNetworkHelper", 2, paramVSBaseRequest.getCmdName() + " sendRequest: success");
  }
  
  public void a(String paramString)
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: cancelRequest：" + paramString);
    a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */