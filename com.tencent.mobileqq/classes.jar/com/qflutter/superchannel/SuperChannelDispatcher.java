package com.qflutter.superchannel;

import io.flutter.plugin.common.MethodChannel.Result;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class SuperChannelDispatcher
{
  public static final String TAG = "SuperChannelDispatcher";
  
  private Map encodeResultTasks(List<SuperChannelTask> paramList)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((List)localObject).add(((SuperChannelTask)paramList.next()).encode());
    }
    paramList = SuperChannelUtils.encodeTaskResults((List)localObject);
    if (SuperChannelLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[encodeResultTasks] map=");
      ((StringBuilder)localObject).append(paramList);
      SuperChannelLog.d("SuperChannelDispatcher", ((StringBuilder)localObject).toString());
    }
    return paramList;
  }
  
  public static SuperChannelDispatcher getInstance()
  {
    return SuperChannelDispatcher.SingleHolder.INSTANCE;
  }
  
  void dispatch(List<SuperChannelTask> paramList, MethodChannel.Result paramResult)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SuperChannelTask localSuperChannelTask = (SuperChannelTask)paramList.next();
      if (SuperChannelLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[dispatch] task=");
        ((StringBuilder)localObject).append(localSuperChannelTask.toString());
        SuperChannelLog.d("SuperChannelDispatcher", ((StringBuilder)localObject).toString());
      }
      Object localObject = ModuleService.getInstance().getModule(localSuperChannelTask.getModuleName());
      if (localObject == null)
      {
        SuperChannelLog.w("SuperChannelDispatcher", "[dispatch] invalid module");
      }
      else
      {
        localObject = ((IModule)localObject).handleTask(localSuperChannelTask);
        if (localObject != null)
        {
          if (SuperChannelLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[dispatch] result=");
            localStringBuilder.append(((SuperChannelResult)localObject).toString());
            SuperChannelLog.d("SuperChannelDispatcher", localStringBuilder.toString());
          }
          localSuperChannelTask.setResult((SuperChannelResult)localObject);
          localArrayList.add(localSuperChannelTask);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      paramResult.success(encodeResultTasks(localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelDispatcher
 * JD-Core Version:    0.7.0.1
 */