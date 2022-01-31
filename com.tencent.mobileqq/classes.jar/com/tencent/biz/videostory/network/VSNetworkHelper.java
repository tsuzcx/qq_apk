package com.tencent.biz.videostory.network;

import android.content.Context;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tqg;
import ybo;
import zab;
import zac;
import zah;

public class VSNetworkHelper
{
  private static final VSNetworkHelper jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper = new VSNetworkHelper();
  private static volatile String jdField_a_of_type_JavaLangString;
  private static final zab jdField_a_of_type_Zab = new zab();
  
  public static VSNetworkHelper a()
  {
    if (jdField_a_of_type_JavaLangString == null) {}
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          b();
        }
        return jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper;
      }
      finally {}
      if (!a()) {
        continue;
      }
      try
      {
        if (a())
        {
          jdField_a_of_type_ComTencentBizVideostoryNetworkVSNetworkHelper.a();
          b();
        }
      }
      finally {}
    }
  }
  
  public static zab a()
  {
    return jdField_a_of_type_Zab;
  }
  
  private static boolean a()
  {
    return (jdField_a_of_type_JavaLangString != null) && (!jdField_a_of_type_JavaLangString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      return paramString.startsWith("_VSNetworkHelperCache");
    }
    return false;
  }
  
  private static void b()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: registerObserver");
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    BaseApplicationImpl.getApplication().getRuntime().registObserver(a());
    QCircleGlobalBroadcastHelper.a().a();
  }
  
  public int a(int paramInt, VSBaseRequest paramVSBaseRequest, zac paramzac)
  {
    if (paramVSBaseRequest == null) {
      return 0;
    }
    paramVSBaseRequest.setContextHashCode(paramInt);
    a().a(paramVSBaseRequest, paramzac);
    paramzac = new VSNetworkHelper.RequestIntent(this, BaseApplicationImpl.getApplication(), zah.class);
    paramzac.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramzac);
    QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVSBaseRequest.getCurrentSeq()) }));
    return paramVSBaseRequest.getCurrentSeq();
  }
  
  public void a()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(a());
    a().a();
    ybo.a();
    tqg.a();
    QCircleGlobalBroadcastHelper.a().b();
    jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      a().a(paramContext);
    }
  }
  
  public void a(Context paramContext, VSBaseRequest paramVSBaseRequest, zac paramzac)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    a(localObject.hashCode(), paramVSBaseRequest, paramzac);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, zac paramzac)
  {
    a(null, paramVSBaseRequest, paramzac);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */