package com.tencent.biz.publicAccountImageCollection;

import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class PublicAccountImageCollectionMainActivity$9
  implements Runnable
{
  PublicAccountImageCollectionMainActivity$9(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = PublicAccountImageCollectionMainActivity.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      this.this$0.a.setVisibility(0);
      this.this$0.a.findViewById(2131378761).setVisibility(0);
      this.this$0.a.findViewById(2131378755).setVisibility(0);
      this.this$0.a.findViewById(2131378756).setVisibility(0);
      this.this$0.a.bringToFront();
      this.this$0.a.startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.9
 * JD-Core Version:    0.7.0.1
 */