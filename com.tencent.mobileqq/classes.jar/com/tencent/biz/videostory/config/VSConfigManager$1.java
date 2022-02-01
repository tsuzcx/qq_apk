package com.tencent.biz.videostory.config;

import apub;
import bgmv;
import com.tencent.qphone.base.util.QLog;
import zwp;
import zwv;
import zwx;
import zxj;

class VSConfigManager$1
  implements Runnable
{
  VSConfigManager$1(VSConfigManager paramVSConfigManager) {}
  
  public void run()
  {
    Object localObject = (zwp)apub.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((zwp)localObject).toString());
    }
    localObject = (zwx)apub.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (zwv)apub.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    localObject = (bgmv)apub.a().a(671);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSHealthConfigBean : " + localObject);
    }
    zxj.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */