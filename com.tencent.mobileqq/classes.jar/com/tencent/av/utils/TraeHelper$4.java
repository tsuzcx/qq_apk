package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;

class TraeHelper$4
  implements Runnable
{
  TraeHelper$4(TraeHelper paramTraeHelper) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    Object localObject;
    do
    {
      return;
      if (this.this$0.b != null)
      {
        localObject = (Button)this.this$0.b.get();
        if (localObject != null)
        {
          ((Button)localObject).setClickable(true);
          if ((!TraeHelper.a(this.this$0)) || (!QAVConfigUtils.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          UITools.a((View)localObject, ((Button)localObject).getResources().getString(2131690297));
        }
      }
      this.this$0.a.a().b("handFreeJob", TraeHelper.a(this.this$0).P);
      TraeHelper.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((VideoRecoveryMonitor)localObject).b();
    return;
    ((Button)localObject).setSelected(TraeHelper.a(this.this$0).P);
    Resources localResources = ((Button)localObject).getResources();
    if (TraeHelper.a(this.this$0).P) {}
    for (int i = 2131690298;; i = 2131690299)
    {
      UITools.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */