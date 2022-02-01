package com.tencent.mobileqq.app;

import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class LoveZoneDynamicRedPointPathInterface
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  private List<String> a = new ArrayList();
  
  public void a()
  {
    if (this.a.isEmpty()) {
      this.a.add("100066");
    }
  }
  
  public void b()
  {
    if (!this.a.isEmpty()) {
      this.a.remove("100066");
    }
  }
  
  public List<String> getRedPointPaths(AppRuntime paramAppRuntime)
  {
    if (((paramAppRuntime instanceof QQAppInterface)) && (!this.a.isEmpty())) {
      return this.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoveZoneDynamicRedPointPathInterface
 * JD-Core Version:    0.7.0.1
 */