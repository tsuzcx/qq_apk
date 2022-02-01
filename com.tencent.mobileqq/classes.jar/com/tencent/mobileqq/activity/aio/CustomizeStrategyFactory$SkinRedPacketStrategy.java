package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BigAnimRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.ResPathRedPkgElem;
import com.tencent.mobileqq.activity.aio.qwallet.elem.SkinRedPkgElem;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import org.json.JSONObject;

class CustomizeStrategyFactory$SkinRedPacketStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  QWalletConfigManager jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IPreloadService jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = null;
  
  CustomizeStrategyFactory$SkinRedPacketStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService = ((IPreloadService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreloadService.class, ""));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager = ((QWalletConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER));
    }
  }
  
  private void a(@NonNull IPreloadService paramIPreloadService, @NonNull QWalletConfigManager paramQWalletConfigManager, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    String str1 = null;
    String str2 = paramQWalletConfigManager.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    switch (paramRedPacketInfo.skinType)
    {
    default: 
      return;
    case 1: 
    case 2: 
      JSONObject localJSONObject = paramQWalletConfigManager.a("redPack", new String[] { "skinMap" });
      paramQWalletConfigManager = str1;
      if (localJSONObject != null)
      {
        localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
        paramQWalletConfigManager = str1;
        if (localJSONObject != null)
        {
          paramQWalletConfigManager = localJSONObject.optString("aioZipMd5", "");
          str1 = localJSONObject.optString("popZipMd5", "");
          if (paramRedPacketInfo.skinType != 1) {
            break label222;
          }
          paramRedPacketInfo.title = localJSONObject.optString("title", "");
          paramRedPacketInfo.isHideTitle = localJSONObject.optInt("isHideTitle", paramRedPacketInfo.a());
        }
      }
      if (paramRedPacketInfo.skinType == 1) {}
      for (str1 = "aio_";; str1 = "pop_")
      {
        paramIPreloadService.getUnzipFolderPath(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramQWalletConfigManager, new CustomizeStrategyFactory.SkinRedPacketStrategy.2(this, paramRedPacketInfo));
        return;
        paramQWalletConfigManager = str1;
        break;
      }
    case 3: 
      label222:
      paramQWalletConfigManager = paramQWalletConfigManager.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramIPreloadService.getUnzipFolderPath(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramQWalletConfigManager, new CustomizeStrategyFactory.SkinRedPacketStrategy.3(this, paramRedPacketInfo));
      return;
    }
    paramQWalletConfigManager = paramQWalletConfigManager.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
    paramIPreloadService.getUnzipFolderPath(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramQWalletConfigManager, new CustomizeStrategyFactory.SkinRedPacketStrategy.4(this, paramRedPacketInfo));
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, BaseRedPkgElem paramBaseRedPkgElem)
  {
    if (paramRedPacketInfo != null)
    {
      if (!(paramBaseRedPkgElem instanceof SkinRedPkgElem)) {
        break label74;
      }
      paramBaseRedPkgElem = (SkinRedPkgElem)paramBaseRedPkgElem;
      paramRedPacketInfo.background = paramBaseRedPkgElem.b;
      paramRedPacketInfo.corner = paramBaseRedPkgElem.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.animInfo = paramBaseRedPkgElem.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
      paramRedPacketInfo.title = paramBaseRedPkgElem.c;
      paramRedPacketInfo.icon = paramBaseRedPkgElem.a(paramRedPacketInfo);
      paramRedPacketInfo.isHideTitle = paramBaseRedPkgElem.jdField_a_of_type_Int;
      paramRedPacketInfo.resPath = paramBaseRedPkgElem.d;
    }
    label74:
    do
    {
      return;
      if ((paramBaseRedPkgElem instanceof BigAnimRedPkgElem))
      {
        paramBaseRedPkgElem = (BigAnimRedPkgElem)paramBaseRedPkgElem;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramBaseRedPkgElem.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
        paramRedPacketInfo.specialBackground = paramBaseRedPkgElem.jdField_a_of_type_AndroidGraphicsBitmap;
        return;
      }
    } while (!(paramBaseRedPkgElem instanceof ResPathRedPkgElem));
    paramRedPacketInfo.resPath = ((ResPathRedPkgElem)paramBaseRedPkgElem).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy
 * JD-Core Version:    0.7.0.1
 */