package com.tencent.mobileqq.ar.arcore.huawei;

import com.tencent.mobileqq.ar.arcore.IArCoreNativeSoLoader;
import java.util.ArrayList;
import java.util.List;

public class HuaweiArCoreNativeSoLoader
  implements IArCoreNativeSoLoader
{
  private final String a = "huawei_arcore";
  private final String b = "huawei_arcore_arch64";
  private final String c = "v8.0.0";
  private final String d = "v8.2.0";
  private final String e = "md5_config.xml";
  private final ArrayList<String> f = new ArrayList();
  
  public HuaweiArCoreNativeSoLoader()
  {
    this.f.add("libarengine_api");
    this.f.add("libhuawei_arengine_impl");
    this.f.add("libhuawei_arengine_ndk");
    this.f.add("libhuawei_arengine_jni");
  }
  
  public String a()
  {
    return "huawei_arcore";
  }
  
  public String b()
  {
    return "v8.0.0";
  }
  
  public String c()
  {
    return "md5_config.xml";
  }
  
  public List<String> d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.huawei.HuaweiArCoreNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */