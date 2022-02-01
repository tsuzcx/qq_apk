package com.tencent.av.business.manager;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.makeup.MakeupMng;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.VirtualBgMng;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.tips.TipsManager;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.wtogether.WTogetherMng;

public class BusinessManagerFactory
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private BusinessManager[] jdField_a_of_type_ArrayOfComTencentAvBusinessManagerBusinessManager = new BusinessManager[17];
  
  public BusinessManagerFactory(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(4);
    a(5);
    a(12);
    a(10);
  }
  
  public BusinessManager a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerBusinessManager[paramInt];
    if (localObject1 != null) {
      return localObject1;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      BusinessManager localBusinessManager = this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerBusinessManager[paramInt];
      localObject1 = localBusinessManager;
      if (localBusinessManager == null)
      {
        localBusinessManager = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt);
        localObject1 = localBusinessManager;
        if (localBusinessManager != null)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerBusinessManager[paramInt] = localBusinessManager;
          localObject1 = localBusinessManager;
        }
      }
      return localObject1;
    }
  }
  
  protected BusinessManager a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    case 9: 
    default: 
      AVLog.printColorLog("BusinessManagerFactory", "error-->create Manager unknown name :" + paramInt);
      paramVideoAppInterface = localObject;
    }
    for (;;)
    {
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.a();
      }
      long l2 = System.currentTimeMillis();
      AVLog.printColorLog("BusinessManagerFactory", "create Manager,cost time:" + (l2 - l1));
      return paramVideoAppInterface;
      paramVideoAppInterface = new EffectZimuManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectFilterTools(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectPendantTools(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new VideoNodeReporter(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectSupportManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectFaceManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedPacketManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new AVRedBagMgr(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectOperateManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new VoiceRecogManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new TipsManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new EffectMutexManager(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new MakeupMng(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new VirtualBgMng(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new WTogetherMng(paramVideoAppInterface);
      continue;
      paramVideoAppInterface = new ScreenShareManager(paramVideoAppInterface);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < 17) && (!BusinessManager.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) && (a(paramInt).a(paramString))) {
      BusinessManager.a("BusinessManagerFactory", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), paramInt, true);
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 17)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ArrayOfComTencentAvBusinessManagerBusinessManager[paramInt] != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.BusinessManagerFactory
 * JD-Core Version:    0.7.0.1
 */