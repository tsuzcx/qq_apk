package com.huawei.hms.push.task;

public class SubscribeTask
  extends BaseVoidTask
{
  public SubscribeTask(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public int getMinApkVersion()
  {
    return 40003000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.task.SubscribeTask
 * JD-Core Version:    0.7.0.1
 */