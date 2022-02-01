package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl;

class SpriteBridge$4
  implements Runnable
{
  SpriteBridge$4(SpriteBridge paramSpriteBridge) {}
  
  public void run()
  {
    if ((SpriteBridge.a(this.this$0) != null) && (SpriteBridge.a(this.this$0).a() != null))
    {
      ApolloAIOHelperImpl localApolloAIOHelperImpl = (ApolloAIOHelperImpl)SpriteBridge.a(this.this$0).a().a(8);
      if (localApolloAIOHelperImpl != null) {
        localApolloAIOHelperImpl.addApolloBackgroundSurfaceView();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.4
 * JD-Core Version:    0.7.0.1
 */