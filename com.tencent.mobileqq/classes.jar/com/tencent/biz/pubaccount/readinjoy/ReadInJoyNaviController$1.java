package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import ors;
import ort;

public class ReadInJoyNaviController$1
  implements Runnable
{
  public ReadInJoyNaviController$1(ors paramors) {}
  
  public void run()
  {
    Object localObject = ors.a(this.this$0).a();
    ors.a(this.this$0, 1000L);
    if ((localObject != null) && (ors.a(this.this$0)))
    {
      ors.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -((View)localObject).getHeight(), ors.e);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new ort(this, (View)localObject));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (ors.a(this.this$0) != null)
      {
        localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        ors.a(this.this$0).startAnimation((Animation)localObject);
      }
      ors.a(0, ors.a(0, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1
 * JD-Core Version:    0.7.0.1
 */