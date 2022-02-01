package com.tencent.avgame.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import anhk;
import anil;
import azwq;
import bdua;
import bdvu;
import bdwr;
import bhgg;
import bjcj;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import leo;
import lep;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mvv;
import mvw;
import mvx;
import mwm;
import mwo;
import mwt;
import mwu;
import mxb;
import mxl;
import myw;
import ndd;
import ndm;
import ndn;
import ndt;
import nfu;
import ngg;

public class AVGameAppInterface
  extends AppInterface
  implements SDKInitListener, lep, ndm
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -2147483648;
  private bdwr jdField_a_of_type_Bdwr;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private leo jdField_a_of_type_Leo;
  private mvw jdField_a_of_type_Mvw;
  private mwo jdField_a_of_type_Mwo;
  private ndd jdField_a_of_type_Ndd;
  private ndn jdField_a_of_type_Ndn;
  
  public AVGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    ProcessMonitor.a().a();
    nfu.a().a("param_AVGameInit");
    ngg.a().a("AVGameCostTrace");
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "init av game app interface [" + paramString + "]");
    }
  }
  
  private void b()
  {
    BaseApplication localBaseApplication;
    if (!jdField_a_of_type_Boolean)
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        break label79;
      }
    }
    label79:
    for (File localFile = new File(bhgg.a(anhk.ba));; localFile = localBaseApplication.getCacheDir())
    {
      URLDrawable.init(localBaseApplication, new mvv(this, localBaseApplication));
      localFile = new File(localFile, "diskcache");
      com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new bdua(localFile);
      bdzx.a = localFile;
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public mwm a(int paramInt)
  {
    mwm localmwm = null;
    if (this.jdField_a_of_type_Mwo != null) {
      localmwm = this.jdField_a_of_type_Mwo.a(this, paramInt);
    }
    return localmwm;
  }
  
  public ndd a()
  {
    return this.jdField_a_of_type_Ndd;
  }
  
  public void a()
  {
    if (BaseApplicationImpl.sImageCache == null)
    {
      long l = MemoryManager.a() / 10L;
      BaseApplicationImpl.sImageCache = new MQLruCache((int)l);
      BaseApplicationImpl.sImageCacheSize = (int)l;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    int j = leo.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onApnChanged, [" + i + "] --> [" + j + "], from[" + paramInt + "]");
    }
    if (i != j)
    {
      this.jdField_a_of_type_Int = j;
      mwu.a().a(mwt.class, 1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  public void addObserver(anil paramanil)
  {
    mwu.a().a(paramanil);
  }
  
  public void addObserver(anil paramanil, boolean paramBoolean)
  {
    mwu.a().a(paramanil, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, reason[" + paramInt + "]");
    mxl.a().a(2, null, mxl.a().a());
    Intent localIntent = new Intent("tencent.avgame.g2q.exit");
    localIntent.putExtra("key_exit_code", paramInt);
    getApp().sendBroadcast(localIntent);
    QLog.flushLog(true);
    getApplication().otherProcessExit(false);
    if (this.jdField_a_of_type_Ndd != null) {
      this.jdField_a_of_type_Ndd.a();
    }
    ProcessMonitor.a().b();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, cost[" + (SystemClock.elapsedRealtime() - l) + "]");
    try
    {
      Thread.sleep(300L);
      label153:
      if (paramInt == 1006) {
        System.exit(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label153;
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<anil> getBusinessObserver(int paramInt)
  {
    return mwu.a().a(paramInt);
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { mvx.class, bjcj.class };
  }
  
  public bdvu getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bdwr == null) {
      this.jdField_a_of_type_Bdwr = new bdwr();
    }
    return this.jdField_a_of_type_Bdwr.a(this, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameAppInterface_onCreate");
    ngg.a().b("AppInterfaceCreate");
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onCreate");
    }
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Mvw = new mvw(this);
    this.jdField_a_of_type_Mwo = new mwo();
    a();
    this.jdField_a_of_type_Ndd = new ndd(this);
    this.jdField_a_of_type_Ndn = new ndn(this);
    ThreadManager.excute(new AVGameAppInterface.1(this), 16, null, true);
    mxl.a().a(this);
    b();
    mxb.a().a(this);
    myw.a().a();
    ThreadManager.excute(new AVGameAppInterface.2(this), 16, null, false);
    this.jdField_a_of_type_Leo = new leo(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Leo);
    if (!azwq.a()) {
      azwq.a(BaseApplicationImpl.getContext(), this);
    }
    ngg.a().c("AppInterfaceCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ndd != null) {
      this.jdField_a_of_type_Ndd.a();
    }
    if (this.jdField_a_of_type_Ndn != null)
    {
      this.jdField_a_of_type_Ndn.b();
      this.jdField_a_of_type_Ndn = null;
    }
    mwu.a().a();
    mxl.a().b();
    ndt.a();
    mxb.a().f();
    myw.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onDestroy");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("AVGameAppInterface", 1, "onSDKInited " + paramBoolean);
  }
  
  public void removeObserver(anil paramanil)
  {
    mwu.a().b(paramanil);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_Mvw != null) {
      this.jdField_a_of_type_Mvw.a(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */