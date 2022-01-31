package com.tencent.av.business.manager.support;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;

public class EffectSupportManager
  extends BusinessManager
{
  private SupportDefault jdField_a_of_type_ComTencentAvBusinessManagerSupportSupportDefault;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private SupportBase[] jdField_a_of_type_ArrayOfComTencentAvBusinessManagerSupportSupportBase = new SupportBase[10];
  
  public EffectSupportManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerSupportSupportDefault = new SupportDefault(paramVideoAppInterface);
  }
  
  private SupportBase a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerSupportSupportBase[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      SupportBase localSupportBase = this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerSupportSupportBase[paramInt];
      localObject1 = localSupportBase;
      if (localSupportBase == null)
      {
        localSupportBase = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localSupportBase;
        if (localSupportBase != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerSupportSupportBase[paramInt] = localSupportBase;
          localObject1 = localSupportBase;
        }
      }
      return localObject1;
    }
  }
  
  private SupportBase a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      localObject = this.jdField_a_of_type_ComTencentAvBusinessManagerSupportSupportDefault;
    }
    for (;;)
    {
      if (localObject != null) {
        ((SupportBase)localObject).a();
      }
      long l2 = System.currentTimeMillis();
      AVLog.c("EffectSupportManager", "create Manager,cost time:" + (l2 - l1));
      return localObject;
      localObject = new SupportZimu(paramVideoAppInterface);
      continue;
      localObject = new SupportFace(paramVideoAppInterface);
      continue;
      localObject = new SupportPendant(paramVideoAppInterface);
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    int i = 1;
    SupportBase localSupportBase = a(paramInt);
    paramInt = i;
    if (localSupportBase != null) {
      paramInt = localSupportBase.a(paramString);
    }
    return paramInt;
  }
  
  protected void a() {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      b();
      return;
    }
    c();
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    SupportBase localSupportBase = a(paramInt1);
    if (localSupportBase != null) {
      return localSupportBase.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    SupportBase localSupportBase = a(paramInt);
    if (localSupportBase != null) {
      bool = localSupportBase.a(paramString);
    }
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public void b()
  {
    int i = 0;
    while (i < 10)
    {
      SupportBase localSupportBase = a(i);
      if (localSupportBase != null) {
        localSupportBase.b();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < 10)
    {
      SupportBase localSupportBase = a(i);
      if (localSupportBase != null) {
        localSupportBase.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.support.EffectSupportManager
 * JD-Core Version:    0.7.0.1
 */