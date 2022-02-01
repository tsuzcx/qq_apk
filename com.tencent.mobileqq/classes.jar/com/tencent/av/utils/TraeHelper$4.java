package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import lcu;
import ley;
import mqq.util.WeakReference;
import msn;
import mts;
import mue;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(mts parammts) {}
  
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
          if ((!mts.a(this.this$0)) || (!msn.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          mue.a((View)localObject, ((Button)localObject).getResources().getString(2131690160));
        }
      }
      this.this$0.a.a().b("handFreeJob", mts.a(this.this$0).P);
      mts.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((lcu)localObject).b();
    return;
    ((Button)localObject).setSelected(mts.a(this.this$0).P);
    Resources localResources = ((Button)localObject).getResources();
    if (mts.a(this.this$0).P) {}
    for (int i = 2131690161;; i = 2131690162)
    {
      mue.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */