package com.tencent.mobileqq.apollo.view;

import alef;
import algy;
import alhd;
import android.graphics.Color;
import android.widget.ImageView;
import bhyv;
import bhyw;
import bhyx;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(alhd paramalhd, ImageView paramImageView) {}
  
  public void run()
  {
    if ((alhd.a(this.this$0) == null) && (alhd.a(this.this$0) != null) && (alhd.a(this.this$0).get() != null))
    {
      Object localObject = (algy)alhd.a(this.this$0).get();
      if ((algy.a((algy)localObject) != null) && (algy.a((algy)localObject).a != null))
      {
        localObject = bhyv.a(algy.a((algy)alhd.a(this.this$0).get()).a).b(8).a(alef.aH).a(16.0F).a(-1);
        ((bhyw)localObject).c(50);
        localObject = new bhyx((bhyw)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          alhd.a(this.this$0, ((bhyw)localObject).a());
        }
      }
    }
    if (alhd.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      alhd.a(this.this$0).a(83);
      alhd.a(this.this$0).c(2);
      alhd.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */