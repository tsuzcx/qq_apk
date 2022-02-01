package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.phonecontact.permission.IReqPermissionRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DenyRunnable
  implements IReqPermissionRunnable
{
  private final WeakReference<Context> a;
  private long b = 0L;
  private DenyRunnable.OnCancelAction c = null;
  private int d = 0;
  
  public DenyRunnable(Context paramContext, int paramInt)
  {
    this.a = new WeakReference(paramContext);
    this.d = paramInt;
  }
  
  public DenyRunnable(Context paramContext, DenyRunnable.OnCancelAction paramOnCancelAction)
  {
    this.a = new WeakReference(paramContext);
    this.c = paramOnCancelAction;
  }
  
  public void a()
  {
    this.b = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqPermission: ");
      localStringBuilder.append(this.b);
      QLog.i("DenyRunnable", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Context localContext = (Context)this.a.get();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("defaultAction [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), localContext }));
    }
    if (localContext == null) {
      return;
    }
    if (!paramBoolean)
    {
      Intent localIntent = new Intent(localContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", this.d);
      localContext.startActivity(localIntent);
    }
  }
  
  public void run()
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.b;
    l2 -= l1;
    boolean bool;
    if ((l1 != 0L) && (Math.abs(l2) >= 800L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("run [%s, %s, %s]", new Object[] { Long.valueOf(this.b), Long.valueOf(l2), Boolean.valueOf(bool) }));
    }
    DenyRunnable.OnCancelAction localOnCancelAction = this.c;
    if (localOnCancelAction != null)
    {
      localOnCancelAction.onCancel((Context)this.a.get(), bool);
      return;
    }
    a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DenyRunnable
 * JD-Core Version:    0.7.0.1
 */