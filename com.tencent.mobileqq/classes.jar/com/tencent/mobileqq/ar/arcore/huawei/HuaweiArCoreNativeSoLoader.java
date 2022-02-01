package com.tencent.mobileqq.ar.arcore.huawei;

import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import java.util.ArrayList;
import java.util.List;

public class HuaweiArCoreNativeSoLoader
  implements IArCoreNativeSoLoader
{
  private final String jdField_a_of_type_JavaLangString = "huawei_arcore";
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final String b = "huawei_arcore_arch64";
  private final String c = "v8.0.0";
  private final String d = "v8.2.0";
  private final String e = "md5_config.xml";
  
  public HuaweiArCoreNativeSoLoader()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add("libarengine_api");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_impl");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_ndk");
    this.jdField_a_of_type_JavaUtilArrayList.add("libhuawei_arengine_jni");
  }
  
  public String a()
  {
    return "huawei_arcore";
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String b()
  {
    return "v8.0.0";
  }
  
  public String c()
  {
    return "md5_config.xml";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.huawei.HuaweiArCoreNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */