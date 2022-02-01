package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

class FakeModule
  implements IModule, IModule.FocusChangeListener
{
  private static String jdField_a_of_type_JavaLangString = "FakeModule";
  private final HashMap<Long, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final String b;
  
  FakeModule(String paramString)
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
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module requestAVFocus, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return "";
  }
  
  public void a()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module abandonAVFocus, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
  }
  
  public void a(IModule.FocusChangeListener paramFocusChangeListener)
  {
    paramFocusChangeListener = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module setListener, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(paramFocusChangeListener, 1, localStringBuilder.toString());
  }
  
  public String b()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module checkAVFocus, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
    return "";
  }
  
  public void b()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module onFocusLoss, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake module onFocusGain, name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.e(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.FakeModule
 * JD-Core Version:    0.7.0.1
 */