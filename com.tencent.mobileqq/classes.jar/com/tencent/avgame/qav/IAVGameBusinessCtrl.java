package com.tencent.avgame.qav;

import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class IAVGameBusinessCtrl
{
  private static IAVGameBusinessCtrl jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl;
  private static String jdField_a_of_type_JavaLangString = "IAVGameBusinessCtrl";
  
  public static IAVGameBusinessCtrl a()
  {
    if (jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl == null)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localAppRuntime instanceof IAVGameAppInterface)) {
        jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl = ((IAVGameAppInterface)localAppRuntime).a();
      }
    }
    return jdField_a_of_type_ComTencentAvgameQavIAVGameBusinessCtrl;
  }
  
  public static boolean f()
  {
    if (a() != null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "IAVGameBusinessCtrl = null");
    }
    return true;
  }
  
  public abstract int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, IAVGameBusinessCtrl.IOnEnterRoom paramIOnEnterRoom);
  
  public abstract IAVGameMediaPlayerCtrl a();
  
  public abstract AVGameSession a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(AVGameUIEventCallback paramAVGameUIEventCallback);
  
  public abstract void b(AVGameUIEventCallback paramAVGameUIEventCallback);
  
  abstract void c();
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.IAVGameBusinessCtrl
 * JD-Core Version:    0.7.0.1
 */