package com.tencent.av.widget.api.impl;

import android.content.Context;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.widget.api.IChildLockCircleApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ChildLockCircleApiImpl
  implements IChildLockCircleApi
{
  private static final String TAG = "ChildLockCircleApiImpl";
  
  public void handleAnimSuccessMsg(Context paramContext)
  {
    try
    {
      Object localObject = (AVActivity)paramContext;
      paramContext = ((AVActivity)localObject).r();
      localObject = (DoubleVideoCtrlUI)((AVActivity)localObject).K;
      boolean bool = paramContext.k().af;
      if (!bool)
      {
        paramContext.k().ag = true;
        ((DoubleVideoCtrlUI)localObject).e(true);
        paramContext.k().ah = 2;
        if (QLog.isColorLevel()) {
          QLog.e("ChildLockCircleApiImpl", 2, "[childLock] action lock");
        }
        ReportController.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return;
      }
      paramContext.k().ag = false;
      ((DoubleVideoCtrlUI)localObject).w();
      if (QLog.isColorLevel()) {
        QLog.e("ChildLockCircleApiImpl", 2, "[childLock] action unlock");
      }
      ReportController.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void onAnimationEnd()
  {
    TipsUtil.b((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onAnimationFailed(Context paramContext)
  {
    try
    {
      if (!((AVActivity)paramContext).r().k().af)
      {
        ReportController.b(null, "CliOper", "", "", "0X80061F8", "0X80061F8", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80061FA", "0X80061FA", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception paramContext)
    {
      AVLog.printErrorLog("ChildLockCircleApiImpl", paramContext.getMessage());
    }
  }
  
  public boolean onLockSuccess(Context paramContext)
  {
    paramContext = ((AVActivity)paramContext).r();
    if (paramContext != null)
    {
      paramContext.k().ah = 1;
      return true;
    }
    return false;
  }
  
  public void startChildLockAnimation()
  {
    TipsUtil.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public boolean updateText(Context paramContext)
  {
    return ((AVActivity)paramContext).r().k().af ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.widget.api.impl.ChildLockCircleApiImpl
 * JD-Core Version:    0.7.0.1
 */