package com.tencent.biz.richframework.network;

import aaau;
import aaav;
import aaba;
import aaee;
import android.content.Context;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import uyn;

public class VSNetworkHelper
{
  private static final aaau jdField_a_of_type_Aaau = new aaau();
  private static final VSNetworkHelper jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper = new VSNetworkHelper();
  private static volatile String jdField_a_of_type_JavaLangString;
  
  public static aaau a()
  {
    return jdField_a_of_type_Aaau;
  }
  
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
        return jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper;
      }
      finally {}
      if (!a()) {
        continue;
      }
      try
      {
        if (a())
        {
          jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper.a();
          b();
        }
      }
      finally {}
    }
  }
  
  private static boolean a()
  {
    return (jdField_a_of_type_JavaLangString != null) && (!jdField_a_of_type_JavaLangString.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 100005;
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
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (!paramString.endsWith(".DataReport"));
  }
  
  public int a(int paramInt, VSBaseRequest paramVSBaseRequest, aaav paramaaav)
  {
    if (paramVSBaseRequest == null) {
      return 0;
    }
    paramVSBaseRequest.setContextHashCode(paramInt);
    a().a(paramVSBaseRequest, paramaaav);
    paramaaav = new VSNetworkHelper.RequestIntent(this, BaseApplicationImpl.getApplication(), aaba.class);
    paramaaav.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramaaav);
    if (b(paramVSBaseRequest.getCmdName())) {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVSBaseRequest.getCurrentSeq()) }));
    }
    return paramVSBaseRequest.getCurrentSeq();
  }
  
  public void a()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(a());
    a().a();
    aaee.a();
    uyn.a();
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
  
  public void a(Context paramContext, VSBaseRequest paramVSBaseRequest, aaav paramaaav)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    a(localObject.hashCode(), paramVSBaseRequest, paramaaav);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, aaav paramaaav)
  {
    a(null, paramVSBaseRequest, paramaaav);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */