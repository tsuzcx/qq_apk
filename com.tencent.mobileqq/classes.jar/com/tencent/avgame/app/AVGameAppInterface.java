package com.tencent.avgame.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import antf;
import anui;
import bapg;
import besu;
import beuo;
import bevk;
import bigv;
import bkdi;
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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import lev;
import lew;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mwu;
import mwv;
import mww;
import mxl;
import mxn;
import mxs;
import mxt;
import mya;
import myk;
import mzz;
import new;
import nff;
import nfg;
import nfm;
import nhp;
import nib;

public class AVGameAppInterface
  extends AppInterface
  implements SDKInitListener, lew, nff
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -2147483648;
  private bevk jdField_a_of_type_Bevk;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private lev jdField_a_of_type_Lev;
  private mwv jdField_a_of_type_Mwv;
  private mxn jdField_a_of_type_Mxn;
  private new jdField_a_of_type_New;
  private nfg jdField_a_of_type_Nfg;
  
  public AVGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    ProcessMonitor.a().a();
    nhp.a().a("param_AVGameInit");
    nib.a().a("AVGameCostTrace");
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
    for (File localFile = new File(bigv.a(antf.ba));; localFile = localBaseApplication.getCacheDir())
    {
      URLDrawable.init(localBaseApplication, new mwu(this, localBaseApplication));
      localFile = new File(localFile, "diskcache");
      com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new besu(localFile);
      beyq.a = localFile;
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public mxl a(int paramInt)
  {
    mxl localmxl = null;
    if (this.jdField_a_of_type_Mxn != null) {
      localmxl = this.jdField_a_of_type_Mxn.a(this, paramInt);
    }
    return localmxl;
  }
  
  public new a()
  {
    return this.jdField_a_of_type_New;
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
    int j = lev.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onApnChanged, [" + i + "] --> [" + j + "], from[" + paramInt + "]");
    }
    if (i != j)
    {
      this.jdField_a_of_type_Int = j;
      mxt.a().a(mxs.class, 1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.jdField_a_of_type_Mwv != null) {
      this.jdField_a_of_type_Mwv.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  public void addObserver(anui paramanui)
  {
    mxt.a().a(paramanui);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    mxt.a().a(paramanui, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, reason[" + paramInt + "]");
    myk.a().a(2, null, myk.a().a());
    Intent localIntent = new Intent("tencent.avgame.g2q.exit");
    localIntent.putExtra("key_exit_code", paramInt);
    getApp().sendBroadcast(localIntent);
    QLog.flushLog(true);
    getApplication().otherProcessExit(false);
    if (this.jdField_a_of_type_New != null) {
      this.jdField_a_of_type_New.a();
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
  
  public List<anui> getBusinessObserver(int paramInt)
  {
    return mxt.a().a(paramInt);
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
    return new Class[] { mww.class, bkdi.class };
  }
  
  public beuo getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bevk == null) {
      this.jdField_a_of_type_Bevk = new bevk();
    }
    return this.jdField_a_of_type_Bevk.a(this, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameAppInterface_onCreate");
    nib.a().b("AppInterfaceCreate");
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onCreate");
    }
    AudioHelper.a(this.app, getLongAccountUin());
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Mwv = new mwv(this);
    this.jdField_a_of_type_Mxn = new mxn();
    a();
    this.jdField_a_of_type_New = new new(this);
    this.jdField_a_of_type_Nfg = new nfg(this);
    ThreadManager.excute(new AVGameAppInterface.1(this), 16, null, true);
    myk.a().a(this);
    b();
    mya.a().a(this);
    mzz.a().a();
    ThreadManager.excute(new AVGameAppInterface.2(this), 16, null, false);
    this.jdField_a_of_type_Lev = new lev(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Lev);
    if (!bapg.a()) {
      bapg.a(BaseApplicationImpl.getContext(), this);
    }
    nib.a().c("AppInterfaceCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_New != null) {
      this.jdField_a_of_type_New.a();
    }
    if (this.jdField_a_of_type_Nfg != null)
    {
      this.jdField_a_of_type_Nfg.b();
      this.jdField_a_of_type_Nfg = null;
    }
    mxt.a().a();
    myk.a().b();
    nfm.a();
    mya.a().f();
    mzz.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onDestroy");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("AVGameAppInterface", 1, "onSDKInited " + paramBoolean);
  }
  
  public void removeObserver(anui paramanui)
  {
    mxt.a().b(paramanui);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_Mwv != null) {
      this.jdField_a_of_type_Mwv.a(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */