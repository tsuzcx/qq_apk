package com.tencent.biz.videostory.config;

import ampl;
import com.tencent.qphone.base.util.QLog;
import xfo;
import xfp;
import xfv;
import xfx;
import xgj;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(xfo paramxfo) {}
  
  public void run()
  {
    Object localObject = (xfp)ampl.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((xfp)localObject).toString());
    }
    localObject = (xfx)ampl.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (xfv)ampl.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    xgj.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */