package com.tencent.biz.qqstory.newshare.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FeedUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Job
{
  public final String e;
  public boolean f;
  public boolean g;
  public ConcurrentHashMap<String, Object> h;
  public Job.JobExecutorCallback i;
  
  public Job()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.share");
    localStringBuilder.append(getClass().getSimpleName());
    this.e = localStringBuilder.toString();
    this.f = true;
    this.g = true;
  }
  
  public final Job a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    return this;
  }
  
  public abstract void a();
  
  public void a(String paramString, Object paramObject)
  {
    SLog.a(this.e, "putResult key %s, value %s, stack = %s", String.valueOf(paramString), String.valueOf(paramObject), FeedUtils.a(7));
    if ((this.h != null) && (!TextUtils.isEmpty(paramString))) {
      this.h.put(paramString, paramObject);
    }
  }
  
  protected abstract void a(Map<String, Object> paramMap);
  
  protected final void a(boolean paramBoolean)
  {
    SLog.a(this.e, "onJobFinish %b, stack = %s", Boolean.valueOf(paramBoolean), FeedUtils.a(7));
    Job.JobExecutorCallback localJobExecutorCallback = this.i;
    if (localJobExecutorCallback != null) {
      localJobExecutorCallback.b(paramBoolean);
    }
  }
  
  public <T> T b(String paramString)
  {
    if ((this.h != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.h.get(paramString);
      SLog.a(this.e, "getResult key %s, result %s, stack = %s", String.valueOf(paramString), String.valueOf(localObject), FeedUtils.a(7));
      return localObject;
    }
    SLog.a(this.e, "getResult key %s, result null, stack = %s", String.valueOf(paramString), FeedUtils.a(7));
    return null;
  }
  
  protected final void b(boolean paramBoolean)
  {
    SLog.a(this.e, "onRunFinish %b, stack = %s", Boolean.valueOf(paramBoolean), FeedUtils.a(7));
    Job.JobExecutorCallback localJobExecutorCallback = this.i;
    if (localJobExecutorCallback != null) {
      localJobExecutorCallback.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.model.Job
 * JD-Core Version:    0.7.0.1
 */