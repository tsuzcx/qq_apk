package com.qflutter.superchannel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SuperChannelTask
{
  private static final String KEY_COMMAND = "command";
  private static final String KEY_MODULE = "module";
  private static final String KEY_TASK_ID = "task_id";
  public static final String TAG = "SuperChannelTask";
  private final Map arguments;
  private WeakReference<ITaskCallback> callbackWeakReference;
  private final String command;
  private final String module;
  private SuperChannelResult result;
  private final String taskId;
  
  SuperChannelTask(String paramString1, String paramString2, String paramString3, Map paramMap)
  {
    this.taskId = paramString1;
    this.module = paramString2;
    this.command = paramString3;
    this.arguments = paramMap;
  }
  
  static SuperChannelTask fromMap(Map paramMap)
  {
    if (!paramMap.containsKey("task_id"))
    {
      SuperChannelLog.w("SuperChannelTask", "[fromMap] invalid task_id");
      return null;
    }
    if (!paramMap.containsKey("module"))
    {
      SuperChannelLog.w("SuperChannelTask", "[fromMap] invalid module");
      return null;
    }
    if (!paramMap.containsKey("command"))
    {
      SuperChannelLog.w("SuperChannelTask", "[fromMap] invalid command");
      return null;
    }
    return new SuperChannelTask(String.valueOf(paramMap.remove("task_id")), String.valueOf(paramMap.remove("module")), String.valueOf(paramMap.remove("command")), paramMap);
  }
  
  void attachCallback(ITaskCallback paramITaskCallback)
  {
    this.callbackWeakReference = new WeakReference(paramITaskCallback);
  }
  
  public Map encode()
  {
    if (this.result != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("task_id", this.taskId);
      localHashMap.putAll(this.result.encode());
      return localHashMap;
    }
    throw new IllegalStateException("this task has no result yet, please call setResult first");
  }
  
  public Map getArguments()
  {
    return this.arguments;
  }
  
  public String getCommand()
  {
    return this.command;
  }
  
  public String getModuleName()
  {
    return this.module;
  }
  
  String getTaskId()
  {
    return this.taskId;
  }
  
  public void send()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(encode());
    localObject1 = SuperChannelUtils.encodeTaskResults((List)localObject1);
    if (SuperChannelLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[send] map=");
      ((StringBuilder)localObject2).append(localObject1);
      SuperChannelLog.d("SuperChannelTask", ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.callbackWeakReference;
    if (localObject2 == null)
    {
      SuperChannelLog.e("SuperChannelTask", "[send] this task has no attached event callback");
      return;
    }
    localObject2 = (ITaskCallback)((WeakReference)localObject2).get();
    if (localObject2 == null)
    {
      SuperChannelLog.w("SuperChannelTask", "[send] the attached event callback has released");
      return;
    }
    ((ITaskCallback)localObject2).sendTask((Map)localObject1);
  }
  
  public void send(SuperChannelResult paramSuperChannelResult)
  {
    setResult(paramSuperChannelResult);
    send();
  }
  
  public void setResult(SuperChannelResult paramSuperChannelResult)
  {
    this.result = paramSuperChannelResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperChannelTask{taskId='");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", module='");
    localStringBuilder.append(this.module);
    localStringBuilder.append('\'');
    localStringBuilder.append(", command='");
    localStringBuilder.append(this.command);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arguments=");
    localStringBuilder.append(this.arguments);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.superchannel.SuperChannelTask
 * JD-Core Version:    0.7.0.1
 */