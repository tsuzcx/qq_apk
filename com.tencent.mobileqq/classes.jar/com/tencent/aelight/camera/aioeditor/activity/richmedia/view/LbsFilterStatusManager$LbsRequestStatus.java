package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import java.util.ArrayList;

class LbsFilterStatusManager$LbsRequestStatus
{
  LbsRequestStatus a = null;
  boolean b = false;
  ArrayList<String> c = new ArrayList(1);
  long d = 0L;
  int e = 3;
  
  static LbsRequestStatus a()
  {
    LbsRequestStatus localLbsRequestStatus = new LbsRequestStatus();
    localLbsRequestStatus.b();
    return localLbsRequestStatus;
  }
  
  boolean a(String paramString)
  {
    LbsFilterStatusManager.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.c.toString() }), null);
    return this.c.contains(paramString);
  }
  
  void b()
  {
    if (this.a == null) {
      this.a = new LbsRequestStatus();
    }
  }
  
  void c()
  {
    this.b = false;
    this.c.clear();
    this.d = 0L;
    this.e = 3;
  }
  
  void d()
  {
    LbsRequestStatus localLbsRequestStatus = this.a;
    localLbsRequestStatus.b = this.b;
    localLbsRequestStatus.c.clear();
    this.a.c.addAll(this.c);
    localLbsRequestStatus = this.a;
    localLbsRequestStatus.e = this.e;
    localLbsRequestStatus.d = this.d;
  }
  
  String e()
  {
    int i = this.e;
    if (i != 1)
    {
      if (i != 2) {
        return "LBS_REQ_OK";
      }
      return "LBS_REQ_PERM_OK";
    }
    return "LBS_REQ_PENDING";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.LbsRequestStatus
 * JD-Core Version:    0.7.0.1
 */