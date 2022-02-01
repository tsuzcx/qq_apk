package com.tencent.avgame.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class AvGameEntranceUtils
{
  public static String a = "AvGameEntranceUtil";
  
  public static boolean a()
  {
    if (StudyModeManager.a())
    {
      QLog.e(a, 2, "getStudyModeSwitch  ");
      return false;
    }
    if (!AvGameEntranceUtil.a())
    {
      QLog.e(a, 2, "is Surport Machine no!  ");
      return false;
    }
    boolean bool = AvGameConfigUtil.a().a();
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isShowInMsgPlusEntrance ");
    localStringBuilder.append(bool);
    QLog.d(str, 2, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    QBaseActivity localQBaseActivity;
    boolean bool1;
    int i;
    if ((paramActivity instanceof QBaseActivity))
    {
      localQBaseActivity = (QBaseActivity)paramActivity;
      bool1 = localQBaseActivity.isFinishing();
      i = 1;
    }
    else
    {
      localQBaseActivity = null;
      i = 0;
      bool1 = true;
    }
    BaseActivity localBaseActivity;
    boolean bool3;
    if ((paramActivity instanceof BaseActivity))
    {
      localBaseActivity = (BaseActivity)paramActivity;
      bool3 = localBaseActivity.isFinishing();
      i = 2;
    }
    else
    {
      localBaseActivity = null;
      bool3 = bool1;
    }
    if ((localQBaseActivity == null) && (localBaseActivity == null)) {
      return true;
    }
    if (localQBaseActivity != null)
    {
      if (localQBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (localQBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {}
    }
    else
    {
      for (;;)
      {
        bool4 = false;
        bool1 = bool2;
        bool2 = bool4;
        break label168;
        if (localBaseActivity == null) {
          break;
        }
        if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
      }
      bool1 = true;
    }
    boolean bool2 = true;
    label168:
    boolean bool4 = VideoController.a(paramActivity);
    if ((QLog.isDevelopLevel()) || (!bool1) || (!bool2) || (bool4))
    {
      paramActivity = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkQAVPermission, Camera[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], audio[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], activityType[");
      localStringBuilder.append(i);
      localStringBuilder.append("], isScreenLocked[");
      localStringBuilder.append(bool4);
      localStringBuilder.append("], isFinishing[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("]");
      QLog.w(paramActivity, 1, localStringBuilder.toString());
    }
    if ((bool1) && (bool2)) {
      return true;
    }
    if (bool4)
    {
      paramOnClickListener.onClick(null, -1);
      return false;
    }
    paramActivity = new AvGameEntranceUtils.2(paramOnClickListener);
    if ((!bool1) && (!bool2))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
      if (localQBaseActivity != null)
      {
        localQBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return false;
      }
      if (localBaseActivity != null)
      {
        localBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return false;
      }
    }
    else if (!bool1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
      if (localQBaseActivity != null)
      {
        localQBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
        return false;
      }
      if (localBaseActivity != null)
      {
        localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
        return false;
      }
    }
    else if (!bool2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
      if (localQBaseActivity != null)
      {
        localQBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
        return false;
      }
      if (localBaseActivity != null) {
        localBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
    return false;
  }
  
  public static boolean a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (paramQBaseActivity != null)
    {
      if (paramString == null) {
        return false;
      }
      Object localObject = (ITroopInfoService)paramQBaseActivity.getAppRuntime().getRuntimeService(ITroopInfoService.class, "");
      IAvGameManager localIAvGameManager = (IAvGameManager)paramQBaseActivity.getAppRuntime().getRuntimeService(IAvGameManager.class, "");
      if (localObject != null)
      {
        if (localIAvGameManager == null) {
          return false;
        }
        if (((QQAppInterface)paramQBaseActivity.getAppRuntime()).getAVNotifyCenter().b(paramQBaseActivity, paramString))
        {
          QQToast.a(paramQBaseActivity, 2131690404, 1).b(paramQBaseActivity.getResources().getDimensionPixelSize(2131299168));
          return true;
        }
        localObject = ((ITroopInfoService)localObject).findTroopInfoInUI(paramString);
        if (localObject != null)
        {
          if (((TroopInfo)localObject).isAdmin()) {
            return false;
          }
          if (localIAvGameManager.isOnlyAllowManagerCreateAVGame(paramString))
          {
            paramString = DialogUtil.a(paramQBaseActivity, 230);
            paramString.setMessage(paramQBaseActivity.getString(2131690317)).setPositiveButton(paramQBaseActivity.getString(2131690499), new AvGameEntranceUtils.1());
            paramString.show();
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameEntranceUtils
 * JD-Core Version:    0.7.0.1
 */