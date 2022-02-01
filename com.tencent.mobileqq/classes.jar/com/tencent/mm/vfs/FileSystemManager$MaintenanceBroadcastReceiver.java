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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Idle status changed: charging = ");
      localStringBuilder.append(this.mIsCharging);
      localStringBuilder.append(", interactive = ");
      localStringBuilder.append(this.mIsInteractive);
      QLog.i("VFS.FileSystemManager", 2, localStringBuilder.toString());
    }
    if ((this.mIsCharging) && (!this.mIsInteractive) && (this.mCancellationSignal == null))
    {
      long l = FileSystemManager.access$000(this.this$0);
      if (l < 0L) {
        return;
      }
      this.mCancellationSignal = new CancellationSignalCompat();
      FileSystemManager.access$100(this.this$0).sendMessageDelayed(Message.obtain(FileSystemManager.access$100(this.this$0), 2, this.mCancellationSignal), l);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("System idle, trigger maintenance timer for ");
        localStringBuilder.append(l / 1000L);
        localStringBuilder.append(" seconds.");
        QLog.i("VFS.FileSystemManager", 2, localStringBuilder.toString());
      }
    }
    else if (((!this.mIsCharging) || (this.mIsInteractive)) && (this.mCancellationSignal != null))
    {
      FileSystemManager.access$100(this.this$0).removeMessages(2);
      this.mCancellationSignal.cancel();
      this.mCancellationSignal = null;
      if (QLog.isColorLevel()) {
        QLog.i("VFS.FileSystemManager", 2, "Exit idle state, maintenance cancelled.");
      }
    }
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
      break;
    case 1019184907: 
      if (paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
        i = 2;
      }
      break;
    case -1454123155: 
      if (paramContext.equals("android.intent.action.SCREEN_ON")) {
        i = 0;
      }
      break;
    case -1886648615: 
      if (paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
        i = 3;
      }
      break;
    case -2128145023: 
      if (paramContext.equals("android.intent.action.SCREEN_OFF")) {
        i = 1;
      }
      break;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.mIsCharging = false;
          }
        }
        else {
          this.mIsCharging = true;
        }
      }
      else {
        this.mIsInteractive = false;
      }
    }
    else {
      this.mIsInteractive = true;
    }
    triggerIdle();
  }
  
  void refreshIdleStatus(Context paramContext)
  {
    this.mIsInteractive = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
    paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (paramContext != null)
    {
      int i = paramContext.getIntExtra("status", -1);
      boolean bool;
      if ((i != 2) && (i != 5)) {
        bool = false;
      } else {
        bool = true;
      }
      this.mIsCharging = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.MaintenanceBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */