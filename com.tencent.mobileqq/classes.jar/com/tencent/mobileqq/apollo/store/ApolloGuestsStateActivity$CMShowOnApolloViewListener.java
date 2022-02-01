package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class ApolloGuestsStateActivity$CMShowOnApolloViewListener
  implements OnApolloViewListener
{
  private SoftReference<ApolloGuestsStateActivity> a;
  
  public ApolloGuestsStateActivity$CMShowOnApolloViewListener(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    this.a = new SoftReference(paramApolloGuestsStateActivity);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloGuestsStateActivity", 2, "apollo view is Ready.");
    }
    ApolloGuestsStateActivity localApolloGuestsStateActivity = (ApolloGuestsStateActivity)this.a.get();
    if ((localApolloGuestsStateActivity != null) && (localApolloGuestsStateActivity.mSurfaceView != null))
    {
      if (ApolloGuestsStateActivity.access$100(localApolloGuestsStateActivity) == null) {
        return;
      }
      float f3 = FontSettingManager.getFontLevel() / 16.0F;
      float f2 = localApolloGuestsStateActivity.mDensity;
      float f1 = f2;
      if (0.0F != f3) {
        f1 = f2 / f3;
      }
      localApolloGuestsStateActivity.mApolloWidth = (paramInt1 / 2 / f1);
      if (localApolloGuestsStateActivity.mSurfaceView.getRenderImpl() != null) {
        localApolloGuestsStateActivity.mSurfaceView.getRenderImpl().a();
      }
      ApolloGuestsStateActivity.access$100(localApolloGuestsStateActivity).c();
      localApolloGuestsStateActivity.mManWidth = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.CMShowOnApolloViewListener
 * JD-Core Version:    0.7.0.1
 */