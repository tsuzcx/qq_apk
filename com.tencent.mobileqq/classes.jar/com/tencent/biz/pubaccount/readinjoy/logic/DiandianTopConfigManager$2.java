package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.UiThreadUtil;

class DiandianTopConfigManager$2
  implements Runnable
{
  DiandianTopConfigManager$2(DiandianTopConfigManager paramDiandianTopConfigManager) {}
  
  public void run()
  {
    synchronized (DiandianTopConfigManager.a)
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      UiThreadUtil.a(new DiandianTopConfigManager.2.1(this, FileUtils.a(BaseApplication.getContext().getFileStreamPath("file_readinjoy_diandian_top_config" + localAppInterface.getCurrentAccountUin()))));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2
 * JD-Core Version:    0.7.0.1
 */