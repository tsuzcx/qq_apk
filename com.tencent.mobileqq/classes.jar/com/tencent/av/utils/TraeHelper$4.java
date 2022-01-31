package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import ktn;
import kvq;
import mhr;
import miu;
import mjg;
import mqq.util.WeakReference;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(miu parammiu) {}
  
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
          if ((!miu.a(this.this$0)) || (!mhr.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          mjg.a((View)localObject, ((Button)localObject).getResources().getString(2131624716));
        }
      }
      this.this$0.a.a().a("handFreeJob", miu.a(this.this$0).N);
      miu.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((ktn)localObject).b();
    return;
    ((Button)localObject).setSelected(miu.a(this.this$0).N);
    Resources localResources = ((Button)localObject).getResources();
    if (miu.a(this.this$0).N) {}
    for (int i = 2131624717;; i = 2131624718)
    {
      mjg.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */