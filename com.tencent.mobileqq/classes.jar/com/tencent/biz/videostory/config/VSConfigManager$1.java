package com.tencent.biz.videostory.config;

import ampm;
import com.tencent.qphone.base.util.QLog;
import xfr;
import xfs;
import xfy;
import xga;
import xgm;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(xfr paramxfr) {}
  
  public void run()
  {
    Object localObject = (xfs)ampm.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((xfs)localObject).toString());
    }
    localObject = (xga)ampm.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (xfy)ampm.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    xgm.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */