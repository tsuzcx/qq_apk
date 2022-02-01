package com.tencent.av.wtogether.util;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CallStatusClient
{
  private static volatile CallStatusClient jdField_a_of_type_ComTencentAvWtogetherUtilCallStatusClient = null;
  private static final String jdField_a_of_type_JavaLangString = CallStatusClient.class.getSimpleName();
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  private IQQServiceForAV jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  
  public static CallStatusClient a()
  {
    if (jdField_a_of_type_ComTencentAvWtogetherUtilCallStatusClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvWtogetherUtilCallStatusClient == null) {
        jdField_a_of_type_ComTencentAvWtogetherUtilCallStatusClient = new CallStatusClient();
      }
      return jdField_a_of_type_ComTencentAvWtogetherUtilCallStatusClient;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e();
      }
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void b()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "bindQQServiceForAV");
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
          this.jdField_a_of_type_AndroidContentServiceConnection = new CallStatusClient.1(this);
        }
        localContext.bindService(new Intent(localContext, QQServiceForAV.class), this.jdField_a_of_type_AndroidContentServiceConnection, 1);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "unbindQQServiceForAV");
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          localContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.util.CallStatusClient
 * JD-Core Version:    0.7.0.1
 */