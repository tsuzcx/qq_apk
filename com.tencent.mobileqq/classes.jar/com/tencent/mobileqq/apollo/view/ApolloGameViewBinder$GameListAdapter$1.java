package com.tencent.mobileqq.apollo.view;

import amip;
import amli;
import amln;
import android.graphics.Color;
import android.widget.ImageView;
import bjvq;
import bjvr;
import bjvs;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(amln paramamln, ImageView paramImageView) {}
  
  public void run()
  {
    if ((amln.a(this.this$0) == null) && (amln.a(this.this$0) != null) && (amln.a(this.this$0).get() != null))
    {
      Object localObject = (amli)amln.a(this.this$0).get();
      if ((amli.a((amli)localObject) != null) && (amli.a((amli)localObject).mActivity != null))
      {
        localObject = bjvq.a(amli.a((amli)amln.a(this.this$0).get()).mActivity).b(8).a(amip.aH).a(16.0F).a(-1);
        ((bjvr)localObject).c(50);
        localObject = new bjvs((bjvr)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          amln.a(this.this$0, ((bjvr)localObject).a());
        }
      }
    }
    if (amln.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      amln.a(this.this$0).a(83);
      amln.a(this.this$0).c(2);
      amln.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */