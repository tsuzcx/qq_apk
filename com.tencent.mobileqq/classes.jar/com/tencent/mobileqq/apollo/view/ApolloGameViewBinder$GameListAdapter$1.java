package com.tencent.mobileqq.apollo.view;

import aliu;
import alln;
import alls;
import android.graphics.Color;
import android.widget.ImageView;
import bidc;
import bidd;
import bide;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(alls paramalls, ImageView paramImageView) {}
  
  public void run()
  {
    if ((alls.a(this.this$0) == null) && (alls.a(this.this$0) != null) && (alls.a(this.this$0).get() != null))
    {
      Object localObject = (alln)alls.a(this.this$0).get();
      if ((alln.a((alln)localObject) != null) && (alln.a((alln)localObject).a != null))
      {
        localObject = bidc.a(alln.a((alln)alls.a(this.this$0).get()).a).b(8).a(aliu.aH).a(16.0F).a(-1);
        ((bidd)localObject).c(50);
        localObject = new bide((bidd)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          alls.a(this.this$0, ((bidd)localObject).a());
        }
      }
    }
    if (alls.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      alls.a(this.this$0).a(83);
      alls.a(this.this$0).c(2);
      alls.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */