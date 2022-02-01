package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.f.a;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;

public class b
  extends c
{
  public BaseMode a(Context paramContext, int paramInt, Intent paramIntent)
  {
    if ((4103 != paramInt) && (4098 != paramInt)) {
      return null;
    }
    paramContext = a(paramIntent);
    d.a().a((DataMessage)paramContext, "push_transmit", paramInt);
    return paramContext;
  }
  
  protected BaseMode a(Intent paramIntent)
  {
    try
    {
      localObject = new DataMessage();
      ((DataMessage)localObject).setMessageID(a.b(paramIntent.getStringExtra("messageID")));
      ((DataMessage)localObject).setTaskID(a.b(paramIntent.getStringExtra("taskID")));
      ((DataMessage)localObject).setAppPackage(a.b(paramIntent.getStringExtra("appPackage")));
      ((DataMessage)localObject).setTitle(a.b(paramIntent.getStringExtra("title")));
      ((DataMessage)localObject).setContent(a.b(paramIntent.getStringExtra("content")));
      ((DataMessage)localObject).setDescription(a.b(paramIntent.getStringExtra("description")));
      paramIntent = a.b(paramIntent.getStringExtra("notifyID"));
      int i;
      if (TextUtils.isEmpty(paramIntent)) {
        i = 0;
      } else {
        i = Integer.parseInt(paramIntent);
      }
      ((DataMessage)localObject).setNotifyID(i);
      return localObject;
    }
    catch (Exception paramIntent)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnHandleIntent--");
      ((StringBuilder)localObject).append(paramIntent.getMessage());
      com.heytap.mcssdk.f.c.a(((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.d.b
 * JD-Core Version:    0.7.0.1
 */