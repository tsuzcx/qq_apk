package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
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
        QLog.d("ApolloGuestsStateActivity", 2, "apolloguestActivity stop loop");
      }
      this.a.mSurfaceView.getRenderImpl().a(0L);
    }
  }
  
  public void a(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.4
 * JD-Core Version:    0.7.0.1
 */