package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$SkinRedPacketStrategy$4
  implements IPreloadService.OnGetPathListener
{
  CustomizeStrategyFactory$SkinRedPacketStrategy$4(CustomizeStrategyFactory.SkinRedPacketStrategy paramSkinRedPacketStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_ANIM path=" + paramPathResult);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.4
 * JD-Core Version:    0.7.0.1
 */