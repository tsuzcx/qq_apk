package com.tencent.avgame.qav;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class SecurityPolicyChecker
{
  private static SecurityPolicyChecker jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static SecurityPolicyChecker a()
  {
    if (jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker == null) {
        jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker = new SecurityPolicyChecker();
      }
      return jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker;
    }
    finally {}
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    Player localPlayer;
    if (paramEngineData != null)
    {
      int i = paramEngineData.a();
      if ((i != 0) && (i != 10))
      {
        localPlayer = paramEngineData.b();
        if ((localPlayer == null) || (!paramEngineData.b(localPlayer.uin))) {}
      }
    }
    for (paramEngineData = localPlayer.uin;; paramEngineData = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
      {
        bool1 = bool2;
        if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramEngineData)) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_JavaLangString = paramEngineData;
      if (bool1)
      {
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          this.jdField_a_of_type_JavaLangRunnable = new SecurityPolicyChecker.CheckCameraTask(null);
        }
        AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "setPlayer1, [" + this.jdField_a_of_type_JavaLangString + "," + bool1 + "]");
      }
      return;
    }
  }
  
  public void a(SecurityPolicyChecker.CheckSecurityPolicyCallback paramCheckSecurityPolicyCallback)
  {
    ThreadManager.excute(new SecurityPolicyChecker.1(this, new WeakReference(paramCheckSecurityPolicyCallback)), 16, null, false);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "setPlayer2, [" + this.jdField_a_of_type_JavaLangString + "-->" + paramString + "]");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Boolean) {
      bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, String.valueOf(paramLong));
    }
    return bool;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b(long paramLong)
  {
    return TextUtils.equals(this.jdField_a_of_type_JavaLangString, String.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker
 * JD-Core Version:    0.7.0.1
 */