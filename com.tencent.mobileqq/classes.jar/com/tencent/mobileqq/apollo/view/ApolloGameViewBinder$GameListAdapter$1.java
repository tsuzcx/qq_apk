package com.tencent.mobileqq.apollo.view;

import ajms;
import ajpl;
import ajpq;
import android.graphics.Color;
import android.widget.ImageView;
import bfxy;
import bfxz;
import bfya;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(ajpq paramajpq, ImageView paramImageView) {}
  
  public void run()
  {
    if ((ajpq.a(this.this$0) == null) && (ajpq.a(this.this$0) != null) && (ajpq.a(this.this$0).get() != null))
    {
      Object localObject = (ajpl)ajpq.a(this.this$0).get();
      if ((ajpl.a((ajpl)localObject) != null) && (ajpl.a((ajpl)localObject).a != null))
      {
        localObject = bfxy.a(ajpl.a((ajpl)ajpq.a(this.this$0).get()).a).b(8).a(ajms.aH).a(16.0F).a(-1);
        ((bfxz)localObject).c(50);
        localObject = new bfya((bfxz)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          ajpq.a(this.this$0, ((bfxz)localObject).a());
        }
      }
    }
    if (ajpq.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      ajpq.a(this.this$0).a(83);
      ajpq.a(this.this$0).c(2);
      ajpq.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */