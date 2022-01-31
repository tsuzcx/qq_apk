package com.tencent.biz.videostory.config;

import alzw;
import com.tencent.qphone.base.util.QLog;
import wwt;
import wwu;
import wxa;
import wxm;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(wwt paramwwt) {}
  
  public void run()
  {
    Object localObject = (wwu)alzw.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((wwu)localObject).toString());
    }
    localObject = (wxa)alzw.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    wxm.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */