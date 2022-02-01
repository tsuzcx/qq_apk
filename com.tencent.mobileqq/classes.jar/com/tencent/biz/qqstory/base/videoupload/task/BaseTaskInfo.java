package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
public class BaseTaskInfo
{
  public volatile int a = 0;
  public List<UploadObject> b = new ArrayList();
  public int c;
  public int d;
  public long e;
  public ErrorMessage f;
  
  public boolean a()
  {
    return this.a == 5;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("BaseTaskInfo{");
    localStringBuffer.append("status=");
    localStringBuffer.append(this.a);
    localStringBuffer.append(", retryTimes=");
    localStringBuffer.append(this.c);
    localStringBuffer.append(", result=");
    localStringBuffer.append(this.f);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.BaseTaskInfo
 * JD-Core Version:    0.7.0.1
 */