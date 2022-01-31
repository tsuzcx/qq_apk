package com.tencent.mobileqq.app;

import alko;
import alkr;
import also;
import altn;
import alxk;
import amhy;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import awbx;
import awce;
import awdh;
import axje;
import axti;
import axtj;
import aytt;
import aywv;
import azey;
import bapv;
import baqu;
import bkvi;
import bkvm;
import blfg;
import blfy;
import blnc;
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
import xiy;

public class PeakAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static blnc a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new altn(this);
  private awbx jdField_a_of_type_Awbx;
  private awce jdField_a_of_type_Awce;
  private axtj jdField_a_of_type_Axtj;
  private aytt jdField_a_of_type_Aytt;
  private baqu jdField_a_of_type_Baqu;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private String jdField_a_of_type_JavaLangString = "";
  private List<alkr> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private alko[] jdField_a_of_type_ArrayOfAlko = new alko[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Blnc = new blnc();
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
      blfg.b("PeakAppInterface", "exitPeakRunTime");
    } while (!paramBaseApplication.equals("com.tencent.process.exit"));
    return blfy.a().a();
  }
  
  private alko b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new axti(this);
    case 1: 
      return new xiy(this);
    case 2: 
      return new also(this);
    case 3: 
      return new bkvm(this);
    }
    return new bkvi(this);
  }
  
  public alko a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAlko[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAlko)
    {
      alko localalko = this.jdField_a_of_type_ArrayOfAlko[paramInt];
      localObject1 = localalko;
      if (localalko == null)
      {
        localalko = b(paramInt);
        localObject1 = localalko;
        if (localalko != null)
        {
          this.jdField_a_of_type_ArrayOfAlko[paramInt] = localalko;
          localObject1 = localalko;
        }
      }
      return localObject1;
    }
  }
  
  public awce a()
  {
    if (this.jdField_a_of_type_Awce == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Awce = new awce(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Awce;
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
      return ((alxk)localObject).b();
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
      this.jdField_a_of_type_Aytt.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Axtj.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(alkr paramalkr)
  {
    addObserver(paramalkr, false);
  }
  
  public void addObserver(alkr paramalkr, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramalkr)) {
      this.jdField_a_of_type_JavaUtilList.add(paramalkr);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new awdh((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((alxk)localObject).b();
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
  
  public List<alkr> getBusinessObserver(int paramInt)
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
  
  public awbx getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Awbx == null) {
      this.jdField_a_of_type_Awbx = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Awbx;
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
      localObject2 = new amhy();
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
  
  public bapv getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Baqu == null) {
      this.jdField_a_of_type_Baqu = new baqu();
    }
    return this.jdField_a_of_type_Baqu.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    blfg.b("PeakAppInterface", "onBeforeExitProc");
    blfy.a().b();
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
    this.jdField_a_of_type_Axtj = new axtj(this);
    this.jdField_a_of_type_Aytt = new aytt(this);
    jdField_a_of_type_Blnc.a("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axje.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAlko)
      {
        alko[] arrayOfalko = this.jdField_a_of_type_ArrayOfAlko;
        int j = arrayOfalko.length;
        i = 0;
        if (i < j)
        {
          alko localalko = arrayOfalko[i];
          if (localalko == null) {
            break label168;
          }
          localalko.onDestroy();
          break label168;
        }
        if (this.jdField_a_of_type_Baqu == null) {}
      }
      try
      {
        this.jdField_a_of_type_Baqu.onDestroy();
        this.jdField_a_of_type_Baqu = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          azey.a(this).a(this);
        }
        jdField_a_of_type_Blnc.a();
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
          this.jdField_a_of_type_Baqu.onDestroy();
        }
      }
      label168:
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    blfg.b("PeakAppInterface", "onReceiveAccountAction");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    blfg.b("PeakAppInterface", "onReceiveAccountAction");
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
  
  public void removeObserver(alkr paramalkr)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramalkr);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Aytt.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Axtj.a(paramToServiceMsg, null, aywv.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */