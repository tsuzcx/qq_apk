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
  VoiceRecogTips d = null;
  
  public VoiceRecogManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("qav_voicerecog");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
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
    return ((EffectSupportManager)paramVideoAppInterface.c(5)).a(3, "normal");
  }
  
  public static EffectFaceManager.BlessingTips c(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = ((EffectFaceManager)paramVideoAppInterface.c(3)).l();
    long l = MessageCache.c();
    paramVideoAppInterface = paramVideoAppInterface.iterator();
    while (paramVideoAppInterface.hasNext())
    {
      EffectFaceManager.BlessingTips localBlessingTips = (EffectFaceManager.BlessingTips)paramVideoAppInterface.next();
      if (a(l * 1000L, localBlessingTips.b, localBlessingTips.c)) {
        return localBlessingTips;
      }
    }
    return null;
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
    if (!a(this.c)) {
      return;
    }
    SessionInfo localSessionInfo = this.c.b().k();
    if (localSessionInfo == null) {
      return;
    }
    EffectFaceManager.BlessingTips localBlessingTips = c(this.c);
    if (localBlessingTips == null) {
      return;
    }
    VoiceRecogTips localVoiceRecogTips = this.d;
    if (localVoiceRecogTips != null) {
      localVoiceRecogTips.c(this.c);
    }
    this.d = new VoiceRecogTips(this.c, localSessionInfo.s, localBlessingTips);
  }
  
  void c()
  {
    VoiceRecogTips localVoiceRecogTips = this.d;
    if (localVoiceRecogTips != null)
    {
      localVoiceRecogTips.c(this.c);
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogManager
 * JD-Core Version:    0.7.0.1
 */