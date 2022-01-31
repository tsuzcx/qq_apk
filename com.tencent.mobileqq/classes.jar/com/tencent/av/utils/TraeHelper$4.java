package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import lga;
import lid;
import mqq.util.WeakReference;
import mvh;
import mwk;
import mww;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(mwk parammwk) {}
  
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
          if ((!mwk.a(this.this$0)) || (!mvh.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          mww.a((View)localObject, ((Button)localObject).getResources().getString(2131690328));
        }
      }
      this.this$0.a.a().a("handFreeJob", mwk.a(this.this$0).O);
      mwk.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((lga)localObject).b();
    return;
    ((Button)localObject).setSelected(mwk.a(this.this$0).O);
    Resources localResources = ((Button)localObject).getResources();
    if (mwk.a(this.this$0).O) {}
    for (int i = 2131690329;; i = 2131690330)
    {
      mww.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */