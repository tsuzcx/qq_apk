package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class CommentBiuProteusItem$2
  implements Animation.AnimationListener
{
  CommentBiuProteusItem$2(CommentBiuProteusItem paramCommentBiuProteusItem, View paramView, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        CommentBiuProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemCommentBiuProteusItem, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.CommentBiuProteusItem.2
 * JD-Core Version:    0.7.0.1
 */