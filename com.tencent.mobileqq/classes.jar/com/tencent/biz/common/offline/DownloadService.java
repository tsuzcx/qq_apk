package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import com.tencent.mobileqq.utils.NetworkUtil;

public class DownloadService
  extends BroadcastReceiver
{
  Messenger a = null;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NetworkUtil.isWifiEnabled(paramContext)) {
      BidDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.DownloadService
 * JD-Core Version:    0.7.0.1
 */