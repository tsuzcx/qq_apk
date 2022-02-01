package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import lcv;
import lez;
import msu;
import mua;
import mum;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(mua parammua) {}
  
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
          if ((!mua.a(this.this$0)) || (!msu.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          mum.a((View)localObject, ((Button)localObject).getResources().getString(2131690195));
        }
      }
      this.this$0.a.a().b("handFreeJob", mua.a(this.this$0).P);
      mua.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((lcv)localObject).b();
    return;
    ((Button)localObject).setSelected(mua.a(this.this$0).P);
    Resources localResources = ((Button)localObject).getResources();
    if (mua.a(this.this$0).P) {}
    for (int i = 2131690196;; i = 2131690197)
    {
      mum.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */