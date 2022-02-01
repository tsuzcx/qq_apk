package com.tencent.aelight.camera.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.log.AEQLog;

public class AEEditorGenerateBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorGenerateBroadcastReceiver";
  private AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener mAETavSessionStatusListener;
  private boolean mReceiverActive = false;
  
  public AEEditorGenerateBroadcastReceiver(AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener paramAEEditorGenerateListener)
  {
    this.mAETavSessionStatusListener = paramAEEditorGenerateListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_ERROR");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DOWNLOADING");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_READY");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      AEQLog.d("AEEditorGenerateBroadcastReceiver", "[onReceive] : action is null");
      return;
    }
    String str1 = paramIntent.getStringExtra("generate_materialid");
    String str2 = paramIntent.getStringExtra("generate_materialname");
    String str3 = paramIntent.getStringExtra("generate_filterid");
    String str4 = paramIntent.getStringExtra("generate_scheme");
    int i = paramIntent.getIntExtra("generate_show_circle_take_same", 0);
    String str5 = paramIntent.getStringExtra("generate_mission");
    String str6 = paramIntent.getStringExtra("generate_path");
    String str7 = paramIntent.getStringExtra("generate_thumb_ptah");
    float f1 = paramIntent.getFloatExtra("generate_progress", 0.0F);
    int j = paramIntent.getIntExtra("generate_errorcode", 0);
    String str8 = paramIntent.getStringExtra("generate_errormessage");
    String str9 = paramIntent.getStringExtra("generate_source_path");
    String str10 = paramIntent.getStringExtra("generate_KuolieId");
    float f2 = paramIntent.getFloatExtra("generate_centerX", 0.0F);
    float f3 = paramIntent.getFloatExtra("generate_centerY", 0.0F);
    float f4 = paramIntent.getFloatExtra("generate_widthScale", 0.0F);
    float f5 = paramIntent.getFloatExtra("generate_HeightScale", 0.0F);
    float f6 = paramIntent.getFloatExtra("generate_rotate", 0.0F);
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] action :");
    paramIntent.append(paramContext);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] mission :");
    paramIntent.append(str5);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] path :");
    paramIntent.append(str6);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] thumbPath :");
    paramIntent.append(str7);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] progress :");
    paramIntent.append(f1);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] errorcode :");
    paramIntent.append(j);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceive] kuolieId :");
    paramIntent.append(str10);
    paramIntent.append(" kuolieCenterX:");
    paramIntent.append(f2);
    paramIntent.append(" kuolieCenterY:");
    paramIntent.append(f3);
    paramIntent.append(" kuolieWidthScale:");
    paramIntent.append(f4);
    paramIntent.append(" kuolieHeightScale:");
    paramIntent.append(f5);
    paramIntent.append(" kuolieRotate:");
    paramIntent.append(f6);
    AEQLog.b("AEEditorGenerateBroadcastReceiver", paramIntent.toString());
    if (this.mAETavSessionStatusListener != null)
    {
      if ("AEEDITOR_GENERATE_STATUS_ERROR".equals(paramContext))
      {
        this.mAETavSessionStatusListener.onAETavSessionExportError(str5, j, str8);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_DOWNLOADING".equals(paramContext))
      {
        this.mAETavSessionStatusListener.onAETavSessionExporting(str5, f1);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_READY".equals(paramContext)) {
        this.mAETavSessionStatusListener.onAETavSessionExportCompleted(str9, str1, str2, str3, str4, i, str5, str6, str7, str10, f2, f3, f4, f5, f6);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AEEditorGenerateBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */