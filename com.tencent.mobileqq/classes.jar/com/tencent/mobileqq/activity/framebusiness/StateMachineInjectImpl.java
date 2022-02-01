package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.statemachine.api.IStateManager;

public class StateMachineInjectImpl
  extends BaseFrameBusiness
{
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((paramFrameFragment instanceof MainFragment)) {
      ((IStateManager)QRoute.api(IStateManager.class)).onMainTabChange(paramInt2);
    }
  }
  
  public void d(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment instanceof MainFragment)) {
      ((IStateManager)QRoute.api(IStateManager.class)).onMainFragmentChange(true);
    }
  }
  
  public void e(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment instanceof MainFragment)) {
      ((IStateManager)QRoute.api(IStateManager.class)).onMainFragmentChange(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.StateMachineInjectImpl
 * JD-Core Version:    0.7.0.1
 */