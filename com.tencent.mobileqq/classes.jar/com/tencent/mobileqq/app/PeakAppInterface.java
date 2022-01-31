package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.richmedia.server.PeakMsfServletProxy;
import com.tencent.mobileqq.servlet.AudioTransServlet;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.startup.step.LoadDex;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Vector;
import zie;

public class PeakAppInterface
  extends AppInterface
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new zie(this);
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  public PeakMsfServletProxy a;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  public List a;
  public boolean a;
  private BusinessHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler = new BusinessHandler[1];
  boolean b = false;
  
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
  
  private BusinessHandler b(int paramInt)
  {
    System.currentTimeMillis();
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new PeakAudioTransHandler(this);
  }
  
  public QQStoryContext a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  }
  
  public BusinessHandler a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler)
    {
      BusinessHandler localBusinessHandler = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt];
      localObject1 = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        localBusinessHandler = b(paramInt);
        localObject1 = localBusinessHandler;
        if (localBusinessHandler != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqAppBusinessHandler[paramInt] = localBusinessHandler;
          localObject1 = localBusinessHandler;
        }
      }
      return localObject1;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
    }
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a;
  }
  
  public List getBusinessObserver(int paramInt)
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
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new LoadDex().c();
    new InitMemoryCache().c();
    new InitUrlDrawable().c();
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "Application OnCreate complete");
    }
    RichmediaClient.a().a(BaseApplicationImpl.sApplication);
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onCreate");
    }
    PtvTemplateManager.a(this);
    if (!PtvTemplateManager.a()) {
      PtvTemplateManager.a(this).a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.b = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy = new PeakMsfServletProxy(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RichmediaClient.a().b(BaseApplicationImpl.sApplication);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      if (this.b)
      {
        this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.b = false;
      }
      if (this.jdField_a_of_type_Boolean) {
        RedBagVideoManager.a(this).a(this);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PeakAppInterface", 2, "onDestroy");
      }
      PtvTemplateManager.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      }
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramToServiceMsg, null, AudioTransServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */