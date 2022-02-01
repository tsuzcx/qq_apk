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
  private static SecurityPolicyChecker a;
  private boolean b = false;
  private boolean c = false;
  private String d = null;
  private Runnable e = null;
  
  public static SecurityPolicyChecker a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new SecurityPolicyChecker();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(EngineData paramEngineData, String paramString)
  {
    if (paramEngineData != null)
    {
      int i = paramEngineData.j();
      if ((i != 0) && (i != 10))
      {
        Player localPlayer = paramEngineData.r();
        if ((localPlayer != null) && (paramEngineData.d(localPlayer.uin)))
        {
          paramEngineData = localPlayer.uin;
          break label53;
        }
      }
    }
    paramEngineData = null;
    label53:
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (TextUtils.equals(this.d, paramString))
    {
      bool1 = bool2;
      if (!TextUtils.equals(this.d, paramEngineData)) {
        bool1 = true;
      }
    }
    this.d = paramEngineData;
    if (bool1)
    {
      if (this.e == null) {
        this.e = new SecurityPolicyChecker.CheckCameraTask(null);
      }
      AVGameHandler.a().c().postDelayed(this.e, 1000L);
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("setPlayer1, [");
      paramEngineData.append(this.d);
      paramEngineData.append(",");
      paramEngineData.append(bool1);
      paramEngineData.append("]");
      QLog.i("SecurityPolicyChecker", 2, paramEngineData.toString());
    }
  }
  
  public void a(SecurityPolicyChecker.CheckSecurityPolicyCallback paramCheckSecurityPolicyCallback)
  {
    ThreadManager.excute(new SecurityPolicyChecker.1(this, new WeakReference(paramCheckSecurityPolicyCallback)), 16, null, false);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.d, paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPlayer2, [");
        localStringBuilder.append(this.d);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("SecurityPolicyChecker", 2, localStringBuilder.toString());
      }
      this.d = paramString;
    }
  }
  
  public boolean a(long paramLong)
  {
    if (this.b) {
      return TextUtils.equals(this.d, String.valueOf(paramLong));
    }
    return true;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public boolean b(long paramLong)
  {
    return TextUtils.equals(this.d, String.valueOf(paramLong));
  }
  
  public boolean c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.SecurityPolicyChecker
 * JD-Core Version:    0.7.0.1
 */