package com.tencent.mobileqq.apollo.script;

import airz;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SpriteBackgroundManager$1
  implements Runnable
{
  public SpriteBackgroundManager$1(airz paramairz) {}
  
  public void run()
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)airz.a(this.this$0).get();
    if ((localApolloTextureView != null) && (localApolloTextureView.getRender() != null) && (localApolloTextureView.getRender().mApolloTicker != null)) {
      ApolloRender.tickerPause(localApolloTextureView.getRender().mApolloTicker.ticker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "mPauseTickerTask");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.1
 * JD-Core Version:    0.7.0.1
 */