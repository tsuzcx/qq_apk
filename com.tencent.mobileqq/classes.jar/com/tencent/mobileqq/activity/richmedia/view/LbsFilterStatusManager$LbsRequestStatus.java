package com.tencent.mobileqq.activity.richmedia.view;

import java.util.ArrayList;

class LbsFilterStatusManager$LbsRequestStatus
{
  LbsRequestStatus a = null;
  boolean b = false;
  ArrayList<String> c = new ArrayList(1);
  long d = 0L;
  int e = 3;
  
  void a()
  {
    this.b = false;
    this.c.clear();
    this.d = 0L;
    this.e = 3;
  }
  
  boolean a(String paramString)
  {
    LbsFilterStatusManager.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.c.toString() }), null);
    return this.c.contains(paramString);
  }
  
  void b()
  {
    LbsRequestStatus localLbsRequestStatus = this.a;
    localLbsRequestStatus.b = this.b;
    localLbsRequestStatus.c.clear();
    this.a.c.addAll(this.c);
    localLbsRequestStatus = this.a;
    localLbsRequestStatus.e = this.e;
    localLbsRequestStatus.d = this.d;
  }
  
  String c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.LbsRequestStatus
 * JD-Core Version:    0.7.0.1
 */