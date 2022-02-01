package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class CmShowSpriteScriptCreator
{
  private ISpriteActionCallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback;
  private CmShowScriptManager jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager;
  private CmShowSpriteContext jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext;
  private CopyOnWriteArrayList<CmShowSpriteAioScript> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public CmShowSpriteScriptCreator(CmShowSpriteContext paramCmShowSpriteContext, ISpriteActionCallback paramISpriteActionCallback, CmShowScriptManager paramCmShowScriptManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext = paramCmShowSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager = paramCmShowScriptManager;
  }
  
  public CmShowSpriteAioScript a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      CmShowSpriteAioScript localCmShowSpriteAioScript = (CmShowSpriteAioScript)localIterator.next();
      if (localCmShowSpriteAioScript.b() == paramInt) {
        return localCmShowSpriteAioScript;
      }
    }
    return null;
  }
  
  public CmShowSpriteAioScript a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("CmShow_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      default: 
        localObject = new CmShowSpriteBusinessScript(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager);
      }
    }
    while ((localObject != null) && (((CmShowSpriteAioScript)localObject).a()))
    {
      ((CmShowSpriteAioScript)localObject).d();
      ((CmShowSpriteAioScript)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback);
      ((CmShowSpriteAioScript)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("CmShow_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
      localObject = new CmShowSpriteActionScript(paramInt1, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager);
      continue;
      localObject = new CmShowSpriteActionScript(paramInt1, "cmshow_base.js", this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowScriptManager);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowSpriteContext.a() == null)
    {
      QLog.w("CmShow_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
      return;
    }
    a(100, -1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((CmShowSpriteAioScript)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowSpriteScriptCreator
 * JD-Core Version:    0.7.0.1
 */