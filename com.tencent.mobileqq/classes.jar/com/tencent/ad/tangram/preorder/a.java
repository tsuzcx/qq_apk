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
    if ((paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(paramContext)) && (getTaskById(paramAdAppPreOrderTask.taskId) == null))
    {
      paramContext = this.queue;
      if (paramContext != null)
      {
        paramContext.offer(paramAdAppPreOrderTask);
        writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
      }
    }
  }
  
  private void appendTask(Context paramContext, ConcurrentHashMap<String, AdAppPreOrderTask> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      AdAppPreOrderTask localAdAppPreOrderTask = (AdAppPreOrderTask)((Map.Entry)paramConcurrentHashMap.next()).getValue();
      if ((localAdAppPreOrderTask != null) && (localAdAppPreOrderTask.isValid(paramContext)) && (getTaskById(localAdAppPreOrderTask.taskId) == null))
      {
        ConcurrentLinkedQueue localConcurrentLinkedQueue = this.queue;
        if (localConcurrentLinkedQueue != null) {
          localConcurrentLinkedQueue.offer(localAdAppPreOrderTask);
        }
      }
    }
    writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
  }
  
  private static ConcurrentLinkedQueue<AdAppPreOrderTask> prepare(ConcurrentLinkedQueue<AdAppPreOrderTask> paramConcurrentLinkedQueue)
  {
    if (paramConcurrentLinkedQueue != null)
    {
      if (paramConcurrentLinkedQueue.isEmpty()) {
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
    return paramConcurrentLinkedQueue;
  }
  
  private static ConcurrentLinkedQueue<AdAppPreOrderTask> readFile(Context paramContext, String paramString)
  {
    paramString = b.fetchFileInDataDir(paramContext, d.md5(paramString, "UTF-8"));
    if (paramString.exists())
    {
      paramContext = b.read(paramString);
    }
    else
    {
      File localFile = b.fetchFileInDataDir(paramContext, "cache");
      if (localFile.exists())
      {
        paramContext = b.read(localFile);
        boolean bool = localFile.renameTo(paramString);
        paramString = new StringBuilder();
        paramString.append("oldCacheFile.renameTo:");
        paramString.append(bool);
        AdLog.i("AppPreOrderCache", paramString.toString());
      }
      else
      {
        paramContext = null;
      }
    }
    if (TextUtils.isEmpty(paramContext))
    {
      AdLog.e("AppPreOrderCache", "readFile cacheContent isEmpty");
      return null;
    }
    try
    {
      paramContext = (AdAppPreOrderTask[])[Lcom.tencent.ad.tangram.preorder.AdAppPreOrderTask.class.cast(AdJSON.toObject(new JSONArray(paramContext), [Lcom.tencent.ad.tangram.preorder.AdAppPreOrderTask.class));
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AppPreOrderCache", "readFile", paramContext);
      paramContext = null;
    }
    if (paramContext != null)
    {
      if (paramContext.length <= 0) {
        return null;
      }
      return new ConcurrentLinkedQueue(Arrays.asList(paramContext));
    }
    return null;
  }
  
  private static void writeFile(Context paramContext, String paramString, ConcurrentLinkedQueue<AdAppPreOrderTask> paramConcurrentLinkedQueue)
  {
    if (paramConcurrentLinkedQueue != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
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
      }
      catch (Throwable paramContext)
      {
        AdLog.e("AppPreOrderCache", "writeFile", paramContext);
        paramContext = null;
      }
      if ((paramContext != null) && (!JSONObject.NULL.equals(paramContext)))
      {
        if (paramContext.length() <= 0) {
          return;
        }
        b.write(paramString, paramContext.toString());
      }
    }
  }
  
  public boolean appendTaskWhenReceivedMsg(Context paramContext, AdAppPreOrderTask paramAdAppPreOrderTask, boolean paramBoolean)
  {
    AdLog.i("AppPreOrderCache", String.format("appendTaskWhenReceivedMsg ready:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if ((paramAdAppPreOrderTask != null) && (paramAdAppPreOrderTask.isValid(paramContext)))
    {
      if (!paramBoolean)
      {
        if ((!this.pendingTaskMap.containsKey(paramAdAppPreOrderTask.taskId)) || (this.pendingTaskMap.get(paramAdAppPreOrderTask.taskId) == null)) {
          this.pendingTaskMap.put(paramAdAppPreOrderTask.taskId, paramAdAppPreOrderTask);
        }
        return false;
      }
      if (getTaskById(paramAdAppPreOrderTask.taskId) != null)
      {
        AdLog.e("AppPreOrderCache", "appendTask failed already in queue!");
        return false;
      }
      appendTask(paramContext, paramAdAppPreOrderTask);
      return true;
    }
    AdLog.e("AppPreOrderCache", "appendTask failed task.isValid()!");
    return false;
  }
  
  public void clear()
  {
    this.uin = null;
    Object localObject = this.queue;
    if (localObject != null) {
      ((ConcurrentLinkedQueue)localObject).clear();
    }
    localObject = this.pendingTaskMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).clear();
    }
  }
  
  public ConcurrentLinkedQueue<AdAppPreOrderTask> getQueue()
  {
    return this.queue;
  }
  
  public AdAppPreOrderTask getTaskById(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.queue.isEmpty()) {
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
    }
    return null;
  }
  
  public List<AdAppPreOrderTask> getTasksByUrl(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.queue.isEmpty()))
    {
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
    return null;
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
    if ((paramAdAppPreOrderTask != null) && (getTaskById(paramAdAppPreOrderTask.taskId) != null))
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.queue;
      if (localConcurrentLinkedQueue != null)
      {
        localConcurrentLinkedQueue.remove(paramAdAppPreOrderTask);
        writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
      }
    }
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      return 0;
    }
    paramInt = paramString.setStatus(paramInt);
    if (paramInt > 0) {
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
    return paramInt;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt1, int paramInt2)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      return 0;
    }
    paramInt1 = paramString.setStatus(paramInt1, paramInt2);
    if (paramInt1 > 0) {
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
    return paramInt1;
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
      return 0;
    }
    paramInt = paramString.setStatus(paramInt, parammsg_content);
    if (paramInt > 0) {
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
    return paramInt;
  }
  
  public int setTaskStatusAndCommit(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = getTaskById(paramString);
    if (paramString == null) {
      return 0;
    }
    paramInt = paramString.setStatus(paramInt, paramBoolean);
    if (paramInt > 0) {
      writeFile(AdAppPreOrderManager.INSTANCE.getContext(), this.uin, this.queue);
    }
    return paramInt;
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
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.queue;
    if ((localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
      writeFile(paramContext, this.uin, this.queue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.a
 * JD-Core Version:    0.7.0.1
 */