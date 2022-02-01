package com.huawei.updatesdk.a.b.d;

import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.service.appmgr.bean.b;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static Map<String, Class> a = new HashMap();
  
  static
  {
    a.put("client.updateCheck", b.class);
  }
  
  public static d a(String paramString)
  {
    Class localClass = (Class)a.get(paramString);
    if (localClass == null) {
      throw new InstantiationException("ResponseBean class not found, method:" + paramString);
    }
    return (d)localClass.newInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */