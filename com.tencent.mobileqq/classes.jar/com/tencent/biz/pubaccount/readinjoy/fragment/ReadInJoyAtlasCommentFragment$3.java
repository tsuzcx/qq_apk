package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ReadInJoyAtlasCommentFragment$3
  implements Animation.AnimationListener
{
  ReadInJoyAtlasCommentFragment$3(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.getView().setVisibility(8);
    this.a.getActivity().setResult(-1);
    this.a.getActivity().finish();
    this.a.getActivity().overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment.3
 * JD-Core Version:    0.7.0.1
 */