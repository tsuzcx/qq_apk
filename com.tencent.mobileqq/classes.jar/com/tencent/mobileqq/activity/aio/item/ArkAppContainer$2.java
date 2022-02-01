package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.qphone.base.util.QLog;

class ArkAppContainer$2
  implements Runnable
{
  ArkAppContainer$2(ArkAppContainer paramArkAppContainer, ArkAppMgr.AppPathInfo paramAppPathInfo) {}
  
  public void run()
  {
    this.this$0.f.getAppFromLocal = true;
    this.this$0.f.endOfGetApp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.ArkAppContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
    }
    this.this$0.a(this.a.path, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.2
 * JD-Core Version:    0.7.0.1
 */