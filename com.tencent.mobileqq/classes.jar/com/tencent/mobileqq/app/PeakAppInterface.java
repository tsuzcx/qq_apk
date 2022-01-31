package com.tencent.mobileqq.app;

import ajtb;
import ajte;
import akaz;
import akby;
import akfu;
import akrt;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import aukq;
import aukx;
import auma;
import avrg;
import awbj;
import awbk;
import awyq;
import axbr;
import axjs;
import aysa;
import aysx;
import biqs;
import biqw;
import bjbs;
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
import vug;

public class PeakAppInterface
  extends AppInterface
{
  public static bjbs a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new akby(this);
  private aukq jdField_a_of_type_Aukq;
  private aukx jdField_a_of_type_Aukx;
  private awbk jdField_a_of_type_Awbk;
  private awyq jdField_a_of_type_Awyq;
  private aysx jdField_a_of_type_Aysx;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private String jdField_a_of_type_JavaLangString = "";
  private List<ajte> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private ajtb[] jdField_a_of_type_ArrayOfAjtb = new ajtb[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Bjbs = new bjbs();
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
  
  private ajtb b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new awbj(this);
    case 1: 
      return new vug(this);
    case 2: 
      return new akaz(this);
    case 3: 
      return new biqw(this);
    }
    return new biqs(this);
  }
  
  public ajtb a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjtb[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAjtb)
    {
      ajtb localajtb = this.jdField_a_of_type_ArrayOfAjtb[paramInt];
      localObject1 = localajtb;
      if (localajtb == null)
      {
        localajtb = b(paramInt);
        localObject1 = localajtb;
        if (localajtb != null)
        {
          this.jdField_a_of_type_ArrayOfAjtb[paramInt] = localajtb;
          localObject1 = localajtb;
        }
      }
      return localObject1;
    }
  }
  
  public aukx a()
  {
    if (this.jdField_a_of_type_Aukx == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Aukx = new aukx(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Aukx;
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
      return ((akfu)localObject).b();
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
      this.jdField_a_of_type_Awyq.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Awbk.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(ajte paramajte)
  {
    addObserver(paramajte, false);
  }
  
  public void addObserver(ajte paramajte, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajte)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajte);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new auma((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((akfu)localObject).b();
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
  
  public List<ajte> getBusinessObserver(int paramInt)
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
  
  public aukq getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Aukq == null) {
      this.jdField_a_of_type_Aukq = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Aukq;
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
      localObject2 = new akrt();
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
  
  public aysa getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Aysx == null) {
      this.jdField_a_of_type_Aysx = new aysx();
    }
    return this.jdField_a_of_type_Aysx.a(this, paramInt);
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
    this.jdField_a_of_type_Awbk = new awbk(this);
    this.jdField_a_of_type_Awyq = new awyq(this);
    jdField_a_of_type_Bjbs.a("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avrg.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAjtb)
      {
        ajtb[] arrayOfajtb = this.jdField_a_of_type_ArrayOfAjtb;
        int j = arrayOfajtb.length;
        i = 0;
        if (i < j)
        {
          ajtb localajtb = arrayOfajtb[i];
          if (localajtb == null) {
            break label169;
          }
          localajtb.onDestroy();
          break label169;
        }
        if (this.jdField_a_of_type_Aysx == null) {}
      }
      try
      {
        this.jdField_a_of_type_Aysx.onDestroy();
        this.jdField_a_of_type_Aysx = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          axjs.a(this).a(this);
        }
        jdField_a_of_type_Bjbs.a();
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
          this.jdField_a_of_type_Aysx.onDestroy();
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
  
  public void removeObserver(ajte paramajte)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajte);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")))
    {
      this.jdField_a_of_type_Awyq.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Awbk.a(paramToServiceMsg, null, axbr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */