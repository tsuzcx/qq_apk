package com.tencent.biz.qqcircle.publish.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QCirclePublishViewModel$AEEditorUIBroadcastReceiver
  extends BroadcastReceiver
{
  public QCirclePublishViewModel$AEEditorUIBroadcastReceiver(QCirclePublishViewModel paramQCirclePublishViewModel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null)
    {
      QLog.e("[QcirclePublish]QCirclePublishViewModel", 1, "[onReceive] : action is null");
      return;
    }
    if ("AEEDITOR_UPDATE_AI_TEXT".equals(paramContext))
    {
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, "onReceive... AEEDITOR_UPDATE_AI_TEXT");
      QCirclePublishViewModel.a(this.a, (HashMap)paramIntent.getSerializableExtra("update_ai_text_map"));
      paramContext = new StringBuilder();
      paramContext.append("onReceive... mAiTextMap:");
      paramContext.append(QCirclePublishViewModel.a(this.a).toString());
      QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, paramContext.toString());
      if (this.a.g != null)
      {
        paramIntent = this.a.g.entrySet().iterator();
        while (paramIntent.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramIntent.next();
          ArrayList localArrayList = (ArrayList)QCirclePublishViewModel.a(this.a).get(localEntry.getKey());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("path:");
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append("\noldTextLabel:");
          localStringBuilder.append(((LocalMediaInfo)localEntry.getValue()).aiTextLabel);
          localStringBuilder.append("\naiTextCache:");
          if (localArrayList != null) {
            paramContext = localArrayList.toString();
          } else {
            paramContext = "null";
          }
          localStringBuilder.append(paramContext);
          QLog.d("[QcirclePublish]QCirclePublishViewModel", 1, localStringBuilder.toString());
          if (localArrayList != null) {
            ((LocalMediaInfo)localEntry.getValue()).aiTextLabel = localArrayList;
          }
        }
      }
      this.a.b.postValue(this.a.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel.AEEditorUIBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */