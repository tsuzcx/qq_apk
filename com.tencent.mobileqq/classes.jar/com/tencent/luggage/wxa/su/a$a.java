package com.tencent.luggage.wxa.su;

import android.text.TextUtils;
import com.tencent.xweb.a;
import com.tencent.xweb.b;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.c;

public class a$a
  extends Scheduler
{
  String a;
  
  public a$a(String paramString)
  {
    this.a = paramString;
    paramString = new StringBuilder();
    paramString.append(a());
    paramString.append("Scheduler");
    this.b = paramString.toString();
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected String a(boolean paramBoolean)
  {
    String str2;
    String str1;
    if (!paramBoolean)
    {
      str2 = b.c("UPDATE_SPEED_CONFIG", "tools");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        return a.a("UPDATE_SPEED_CONFIG", "tools");
      }
    }
    else
    {
      str2 = b.c("UPDATE_FORWARD_SPEED_CONFIG", "tools");
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = a.a("UPDATE_FORWARD_SPEED_CONFIG", "tools");
      }
    }
    return str1;
  }
  
  protected boolean a(c paramc1, c paramc2)
  {
    if ((paramc1.x == paramc2.x) && (a(paramc1.y, paramc2.y))) {
      return super.a(paramc1, paramc2);
    }
    return false;
  }
  
  public int b()
  {
    return 15;
  }
  
  protected String c()
  {
    String str2 = b.c("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = super.c();
    }
    return str1;
  }
  
  protected String d()
  {
    return b.c("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.a.a
 * JD-Core Version:    0.7.0.1
 */