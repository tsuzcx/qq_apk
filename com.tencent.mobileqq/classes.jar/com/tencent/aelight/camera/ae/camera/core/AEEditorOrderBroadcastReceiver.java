package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.log.AEQLog;

public class AEEditorOrderBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorOrderBroadcastReceiver";
  private AEEditorOrderBroadcastReceiver.AEEditorOrderListener mAEEditorOrderListener;
  private boolean mReceiverActive = false;
  
  public AEEditorOrderBroadcastReceiver(AEEditorOrderBroadcastReceiver.AEEditorOrderListener paramAEEditorOrderListener)
  {
    this.mAEEditorOrderListener = paramAEEditorOrderListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_ORDER_CANCEL");
    localIntentFilter.addAction("AEEDITOR_ORDER_SAVE");
    localIntentFilter.addAction("AEEDITOR_ORDER_REMOVE_MISSION");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("generate_mission");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceive] action :");
    localStringBuilder.append(paramContext);
    AEQLog.b("AEEditorOrderBroadcastReceiver", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceive] mission :");
    localStringBuilder.append(paramIntent);
    AEQLog.b("AEEditorOrderBroadcastReceiver", localStringBuilder.toString());
    if ("AEEDITOR_ORDER_CANCEL".equals(paramContext))
    {
      this.mAEEditorOrderListener.onAEEditorCancel(paramIntent);
      return;
    }
    if ("AEEDITOR_ORDER_REMOVE_MISSION".equals(paramContext)) {
      this.mAEEditorOrderListener.onAEEditorRemove(paramIntent);
    }
  }
  
  public void registerSelf(Context paramContext)
  {
    if ((!this.mReceiverActive) && (paramContext != null))
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(Context paramContext)
  {
    if ((this.mReceiverActive) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AEEditorOrderBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */