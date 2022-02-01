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
  private boolean a;
  protected Context b;
  public boolean c = false;
  private int d = -25;
  private PadOrientationRotateChecker e;
  private AbstractOrientationEventListener.RotationObserver f;
  
  public AbstractOrientationEventListener(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = PhoneStatusTools.i(paramContext);
    if (this.a) {
      this.e = new PadOrientationRotateChecker();
    }
    this.f = new AbstractOrientationEventListener.RotationObserver(this, new Handler(Looper.getMainLooper()));
    this.f.a();
  }
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    Object localObject;
    if (paramInt == -1)
    {
      this.d = paramInt;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChanged ORIENTATION_UNKNOWN. orientation: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", mLastOrientation: ");
        ((StringBuilder)localObject).append(this.d);
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
      ((StringBuilder)localObject).append(this.d);
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
    if (this.d < 0) {
      this.d = 0;
    }
    int j = this.d;
    if ((paramInt - j < 20) && (paramInt - j > -20) && (!this.c) && (i != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("do nothing when orientation and mLastOrientation are too close. orientation: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", mLastOrientation: ");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("AbstractOrientationEventListener", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    int i = paramInt;
    if (this.a)
    {
      localObject = this.e;
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
    if (this.c) {
      paramInt = ConfigSystemImpl.a(this.b.getApplicationContext(), false, false, (byte)0, true);
    } else {
      paramInt = ConfigSystemImpl.b(this.b.getApplicationContext(), false, false, (byte)0, true);
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
    this.d = paramInt;
    if ((paramInt <= 314) && (paramInt >= 45))
    {
      if ((paramInt > 44) && (paramInt < 135))
      {
        a(90, this.c);
        return;
      }
      if ((paramInt > 134) && (paramInt < 225))
      {
        a(180, this.c);
        return;
      }
      a(270, this.c);
      return;
    }
    a(0, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AbstractOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */