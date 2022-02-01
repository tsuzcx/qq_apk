package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import oii;
import oil;

public class ReadInJoyNaviController$2
  implements Runnable
{
  public ReadInJoyNaviController$2(oii paramoii, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    Object localObject = oii.a(this.this$0).a();
    oii.a(this.this$0, 1000L);
    if ((localObject != null) && (oii.a(this.this$0)))
    {
      oii.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -((View)localObject).getHeight());
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new oil(this));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (oii.a(this.this$0) != null)
      {
        localObject = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        oii.a(this.this$0).startAnimation((Animation)localObject);
      }
      oii.a(1, oii.a(1, this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2
 * JD-Core Version:    0.7.0.1
 */