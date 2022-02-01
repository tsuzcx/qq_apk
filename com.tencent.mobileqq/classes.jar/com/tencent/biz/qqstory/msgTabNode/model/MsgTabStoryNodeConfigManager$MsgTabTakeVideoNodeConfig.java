package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.support.logging.SLog;

public class MsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig
{
  public long a;
  public long b;
  public String c;
  public String d;
  public String e;
  public String f;
  public boolean g = false;
  public boolean h = false;
  
  public void a(MsgTabTakeVideoNodeConfig paramMsgTabTakeVideoNodeConfig)
  {
    if (paramMsgTabTakeVideoNodeConfig == null) {
      return;
    }
    this.a = paramMsgTabTakeVideoNodeConfig.a;
    this.b = paramMsgTabTakeVideoNodeConfig.b;
    this.c = paramMsgTabTakeVideoNodeConfig.c;
    this.d = paramMsgTabTakeVideoNodeConfig.d;
    this.e = paramMsgTabTakeVideoNodeConfig.e;
    this.f = paramMsgTabTakeVideoNodeConfig.f;
    this.g = paramMsgTabTakeVideoNodeConfig.g;
    this.h = paramMsgTabTakeVideoNodeConfig.h;
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    boolean bool1;
    if ((l >= this.a) && (l < this.b)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (this.g)
      {
        bool2 = bool1;
        if (this.h) {
          bool2 = false;
        }
      }
    }
    SLog.a("Q.qqstory.config.takevideo", "isVariable=%b content=%s", Boolean.valueOf(bool2), toString());
    return bool2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MsgTabTakeVideoNodeConfig=[");
    localStringBuilder.append(" startTime:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" endTime:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" imageUrl:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" desc:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" jumpUrl:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" contentId:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" isOneTimeUse:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" hasClicked:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig
 * JD-Core Version:    0.7.0.1
 */