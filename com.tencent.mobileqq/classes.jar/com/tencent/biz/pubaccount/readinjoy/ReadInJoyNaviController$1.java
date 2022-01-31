package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import nxf;
import nxg;

public class ReadInJoyNaviController$1
  implements Runnable
{
  public ReadInJoyNaviController$1(nxf paramnxf) {}
  
  public void run()
  {
    Object localObject = nxf.a(this.this$0).a();
    nxf.a(this.this$0, 1000L);
    if ((localObject != null) && (nxf.a(this.this$0)))
    {
      nxf.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -((View)localObject).getHeight(), this.this$0.e);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new nxg(this, (View)localObject));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (nxf.a(this.this$0) != null)
      {
        localObject = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        nxf.a(this.this$0).startAnimation((Animation)localObject);
      }
      nxf.a(0, nxf.a(0, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1
 * JD-Core Version:    0.7.0.1
 */