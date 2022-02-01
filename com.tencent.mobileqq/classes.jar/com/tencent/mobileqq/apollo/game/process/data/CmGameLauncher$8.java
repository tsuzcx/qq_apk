package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTicker;
import com.tencent.qphone.base.util.QLog;

class CmGameLauncher$8
  extends IApolloRunnableTask
{
  CmGameLauncher$8(CmGameLauncher paramCmGameLauncher) {}
  
  public void run()
  {
    if ((CmGameLauncher.a(this.this$0) != null) && (CmGameLauncher.a(this.this$0).getRender() != null) && (CmGameLauncher.a(this.this$0).getRender().mApolloTicker != null))
    {
      ApolloRender.tickerResume(CmGameLauncher.a(this.this$0).getRender().mApolloTicker.ticker);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "mResumeTickerTask");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.8
 * JD-Core Version:    0.7.0.1
 */