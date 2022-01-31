package com.tencent.mm.vfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

class FileSystemManager$1
  extends BroadcastReceiver
{
  FileSystemManager$1(FileSystemManager paramFileSystemManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    FileSystemManager.access$100(this.this$0).sendMessageAtFrontOfQueue(Message.obtain(FileSystemManager.access$100(this.this$0), 1, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.1
 * JD-Core Version:    0.7.0.1
 */