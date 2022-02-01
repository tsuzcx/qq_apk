package com.tencent.aelight.camera.ae.biz.circle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.view.TabLayout;
import mqq.util.WeakReference;

final class AECircleMultiUnit$AEEditorUIBroadCast
  extends BroadcastReceiver
{
  private TabLayout a;
  
  public void a(TabLayout paramTabLayout)
  {
    this.a = ((TabLayout)new WeakReference(paramTabLayout).get());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    boolean bool = "ae_editor_bottom_tab_show_hide".equals(paramContext);
    int i = 0;
    if (bool)
    {
      bool = paramIntent.getBooleanExtra("is_show", true);
      paramContext = this.a;
      if (paramContext != null)
      {
        if (!bool) {
          i = 8;
        }
        paramContext.setVisibility(i);
      }
    }
    else if ("ae_editor_bottom_tab_change_style".equals(paramContext))
    {
      bool = paramIntent.getBooleanExtra("is_full_screen_capture", false);
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.a(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleMultiUnit.AEEditorUIBroadCast
 * JD-Core Version:    0.7.0.1
 */