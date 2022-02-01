package com.tencent.biz.pubaccount.readinjoy.pts.util;

import com.tencent.biz.pubaccount.readinjoy.pts.PTSEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSAllInOneJumpModule;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSHandleJSException;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSLoadFeedsModule;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSMarkArticleReadModule;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSNavigateToModule;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSReportTo1160Module;
import com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSRequestFeedsModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class PTSSwitchManager
{
  public static PTSSwitchManager a;
  private boolean a;
  private boolean b = false;
  private boolean c = false;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsUtilPTSSwitchManager = new PTSSwitchManager();
  }
  
  private PTSSwitchManager()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    d();
  }
  
  private void c()
  {
    d();
    PTSHelper.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new PTSRequestFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new PTSNavigateToModule());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new PTSAllInOneJumpModule());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new PTSLoadFeedsModule());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new PTSHandleJSException());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new PTSReportTo1160Module());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new PTSMarkArticleReadModule());
    PTSEngineLoader.a().a();
    PTSAppLoader.a().a();
  }
  
  private void d()
  {
    PTSHelper.c();
    PTSNativeModuleRegistry.clearNativeModule();
    PTSEventDispatcher.a().a();
  }
  
  void a()
  {
    b();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager
 * JD-Core Version:    0.7.0.1
 */