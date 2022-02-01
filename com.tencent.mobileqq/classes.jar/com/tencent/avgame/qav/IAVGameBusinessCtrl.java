package com.tencent.avgame.qav;

import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class IAVGameBusinessCtrl
{
  private static IAVGameBusinessCtrl a;
  private static String b = "IAVGameBusinessCtrl";
  
  public static IAVGameBusinessCtrl p()
  {
    if (a == null)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localAppRuntime instanceof IAVGameAppInterface)) {
        a = ((IAVGameAppInterface)localAppRuntime).c();
      }
    }
    return a;
  }
  
  public static boolean q()
  {
    if (p() != null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "IAVGameBusinessCtrl = null");
    }
    return true;
  }
  
  public abstract int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IAVGameBusinessCtrl.IOnEnterRoom paramIOnEnterRoom);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(AVGameUIEventCallback paramAVGameUIEventCallback);
  
  public abstract void b(AVGameUIEventCallback paramAVGameUIEventCallback);
  
  public abstract boolean g();
  
  public abstract AVGameSession j();
  
  abstract void l();
  
  public abstract IAVGameMediaPlayerCtrl n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.IAVGameBusinessCtrl
 * JD-Core Version:    0.7.0.1
 */