package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction()))
    {
      QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio args is invalid");
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper = new ArkSilkAudioPlayerWrapper(this.a.jdField_a_of_type_JavaLangString);
      ArkSilkAudioPlayerHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper);
    }
    try
    {
      paramArkAppModuleBase = paramArrayOfVariantWrapper[0].GetString();
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1].Copy();
      if (paramArrayOfVariantWrapper == null)
      {
        QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio callBack is invalid");
        return;
      }
    }
    catch (Exception paramArkAppModuleBase)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper.a(6);
      QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio exception" + paramArkAppModuleBase);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper.a(paramArrayOfVariantWrapper);
    if (TextUtils.isEmpty(paramArkAppModuleBase))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper.b(6);
      QLog.w("ArkApp.ArkAppQQModule", 1, "invoke method MethodPlaySilkAudio url is invalid");
      return;
    }
    paramArrayOfVariantWrapper = ArkCommonUtil.a();
    if (paramArrayOfVariantWrapper != null) {
      ((MediaPlayerManager)paramArrayOfVariantWrapper.getManager(QQManagerFactory.MGR_MEDIA_PLAYER)).a(false);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkSilkAudioPlayerWrapper.a(paramArkAppModuleBase);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.MethodPlaySilkAudio
 * JD-Core Version:    0.7.0.1
 */