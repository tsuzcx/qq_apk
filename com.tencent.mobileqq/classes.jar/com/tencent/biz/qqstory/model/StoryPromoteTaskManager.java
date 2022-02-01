package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.model.item.PromoteTaskItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPromoteTaskList;
import com.tencent.biz.qqstory.network.request.promotetask.GetPromoteTaskRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StoryPromoteTaskManager
  implements IManager
{
  protected EntityManager a;
  protected String b = "";
  protected ConcurrentHashMap<Long, Long> c = new ConcurrentHashMap();
  protected ConcurrentHashMap<Long, PromoteTaskEntry> d = new ConcurrentHashMap();
  protected boolean e = false;
  public long f = 0L;
  public String g = "";
  
  static <T> String a(T[] paramArrayOfT)
  {
    if ((paramArrayOfT != null) && (paramArrayOfT.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('(');
      int j = paramArrayOfT.length - 1;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramArrayOfT[i]);
        localStringBuilder.append(", ");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfT[j]);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    return "()";
  }
  
  public List<PromoteTaskEntry> a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
      return Collections.emptyList();
    }
    List localList = this.a.query(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "feedId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      a(localList, "findPromoteTaskListByFeedIdInner() returns");
      return localList;
    }
    SLog.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIdInner(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public List<PromoteTaskEntry> a(@NonNull List<String> paramList, int paramInt)
  {
    SLog.a("StoryPromoteTaskManager", "findPromoteTaskListByFeedIds(%s, %d)", paramList, Integer.valueOf(paramInt));
    c();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.addAll(a((String)paramList.get(i), paramInt));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.a = QQStoryContext.a().d().createEntityManager();
    long l = NetConnInfoCenter.getServerTime();
    ArrayList localArrayList = new ArrayList();
    this.g = ((String)((StoryConfigManager)SuperManager.a(10)).c("key_story_player_promote_url", this.g));
    SLog.a("StoryPromoteTaskManager", "onInit() mUrl = %s", this.g);
    Object localObject2 = this.a.query(PromoteTaskEntry.class);
    int j = 0;
    Object localObject1 = localObject2;
    int i;
    if (localObject2 != null)
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (PromoteTaskEntry)((List)localObject2).get(i);
        if (l > ((PromoteTaskEntry)localObject1).expireTime) {
          localArrayList.add(Long.valueOf(((PromoteTaskEntry)localObject1).taskId));
        }
        i += 1;
      }
      a((List)localObject2, "onInit() before delete expired local entries");
      localObject1 = localObject2;
      if (!localArrayList.isEmpty())
      {
        a(localArrayList);
        localObject1 = this.a.query(PromoteTaskEntry.class);
      }
    }
    a((List)localObject1, "onInit() local entries");
    if (localObject1 != null)
    {
      i = j;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (PromoteTaskEntry)((List)localObject1).get(i);
        this.d.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), localObject2);
        i += 1;
      }
    }
    if ((c()) && (localObject1 != null))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PromoteTaskEntry)((Iterator)localObject1).next();
        this.c.put(Long.valueOf(((PromoteTaskEntry)localObject2).taskId), Long.valueOf(((PromoteTaskEntry)localObject2).promoteCount));
      }
      SLog.a("StoryPromoteTaskManager", "onInit() update memory count from DB; %s", this.c);
    }
  }
  
  void a(String paramString) {}
  
  void a(List<PromoteTaskEntry> paramList, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (this.f > l)
    {
      SLog.a("StoryPromoteTaskManager", "refreshPromoteTask, time not expire now: %s(%d), expire: %s(%d), won't request!", DateUtils.b(l), Long.valueOf(l), DateUtils.b(this.f), Long.valueOf(this.f));
      return;
    }
    SLog.a("StoryPromoteTaskManager", "refreshPromoteTask(clear=%b), time expire, will request new list, now: %d, expire: %d", Boolean.valueOf(paramBoolean), Long.valueOf(l), Long.valueOf(this.f));
    if (paramBoolean) {
      this.b = "";
    }
    GetPromoteTaskRequest localGetPromoteTaskRequest = new GetPromoteTaskRequest(this.b);
    CmdTaskManger.a().a(localGetPromoteTaskRequest, new StoryPromoteTaskManager.1(this));
  }
  
  public boolean a(long paramLong)
  {
    SLog.a("StoryPromoteTaskManager", "markTaskIdPromoted(%s)", Long.valueOf(paramLong));
    return b((PromoteTaskEntry)this.a.find(PromoteTaskEntry.class, "taskId = ?", new String[] { String.valueOf(paramLong) }));
  }
  
  public boolean a(PromoteTaskEntry paramPromoteTaskEntry)
  {
    int i = paramPromoteTaskEntry.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.a.persistOrReplace(paramPromoteTaskEntry);
      if (paramPromoteTaskEntry.getStatus() == 1001) {
        bool = true;
      }
    }
    else if ((paramPromoteTaskEntry.getStatus() != 1001) && (paramPromoteTaskEntry.getStatus() != 1002))
    {
      SLog.e("StoryPromoteTaskManager", "updateEntry error: entry status unknown: %d", new Object[] { Integer.valueOf(paramPromoteTaskEntry.getStatus()) });
    }
    else
    {
      bool = this.a.update(paramPromoteTaskEntry);
    }
    this.d.put(Long.valueOf(paramPromoteTaskEntry.taskId), paramPromoteTaskEntry);
    SLog.a("StoryPromoteTaskManager", "updateEntry %s, return %b", paramPromoteTaskEntry, Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean a(qqstory_service.RspGetPromoteTaskList paramRspGetPromoteTaskList)
  {
    ArrayList localArrayList = new ArrayList(this.d.keySet());
    paramRspGetPromoteTaskList = paramRspGetPromoteTaskList.promote_tasks.get();
    int i = 0;
    while (i < paramRspGetPromoteTaskList.size())
    {
      Object localObject = PromoteTaskItem.a((qqstory_service.PromoteTask)paramRspGetPromoteTaskList.get(i));
      Long localLong = (Long)this.c.get(Long.valueOf(((PromoteTaskItem)localObject).a));
      if (localLong != null) {
        ((PromoteTaskItem)localObject).h = localLong.longValue();
      } else {
        ((PromoteTaskItem)localObject).h = 0L;
      }
      localArrayList.remove(Long.valueOf(((PromoteTaskItem)localObject).a));
      localObject = ((PromoteTaskItem)localObject).a();
      a((PromoteTaskEntry)localObject);
      SLog.a("StoryPromoteTaskManager", "overwriteEntries() [%d] taskEntry updated %s", Integer.valueOf(i), localObject);
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      SLog.b("StoryPromoteTaskManager", "overwriteEntries() taskIds not empty, will delete it");
      a(localArrayList);
    }
    return true;
  }
  
  public boolean a(List<Long> paramList)
  {
    SLog.a("StoryPromoteTaskManager", "deleteListOfTasks(%s)", paramList);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        this.d.remove(Long.valueOf(l));
        this.c.remove(Long.valueOf(l));
      }
      localObject = new Long[paramList.size()];
      paramList.toArray((Object[])localObject);
      paramList = a((Object[])localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delete from ");
      ((StringBuilder)localObject).append(PromoteTaskEntry.class.getSimpleName());
      ((StringBuilder)localObject).append(" where taskId in ");
      ((StringBuilder)localObject).append(paramList);
      paramList = ((StringBuilder)localObject).toString();
      SLog.a("StoryPromoteTaskManager", "deleteListOfTasks() exec sql: taskEntry updated %s", paramList);
      return this.a.execSQL(paramList);
    }
    return false;
  }
  
  public List<PromoteTaskEntry> b(String paramString, int paramInt)
  {
    SLog.a("StoryPromoteTaskManager", "findPromoteTaskByUnionId(%s, %d)", paramString, Integer.valueOf(paramInt));
    c();
    List localList = this.a.query(PromoteTaskEntry.class, PromoteTaskEntry.class.getSimpleName(), false, "unionId = ? AND limitPromoteCount > promoteCount AND (type&?) > 0", new String[] { paramString, String.valueOf(paramInt) }, null, null, "taskId", null);
    if ((localList != null) && (localList.size() > 0))
    {
      paramString = (PromoteTaskEntry)localList.get(0);
      a(localList, "findPromoteTaskListByUnionId() returns");
      return localList;
    }
    SLog.a("StoryPromoteTaskManager", "findPromoteTaskListByUnionId(%s, %d) return null", paramString, Integer.valueOf(paramInt));
    return Collections.emptyList();
  }
  
  public void b()
  {
    this.a.close();
    this.e = true;
  }
  
  public boolean b(PromoteTaskEntry paramPromoteTaskEntry)
  {
    SLog.a("StoryPromoteTaskManager", "markEntryPromoted(%s)", paramPromoteTaskEntry);
    if (paramPromoteTaskEntry == null)
    {
      SLog.b("StoryPromoteTaskManager", "markEntryPromoted entry is null!");
      return false;
    }
    if (paramPromoteTaskEntry.promoteCount >= paramPromoteTaskEntry.limitPromoteCount)
    {
      SLog.e("StoryPromoteTaskManager", "Error: entry.promoteCount >= entry.limitPromoteCount");
      return false;
    }
    paramPromoteTaskEntry.promoteCount += 1L;
    this.c.put(Long.valueOf(paramPromoteTaskEntry.taskId), Long.valueOf(paramPromoteTaskEntry.promoteCount));
    a(paramPromoteTaskEntry);
    return true;
  }
  
  public boolean c()
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    String str = DateUtils.a();
    if (TextUtils.equals((String)((StoryConfigManager)localObject).c("key_story_promote_task_date", ""), str))
    {
      SLog.a("StoryPromoteTaskManager", "ensureCountValidate() date is %s, keep last promoteCount", str);
      return true;
    }
    SLog.a("StoryPromoteTaskManager", "ensureCountValidate() date is %s new date, so mTaskIdCounts should be empty, taskIdCounts=%s", str, this.c);
    ((StoryConfigManager)localObject).d("key_story_promote_task_date", str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("update ");
    ((StringBuilder)localObject).append(PromoteTaskEntry.class.getSimpleName());
    ((StringBuilder)localObject).append(" set promoteCount = 0");
    localObject = ((StringBuilder)localObject).toString();
    this.a.execSQL((String)localObject);
    this.c.clear();
    SLog.a("StoryPromoteTaskManager", "ensureCountValidate() exec sql: taskEntry updated sql=%s", localObject);
    a("ensureCountValidate() after execSQL()");
    return false;
  }
  
  public void d()
  {
    ((StoryConfigManager)SuperManager.a(10)).d("key_story_promote_task_date", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryPromoteTaskManager
 * JD-Core Version:    0.7.0.1
 */