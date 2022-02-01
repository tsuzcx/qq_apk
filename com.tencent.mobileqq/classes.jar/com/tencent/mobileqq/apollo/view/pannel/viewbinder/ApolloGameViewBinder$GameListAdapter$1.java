package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.graphics.Color;
import android.widget.ImageView;
import anka;
import anpu;
import anpz;
import blhb;
import blhc;
import blhd;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(anpz paramanpz, ImageView paramImageView) {}
  
  public void run()
  {
    if ((anpz.a(this.this$0) == null) && (anpz.a(this.this$0) != null) && (anpz.a(this.this$0).get() != null))
    {
      Object localObject = (anpu)anpz.a(this.this$0).get();
      if ((anpu.a((anpu)localObject) != null) && (anpu.a((anpu)localObject).mActivity != null))
      {
        localObject = blhb.a(anpu.a((anpu)anpz.a(this.this$0).get()).mActivity).b(8).a(anka.U).a(16.0F).a(-1);
        ((blhc)localObject).c(50);
        localObject = new blhd((blhc)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          anpz.a(this.this$0, ((blhc)localObject).a());
        }
      }
    }
    if (anpz.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      anpz.a(this.this$0).a(83);
      anpz.a(this.this$0).c(2);
      anpz.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */