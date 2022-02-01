package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.ViewHolder;
import java.util.ArrayList;

class RIJDislikeManager$1$1
  implements Animation.AnimationListener
{
  RIJDislikeManager$1$1(RIJDislikeManager.1 param1, ArrayList paramArrayList, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDecouplingUilayerFramewrokDislikeRIJDislikeManager$1.a.g.post(new RIJDislikeManager.1.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.dislike.RIJDislikeManager.1.1
 * JD-Core Version:    0.7.0.1
 */