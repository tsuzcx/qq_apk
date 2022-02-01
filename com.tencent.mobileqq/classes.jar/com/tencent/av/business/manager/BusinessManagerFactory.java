package com.tencent.av.business.manager;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.VirtualBgMng;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.tips.TipsManager;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.wtogether.WTogetherMng;

public class BusinessManagerFactory
{
  private Object a = new Object();
  private VideoAppInterface b;
  private BusinessManager[] c = new BusinessManager[19];
  
  public BusinessManagerFactory(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public BusinessManager a(int paramInt)
  {
    Object localObject1 = this.c[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.a)
    {
      BusinessManager localBusinessManager = this.c[paramInt];
      localObject1 = localBusinessManager;
      if (localBusinessManager == null)
      {
        localBusinessManager = a(this.b, paramInt);
        localObject1 = localBusinessManager;
        if (localBusinessManager != null)
        {
          this.c[paramInt] = localBusinessManager;
          localObject1 = localBusinessManager;
        }
      }
      return localObject1;
    }
  }
  
  protected BusinessManager a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 9: 
    default: 
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("error-->create Manager unknown name :");
      paramVideoAppInterface.append(paramInt);
      AVLog.printColorLog("BusinessManagerFactory", paramVideoAppInterface.toString());
      paramVideoAppInterface = null;
      break;
    case 18: 
      paramVideoAppInterface = new ScreenShareManager(paramVideoAppInterface);
      break;
    case 17: 
      paramVideoAppInterface = new WTogetherMng(paramVideoAppInterface);
      break;
    case 16: 
      paramVideoAppInterface = new EffectAvatar2dManager(paramVideoAppInterface);
      break;
    case 15: 
      paramVideoAppInterface = new EffectMaterialManager(paramVideoAppInterface);
      break;
    case 14: 
      paramVideoAppInterface = new VirtualBgMng(paramVideoAppInterface);
      break;
    case 13: 
      paramVideoAppInterface = new MakeupMng(paramVideoAppInterface);
      break;
    case 12: 
      paramVideoAppInterface = new EffectMutexManager(paramVideoAppInterface);
      break;
    case 11: 
      paramVideoAppInterface = new TipsManager(paramVideoAppInterface);
      break;
    case 10: 
      paramVideoAppInterface = new VoiceRecogManager(paramVideoAppInterface);
      break;
    case 8: 
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      break;
    case 5: 
      paramVideoAppInterface = new EffectSupportManager(paramVideoAppInterface);
      break;
    case 4: 
      paramVideoAppInterface = new VideoNodeReporter(paramVideoAppInterface);
      break;
    case 3: 
      paramVideoAppInterface = new EffectFaceManager(paramVideoAppInterface);
      break;
    case 2: 
      paramVideoAppInterface = new EffectPendantTools(paramVideoAppInterface);
      break;
    case 1: 
      paramVideoAppInterface = new EffectFilterTools(paramVideoAppInterface);
      break;
    case 0: 
      paramVideoAppInterface = new EffectZimuManager(paramVideoAppInterface);
    }
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a();
    }
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create Manager,cost time:");
    localStringBuilder.append(l2 - l1);
    AVLog.printColorLog("BusinessManagerFactory", localStringBuilder.toString());
    return paramVideoAppInterface;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 19) && (!BusinessManager.a("BusinessManagerFactory", this.b, paramInt)) && (a(paramInt).a(paramString))) {
      BusinessManager.a("BusinessManagerFactory", this.b.getApplication(), paramInt, true);
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 19)
      {
        bool1 = bool2;
        if (this.c[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessManagerFactory
 * JD-Core Version:    0.7.0.1
 */