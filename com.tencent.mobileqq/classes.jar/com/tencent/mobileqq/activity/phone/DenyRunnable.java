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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private DenyRunnable.OnCancelAction jdField_a_of_type_ComTencentMobileqqActivityPhoneDenyRunnable$OnCancelAction = null;
  private final WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public DenyRunnable(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public DenyRunnable(Context paramContext, DenyRunnable.OnCancelAction paramOnCancelAction)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDenyRunnable$OnCancelAction = paramOnCancelAction;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqPermission: ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.i("DenyRunnable", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("defaultAction [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), localContext }));
    }
    if (localContext == null) {
      return;
    }
    if (!paramBoolean)
    {
      Intent localIntent = new Intent(localContext, GuideBindPhoneActivity.class);
      localIntent.putExtra("fromKeyForContactBind", this.jdField_a_of_type_Int);
      localContext.startActivity(localIntent);
    }
  }
  
  public void run()
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.jdField_a_of_type_Long;
    l2 -= l1;
    boolean bool;
    if ((l1 != 0L) && (Math.abs(l2) >= 800L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("run [%s, %s, %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(l2), Boolean.valueOf(bool) }));
    }
    DenyRunnable.OnCancelAction localOnCancelAction = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDenyRunnable$OnCancelAction;
    if (localOnCancelAction != null)
    {
      localOnCancelAction.onCancel((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), bool);
      return;
    }
    a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DenyRunnable
 * JD-Core Version:    0.7.0.1
 */