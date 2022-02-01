package com.tencent.mobileqq.app.automator.step;

import aocj;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public class GetRedpointStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetRedpointStep", 2, "GetRedpointStep");
    }
    ((aocj)this.a.app.getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER)).a(false, false, 1);
    ((MedalWallMng)this.a.app.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetRedpointStep
 * JD-Core Version:    0.7.0.1
 */