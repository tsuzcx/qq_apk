package com.tencent.av.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.qphone.base.util.QLog;

public abstract class AbstractOrientationEventListener
  extends OrientationEventListener
{
  private int jdField_a_of_type_Int = -25;
  protected Context a;
  private AbstractOrientationEventListener.RotationObserver jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener$RotationObserver;
  private PadOrientationRotateChecker jdField_a_of_type_ComTencentAvUiPadOrientationRotateChecker;
  public boolean a;
  private boolean b;
  
  public AbstractOrientationEventListener(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = PhoneStatusTools.g(paramContext);
    if (this.b) {
      this.jdField_a_of_type_ComTencentAvUiPadOrientationRotateChecker = new PadOrientationRotateChecker();
    }
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener$RotationObserver = new AbstractOrientationEventListener.RotationObserver(this, new Handler(Looper.getMainLooper()));
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener$RotationObserver.a();
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("AbstractOrientationEventListener", 2, "onOrientationChanged ORIENTATION_UNKNOWN. orientation: " + paramInt + ", mLastOrientation: " + this.jdField_a_of_type_Int);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractOrientationEventListener", 2, "onOrientationChanged. orientation: " + paramInt + ", mLastOrientation: " + this.jdField_a_of_type_Int);
    }
    int i;
    if (PhoneStatusTools.d()) {
      if (paramInt == -2)
      {
        i = 0;
        label111:
        if (QLog.isColorLevel()) {
          QLog.d("AbstractOrientationEventListener", 2, "onOrientationChanged returns 0 rotation when auto rotate disabled. orientation: " + 0 + ", mLastOrientation: " + this.jdField_a_of_type_Int);
        }
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
      if ((paramInt - this.jdField_a_of_type_Int < 20) && (paramInt - this.jdField_a_of_type_Int > -20) && (!this.jdField_a_of_type_Boolean) && (i != 0))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AbstractOrientationEventListener", 2, "do nothing when orientation and mLastOrientation are too close. orientation: " + paramInt + ", mLastOrientation: " + this.jdField_a_of_type_Int);
        return;
      }
      i = paramInt;
      if (this.b) {
        if (this.jdField_a_of_type_ComTencentAvUiPadOrientationRotateChecker == null) {
          break label461;
        }
      }
      label461:
      for (boolean bool = this.jdField_a_of_type_ComTencentAvUiPadOrientationRotateChecker.a();; bool = true)
      {
        int j = paramInt;
        if (bool) {
          j = paramInt - 90;
        }
        i = j;
        if (j < 0) {
          i = j + 360;
        }
        if (this.jdField_a_of_type_Boolean) {}
        for (paramInt = ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90;; paramInt = ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true) * 90)
        {
          j = paramInt;
          if (paramInt > 360) {
            j = paramInt % 360;
          }
          i -= j;
          paramInt = i;
          if (i < 0) {
            paramInt = i + 360;
          }
          this.jdField_a_of_type_Int = paramInt;
          if ((paramInt <= 314) && (paramInt >= 45)) {
            break;
          }
          a(0, this.jdField_a_of_type_Boolean);
          return;
        }
        if ((paramInt > 44) && (paramInt < 135))
        {
          a(90, this.jdField_a_of_type_Boolean);
          return;
        }
        if ((paramInt > 134) && (paramInt < 225))
        {
          a(180, this.jdField_a_of_type_Boolean);
          return;
        }
        a(270, this.jdField_a_of_type_Boolean);
        return;
      }
      i = 1;
      break label111;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AbstractOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */