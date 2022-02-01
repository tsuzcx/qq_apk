package com.tencent.biz.videostory.config;

import com.tencent.biz.videostory.config.processor.VSEntranceConfBean;
import com.tencent.biz.videostory.config.processor.VSStickyNoteConfBean;
import com.tencent.biz.videostory.config.processor.VSSubscribeConfBean;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

class VSConfigManager$1
  implements Runnable
{
  VSConfigManager$1(VSConfigManager paramVSConfigManager) {}
  
  public void run()
  {
    Object localObject = (VSEntranceConfBean)QConfigManager.b().b(411);
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init load conf:");
      localStringBuilder.append(((VSEntranceConfBean)localObject).toString());
      QLog.i("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    }
    localObject = (VSSubscribeConfBean)QConfigManager.b().b(463);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init load VSSubscribeConfBean : ");
      localStringBuilder.append(localObject);
      QLog.d("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    }
    localObject = (VSStickyNoteConfBean)QConfigManager.b().b(595);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init load VSStickyNoteConfBean : ");
      localStringBuilder.append(localObject);
      QLog.d("Q.videostory.config.VSConfigManager", 2, localStringBuilder.toString());
    }
    VSEntranceWidgetHelper.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */