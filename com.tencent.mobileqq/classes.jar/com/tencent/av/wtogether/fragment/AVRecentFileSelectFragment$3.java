package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

class AVRecentFileSelectFragment$3
  extends BroadcastReceiver
{
  AVRecentFileSelectFragment$3(AVRecentFileSelectFragment paramAVRecentFileSelectFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("receive[");
    paramContext.append(paramIntent.getAction());
    paramContext.append("]");
    QLog.i("AVRecentFileSelectFragment", 1, paramContext.toString());
    if (!WTBusinessForWebPlugin.a.empty())
    {
      paramContext = (Activity)WTBusinessForWebPlugin.a.peek();
      paramContext.setResult(-1, new Intent());
      paramContext.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment.3
 * JD-Core Version:    0.7.0.1
 */