package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.log.AEQLog;

public class AEEditorUIBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorUIBroadcastReceiver";
  private AEEditorUIBroadcastReceiver.AEEditorUIListener mAEUIListener;
  private boolean mReceiverActive = false;
  
  public AEEditorUIBroadcastReceiver(AEEditorUIBroadcastReceiver.AEEditorUIListener paramAEEditorUIListener)
  {
    this.mAEUIListener = paramAEEditorUIListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DELETE");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      AEQLog.d("AEEditorUIBroadcastReceiver", "[onReceive] : action is null");
      return;
    }
    if ("AEEDITOR_GENERATE_STATUS_DELETE".equals(paramContext))
    {
      int i = paramIntent.getIntExtra("delete_position", 0);
      this.mAEUIListener.deteleMedia(i);
    }
  }
  
  public void registerSelf(@NonNull Context paramContext)
  {
    if ((!this.mReceiverActive) && (paramContext != null))
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(@NonNull Context paramContext)
  {
    if ((this.mReceiverActive) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AEEditorUIBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */