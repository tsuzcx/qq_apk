package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ndk;

public class BidDownloader$WifiListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (ndk.a(paramContext) == 1) {
      BidDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.WifiListener
 * JD-Core Version:    0.7.0.1
 */