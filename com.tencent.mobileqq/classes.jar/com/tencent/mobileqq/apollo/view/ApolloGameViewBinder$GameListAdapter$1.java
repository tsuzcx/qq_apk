package com.tencent.mobileqq.apollo.view;

import android.graphics.Color;
import android.widget.ImageView;
import annv;
import anqo;
import anqt;
import blrr;
import blrs;
import blrt;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(anqt paramanqt, ImageView paramImageView) {}
  
  public void run()
  {
    if ((anqt.a(this.this$0) == null) && (anqt.a(this.this$0) != null) && (anqt.a(this.this$0).get() != null))
    {
      Object localObject = (anqo)anqt.a(this.this$0).get();
      if ((anqo.a((anqo)localObject) != null) && (anqo.a((anqo)localObject).a != null))
      {
        localObject = blrr.a(anqo.a((anqo)anqt.a(this.this$0).get()).a).b(8).a(annv.aH).a(16.0F).a(-1);
        ((blrs)localObject).c(50);
        localObject = new blrt((blrs)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          anqt.a(this.this$0, ((blrs)localObject).a());
        }
      }
    }
    if (anqt.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      anqt.a(this.this$0).a(83);
      anqt.a(this.this$0).c(2);
      anqt.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */