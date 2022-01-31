package com.tencent.mobileqq.apollo.view;

import ajmu;
import ajpn;
import ajps;
import android.graphics.Color;
import android.widget.ImageView;
import bfxh;
import bfxi;
import bfxj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(ajps paramajps, ImageView paramImageView) {}
  
  public void run()
  {
    if ((ajps.a(this.this$0) == null) && (ajps.a(this.this$0) != null) && (ajps.a(this.this$0).get() != null))
    {
      Object localObject = (ajpn)ajps.a(this.this$0).get();
      if ((ajpn.a((ajpn)localObject) != null) && (ajpn.a((ajpn)localObject).a != null))
      {
        localObject = bfxh.a(ajpn.a((ajpn)ajps.a(this.this$0).get()).a).b(8).a(ajmu.aH).a(16.0F).a(-1);
        ((bfxi)localObject).c(50);
        localObject = new bfxj((bfxi)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          ajps.a(this.this$0, ((bfxi)localObject).a());
        }
      }
    }
    if (ajps.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      ajps.a(this.this$0).a(83);
      ajps.a(this.this$0).c(2);
      ajps.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */