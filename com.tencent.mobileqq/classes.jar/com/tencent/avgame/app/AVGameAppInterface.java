package com.tencent.avgame.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import bapt;
import bjtv;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import leu;
import lev;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import ncw;
import ncx;
import ncy;
import ndi;
import ndk;
import ndp;
import ndq;
import ndx;
import nfc;
import ngq;
import nmv;
import nne;
import nnf;
import nnm;
import nqc;
import nqo;

public class AVGameAppInterface
  extends AppInterface
  implements SDKInitListener, lev, nne
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = -2147483648;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private leu jdField_a_of_type_Leu;
  private ncx jdField_a_of_type_Ncx;
  private ndk jdField_a_of_type_Ndk;
  private nmv jdField_a_of_type_Nmv;
  private nnf jdField_a_of_type_Nnf;
  
  public AVGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    ProcessMonitor.a().a();
    nqc.a().a("param_AVGameInit");
    nqo.a().a("AVGameCostTrace");
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
    for (File localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));; localFile = localBaseApplication.getCacheDir())
    {
      URLDrawable.init(localBaseApplication, new ncw(this, localBaseApplication));
      localFile = new File(localFile, "diskcache");
      com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new DiskCache(localFile);
      com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = localFile;
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public ndi a(int paramInt)
  {
    ndi localndi = null;
    if (this.jdField_a_of_type_Ndk != null) {
      localndi = this.jdField_a_of_type_Ndk.a(this, paramInt);
    }
    return localndi;
  }
  
  public nmv a()
  {
    return this.jdField_a_of_type_Nmv;
  }
  
  public void a()
  {
    if (BaseApplicationImpl.sImageCache == null)
    {
      long l = MemoryManager.getAvailClassSize() / 10L;
      BaseApplicationImpl.sImageCache = new MQLruCache((int)l);
      BaseApplicationImpl.sImageCacheSize = (int)l;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    int j = leu.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onApnChanged, [" + i + "] --> [" + j + "], from[" + paramInt + "]");
    }
    if (i != j)
    {
      this.jdField_a_of_type_Int = j;
      ndq.a().a(ndp.class, 1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (this.jdField_a_of_type_Ncx != null) {
      this.jdField_a_of_type_Ncx.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    ndq.a().a(paramBusinessObserver);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ndq.a().a(paramBusinessObserver, paramBoolean);
  }
  
  public void b(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, reason[" + paramInt + "]");
    nfc.a().a(2, null, nfc.a().a());
    Intent localIntent = new Intent("tencent.avgame.g2q.exit");
    localIntent.putExtra("key_exit_code", paramInt);
    getApp().sendBroadcast(localIntent);
    QLog.flushLog(true);
    getApplication().otherProcessExit(false);
    if (this.jdField_a_of_type_Nmv != null) {
      this.jdField_a_of_type_Nmv.a();
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
  
  public List<BusinessObserver> getBusinessObserver(int paramInt)
  {
    return ndq.a().a(paramInt);
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
    return new Class[] { ncy.class, bjtv.class };
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.getEngineInstance(this, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameAppInterface_onCreate");
    nqo.a().b("AppInterfaceCreate");
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onCreate");
    }
    AudioHelper.a(this.app, getLongAccountUin());
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Ncx = new ncx(this);
    this.jdField_a_of_type_Ndk = new ndk();
    a();
    this.jdField_a_of_type_Nmv = new nmv(this);
    this.jdField_a_of_type_Nnf = new nnf(this);
    ThreadManager.excute(new AVGameAppInterface.1(this), 16, null, true);
    nfc.a().a(this);
    b();
    ndx.a().a(this);
    ngq.a().a();
    ThreadManager.excute(new AVGameAppInterface.2(this), 16, null, false);
    this.jdField_a_of_type_Leu = new leu(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Leu);
    if (!bapt.a()) {
      bapt.a(BaseApplicationImpl.getContext(), this);
    }
    nqo.a().c("AppInterfaceCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Nmv != null) {
      this.jdField_a_of_type_Nmv.a();
    }
    if (this.jdField_a_of_type_Nnf != null)
    {
      this.jdField_a_of_type_Nnf.b();
      this.jdField_a_of_type_Nnf = null;
    }
    ndq.a().a();
    nfc.a().b();
    nnm.a();
    ndx.a().f();
    ngq.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onDestroy");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("AVGameAppInterface", 1, "onSDKInited " + paramBoolean);
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    ndq.a().b(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_Ncx != null) {
      this.jdField_a_of_type_Ncx.a(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */