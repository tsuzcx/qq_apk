package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import ldx;
import lga;
import mqq.util.WeakReference;
import msn;
import mtq;
import muc;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(mtq parammtq) {}
  
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
          if ((!mtq.a(this.this$0)) || (!msn.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          muc.a((View)localObject, ((Button)localObject).getResources().getString(2131690277));
        }
      }
      this.this$0.a.a().a("handFreeJob", mtq.a(this.this$0).N);
      mtq.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((ldx)localObject).b();
    return;
    ((Button)localObject).setSelected(mtq.a(this.this$0).N);
    Resources localResources = ((Button)localObject).getResources();
    if (mtq.a(this.this$0).N) {}
    for (int i = 2131690278;; i = 2131690279)
    {
      muc.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */