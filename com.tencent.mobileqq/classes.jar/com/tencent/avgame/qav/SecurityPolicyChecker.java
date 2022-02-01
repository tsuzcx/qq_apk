package com.tencent.avgame.qav;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import myc;
import nel;
import neq;

public class SecurityPolicyChecker
{
  private static SecurityPolicyChecker jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
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
  
  public void a(myc parammyc, String paramString)
  {
    Player localPlayer;
    if (parammyc != null)
    {
      int i = parammyc.a();
      if ((i != 0) && (i != 10))
      {
        localPlayer = parammyc.b();
        if ((localPlayer == null) || (!parammyc.b(localPlayer.uin))) {}
      }
    }
    for (parammyc = localPlayer.uin;; parammyc = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
      {
        bool1 = bool2;
        if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, parammyc)) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_JavaLangString = parammyc;
      if (bool1)
      {
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          this.jdField_a_of_type_JavaLangRunnable = new SecurityPolicyChecker.CheckCameraTask(null);
        }
        neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPolicyChecker", 2, "setPlayer1, [" + this.jdField_a_of_type_JavaLangString + "," + bool1 + "]");
      }
      return;
    }
  }
  
  public void a(nel paramnel)
  {
    ThreadManager.excute(new SecurityPolicyChecker.1(this, new WeakReference(paramnel)), 16, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker
 * JD-Core Version:    0.7.0.1
 */