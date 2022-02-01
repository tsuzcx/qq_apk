package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskException;

class KandianMergeManager$8
  extends BroadcastReceiver
{
  KandianMergeManager$8(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    TaskException.reportCrash(paramIntent.getBooleanExtra("isNativeCrashed", false), paramIntent.getStringExtra("crashType"), paramIntent.getStringExtra("crashAddress"), paramIntent.getStringExtra("crashStack"), paramIntent.getIntExtra("native_SICODE", 0), paramIntent.getLongExtra("crashTime", 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.8
 * JD-Core Version:    0.7.0.1
 */