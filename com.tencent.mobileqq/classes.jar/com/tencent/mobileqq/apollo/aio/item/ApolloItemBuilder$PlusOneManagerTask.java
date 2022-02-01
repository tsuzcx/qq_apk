package com.tencent.mobileqq.apollo.aio.item;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import java.lang.ref.WeakReference;

class ApolloItemBuilder$PlusOneManagerTask
  implements Runnable
{
  WeakReference<ApolloItemBuilder.Holder> a;
  WeakReference<ApolloItemBuilder> b;
  WeakReference<MessageForApollo> c;
  int d;
  boolean e;
  
  public ApolloItemBuilder$PlusOneManagerTask(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.b = new WeakReference(paramApolloItemBuilder);
    this.a = new WeakReference(paramHolder);
    this.c = new WeakReference(paramMessageForApollo);
    this.d = paramInt;
  }
  
  public void run()
  {
    ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.b.get();
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)this.a.get();
    MessageForApollo localMessageForApollo = (MessageForApollo)this.c.get();
    if ((localApolloItemBuilder != null) && (localHolder != null))
    {
      if (localMessageForApollo == null) {
        return;
      }
      if (!(localHolder instanceof ApolloItemBuilder.Holder)) {
        return;
      }
      if (this.d == 0)
      {
        if ((!(localHolder.x.getContext() instanceof MultiForwardActivity)) && (!this.e) && (!localApolloItemBuilder.f.G)) {
          if (localMessageForApollo.isSend())
          {
            localHolder.x.setVisibility(0);
            localHolder.y.setVisibility(8);
          }
          else
          {
            localHolder.x.setVisibility(8);
            localHolder.y.setVisibility(0);
          }
        }
        ApolloItemBuilder.a(localApolloItemBuilder, true);
      }
      if ((this.d == 1) && (ApolloItemBuilder.a(localApolloItemBuilder) == localMessageForApollo.uniseq))
      {
        localHolder.x.setVisibility(8);
        localHolder.y.setVisibility(8);
        ApolloItemBuilder.a(localApolloItemBuilder, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.PlusOneManagerTask
 * JD-Core Version:    0.7.0.1
 */