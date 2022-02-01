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

public class ProcessExitReceiver
  extends BroadcastReceiver
{
  protected AppInterface a;
  
  protected String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  protected boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.equals(a(paramArrayList, false))) {
      return paramString.equals(a(paramArrayList, true));
    }
    return true;
  }
  
  protected boolean a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return true;
      }
      String str = MobileQQ.getMobileQQ().getQQProcessName();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (str.equals((String)paramArrayList.next())) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if (paramContext.equals("com.tencent.process.exit"))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext == null) {
        return;
      }
      paramIntent = paramContext.getStringArrayList("procNameList");
      if (a(paramContext.getString("verify"), paramIntent))
      {
        if (!a(paramIntent)) {
          return;
        }
        ThreadManager.post(new ProcessExitReceiver.1(this), 8, null, true);
        return;
      }
      return;
    }
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ProcessExitReceiver
 * JD-Core Version:    0.7.0.1
 */