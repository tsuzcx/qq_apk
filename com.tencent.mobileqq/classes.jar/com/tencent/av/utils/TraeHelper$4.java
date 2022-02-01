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
    if (this.this$0.d == null) {
      return;
    }
    if (this.this$0.g != null)
    {
      localObject = (Button)this.this$0.g.get();
      if (localObject != null)
      {
        ((Button)localObject).setClickable(true);
        if ((TraeHelper.b(this.this$0)) && (QAVConfigUtils.a()))
        {
          ((Button)localObject).setSelected(true);
          UITools.a((View)localObject, ((Button)localObject).getResources().getString(2131887115));
        }
        else
        {
          ((Button)localObject).setSelected(TraeHelper.c(this.this$0).aG);
          Resources localResources = ((Button)localObject).getResources();
          int i;
          if (TraeHelper.c(this.this$0).aG) {
            i = 2131887116;
          } else {
            i = 2131887117;
          }
          UITools.a((View)localObject, localResources.getString(i));
        }
      }
    }
    this.this$0.d.k().b("handFreeJob", TraeHelper.c(this.this$0).aG);
    TraeHelper.d(this.this$0);
    Object localObject = this.this$0.d.e.d();
    if (localObject != null) {
      ((VideoRecoveryMonitor)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */