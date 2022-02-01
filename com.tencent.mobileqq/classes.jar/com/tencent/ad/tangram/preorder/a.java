package com.tencent.ad.tangram.preorder;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.msg_content;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import com.tencent.ad.tangram.util.b;
import com.tencent.ad.tangram.util.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

final class a
{
  public static final String CACHE_NAME = "cache";
  public static final String TAG = "AppPreOrderCache";
  private ConcurrentHashMap<String, AdAppPreOrderTask> pendingTaskMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<AdAppPreOrderTask> queue = new ConcurrentLinkedQueue();
  private String uin;
  
  private void appendTask(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if ((paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(paramContext)) && (getTaskById(paramAdAppPreOrderTask.taskId) == null) && (this.queue != null))
    {
      this.queue.offer(paramAdAppPreOrderTask);
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
  }
  
  private void appendTask(Context paramContext, ConcurrentHashMap<String, AdAppPreOrderTask> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)((Map.Entry)paramConcurrentHashMap.next()).getValue();
      if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.isValid(paramContext)) && (getTaskById(localAdAppPreOrderTask.taskId) == null) && (this.queue != null)) {
        this.queue.offer(localAdAppPreOrderTask);
      }
    }
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
  }
  
  private static ConcurrentLinkedQueue<AdAppPreOrderTask> prepare(ConcurrentLinkedQueue<AdAppPreOrderTask> paramConcurrentLinkedQueue)
  {
    if ((paramConcurrentLinkedQueue == null) || (paramConcurrentLinkedQueue.isEmpty())) {
      return paramConcurrentLinkedQueue;
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue(paramConcurrentLinkedQueue);
    paramConcurrentLinkedQueue = paramConcurrentLinkedQueue.iterator();
    AdAppPreOrderTask localAdAppPreOrderTask;
    while (paramConcurrentLinkedQueue.hasNext())
    {
      localAdAppPreOrderTask = (AdAppPreOrderTask)paramConcurrentLinkedQueue.next();
      if (localAdAppPreOrderTask == null)
      {
        localConcurrentLinkedQueue.remove(localAdAppPreOrderTask);
      }
      else if (localAdAppPreOrderTask.status == -1)
      {
        localConcurrentLinkedQueue.remove(localAdAppPreOrderTask);
      }
      else if (localAdAppPreOrderTask.status == 11)
      {
        localAdAppPreOrderTask = (AdAppPreOrderTask)localConcurrentLinkedQueue.remove();
        if (localAdAppPreOrderTask != null) {
          localConcurrentLinkedQueue.offer(localAdAppPreOrderTask);
        }
      }
    }
    paramConcurrentLinkedQueue = localConcurrentLinkedQueue.iterator();
    while (paramConcurrentLinkedQueue.hasNext())
    {
      localAdAppPreOrderTask = (AdAppPreOrderTask)paramConcurrentLinkedQueue.next();
      localAdAppPreOrderTask.isDownloadLaunched = false;
      if ((localAdAppPreOrderTask.status == 7) || (localAdAppPreOrderTask.status == 8)) {
        localAdAppPreOrderTask.status = 9;
      }
    }
    return localConcurrentLinkedQueue;
  }
  
  private static ConcurrentLinkedQueue<AdAppPreOrderTask> readFile(Context paramContext, String paramString)
  {
    paramString = b.fetchFileInDataDir(paramContext, d.md5(paramString, "UTF-8"));
    if (paramString.exists()) {
      paramContext = b.read(paramString);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramContext)) {
        AdLog.e("AppPreOrderCache", "readFile cacheContent isEmpty");
      }
      for (;;)
      {
        return null;
        File localFile = b.fetchFileInDataDir(paramContext, "cache");
        if (localFile.exists())
        {
          paramContext = b.read(localFile);
          boolean bool = localFile.renameTo(paramString);
          AdLog.i("AppPreOrderCache", "oldCacheFile.renameTo:" + bool);
          break;
          try
          {
            paramContext = (AdAppPreOrderTask[])[Lcom.tencent.ad.tangram.preorder.AdAppPreOrderTask.class.cast(AdJSON.toObject(new JSONArray(paramContext), [Lcom.tencent.ad.tangram.preorder.AdAppPreOrderTask.class));
            if ((paramContext != null) && (paramContext.length > 0)) {
              return new ConcurrentLinkedQueue(Arrays.asList(paramContext));
            }
          }
          catch (Throwable paramContext)
          {
            for (;;)
            {
              AdLog.e("AppPreOrderCache", "readFile", paramContext);
              paramContext = null;
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  private static void writeFile(Context paramContext, String paramString, ConcurrentLinkedQueue<AdAppPreOrderTask> paramConcurrentLinkedQueue)
  {
    if ((paramConcurrentLinkedQueue == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      paramString = b.fetchFileInDataDir(paramContext, d.md5(paramString, "UTF-8"));
      if (paramConcurrentLinkedQueue.isEmpty())
      {
        AdLog.e("AppPreOrderCache", "writeFile tasks.isEmpty() write new JSONArray().toString()");
        b.write(paramString, new JSONArray().toString());
        return;
      }
      paramContext = (AdAppPreOrderTask[])paramConcurrentLinkedQueue.toArray(new AdAppPreOrderTask[0]);
      try
      {
        paramContext = (JSONArray)JSONArray.class.cast(AdJSON.fromObject(paramContext));
        if ((paramContext == null) || (JSONObject.NULL.equals(paramContext)) || (paramContext.length() <= 0)) {
          continue;
        }
        b.write(paramString, paramContext.toString());
        return;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          AdLog.e("AppPreOrderCache", "writeFile", paramContext);
          paramContext = null;
        }
      }
    }
  }
  
  public boolean appendTaskWhenReceivedMsg(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean)
  {
    AdLog.i("AppPreOrderCache", String.format("appendTaskWhenReceivedMsg ready:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if ((paramAdAppPreOrderTask == null) || (!paramAdAppPreOrderTask.isValid(paramContext))) {
      AdLog.e("AppPreOrderCache", "appendTask failed task.isValid()!");
    }
    do
    {
      return false;
      if (paramBoolean) {
        break;
      }
    } while ((this.pendingTaskMap.containsKey(paramAdAppPreOrderTask.taskId)) && (this.pendingTaskMap.get(paramAdAppPreOrderTask.taskId) != null));
    this.pendingTaskMap.put(paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask);
    return false;
    if (getTaskById(paramAdAppPreOrderTask.taskId) != null)
    {
      AdLog.e("AppPreOrderCache", "appendTask failed already in queue!");
      return false;
    }
    appendTask(paramContext, paramAdAppPreOrderTask);
    return true;
  }
  
  public void clear()
  {
    this.uin = null;
    if (this.queue != null) {
      this.queue.clear();
    }
    if (this.pendingTaskMap != null) {
      this.pendingTaskMap.clear();
    }
  }
  
  public ConcurrentLinkedQueue<AdAppPreOrderTask> getQueue()
  {
    return this.queue;
  }
  
  public AdAppPreOrderTask getTaskById(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.queue.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.queue.iterator();
    while (localIterator.hasNext())
    {
      AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)localIterator.next();
      if (paramString.equals(localAdAppPreOrderTask.taskId)) {
        return localAdAppPreOrderTask;
      }
    }
    return null;
  }
  
  public List<AdAppPreOrderTask> getTasksByUrl(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.queue.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.queue.iterator();
    while (localIterator.hasNext())
    {
      AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)localIterator.next();
      if (paramString.equals(localAdAppPreOrderTask.content.ad_info.app_info.pkg_url)) {
        localArrayList.add(localAdAppPreOrderTask);
      }
    }
    return localArrayList;
  }
  
  public void init(Context paramContext, String paramString)
  {
    this.uin = paramString;
    ConcurrentLinkedQueue localConcurrentLinkedQueue = prepare(readFile(paramContext, paramString));
    if ((localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty()))
    {
      this.queue = localConcurrentLinkedQueue;
      writeFile(paramContext, paramString, this.queue);
    }
  }
  
  public void removeTask(AdAppPreOrderTask paramAdAppPreOrderTask)
  {
    if ((paramAdAppPreOrderTask != null) && (getTaskById(paramAdAppPreOrderTask.taskId) != null) && (this.queue != null))
    {
      this.queue.remove(paramAdAppPreOrderTask);
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = paramString.setStatus(paramInt);
      paramInt = i;
    } while (i <= 0);
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    return i;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt1, int paramInt2)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      paramInt1 = 0;
    }
    do
    {
      return paramInt1;
      paramInt2 = paramString.setStatus(paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    return paramInt2;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt1, int paramInt2, int paramInt3, AdAppPreOrderTask.a[] paramArrayOfa)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      return 0;
    }
    paramInt1 = paramString.setStatus(paramInt1);
    paramString.reminderSwichOnCount = paramInt2;
    paramString.reminderRescheduleCount = paramInt3;
    paramString.reminders = paramArrayOfa;
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    return paramInt1;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt, msg_content parammsg_content)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = paramString.setStatus(paramInt, parammsg_content);
      paramInt = i;
    } while (i <= 0);
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    return i;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = paramString.setStatus(paramInt, paramBoolean);
      paramInt = i;
    } while (i <= 0);
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    return i;
  }
  
  public void syncPendingTaskToCacheAndFile(Context paramContext)
  {
    if (this.pendingTaskMap.isEmpty()) {
      return;
    }
    appendTask(paramContext, this.pendingTaskMap);
    this.pendingTaskMap.clear();
  }
  
  public void writeCurrentIntoFile(Context paramContext)
  {
    if ((this.queue != null) && (!this.queue.isEmpty())) {
      writeFile(paramContext, this.uin, this.queue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.a
 * JD-Core Version:    0.7.0.1
 */