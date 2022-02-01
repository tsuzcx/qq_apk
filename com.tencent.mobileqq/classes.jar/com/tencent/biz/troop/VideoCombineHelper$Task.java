package com.tencent.biz.troop;

import java.io.File;
import java.util.HashMap;

public abstract class VideoCombineHelper$Task
{
  Task jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task;
  VideoCombineHelper.TaskListener jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener;
  String c;
  String d;
  
  public VideoCombineHelper$Task(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener = paramTaskListener;
    this.c = paramString;
  }
  
  public VideoCombineHelper.CombineParams a()
  {
    synchronized (this.b.jdField_a_of_type_JavaLangObject)
    {
      VideoCombineHelper.CombineParams localCombineParams = (VideoCombineHelper.CombineParams)this.b.jdField_a_of_type_JavaUtilHashMap.get(this.c);
      return localCombineParams;
    }
  }
  
  public File a()
  {
    int i = this.c.indexOf("_");
    Object localObject = this.c;
    localObject = ((String)localObject).substring(i + 1, ((String)localObject).length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoCombineHelper.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append((String)localObject);
    localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public abstract void a();
  
  public File b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VideoCombineHelper.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("cache");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public void b()
  {
    Task localTask = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task;
    if (localTask != null) {
      localTask.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.Task
 * JD-Core Version:    0.7.0.1
 */