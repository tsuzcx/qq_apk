package com.tencent.mobileqq.app;

import alpd;
import alpg;
import alxd;
import alyc;
import ambz;
import ammn;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import awgg;
import awgn;
import awhq;
import axnn;
import axxr;
import axxs;
import ayyc;
import azbe;
import azjh;
import baue;
import bavd;
import bkzp;
import bkzt;
import bljn;
import blkf;
import blro;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;
import xnh;

public class PeakAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static blro a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new alyc(this);
  private awgg jdField_a_of_type_Awgg;
  private awgn jdField_a_of_type_Awgn;
  private axxs jdField_a_of_type_Axxs;
  private ayyc jdField_a_of_type_Ayyc;
  private bavd jdField_a_of_type_Bavd;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private String jdField_a_of_type_JavaLangString = "";
  private List<alpg> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private alpd[] jdField_a_of_type_ArrayOfAlpd = new alpd[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Blro = new blro();
  }
  
  public PeakAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private boolean a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.peak.q2v.AudioTransPush");
    this.app.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    return this.app.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  private boolean a(BaseApplication paramBaseApplication, Intent paramIntent)
  {
    paramBaseApplication = paramIntent.getAction();
    if (paramBaseApplication == null) {}
    do
    {
      return false;
      bljn.b("PeakAppInterface", "exitPeakRunTime");
    } while (!paramBaseApplication.equals("com.tencent.process.exit"));
    return blkf.a().a();
  }
  
  private alpd b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new axxr(this);
    case 1: 
      return new xnh(this);
    case 2: 
      return new alxd(this);
    case 3: 
      return new bkzt(this);
    }
    return new bkzp(this);
  }
  
  public alpd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAlpd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAlpd)
    {
      alpd localalpd = this.jdField_a_of_type_ArrayOfAlpd[paramInt];
      localObject1 = localalpd;
      if (localalpd == null)
      {
        localalpd = b(paramInt);
        localObject1 = localalpd;
        if (localalpd != null)
        {
          this.jdField_a_of_type_ArrayOfAlpd[paramInt] = localalpd;
          localObject1 = localalpd;
        }
      }
      return localObject1;
    }
  }
  
  public awgn a()
  {
    if (this.jdField_a_of_type_Awgn == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Awgn = new awgn(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Awgn;
  }
  
  public QQStoryContext a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  }
  
  public SQLiteDatabase a()
  {
    Object localObject = getCurrentAccountUin();
    localObject = ((QQEntityManagerFactory)getEntityManagerFactory((String)localObject)).build((String)localObject);
    if (localObject != null) {
      return ((ambz)localObject).b();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Ayyc.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Axxs.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(alpg paramalpg)
  {
    addObserver(paramalpg, false);
  }
  
  public void addObserver(alpg paramalpg, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramalpg)) {
      this.jdField_a_of_type_JavaUtilList.add(paramalpg);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new awhq((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((ambz)localObject).b();
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.c = bool1;
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<alpg> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public awgg getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Awgg == null) {
      this.jdField_a_of_type_Awgg = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Awgg;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject2 = (Manager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null) {
          localObject1 = (Manager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getManager(paramInt);
      }
      return localObject2;
      localObject2 = new ammn();
      break;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject2);
        localObject1 = localObject2;
      }
    }
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public baue getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bavd == null) {
      this.jdField_a_of_type_Bavd = new bavd();
    }
    return this.jdField_a_of_type_Bavd.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    bljn.b("PeakAppInterface", "onBeforeExitProc");
    blkf.a().b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onCreate");
    }
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    a();
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.b = a();
    this.jdField_a_of_type_Axxs = new axxs(this);
    this.jdField_a_of_type_Ayyc = new ayyc(this);
    jdField_a_of_type_Blro.a("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axnn.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAlpd)
      {
        alpd[] arrayOfalpd = this.jdField_a_of_type_ArrayOfAlpd;
        int j = arrayOfalpd.length;
        i = 0;
        if (i < j)
        {
          alpd localalpd = arrayOfalpd[i];
          if (localalpd == null) {
            break label168;
          }
          localalpd.onDestroy();
          break label168;
        }
        if (this.jdField_a_of_type_Bavd == null) {}
      }
      try
      {
        this.jdField_a_of_type_Bavd.onDestroy();
        this.jdField_a_of_type_Bavd = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          azjh.a(this).a(this);
        }
        jdField_a_of_type_Blro.a();
        if (QLog.isColorLevel()) {
          QLog.d("PeakAppInterface", 2, "onDestroy");
        }
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Bavd.onDestroy();
        }
      }
      label168:
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    bljn.b("PeakAppInterface", "onReceiveAccountAction");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    bljn.b("PeakAppInterface", "onReceiveAccountAction");
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public void onRunningBackground()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("PeakAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    LpReportManager.getInstance().startReportImediately(2);
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    ThreadManager.executeOnFileThread(new PeakAppInterface.2(this));
  }
  
  public void removeObserver(alpg paramalpg)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramalpg);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Ayyc.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Axxs.a(paramToServiceMsg, null, azbe.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */