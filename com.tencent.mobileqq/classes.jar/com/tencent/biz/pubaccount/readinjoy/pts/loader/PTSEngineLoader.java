package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class PTSEngineLoader
{
  private static volatile PTSEngineLoader jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSEngineLoader;
  private static String jdField_a_of_type_JavaLangString;
  public final boolean a;
  private final String jdField_b_of_type_JavaLangString = OfflineEnvHelper.a("3980") + "3980";
  private volatile boolean jdField_b_of_type_Boolean = false;
  private final String c = BaseApplicationImpl.getApplication().getFilesDir().getParent() + "/txlib/" + "readinjoy_pts_engine";
  
  private PTSEngineLoader()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static PTSEngineLoader a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSEngineLoader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSEngineLoader == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSEngineLoader = new PTSEngineLoader();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSEngineLoader;
    }
    finally {}
  }
  
  private boolean b()
  {
    Object localObject = this.c + "/" + "libpts.so";
    String str = this.c + "/" + "pts_config.json";
    boolean bool1 = FileUtils.a((String)localObject);
    boolean bool2 = PTSOfflineUtil.a(str);
    jdField_a_of_type_JavaLangString = PTSOfflineUtil.b(str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[checkInnerPTSEngineIsValid]").append("\n").append(", ptsEngineVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isSoExists = ").append(bool1).append("\n").append(", isVersionSupport = ").append(bool2).append("\n");
    QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
    return (bool1) && (bool2);
  }
  
  private void c()
  {
    ThreadManager.excute(new PTSEngineLoader.3(this), 128, null, true);
  }
  
  private boolean c()
  {
    return false;
  }
  
  private void d()
  {
    ThreadManager.excute(new PTSEngineLoader.4(this), 64, null, false);
  }
  
  private void e()
  {
    if (c()) {
      return;
    }
    if (a())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts engine is ready, do not load again.");
      return;
    }
    if (b())
    {
      PTSEngineLoader.5 local5 = new PTSEngineLoader.5(this);
      PTSJSCLoader.a().a(local5);
      return;
    }
    QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], inner dir is not valid, load pts engine failed.");
    d();
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    PTSEngineLoader.1 local1 = new PTSEngineLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_Boolean = false;
      PTSEngineLoader.2 local2 = new PTSEngineLoader.2(this);
      ThreadManager.getFileThreadHandler().post(local2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSEngineLoader
 * JD-Core Version:    0.7.0.1
 */