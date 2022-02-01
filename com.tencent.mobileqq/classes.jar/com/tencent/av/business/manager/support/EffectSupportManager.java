package com.tencent.av.business.manager.support;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;

public class EffectSupportManager
  extends BusinessManager
{
  private Object d = new Object();
  private SupportBase[] e = new SupportBase[19];
  private SupportDefault f;
  
  public EffectSupportManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.f = new SupportDefault(paramVideoAppInterface);
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
      for (paramVideoAppInterface = this.f;; paramVideoAppInterface = null)
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
  
  private SupportBase b(int paramInt)
  {
    Object localObject1 = this.e[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.d)
    {
      SupportBase localSupportBase = this.e[paramInt];
      localObject1 = localSupportBase;
      if (localSupportBase == null)
      {
        localSupportBase = a(this.c, paramInt);
        localObject1 = localSupportBase;
        if (localSupportBase != null)
        {
          this.e[paramInt] = localSupportBase;
          localObject1 = localSupportBase;
        }
      }
      return localObject1;
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < 19)
    {
      if ((paramInt == 255) || (paramInt == i))
      {
        SupportBase localSupportBase = b(i);
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
    SupportBase localSupportBase = b(paramInt1);
    if (localSupportBase != null) {
      return localSupportBase.a(paramInt2, paramString);
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    SupportBase localSupportBase = b(paramInt);
    if (localSupportBase != null) {
      return localSupportBase.a(paramString);
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return true;
  }
  
  public int b(int paramInt, String paramString)
  {
    SupportBase localSupportBase = b(paramInt);
    if (localSupportBase != null) {
      return localSupportBase.b(paramString);
    }
    return 1;
  }
  
  public void b()
  {
    int i = 0;
    while (i < 19)
    {
      SupportBase localSupportBase = b(i);
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