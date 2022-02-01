package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public class c
  implements Callable<Void>
{
  private Context a;
  private Intent b;
  private String c;
  
  public c(Context paramContext, Intent paramIntent, String paramString)
  {
    this.a = paramContext;
    this.b = paramIntent;
    this.c = paramString;
  }
  
  public Void call()
  {
    this.a.sendBroadcast(this.b);
    g.a(this.a, "push.setNotifyFlag", this.c, a.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.c
 * JD-Core Version:    0.7.0.1
 */