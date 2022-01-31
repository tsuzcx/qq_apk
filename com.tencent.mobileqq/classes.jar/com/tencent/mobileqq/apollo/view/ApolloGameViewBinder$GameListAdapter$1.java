package com.tencent.mobileqq.apollo.view;

import aiys;
import ajbl;
import ajbq;
import android.graphics.Color;
import android.widget.ImageView;
import bepn;
import bepo;
import bepp;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(ajbq paramajbq, ImageView paramImageView) {}
  
  public void run()
  {
    if ((ajbq.a(this.this$0) == null) && (ajbq.a(this.this$0) != null) && (ajbq.a(this.this$0).get() != null))
    {
      Object localObject = (ajbl)ajbq.a(this.this$0).get();
      if ((ajbl.a((ajbl)localObject) != null) && (ajbl.a((ajbl)localObject).a != null))
      {
        localObject = bepn.a(ajbl.a((ajbl)ajbq.a(this.this$0).get()).a).b(8).a(aiys.aH).a(16.0F).a(-1);
        ((bepo)localObject).c(50);
        localObject = new bepp((bepo)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          ajbq.a(this.this$0, ((bepo)localObject).a());
        }
      }
    }
    if (ajbq.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      ajbq.a(this.this$0).a(83);
      ajbq.a(this.this$0).c(2);
      ajbq.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */