package com.tencent.biz.videostory.config;

import abac;
import abae;
import abak;
import abam;
import abay;
import aran;
import bigk;
import com.tencent.qphone.base.util.QLog;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(abac paramabac) {}
  
  public void run()
  {
    Object localObject = (abae)aran.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((abae)localObject).toString());
    }
    localObject = (abam)aran.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (abak)aran.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    localObject = (bigk)aran.a().a(671);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSHealthConfigBean : " + localObject);
    }
    abay.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */