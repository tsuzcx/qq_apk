package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpriteScriptCreator
{
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private ISpriteActionCallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback;
  private CopyOnWriteArrayList<SpriteAioScript> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  
  public SpriteScriptCreator(SpriteContext paramSpriteContext, ISpriteActionCallback paramISpriteActionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  public SpriteAioScript a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = b(paramInt);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null) {
      if (bool)
      {
        QLog.w("[cmshow][scripted]SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
      else
      {
        return localObject;
      }
    }
    if (paramInt != 0) {
      localObject = new SpriteBusinessScript(paramInt, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    } else {
      localObject = new SpriteActionScript(paramInt, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
    if (((SpriteAioScript)localObject).a())
    {
      ((SpriteAioScript)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback);
      ((SpriteAioScript)localObject).c();
      ((SpriteAioScript)localObject).b();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create script, bid:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",cost:");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(",threadId:");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(",init:");
      localStringBuilder.append(bool);
      QLog.i("[cmshow][scripted]SpriteCreator", 1, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return;
    }
    a(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public SpriteAioScript b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteAioScript localSpriteAioScript = (SpriteAioScript)localIterator.next();
      if (localSpriteAioScript.a() == paramInt) {
        return localSpriteAioScript;
      }
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SpriteAioScript)((Iterator)localObject).next()).f();
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptCreator
 * JD-Core Version:    0.7.0.1
 */