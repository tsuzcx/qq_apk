package com.tencent.biz.troop;

import java.io.File;
import java.util.HashMap;

public abstract class VideoCombineHelper$Task
{
  VideoCombineHelper.TaskListener f;
  String g;
  Task h;
  String i;
  
  public VideoCombineHelper$Task(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    this.f = paramTaskListener;
    this.g = paramString;
  }
  
  public abstract void a();
  
  public void b()
  {
    Task localTask = this.h;
    if (localTask != null) {
      localTask.a();
    }
  }
  
  public VideoCombineHelper.CombineParams c()
  {
    synchronized (this.j.f)
    {
      VideoCombineHelper.CombineParams localCombineParams = (VideoCombineHelper.CombineParams)this.j.g.get(this.g);
      return localCombineParams;
    }
  }
  
  public File d()
  {
    int k = this.g.indexOf("_");
    Object localObject = this.g;
    localObject = ((String)localObject).substring(k + 1, ((String)localObject).length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoCombineHelper.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public File e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VideoCombineHelper.a);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("cache");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.Task
 * JD-Core Version:    0.7.0.1
 */