package com.tencent.biz.videostory.config;

import aogj;
import com.tencent.qphone.base.util.QLog;
import yuh;
import yui;
import yuo;
import yuq;
import yvc;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(yuh paramyuh) {}
  
  public void run()
  {
    Object localObject = (yui)aogj.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((yui)localObject).toString());
    }
    localObject = (yuq)aogj.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (yuo)aogj.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    yvc.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */