package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AVBizQQProcessModule
  implements IModule, IModule.FocusChangeListener
{
  private static String jdField_a_of_type_JavaLangString = "AVBizQQProcessModule";
  private WeakReference<IModule.FocusChangeListener> jdField_a_of_type_MqqUtilWeakReference = new WeakReference(null);
  private final String b;
  
  AVBizQQProcessModule(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.b = paramString;
  }
  
  public String a()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module requestAVFocus, name[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], processName[");
      localStringBuilder.append("com.tencent.mobileqq");
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.a().a(this.b, "com.tencent.mobileqq");
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module abandonAVFocus, name[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    AVBizPriorityManager.a().a(this.b);
  }
  
  public void a(IModule.FocusChangeListener paramFocusChangeListener)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramFocusChangeListener);
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("module checkAVFocus, name[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return AVBizPriorityManager.a().a(this.b);
  }
  
  public void b()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.b();
    }
  }
  
  public void c()
  {
    IModule.FocusChangeListener localFocusChangeListener = (IModule.FocusChangeListener)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localFocusChangeListener != null) {
      localFocusChangeListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizQQProcessModule
 * JD-Core Version:    0.7.0.1
 */