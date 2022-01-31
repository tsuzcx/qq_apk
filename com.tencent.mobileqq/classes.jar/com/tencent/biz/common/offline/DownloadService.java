package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import nar;

public class DownloadService
  extends BroadcastReceiver
{
  Messenger a = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (nar.a(paramContext) == 1) {
      BidDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.common.offline.DownloadService
 * JD-Core Version:    0.7.0.1
 */