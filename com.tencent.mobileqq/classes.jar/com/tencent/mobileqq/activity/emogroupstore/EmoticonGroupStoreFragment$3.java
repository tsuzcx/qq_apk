package com.tencent.mobileqq.activity.emogroupstore;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class EmoticonGroupStoreFragment$3
  extends AnimateUtils.AnimationAdapter
{
  EmoticonGroupStoreFragment$3(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(true);
    EmoticonGroupStoreFragment.a(this.a, false);
    this.a.titleRoot.removeView(EmoticonGroupStoreFragment.e(this.a));
    this.a.titleRoot.removeView(EmoticonGroupStoreFragment.f(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment.3
 * JD-Core Version:    0.7.0.1
 */