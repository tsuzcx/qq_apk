package com.tencent.mobileqq.activity.phone;

import agjv;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DenyRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private agjv jdField_a_of_type_Agjv;
  private final WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public DenyRunnable(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public DenyRunnable(Context paramContext, agjv paramagjv)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Agjv = paramagjv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, "onReqPermission: " + this.jdField_a_of_type_Long);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.i("DenyRunnable", 2, String.format("defaultAction [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), localContext }));
    }
    if (localContext == null) {}
    while (paramBoolean) {
      return;
    }
    Intent localIntent = new Intent(localContext, GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", this.jdField_a_of_type_Int);
    localContext.startActivity(localIntent);
  }
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Long == 0L) || (Math.abs(l) < 800L)) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DenyRunnable", 2, String.format("run [%s, %s, %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(l), Boolean.valueOf(bool) }));
      }
      if (this.jdField_a_of_type_Agjv != null)
      {
        this.jdField_a_of_type_Agjv.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), bool);
        return;
      }
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DenyRunnable
 * JD-Core Version:    0.7.0.1
 */