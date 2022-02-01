package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import anud;
import anui;
import aocp;
import aodg;
import aouq;
import aznw;
import azoq;
import bbeh;
import bbol;
import bbom;
import bcpx;
import bcuv;
import bdcy;
import beuo;
import bevk;
import boqe;
import boqi;
import bpam;
import bpbr;
import bpmn;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
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
import zkn;

public class PeakAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static bpmn a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aodg(this);
  private aznw jdField_a_of_type_Aznw;
  private bbom jdField_a_of_type_Bbom;
  private bcpx jdField_a_of_type_Bcpx;
  private bevk jdField_a_of_type_Bevk;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private List<anui> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private anud[] jdField_a_of_type_ArrayOfAnud = new anud[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Bpmn = new bpmn();
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
    bpam.d("PeakAppInterface", "exitPeakRunTime");
    paramBaseApplication = paramIntent.getAction();
    if (paramBaseApplication == null) {}
    while (!paramBaseApplication.equals("com.tencent.process.exit")) {
      return false;
    }
    boolean bool = bpbr.a().a();
    bpam.d("PeakAppInterface", "isGenerateWorking" + bool);
    return bool;
  }
  
  private anud b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new bbol(this);
    case 1: 
      return new zkn(this);
    case 2: 
      return new aocp(this);
    case 3: 
      return new boqi(this);
    }
    return new boqe(this);
  }
  
  public anud a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAnud[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAnud)
    {
      anud localanud = this.jdField_a_of_type_ArrayOfAnud[paramInt];
      localObject1 = localanud;
      if (localanud == null)
      {
        localanud = b(paramInt);
        localObject1 = localanud;
        if (localanud != null)
        {
          this.jdField_a_of_type_ArrayOfAnud[paramInt] = localanud;
          localObject1 = localanud;
        }
      }
      return localObject1;
    }
  }
  
  public aznw a()
  {
    if (this.jdField_a_of_type_Aznw == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Aznw = new aznw(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Aznw;
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
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
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
      this.jdField_a_of_type_Bcpx.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Bbom.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(anui paramanui)
  {
    addObserver(paramanui, false);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramanui)) {
      this.jdField_a_of_type_JavaUtilList.add(paramanui);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new azoq((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
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
  
  public List<anui> getBusinessObserver(int paramInt)
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
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
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
      localObject2 = new aouq();
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
  
  public beuo getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bevk == null) {
      this.jdField_a_of_type_Bevk = new bevk();
    }
    return this.jdField_a_of_type_Bevk.a(this, paramInt);
  }
  
  public void onBeforeExitProc()
  {
    bpam.d("PeakAppInterface", "onBeforeExitProc");
    bpbr.a().b();
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
    this.jdField_a_of_type_Bbom = new bbom(this);
    this.jdField_a_of_type_Bcpx = new bcpx(this);
    jdField_a_of_type_Bpmn.a("{1000,1002}");
    DtSdkInitStep.initDTSDK(0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bbeh.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAnud)
      {
        anud[] arrayOfanud = this.jdField_a_of_type_ArrayOfAnud;
        int j = arrayOfanud.length;
        i = 0;
        if (i < j)
        {
          anud localanud = arrayOfanud[i];
          if (localanud == null) {
            break label168;
          }
          localanud.onDestroy();
          break label168;
        }
        if (this.jdField_a_of_type_Bevk == null) {}
      }
      try
      {
        this.jdField_a_of_type_Bevk.onDestroy();
        this.jdField_a_of_type_Bevk = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          bdcy.a(this).a(this);
        }
        jdField_a_of_type_Bpmn.a();
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
          this.jdField_a_of_type_Bevk.onDestroy();
        }
      }
      label168:
      i += 1;
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    bpam.b("PeakAppInterface", "onReceiveAccountAction");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    bpam.d("PeakAppInterface", "onReceiveAccountAction");
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
  
  public void removeObserver(anui paramanui)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramanui);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")))
    {
      this.jdField_a_of_type_Bcpx.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Bbom.a(paramToServiceMsg, null, bcuv.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */