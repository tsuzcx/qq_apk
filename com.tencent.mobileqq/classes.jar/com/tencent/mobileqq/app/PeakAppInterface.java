package com.tencent.mobileqq.app;

import ajfb;
import ajfe;
import ajms;
import ajnp;
import ajrl;
import akdi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import atmq;
import atmx;
import atoa;
import aurv;
import avbo;
import avbp;
import avyv;
import avzi;
import avzm;
import awch;
import awkk;
import axrr;
import axso;
import bhgj;
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
import vhn;

public class PeakAppInterface
  extends AppInterface
{
  public static bhgj a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajnp(this);
  private atmq jdField_a_of_type_Atmq;
  private atmx jdField_a_of_type_Atmx;
  private avbp jdField_a_of_type_Avbp;
  private avyv jdField_a_of_type_Avyv;
  private axso jdField_a_of_type_Axso;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private String jdField_a_of_type_JavaLangString = "";
  private List<ajfe> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private ajfb[] jdField_a_of_type_ArrayOfAjfb = new ajfb[5];
  private boolean b;
  
  static
  {
    jdField_a_of_type_Bhgj = new bhgj();
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
  
  private ajfb b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new avbo(this);
    case 1: 
      return new vhn(this);
    case 2: 
      return new ajms(this);
    case 3: 
      return new avzm(this);
    }
    return new avzi(this);
  }
  
  public ajfb a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAjfb[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfAjfb)
    {
      ajfb localajfb = this.jdField_a_of_type_ArrayOfAjfb[paramInt];
      localObject1 = localajfb;
      if (localajfb == null)
      {
        localajfb = b(paramInt);
        localObject1 = localajfb;
        if (localajfb != null)
        {
          this.jdField_a_of_type_ArrayOfAjfb[paramInt] = localajfb;
          localObject1 = localajfb;
        }
      }
      return localObject1;
    }
  }
  
  public atmx a()
  {
    if (this.jdField_a_of_type_Atmx == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_Atmx = new atmx(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_Atmx;
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
      return ((ajrl)localObject).b();
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
      this.jdField_a_of_type_Avyv.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_Avbp.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void addObserver(ajfe paramajfe)
  {
    addObserver(paramajfe, false);
  }
  
  public void addObserver(ajfe paramajfe, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajfe)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajfe);
    }
  }
  
  public SQLiteDatabase b()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new atoa((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((ajrl)localObject).b();
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
  
  public List<ajfe> getBusinessObserver(int paramInt)
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
  
  public atmq getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Atmq == null) {
      this.jdField_a_of_type_Atmq = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Atmq;
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
      localObject2 = new akdi();
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
  
  public axrr getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Axso == null) {
      this.jdField_a_of_type_Axso = new axso();
    }
    return this.jdField_a_of_type_Axso.a(this, paramInt);
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
    this.jdField_a_of_type_Avbp = new avbp(this);
    this.jdField_a_of_type_Avyv = new avyv(this);
    jdField_a_of_type_Bhgj.a("{1000,1002}");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aurv.a().b(BaseApplicationImpl.sApplication);
    ??? = PresendPicMgr.a(null);
    if (??? != null) {
      ((PresendPicMgr)???).b();
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ArrayOfAjfb)
      {
        ajfb[] arrayOfajfb = this.jdField_a_of_type_ArrayOfAjfb;
        int j = arrayOfajfb.length;
        i = 0;
        if (i < j)
        {
          ajfb localajfb = arrayOfajfb[i];
          if (localajfb == null) {
            break label169;
          }
          localajfb.onDestroy();
          break label169;
        }
        if (this.jdField_a_of_type_Axso == null) {}
      }
      try
      {
        this.jdField_a_of_type_Axso.onDestroy();
        this.jdField_a_of_type_Axso = null;
        if (this.b)
        {
          this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.b = false;
        }
        if (this.jdField_a_of_type_Boolean) {
          awkk.a(this).a(this);
        }
        jdField_a_of_type_Bhgj.a();
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
          this.jdField_a_of_type_Axso.onDestroy();
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
  
  public void removeObserver(ajfe paramajfe)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajfe);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterial")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")))
    {
      this.jdField_a_of_type_Avyv.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_Avbp.a(paramToServiceMsg, null, awch.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */