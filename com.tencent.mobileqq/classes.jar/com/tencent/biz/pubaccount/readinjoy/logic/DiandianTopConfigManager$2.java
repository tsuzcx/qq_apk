package com.tencent.biz.pubaccount.readinjoy.logic;

import bbdx;
import bfny;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import oyv;

public class DiandianTopConfigManager$2
  implements Runnable
{
  public DiandianTopConfigManager$2(oyv paramoyv) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      bfny.a(new DiandianTopConfigManager.2.1(this, bbdx.a(BaseApplication.getContext().getFileStreamPath("file_readinjoy_diandian_top_config" + localAppInterface.getCurrentAccountUin()))));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2
 * JD-Core Version:    0.7.0.1
 */