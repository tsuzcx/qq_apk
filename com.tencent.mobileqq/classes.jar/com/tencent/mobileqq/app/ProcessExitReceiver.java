package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import zgq;

public class ProcessExitReceiver
  extends BroadcastReceiver
{
  private AppInterface a;
  
  protected String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  protected boolean a(String paramString, ArrayList paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  protected boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return true;
    }
    String str = MobileQQ.getMobileQQ().getProcessName();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (str.equals((String)paramArrayList.next())) {
        return true;
      }
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (!paramContext.equals("com.tencent.process.exit")) {
          break;
        }
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      paramIntent = paramContext.getStringArrayList("procNameList");
    } while ((!a(paramContext.getString("verify"), paramIntent)) || (!a(paramIntent)));
    ThreadManager.post(new zgq(this), 8, null, true);
    return;
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ProcessExitReceiver
 * JD-Core Version:    0.7.0.1
 */