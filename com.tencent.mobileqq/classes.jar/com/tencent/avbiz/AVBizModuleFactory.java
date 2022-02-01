package com.tencent.avbiz;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.HashMap;

public class AVBizModuleFactory
{
  private static final String jdField_a_of_type_JavaLangString = "AVBizModuleFactory";
  private static final HashMap<String, IModule> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static IModule a(String paramString)
  {
    try
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (!AVBizUtils.a(paramString))
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getModuleByName invalid business name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        paramString = new FakeModule(paramString);
        return paramString;
      }
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        localObject = b(paramString);
        jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("create module[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("]");
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
      }
      paramString = (IModule)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    try
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        localObject = (IModule)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (!"com.tencent.mobileqq".equals(AVBizUtils.a())) {
          QIPCClientHelper.getInstance().getClient().unRegisterModule((AVBizClientQIPCModule)localObject);
        }
        jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unRegisterModule[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("]");
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("module not register[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  private static IModule b(String paramString)
  {
    String str = AVBizUtils.a();
    if ("com.tencent.mobileqq".equals(str)) {
      return new AVBizQQProcessModule(paramString);
    }
    paramString = new AVBizClientQIPCModule(paramString, str);
    QIPCClientHelper.getInstance().getClient().registerModule(paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizModuleFactory
 * JD-Core Version:    0.7.0.1
 */