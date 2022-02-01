package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class CmGameLauncher$6
  extends IApolloRunnableTask
{
  CmGameLauncher$6(CmGameLauncher paramCmGameLauncher) {}
  
  public void run()
  {
    ApolloCmdChannel.getInstance().requestData(CmGameLauncher.a(this.this$0).getLuaState(), "cs.make_room_min.local", "{}", true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.6
 * JD-Core Version:    0.7.0.1
 */