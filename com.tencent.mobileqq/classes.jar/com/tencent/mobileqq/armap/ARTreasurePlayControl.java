package com.tencent.mobileqq.armap;

import abjd;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class ARTreasurePlayControl
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  private boolean f;
  
  public ARTreasurePlayControl(Activity paramActivity, ARGLSurfaceView paramARGLSurfaceView, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView = paramARGLSurfaceView;
    this.jdField_b_of_type_Int = paramInt;
    this.e = a(paramActivity);
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 11) && (this.c)) {
      if (QLog.isColorLevel()) {
        QLog.i("ARTreasurePlayControl", 2, "caishen already found, ignore switching mode to : " + paramInt);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARTreasurePlayControl", 2, "switchMode to : " + paramInt);
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.runOnGlThread(new abjd(this, paramInt));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARTreasurePlayControl", 2, "switchMode to : " + paramInt + " fail.");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("ARTreasurePlayControl", 2, "already init mode, return");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Boolean) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("ARTreasurePlayControl", 2, "mode switch not ready, return");
          return;
          if (this.jdField_a_of_type_Int != -1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ARTreasurePlayControl", 2, "camera status unknown, return");
        return;
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        if ((paramBoolean) || (this.f))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ARTreasurePlayControl", 2, "camera fail or camera dialog already clicked, ignoreCameraFail:" + paramBoolean + ", mCameraFailDialogClicked:" + this.f);
          }
          a(14);
          this.jdField_b_of_type_Boolean = true;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ARTreasurePlayControl", 2, "camera fail do nothing, ignoreCameraFail:" + paramBoolean + ", mCameraFailDialogClicked:" + this.f);
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        if (!this.e)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ARTreasurePlayControl", 2, "sensor not support");
          }
          a(14);
          this.jdField_b_of_type_Boolean = true;
          return;
        }
        if ((this.jdField_b_of_type_Int != 6) && (this.jdField_b_of_type_Int != 7))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ARTreasurePlayControl", 2, "ignore finding caishen");
          }
          a(11);
          this.jdField_b_of_type_Boolean = true;
          return;
        }
        if (this.d)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ARTreasurePlayControl", 2, "find caishen already timeout");
          }
          a(11);
          this.jdField_b_of_type_Boolean = true;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ARTreasurePlayControl", 2, "try to find caishen");
        }
        a(10);
        this.jdField_b_of_type_Boolean = false;
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARTreasurePlayControl", 2, "initMode do nothing");
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (SensorManager)paramContext.getSystemService("sensor");
    paramContext = ((SensorManager)localObject).getDefaultSensor(11);
    Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
    localObject = ((SensorManager)localObject).getDefaultSensor(4);
    return (localSensor != null) && (localObject != null) && (paramContext != null) && (Build.VERSION.SDK_INT >= 9);
  }
  
  public void a()
  {
    this.f = true;
    a(true);
  }
  
  public void b()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARTreasurePlayControl
 * JD-Core Version:    0.7.0.1
 */