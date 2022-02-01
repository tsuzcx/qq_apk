package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import anha;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import mzl;
import mzu;
import mzv;
import naf;
import nai;
import nbe;
import nbn;
import nht;

public class GameActivityCenterCtrl
{
  private static GameActivityCenterCtrl jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl;
  private long jdField_a_of_type_Long;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private nai jdField_a_of_type_Nai;
  private nbn jdField_a_of_type_Nbn = new mzv(this);
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
        ((AVGameAppInterface)localObject).addObserver(this.jdField_a_of_type_Nbn, true);
        localObject = (nbe)((AVGameAppInterface)localObject).a(1);
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ((nbe)localObject).a();
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
    nht.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
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
      paramActivity.addObserver(this.jdField_a_of_type_Nbn, true);
      paramActivity = (nbe)paramActivity.a(1);
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
    AVGameAppInterface localAVGameAppInterface = mzl.a().a();
    String str2 = localAVGameAppInterface.getCurrentAccountUin();
    naf localnaf = mzl.a().a();
    long l;
    String str1;
    if (localnaf != null)
    {
      l = localnaf.a();
      str1 = localnaf.a().getNick(str2);
    }
    for (int i = localnaf.d();; i = 0)
    {
      anha.a().a(localAVGameAppInterface, l, Long.valueOf(str2).longValue(), str1, 3, "", i, new mzu(this, str1));
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "openGameActivityCenter, ctx[" + paramActivity + "], entry[" + this.jdField_a_of_type_Nai + "]");
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