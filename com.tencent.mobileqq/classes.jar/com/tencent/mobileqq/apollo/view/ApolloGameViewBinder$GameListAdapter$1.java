package com.tencent.mobileqq.apollo.view;

import ancb;
import android.graphics.Color;
import android.widget.ImageView;
import anet;
import aney;
import bkqo;
import bkqp;
import bkqq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ApolloGameViewBinder$GameListAdapter$1
  implements Runnable
{
  public ApolloGameViewBinder$GameListAdapter$1(aney paramaney, ImageView paramImageView) {}
  
  public void run()
  {
    if ((aney.a(this.this$0) == null) && (aney.a(this.this$0) != null) && (aney.a(this.this$0).get() != null))
    {
      Object localObject = (anet)aney.a(this.this$0).get();
      if ((anet.a((anet)localObject) != null) && (anet.a((anet)localObject).a != null))
      {
        localObject = bkqo.a(anet.a((anet)aney.a(this.this$0).get()).a).b(8).a(ancb.aH).a(16.0F).a(-1);
        ((bkqp)localObject).c(50);
        localObject = new bkqq((bkqp)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          aney.a(this.this$0, ((bkqp)localObject).a());
        }
      }
    }
    if (aney.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.a.getX() + " " + this.a.getY());
      }
      aney.a(this.this$0).a(83);
      aney.a(this.this$0).c(2);
      aney.a(this.this$0).b(this.a, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */