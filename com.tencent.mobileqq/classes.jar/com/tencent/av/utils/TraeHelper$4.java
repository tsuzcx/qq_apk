package com.tencent.av.utils;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import java.lang.ref.WeakReference;
import lda;
import lfe;
import mtr;
import muy;
import mvk;

public class TraeHelper$4
  implements Runnable
{
  public TraeHelper$4(muy parammuy) {}
  
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
          if ((!muy.a(this.this$0)) || (!mtr.a())) {
            break;
          }
          ((Button)localObject).setSelected(true);
          mvk.a((View)localObject, ((Button)localObject).getResources().getString(2131690233));
        }
      }
      this.this$0.a.a().b("handFreeJob", muy.a(this.this$0).P);
      muy.a(this.this$0);
      localObject = this.this$0.a.a.a();
    } while (localObject == null);
    ((lda)localObject).b();
    return;
    ((Button)localObject).setSelected(muy.a(this.this$0).P);
    Resources localResources = ((Button)localObject).getResources();
    if (muy.a(this.this$0).P) {}
    for (int i = 2131690234;; i = 2131690235)
    {
      mvk.a((View)localObject, localResources.getString(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.4
 * JD-Core Version:    0.7.0.1
 */