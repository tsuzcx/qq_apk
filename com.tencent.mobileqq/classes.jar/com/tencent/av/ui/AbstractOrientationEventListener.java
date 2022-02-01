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
    Object localObject;
    if (paramInt == -1)
    {
      this.jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChanged ORIENTATION_UNKNOWN. orientation: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", mLastOrientation: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("AbstractOrientationEventListener", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOrientationChanged. orientation: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mLastOrientation: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("AbstractOrientationEventListener", 2, ((StringBuilder)localObject).toString());
    }
    if (PhoneStatusTools.d())
    {
      if (paramInt == -2) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      j = 0;
      i = paramInt;
      paramInt = j;
    }
    else
    {
      i = 1;
    }
    if (this.jdField_a_of_type_Int < 0) {
      this.jdField_a_of_type_Int = 0;
    }
    int j = this.jdField_a_of_type_Int;
    if ((paramInt - j < 20) && (paramInt - j > -20) && (!this.jdField_a_of_type_Boolean) && (i != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("do nothing when orientation and mLastOrientation are too close. orientation: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", mLastOrientation: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("AbstractOrientationEventListener", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    int i = paramInt;
    if (this.b)
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiPadOrientationRotateChecker;
      boolean bool;
      if (localObject != null) {
        bool = ((PadOrientationRotateChecker)localObject).a();
      } else {
        bool = true;
      }
      j = paramInt;
      if (bool) {
        j = paramInt - 90;
      }
      i = j;
      if (j < 0) {
        i = j + 360;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = ConfigSystemImpl.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true);
    } else {
      paramInt = ConfigSystemImpl.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), false, false, (byte)0, true);
    }
    j = paramInt * 90;
    paramInt = j;
    if (j > 360) {
      paramInt = j % 360;
    }
    i -= paramInt;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 360;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt <= 314) && (paramInt >= 45))
    {
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
    a(0, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AbstractOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */