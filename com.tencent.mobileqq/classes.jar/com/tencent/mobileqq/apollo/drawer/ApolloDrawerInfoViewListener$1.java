package com.tencent.mobileqq.apollo.drawer;

import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import java.lang.ref.WeakReference;

class ApolloDrawerInfoViewListener$1
  implements Runnable
{
  ApolloDrawerInfoViewListener$1(ApolloDrawerInfoViewListener paramApolloDrawerInfoViewListener) {}
  
  public void run()
  {
    if (ApolloDrawerInfoViewListener.a(this.this$0).get() != null) {
      ((SpriteDrawerInfoManager)ApolloDrawerInfoViewListener.a(this.this$0).get()).a(ApolloDrawerInfoViewListener.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoViewListener.1
 * JD-Core Version:    0.7.0.1
 */