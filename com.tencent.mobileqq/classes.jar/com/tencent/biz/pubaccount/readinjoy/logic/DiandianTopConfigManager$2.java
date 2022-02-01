package com.tencent.biz.pubaccount.readinjoy.logic;

import bgmg;
import bkgk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import pvf;

public class DiandianTopConfigManager$2
  implements Runnable
{
  public DiandianTopConfigManager$2(pvf parampvf) {}
  
  public void run()
  {
    synchronized (pvf.a)
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      bkgk.a(new DiandianTopConfigManager.2.1(this, bgmg.a(BaseApplication.getContext().getFileStreamPath("file_readinjoy_diandian_top_config" + localAppInterface.getCurrentAccountUin()))));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2
 * JD-Core Version:    0.7.0.1
 */