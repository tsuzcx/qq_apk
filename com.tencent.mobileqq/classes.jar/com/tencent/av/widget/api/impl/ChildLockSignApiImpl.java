package com.tencent.av.widget.api.impl;

import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.widget.api.IChildLockSignApi;
import com.tencent.mobileqq.statistics.ReportController;

public class ChildLockSignApiImpl
  implements IChildLockSignApi
{
  public void handleSuccessMsg(Context paramContext)
  {
    try
    {
      Object localObject = (AVActivity)paramContext;
      paramContext = ((AVActivity)localObject).r();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).K;
      if (!paramContext.k().af)
      {
        paramContext.k().ag = true;
        ((DoubleVideoCtrlUI)localObject).e(true);
        ReportController.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return;
      }
      paramContext.k().ag = false;
      ((DoubleVideoCtrlUI)localObject).w();
      ReportController.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.widget.api.impl.ChildLockSignApiImpl
 * JD-Core Version:    0.7.0.1
 */