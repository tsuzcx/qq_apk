package com.tencent.avbiz;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.util.HashMap;

public class AVBizModuleFactory
{
  private static final String TAG = "AVBizModuleFactory";
  private static final HashMap<String, IModule> sModuleMap = new HashMap();
  
  private static IModule createModuleByName(String paramString)
  {
    String str = AVBizUtils.getProcessName();
    if ((!"默认".equals(paramString)) && (!"默认相机".equals(paramString)) && (!"默认音频".equals(paramString)))
    {
      if ("com.tencent.mobileqq".equals(str)) {
        return new AVBizQQProcessModule(paramString);
      }
      paramString = new AVBizClientQIPCModule(paramString, str);
      QIPCClientHelper.getInstance().getClient().registerModule(paramString);
      return paramString;
    }
    return new DefaultModule(paramString, str);
  }
  
  public static IModule getModuleByName(String paramString)
  {
    try
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (!AVBizUtils.isValid(paramString))
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getModuleByName invalid business name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        paramString = new FakeModule(paramString);
        return paramString;
      }
      if (!sModuleMap.containsKey(paramString))
      {
        localObject = createModuleByName(paramString);
        sModuleMap.put(paramString, localObject);
        if (QLog.isColorLevel())
        {
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("create module[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("]");
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
      }
      paramString = (IModule)sModuleMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public static void removeModuleByName(String paramString)
  {
    try
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (sModuleMap.containsKey(paramString))
      {
        localObject = (IModule)sModuleMap.get(paramString);
        if (!"com.tencent.mobileqq".equals(AVBizUtils.getProcessName())) {
          QIPCClientHelper.getInstance().getClient().unRegisterModule((AVBizClientQIPCModule)localObject);
        }
        sModuleMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unRegisterModule[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("]");
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = TAG;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizModuleFactory
 * JD-Core Version:    0.7.0.1
 */