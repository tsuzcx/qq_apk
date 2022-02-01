package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

class WebFastLikeDislikeCreator$ViewHolder$2
  implements Animation.AnimationListener
{
  WebFastLikeDislikeCreator$ViewHolder$2(WebFastLikeDislikeCreator.ViewHolder paramViewHolder, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = WebFastLikeDislikeCreator.ViewHolder.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastLikeDislikeCreator$ViewHolder);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a) {}
    for (int i = 2130843069;; i = 2130841845)
    {
      localImageView.setImageResource(i);
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastLikeDislikeCreator.ViewHolder.2
 * JD-Core Version:    0.7.0.1
 */