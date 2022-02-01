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
    if (this.this$0.a == null) {
      return;
    }
    if (this.this$0.b != null)
    {
      localObject = (Button)this.this$0.b.get();
      if (localObject != null)
      {
        ((Button)localObject).setClickable(true);
        if ((TraeHelper.a(this.this$0)) && (QAVConfigUtils.a()))
        {
          ((Button)localObject).setSelected(true);
          UITools.a((View)localObject, ((Button)localObject).getResources().getString(2131690215));
        }
        else
        {
          ((Button)localObject).setSelected(TraeHelper.a(this.this$0).E);
          Resources localResources = ((Button)localObject).getResources();
          int i;
          if (TraeHelper.a(this.this$0).E) {
            i = 2131690216;
          } else {
            i = 2131690217;
          }
          UITools.a((View)localObject, localResources.getString(i));
        }
      }
    }
    this.this$0.a.a().b("handFreeJob", TraeHelper.a(this.this$0).E);
    TraeHelper.a(this.this$0);
    Object localObject = this.this$0.a.a.a();
    if (localObject != null) {
      ((VideoRecoveryMonitor)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */