package com.tencent.mobileqq.apollo.script;

import ajev;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.ApolloTicker;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SpriteBackgroundManager$2
  implements Runnable
{
  public SpriteBackgroundManager$2(ajev paramajev) {}
  
  public void run()
  {
    ApolloTextureView localApolloTextureView = (ApolloTextureView)ajev.a(this.this$0).get();
    if ((localApolloTextureView != null) && (localApolloTextureView.getRender() != null) && (localApolloTextureView.getRender().mApolloTicker != null)) {
      ApolloRender.tickerResume(localApolloTextureView.getRender().mApolloTicker.ticker);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteBackgroundManager", 2, "mResumeTickerTask");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBackgroundManager.2
 * JD-Core Version:    0.7.0.1
 */