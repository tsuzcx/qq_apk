package com.tencent.biz.troop;

import java.io.File;
import java.util.HashMap;

public abstract class VideoCombineHelper$Task
{
  public Task a;
  public VideoCombineHelper.TaskListener a;
  public String c;
  public String d;
  
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
    Object localObject = this.c.substring(i + 1, this.c.length());
    localObject = new File(VideoCombineHelper.jdField_a_of_type_JavaLangString + File.separator + (String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public abstract void a();
  
  public File b()
  {
    File localFile = new File(VideoCombineHelper.jdField_a_of_type_JavaLangString + File.separator + "cache");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task != null) {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.Task
 * JD-Core Version:    0.7.0.1
 */