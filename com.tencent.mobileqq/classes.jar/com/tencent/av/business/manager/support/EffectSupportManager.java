package com.tencent.av.business.manager.support;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;

public class EffectSupportManager
  extends BusinessManager
{
  private SupportDefault jdField_a_of_type_ComTencentAvBusinessManagerSupportSupportDefault;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private SupportBase[] jdField_a_of_type_ArrayOfComTencentAvBusinessManagerSupportSupportBase = new SupportBase[18];
  
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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3) {}
        }
      }
      for (paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvBusinessManagerSupportSupportDefault;; paramVideoAppInterface = null)
      {
        break;
        paramVideoAppInterface = new SupportFace(paramVideoAppInterface);
        break;
        paramVideoAppInterface = new SupportPendant(paramVideoAppInterface);
        break;
      }
    }
    paramVideoAppInterface = new SupportZimu(paramVideoAppInterface);
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a();
    }
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create Manager,cost time:");
    localStringBuilder.append(l2 - l1);
    AVLog.printColorLog("EffectSupportManager", localStringBuilder.toString());
    return paramVideoAppInterface;
  }
  
  public int a(int paramInt, String paramString)
  {
    SupportBase localSupportBase = a(paramInt);
    if (localSupportBase != null) {
      return localSupportBase.a(paramString);
    }
    return 1;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 18)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        SupportBase localSupportBase = a(i);
        if (localSupportBase != null) {
          localSupportBase.b();
        }
      }
      i += 1;
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("EffectFaceSupportManager onSessionStatusChanged ");
    paramString1.append(paramInt);
    AVLog.printColorLog("EffectSupportManager", paramString1.toString());
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return;
      }
      b();
      return;
    }
    a(255);
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
    SupportBase localSupportBase = a(paramInt);
    if (localSupportBase != null) {
      return localSupportBase.a(paramString);
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public void b()
  {
    int i = 0;
    while (i < 18)
    {
      SupportBase localSupportBase = a(i);
      if (localSupportBase != null) {
        localSupportBase.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.support.EffectSupportManager
 * JD-Core Version:    0.7.0.1
 */