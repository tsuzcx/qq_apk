package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;

class ApolloVoiceDIYHelper$1
  implements Runnable
{
  ApolloVoiceDIYHelper$1(ApolloVoiceDIYHelper paramApolloVoiceDIYHelper, ApolloTextureView paramApolloTextureView, double paramDouble) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.a.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null)) {
      localApolloRender.getSavaWrapper().drawSpecialFrame(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloVoiceDIYHelper.1
 * JD-Core Version:    0.7.0.1
 */