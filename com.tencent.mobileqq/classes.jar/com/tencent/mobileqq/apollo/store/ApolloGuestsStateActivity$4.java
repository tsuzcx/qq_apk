package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.qphone.base.util.QLog;

class ApolloGuestsStateActivity$4
  implements IRenderCallback
{
  ApolloGuestsStateActivity$4(ApolloGuestsStateActivity paramApolloGuestsStateActivity) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.mSurfaceView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloGuestsStateActivity", 2, "apolloguestActivity stop loop");
      }
      this.a.mSurfaceView.getRenderImpl().a(0L);
    }
  }
  
  public void b_(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.4
 * JD-Core Version:    0.7.0.1
 */