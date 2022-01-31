package com.tencent.mobileqq.apollo.process.data;

import ajcf;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

public class CmGameLauncher$8
  extends IApolloRunnableTask
{
  public CmGameLauncher$8(ajcf paramajcf) {}
  
  public String a()
  {
    return "resumeTickerTask";
  }
  
  public void run()
  {
    if ((ajcf.a(this.this$0) != null) && (ajcf.a(this.this$0).getRender() != null) && (ajcf.a(this.this$0).getRender().mApolloTicker != null))
    {
      ApolloRender.tickerResume(ajcf.a(this.this$0).getRender().mApolloTicker.ticker);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 2, "mResumeTickerTask");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.8
 * JD-Core Version:    0.7.0.1
 */