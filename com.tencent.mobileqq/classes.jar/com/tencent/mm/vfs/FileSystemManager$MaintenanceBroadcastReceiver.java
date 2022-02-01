package com.tencent.mm.vfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.qphone.base.util.QLog;

final class FileSystemManager$MaintenanceBroadcastReceiver
  extends BroadcastReceiver
{
  private CancellationSignalCompat mCancellationSignal;
  private boolean mIsCharging;
  private boolean mIsInteractive;
  
  private FileSystemManager$MaintenanceBroadcastReceiver(FileSystemManager paramFileSystemManager) {}
  
  private void triggerIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VFS.FileSystemManager", 2, "Idle status changed: charging = " + this.mIsCharging + ", interactive = " + this.mIsInteractive);
    }
    long l;
    if ((this.mIsCharging) && (!this.mIsInteractive) && (this.mCancellationSignal == null))
    {
      l = FileSystemManager.access$000(this.this$0);
      if (l >= 0L) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          this.mCancellationSignal = new CancellationSignalCompat();
          FileSystemManager.access$100(this.this$0).sendMessageDelayed(Message.obtain(FileSystemManager.access$100(this.this$0), 2, this.mCancellationSignal), l);
        } while (!QLog.isColorLevel());
        QLog.i("VFS.FileSystemManager", 2, "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        return;
      } while (((this.mIsCharging) && (!this.mIsInteractive)) || (this.mCancellationSignal == null));
      FileSystemManager.access$100(this.this$0).removeMessages(2);
      this.mCancellationSignal.cancel();
      this.mCancellationSignal = null;
    } while (!QLog.isColorLevel());
    QLog.i("VFS.FileSystemManager", 2, "Exit idle state, maintenance cancelled.");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      triggerIdle();
      return;
      if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        break;
      }
      i = 2;
      break;
      if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        break;
      }
      i = 3;
      break;
      this.mIsInteractive = true;
      continue;
      this.mIsInteractive = false;
      continue;
      this.mIsCharging = true;
      continue;
      this.mIsCharging = false;
    }
  }
  
  void refreshIdleStatus(Context paramContext)
  {
    this.mIsInteractive = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (paramContext != null)
    {
      int i = paramContext.getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.mIsCharging = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.MaintenanceBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */