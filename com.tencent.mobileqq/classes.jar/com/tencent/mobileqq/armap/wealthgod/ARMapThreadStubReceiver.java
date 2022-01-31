package com.tencent.mobileqq.armap.wealthgod;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class ARMapThreadStubReceiver
  extends BroadcastReceiver
{
  private void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapThreadStubReceiver", 2, String.format("notifyARMapThreadStartCompleted preStart=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.armap.ACTION_START_THREAD_COMPLETED");
    localIntent.putExtra("pre_start_thread", paramBoolean);
    localIntent.putExtra("from", paramString);
    if (paramContext != null) {
      paramContext.sendBroadcast(localIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getAction();
      boolean bool = paramIntent.getBooleanExtra("pre_start_thread", false);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapThreadStubReceiver", 2, String.format("onReceive action=%s preStart=%s", new Object[] { str, Boolean.valueOf(bool) }));
      }
      paramIntent = paramIntent.getStringExtra("from");
      if ("com.tencent.mobileqq.armap.ACTION_START_THREAD".equals(str)) {
        a(paramContext, bool, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapThreadStubReceiver
 * JD-Core Version:    0.7.0.1
 */