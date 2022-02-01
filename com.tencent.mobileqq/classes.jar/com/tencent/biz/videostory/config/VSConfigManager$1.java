package com.tencent.biz.videostory.config;

import aavz;
import aawb;
import aawh;
import aawj;
import aawv;
import aqlk;
import com.tencent.qphone.base.util.QLog;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(aavz paramaavz) {}
  
  public void run()
  {
    Object localObject = (aawb)aqlk.a().a(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((aawb)localObject).toString());
    }
    localObject = (aawj)aqlk.a().a(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (aawh)aqlk.a().a(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    aawv.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */