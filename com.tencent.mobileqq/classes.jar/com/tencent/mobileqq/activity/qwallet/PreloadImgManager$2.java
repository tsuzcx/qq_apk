package com.tencent.mobileqq.activity.qwallet;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import java.util.List;
import java.util.Map;

class PreloadImgManager$2
  implements IPreloadService.OnGetPathListener
{
  PreloadImgManager$2(PreloadImgManager paramPreloadImgManager, AppInterface paramAppInterface) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    List localList = (List)PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager).get(paramPathResult.url);
    if (paramPathResult.url.endsWith(".zip")) {
      PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, paramPathResult.folderPath, localList);
    }
    while (!paramPathResult.url.endsWith(".png")) {
      return;
    }
    PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPathResult.url, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PreloadImgManager.2
 * JD-Core Version:    0.7.0.1
 */