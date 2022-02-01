package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CustomizeStrategyFactory$SkinRedPacketStrategy$3
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$3(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      paramPathResult = paramPathResult + File.separator;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult + "anim_bg");
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_SPECAIL_ANIM specailBackgroundAnimInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.specailBackgroundAnimInfo);
      }
      CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
      return;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.3
 * JD-Core Version:    0.7.0.1
 */