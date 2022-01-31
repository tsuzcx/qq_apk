package com.tencent.mobileqq.app;

import ajtd;
import ajtg;
import akbb;
import akbz;
import akfv;
import akru;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import auko;
import aukv;
import auly;
import avre;
import awbh;
import awbi;
import awyo;
import axbp;
import axjq;
import ayry;
import aysv;
import biqb;
import biqf;
import bjbb;
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
import mqq.manager.Manager;
import vuj;

public class PeakAppInterface
  extends AppInterface
{
  public static bjbb a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akbz(this);
  private auko jdField_a_of_type_Auko;
  private aukv jdField_a_of_type_Aukv;
  private awbi jdField_a_of_type_Awbi;
  private awyo jdField_a_of_type_Awyo;
  private aysv jdField_a_of_type_Aysv;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private String jdField_a_of_type_JavaLangString = "";
  private List<ajtg> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private ajtd[] jdField_a_of_type_ArrayOfAjtd = new ajtd[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Bjbb = new bjbb();
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
  
  private ajtd b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new awbh(this);
    case 1: 
      return new vuj(this);
    case 2: 
      return new akbb(this);
    case 3: 
      return new biqf(this);
    }
    return new biqb(this);
  }
  
  public ajtd a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjtd[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAjtd)
    {
      ajtd localajtd = this.jdField_a_of_type_ArrayOfAjtd[paramInt];
      localObject1 = localajtd;
      if (localajtd == null)
      {
        localajtd = b(paramInt);
        localObject1 = localajtd;
        if (localajtd != null)
        {
          this.jdField_a_of_type_ArrayOfAjtd[paramInt] = localajtd;
          localObject1 = localajtd;
        }
      }
      return localObject1;
    }
  }
  
  public aukv a()
  {
    if (this.jdField_a_of_type_Aukv == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Aukv = new aukv(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Aukv;
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
      return ((akfv)localObject).b();
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
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")))
    {
      this.jdField_a_of_type_Awyo.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Awbi.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(ajtg paramajtg)
  {
    addObserver(paramajtg, false);
  }
  
  public void addObserver(ajtg paramajtg, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajtg)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajtg);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new auly((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((akfv)localObject).b();
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
        AppSetting.d = bool1;
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
  
  public List<ajtg> getBusinessObserver(int paramInt)
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
  
  public auko getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Auko == null) {
      this.jdField_a_of_type_Auko = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Auko;
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
      localObject2 = new akru();
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
  
  public ayry getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aysv == null) {
      this.jdField_a_of_type_Aysv = new aysv();
    }
    return this.jdField_a_of_type_Aysv.a(this, paramInt);
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
    this.jdField_a_of_type_Awbi = new awbi(this);
    this.jdField_a_of_type_Awyo = new awyo(this);
    jdField_a_of_type_Bjbb.a("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avre.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAjtd)
      {
        ajtd[] arrayOfajtd = this.jdField_a_of_type_ArrayOfAjtd;
        int j = arrayOfajtd.length;
        i = 0;
        if (i < j)
        {
          ajtd localajtd = arrayOfajtd[i];
          if (localajtd == null) {
            break label169;
          }
          localajtd.onDestroy();
          break label169;
        }
        if (this.jdField_a_of_type_Aysv == null) {}
      }
      try
      {
        this.jdField_a_of_type_Aysv.onDestroy();
        this.jdField_a_of_type_Aysv = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          axjq.a(this).a(this);
        }
        jdField_a_of_type_Bjbb.a();
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
          this.jdField_a_of_type_Aysv.onDestroy();
        }
      }
      label169:
      i += 1;
    }
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
  
  public void removeObserver(ajtg paramajtg)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajtg);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")))
    {
      this.jdField_a_of_type_Awyo.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Awbi.a(paramToServiceMsg, null, axbp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */