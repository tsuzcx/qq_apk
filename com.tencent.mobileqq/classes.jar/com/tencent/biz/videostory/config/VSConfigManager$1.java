package com.tencent.biz.videostory.config;

import com.tencent.biz.videostory.config.processor.VSEntranceConfBean;
import com.tencent.biz.videostory.config.processor.VSStickyNoteConfBean;
import com.tencent.biz.videostory.config.processor.VSSubscribeConfBean;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.vashealth.VSHealthConfigBean;
import com.tencent.qphone.base.util.QLog;

class VSConfigManager$1
  implements Runnable
{
  VSConfigManager$1(VSConfigManager paramVSConfigManager) {}
  
  public void run()
  {
    Object localObject = (VSEntranceConfBean)QConfigManager.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((VSEntranceConfBean)localObject).toString());
    }
    localObject = (VSSubscribeConfBean)QConfigManager.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (VSStickyNoteConfBean)QConfigManager.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    localObject = (VSHealthConfigBean)QConfigManager.a().a(671);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSHealthConfigBean : " + localObject);
    }
    VSEntranceWidgetHelper.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */