package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class PublicAccountImageCollectionMainActivityImpl$9
  implements Runnable
{
  PublicAccountImageCollectionMainActivityImpl$9(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivityImpl.access$2200(this.this$0);
    if (localTranslateAnimation != null)
    {
      this.this$0.mUserGuide.setVisibility(0);
      this.this$0.mUserGuide.findViewById(2131449246).setVisibility(0);
      this.this$0.mUserGuide.findViewById(2131449242).setVisibility(0);
      this.this$0.mUserGuide.findViewById(2131449243).setVisibility(0);
      this.this$0.mUserGuide.bringToFront();
      this.this$0.mUserGuide.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.9
 * JD-Core Version:    0.7.0.1
 */