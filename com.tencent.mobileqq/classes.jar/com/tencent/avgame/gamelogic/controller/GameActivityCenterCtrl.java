package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import aojq;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import nfc;
import nfl;
import nfm;
import nfv;
import nfy;
import ngu;
import nhd;
import nom;

public class GameActivityCenterCtrl
{
  private static GameActivityCenterCtrl jdField_a_of_type_ComTencentAvgameGamelogicControllerGameActivityCenterCtrl;
  private long jdField_a_of_type_Long;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  private nfy jdField_a_of_type_Nfy;
  private nhd jdField_a_of_type_Nhd = new nfm(this);
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
        ((AVGameAppInterface)localObject).addObserver(this.jdField_a_of_type_Nhd, true);
        localObject = (ngu)((AVGameAppInterface)localObject).a(1);
        if (localObject != null)
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          ((ngu)localObject).a();
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
    nom.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
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
      paramActivity.addObserver(this.jdField_a_of_type_Nhd, true);
      paramActivity = (ngu)paramActivity.a(1);
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
    AVGameAppInterface localAVGameAppInterface = nfc.a().a();
    String str2 = localAVGameAppInterface.getCurrentAccountUin();
    nfv localnfv = nfc.a().a();
    long l;
    String str1;
    if (localnfv != null)
    {
      l = localnfv.a();
      str1 = localnfv.a().getNick(str2);
    }
    for (int i = localnfv.d();; i = 0)
    {
      aojq.a().a(localAVGameAppInterface, l, Long.valueOf(str2).longValue(), str1, 3, "", i, new nfl(this, str1));
      if (QLog.isColorLevel()) {
        QLog.i("GameACCtrl", 2, "openGameActivityCenter, ctx[" + paramActivity + "], entry[" + this.jdField_a_of_type_Nfy + "]");
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