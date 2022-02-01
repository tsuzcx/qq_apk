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
      paramContext = ((AVActivity)localObject).a();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).a;
      if (!paramContext.a().w)
      {
        paramContext.a().x = true;
        ((DoubleVideoCtrlUI)localObject).e(true);
        ReportController.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return;
      }
      paramContext.a().x = false;
      ((DoubleVideoCtrlUI)localObject).s();
      ReportController.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.widget.api.impl.ChildLockSignApiImpl
 * JD-Core Version:    0.7.0.1
 */