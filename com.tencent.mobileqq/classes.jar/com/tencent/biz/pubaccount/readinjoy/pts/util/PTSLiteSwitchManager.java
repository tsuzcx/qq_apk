package com.tencent.biz.pubaccount.readinjoy.pts.util;

import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSSoLoader;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PTSLiteSwitchManager
{
  private static volatile PTSLiteSwitchManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSLiteSwitchManager;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  public static PTSLiteSwitchManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSLiteSwitchManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSLiteSwitchManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSLiteSwitchManager = new PTSLiteSwitchManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSLiteSwitchManager;
    }
    finally {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
    PTSHelper.c();
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean d()
  {
    return this.b;
  }
  
  void a()
  {
    b();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return (d()) && (PTSSoLoader.a().a());
  }
  
  @Deprecated
  public boolean b()
  {
    return (c()) && (PTSSoLoader.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSLiteSwitchManager
 * JD-Core Version:    0.7.0.1
 */