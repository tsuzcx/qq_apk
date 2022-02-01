package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.util.CommonUtil;
import java.util.ArrayList;

class DirectForwardActivity$2
  extends BroadcastReceiver
{
  DirectForwardActivity$2(DirectForwardActivity paramDirectForwardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramContext = paramIntent.getStringArrayList("procNameList");
      paramIntent = paramIntent.getString("verify");
      if ((paramContext != null) && (paramContext.size() != 0) && (this.a.a != null))
      {
        if (!CommonUtil.a(paramIntent, paramContext)) {
          return;
        }
        int i = 0;
        while (i < paramContext.size())
        {
          if (this.a.a.equals(paramContext.get(i)))
          {
            this.a.finish();
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DirectForwardActivity.2
 * JD-Core Version:    0.7.0.1
 */