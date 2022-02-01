package com.tencent.av;

import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public class QavABTestUtils
{
  public static boolean a()
  {
    boolean bool = false;
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_qav_zimu_entrance_1215");
    localExpEntityInfo.a();
    if (localExpEntityInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("exp_qav", 2, "experiment, hide zimu");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!localExpEntityInfo.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("exp_qav", 2, "contrast, show zimu");
      return false;
    } while (!QLog.isColorLevel());
    QLog.i("exp_qav", 2, "default, show zimu");
    return false;
  }
  
  public static boolean b()
  {
    boolean bool = false;
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_qav_redbag_entrance_1215");
    localExpEntityInfo.a();
    if (localExpEntityInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("exp_qav", 2, "experiment, hide redbag");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!localExpEntityInfo.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("exp_qav", 2, "contrast, show redbag");
      return false;
    } while (!QLog.isColorLevel());
    QLog.i("exp_qav", 2, "default, show redbag");
    return false;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_qav_record_entrance_1215");
    localExpEntityInfo.a();
    if (localExpEntityInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("exp_qav", 2, "experiment, hide record");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!localExpEntityInfo.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("exp_qav", 2, "contrast, show record");
      return false;
    } while (!QLog.isColorLevel());
    QLog.i("exp_qav", 2, "default, show record");
    return false;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_qav_shoot_entrance_1215");
    localExpEntityInfo.a();
    if (localExpEntityInfo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("exp_qav", 2, "experiment, hide interact video");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!localExpEntityInfo.b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("exp_qav", 2, "contrast, show interact video");
      return false;
    } while (!QLog.isColorLevel());
    QLog.i("exp_qav", 2, "default, show interact video");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.QavABTestUtils
 * JD-Core Version:    0.7.0.1
 */