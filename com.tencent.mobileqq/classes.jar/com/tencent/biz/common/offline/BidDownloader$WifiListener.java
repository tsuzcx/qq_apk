package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.NetworkUtil;

public class BidDownloader$WifiListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NetworkUtil.getNetWorkType() == 1) {
      BidDownloader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader.WifiListener
 * JD-Core Version:    0.7.0.1
 */