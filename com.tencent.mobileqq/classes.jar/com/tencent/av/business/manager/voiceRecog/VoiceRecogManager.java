package com.tencent.av.business.manager.voiceRecog;

import android.content.SharedPreferences;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.EffectFaceManager.BlessingTips;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class VoiceRecogManager
  extends BusinessManager
{
  VoiceRecogTips a;
  
  public VoiceRecogManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = null;
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("qav_voicerecog");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static EffectFaceManager.BlessingTips a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = ((EffectFaceManager)paramVideoAppInterface.a(3)).a();
    long l = MessageCache.a();
    paramVideoAppInterface = paramVideoAppInterface.iterator();
    while (paramVideoAppInterface.hasNext())
    {
      EffectFaceManager.BlessingTips localBlessingTips = (EffectFaceManager.BlessingTips)paramVideoAppInterface.next();
      if (a(l * 1000L, localBlessingTips.a, localBlessingTips.b)) {
        return localBlessingTips;
      }
    }
    return null;
  }
  
  public static boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 <= paramLong3);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    return b(paramVideoAppInterface);
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    return ((EffectSupportManager)paramVideoAppInterface.a(5)).a(3, "normal");
  }
  
  protected void a() {}
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (1 == paramInt)
    {
      b();
      return;
    }
    if (3 == paramInt) {
      c();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    if (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if (localSessionInfo == null) {
      return;
    }
    EffectFaceManager.BlessingTips localBlessingTips = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localBlessingTips == null) {
      return;
    }
    VoiceRecogTips localVoiceRecogTips = this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips;
    if (localVoiceRecogTips != null) {
      localVoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = new VoiceRecogTips(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localSessionInfo.c, localBlessingTips);
  }
  
  void c()
  {
    VoiceRecogTips localVoiceRecogTips = this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips;
    if (localVoiceRecogTips != null)
    {
      localVoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogManager
 * JD-Core Version:    0.7.0.1
 */