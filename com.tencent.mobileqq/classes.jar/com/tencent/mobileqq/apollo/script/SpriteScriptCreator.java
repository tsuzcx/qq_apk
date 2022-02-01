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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteAioScript localSpriteAioScript = (SpriteAioScript)localIterator.next();
      if (localSpriteAioScript.b() == paramInt) {
        return localSpriteAioScript;
      }
    }
    return null;
  }
  
  public SpriteAioScript a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = a(paramInt1);
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (localObject != null)
    {
      if (bool)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "createScript init load but has last script");
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      }
    }
    else {
      switch (paramInt1)
      {
      }
    }
    for (localObject = new SpriteBusinessScript(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext); (localObject != null) && (((SpriteAioScript)localObject).a()); localObject = new SpriteActionScript(paramInt1, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext))
    {
      ((SpriteAioScript)localObject).d();
      ((SpriteAioScript)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback);
      ((SpriteAioScript)localObject).c();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
      long l2 = System.currentTimeMillis();
      QLog.i("cmshow_scripted_SpriteCreator", 1, "create script, bid:" + paramInt1 + ",cost:" + (l2 - l1) + ",threadId:" + Thread.currentThread().getId() + ",init:" + bool);
      return localObject;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {}
    SpriteAioScript localSpriteAioScript;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)
      {
        QLog.w("cmshow_scripted_SpriteCreator", 1, "[loadBasicScript], fail. surfaceView is null.");
        return;
      }
      localSpriteAioScript = a(0, -1);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    } while ((localSpriteAioScript == null) || (!(localSpriteAioScript instanceof SpriteActionScript)) || ((SpriteActionScript)localSpriteAioScript != null));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((SpriteAioScript)localIterator.next()).g();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptCreator
 * JD-Core Version:    0.7.0.1
 */