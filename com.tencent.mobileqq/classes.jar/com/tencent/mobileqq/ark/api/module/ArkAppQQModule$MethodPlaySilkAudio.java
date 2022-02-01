package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerHelper;
import com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$MethodPlaySilkAudio
  extends ArkAppQQModule.TencentMethod
{
  private ArkAppQQModule$MethodPlaySilkAudio(ArkAppQQModule paramArkAppQQModule)
  {
    super(null);
  }
  
  public String a()
  {
    return "PlaySilkAudio";
  }
  
  public void a(ArkAppModuleBase paramArkAppModuleBase, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsFunction()))
    {
      if (this.a.a == null)
      {
        paramArkAppModuleBase = this.a;
        paramArkAppModuleBase.a = new ArkSilkAudioPlayerWrapper(ArkAppQQModule.q(paramArkAppModuleBase));
        ArkSilkAudioPlayerHelper.a(this.a.a);
      }
      try
      {
        paramArkAppModuleBase = paramArrayOfVariantWrapper[0].GetString();
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].Copy();
        if (paramArrayOfVariantWrapper == null)
        {
          this.a.a.b(6);
          QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio callBack is invalid");
          return;
        }
        if (TextUtils.isEmpty(paramArkAppModuleBase))
        {
          this.a.a.b(6);
          QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio url is invalid");
          return;
        }
        paramVariantWrapper = ArkCommonUtil.a();
        if (paramVariantWrapper != null) {
          ((MediaPlayerManager)paramVariantWrapper.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(false);
        }
        this.a.a.a(paramArrayOfVariantWrapper);
        this.a.a.a(paramArkAppModuleBase);
        return;
      }
      catch (Exception paramArkAppModuleBase)
      {
        this.a.a.a(6);
        paramArrayOfVariantWrapper = new StringBuilder();
        paramArrayOfVariantWrapper.append("invoke method MethodPlaySilkAudio exception");
        paramArrayOfVariantWrapper.append(paramArkAppModuleBase);
        QLog.w("ArkApp.ArkAppQQModule", 1, paramArrayOfVariantWrapper.toString());
        return;
      }
    }
    QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio args is invalid");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.MethodPlaySilkAudio
 * JD-Core Version:    0.7.0.1
 */