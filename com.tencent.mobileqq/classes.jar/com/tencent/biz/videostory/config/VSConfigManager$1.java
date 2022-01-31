package com.tencent.biz.videostory.config;

import aoks;
import com.tencent.qphone.base.util.QLog;
import yyw;
import yyx;
import yzd;
import yzf;
import yzr;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(yyw paramyyw) {}
  
  public void run()
  {
    Object localObject = (yyx)aoks.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((yyx)localObject).toString());
    }
    localObject = (yzf)aoks.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (yzd)aoks.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    yzr.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */