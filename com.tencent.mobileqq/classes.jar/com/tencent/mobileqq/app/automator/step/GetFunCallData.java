package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

public class GetFunCallData
  extends AsyncStep
{
  protected int doStep()
  {
    long l = VipFunCallUtil.a(this.mAutomator.k, 1, null).getLong("update_time", 0L);
    if ((System.currentTimeMillis() - l <= 14400000L) && (System.currentTimeMillis() >= l))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStep system time");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append(",last update time:");
        localStringBuilder.append(l);
        QLog.d("GetFunCallData", 2, localStringBuilder.toString());
      }
    }
    else
    {
      ((VipSetFunCallHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(1, new Bundle());
      if (QLog.isColorLevel()) {
        QLog.d("GetFunCallData", 2, "doStep SUB_CMD_GET_MY_FC.");
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetFunCallData
 * JD-Core Version:    0.7.0.1
 */