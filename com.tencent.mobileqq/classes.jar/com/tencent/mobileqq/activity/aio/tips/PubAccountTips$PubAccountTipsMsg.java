package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONObject;

public class PubAccountTips$PubAccountTipsMsg
{
  JSONObject a;
  int b;
  int c = 0;
  long d;
  String e;
  String f;
  String g;
  long h;
  long i;
  protected int j;
  int k = 0;
  int l = 0;
  String m;
  public long n;
  
  public PubAccountTips$PubAccountTipsMsg(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.d = paramJSONObject.optLong("puin");
      this.b = paramJSONObject.optInt("type");
      this.c = paramJSONObject.optInt("show_tab");
      this.e = paramJSONObject.optString("content");
      this.f = paramJSONObject.optString("icon");
      this.g = paramJSONObject.optString("url");
      this.h = paramJSONObject.optLong("begin");
      this.i = paramJSONObject.optLong("end");
      this.m = paramJSONObject.optString("shool_id");
      this.j = paramJSONObject.optInt("times");
      this.n = paramJSONObject.optLong("msg_seqno");
      this.n = paramJSONObject.optLong("msg_seqno");
      this.k = paramJSONObject.optInt("tid");
      this.l = paramJSONObject.optInt("clicked");
    }
  }
  
  boolean a()
  {
    return (this.d > 0L) && (this.j >= 0);
  }
  
  public boolean b()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    return (l1 < this.h) || (l1 > this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.PubAccountTips.PubAccountTipsMsg
 * JD-Core Version:    0.7.0.1
 */