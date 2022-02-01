package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import java.util.concurrent.Callable;

public class IntentCallable
  implements Callable<Void>
{
  public Context a;
  public Intent b;
  public String c;
  
  public IntentCallable(Context paramContext, Intent paramIntent, String paramString)
  {
    this.a = paramContext;
    this.b = paramIntent;
    this.c = paramString;
  }
  
  public Void call()
  {
    this.a.sendBroadcast(this.b);
    PushBiUtil.reportExit(this.a, "push.setNotifyFlag", this.c, ErrorEnum.SUCCESS);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.task.IntentCallable
 * JD-Core Version:    0.7.0.1
 */