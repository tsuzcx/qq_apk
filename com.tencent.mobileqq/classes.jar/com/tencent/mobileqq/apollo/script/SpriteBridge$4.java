package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl;

class SpriteBridge$4
  implements Runnable
{
  SpriteBridge$4(SpriteBridge paramSpriteBridge) {}
  
  public void run()
  {
    if ((SpriteBridge.b(this.this$0) != null) && (SpriteBridge.b(this.this$0).m() != null))
    {
      ApolloAIOHelperImpl localApolloAIOHelperImpl = (ApolloAIOHelperImpl)SpriteBridge.b(this.this$0).m().q(8);
      if (localApolloAIOHelperImpl != null) {
        localApolloAIOHelperImpl.addApolloBackgroundSurfaceView();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge.4
 * JD-Core Version:    0.7.0.1
 */