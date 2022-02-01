package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.logic.TabDataHandler;

final class TabDataHelper$1
  implements Runnable
{
  TabDataHelper$1(AppInterface paramAppInterface) {}
  
  public void run()
  {
    ((TabDataHandler)this.val$app.getBusinessHandler(TabDataHandler.class.getName())).a("RIJ", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper.1
 * JD-Core Version:    0.7.0.1
 */