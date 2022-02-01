package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import aono;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import myk;
import myt;
import myu;
import mze;
import mzh;
import nad;
import nam;
import ngk;

public class GameActivityCenterCtrl
{
  private static GameActivityCenterCtrl jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl;
  private long jdField_a_of_type_Long;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private mzh jdField_a_of_type_Mzh;
  private nam jdField_a_of_type_Nam = new myu(this);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private Activity a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  private AVGameAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AVGameAppInterface)) {
      return (AVGameAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static GameActivityCenterCtrl a()
  {
    if (jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl == null) {
        jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl = new GameActivityCenterCtrl();
      }
      return jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl;
    }
    finally {}
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = a();
    long l = Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    boolean bool;
    if (!paramBoolean) {
      if (l > 5000L) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "requestActivityCenterData, needGetData[" + bool + "], force[" + paramBoolean + "], interval[" + l + "], appInterface[" + localObject + "]");
      }
      if ((localObject != null) && (bool))
      {
        ((AVGameAppInterface)localObject).addObserver(this.jdField_a_of_type_Nam, true);
        localObject = (nad)((AVGameAppInterface)localObject).a(1);
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ((nad)localObject).a();
        }
      }
      return;
      bool = false;
      continue;
      bool = paramBoolean;
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    if (!this.jdField_a_of_type_Boolean) {
      a(this.b);
    }
    this.b = false;
    this.jdField_a_of_type_Boolean = true;
    ngk.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "enterGameRoom, activity[" + paramActivity + "]");
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    paramActivity = a();
    if (paramActivity != null)
    {
      paramActivity.addObserver(this.jdField_a_of_type_Nam, true);
      paramActivity = (nad)paramActivity.a(1);
      if (paramActivity != null) {
        paramActivity.a(paramString);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "onShareGameSuc, playGameId[" + paramString + "]");
    }
  }
  
  public void b(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("GameACCtrl", 4, "leaveGameRoom, activity[" + paramActivity + "]");
    }
  }
  
  public void c(Activity paramActivity)
  {
    if (paramActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramActivity);
    }
    AVGameAppInterface localAVGameAppInterface = myk.a().a();
    String str2 = localAVGameAppInterface.getCurrentAccountUin();
    mze localmze = myk.a().a();
    long l;
    String str1;
    if (localmze != null)
    {
      l = localmze.a();
      str1 = localmze.a().getNick(str2);
    }
    for (int i = localmze.d();; i = 0)
    {
      aono.a().a(localAVGameAppInterface, l, Long.valueOf(str2).longValue(), str1, 3, "", i, new myt(this, str1));
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "openGameActivityCenter, ctx[" + paramActivity + "], entry[" + this.jdField_a_of_type_Mzh + "]");
      }
      return;
      l = 0L;
      str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl
 * JD-Core Version:    0.7.0.1
 */