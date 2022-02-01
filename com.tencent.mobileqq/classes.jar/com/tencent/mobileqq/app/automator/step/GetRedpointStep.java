package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.qphone.base.util.QLog;

public class GetRedpointStep
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetRedpointStep", 2, "GetRedpointStep");
    }
    if (BaseActivity.mAppForground) {
      ((IRedTouchServer)this.mAutomator.k.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(false, false, 1);
    }
    ((MedalWallMng)this.mAutomator.k.getManager(QQManagerFactory.MEDAL_WALL_MNG)).b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetRedpointStep
 * JD-Core Version:    0.7.0.1
 */