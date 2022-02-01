package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class CmGameLauncher$2
  implements Runnable
{
  CmGameLauncher$2(CmGameLauncher paramCmGameLauncher) {}
  
  public void run()
  {
    if (CmGameLauncher.a(this.this$0) != null) {
      CmGameLauncher.a(this.this$0).onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.2
 * JD-Core Version:    0.7.0.1
 */