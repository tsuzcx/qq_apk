package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class RIJDataManager$1
  implements Animation.AnimationListener
{
  RIJDataManager$1(RIJDataManager paramRIJDataManager, BaseArticleInfo paramBaseArticleInfo, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      ThreadManager.getUIHandler().post(new RIJDataManager.1.1(this));
      return;
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.1
 * JD-Core Version:    0.7.0.1
 */