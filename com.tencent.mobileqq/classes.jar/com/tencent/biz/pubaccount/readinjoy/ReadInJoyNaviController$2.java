package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import nua;
import nud;

public class ReadInJoyNaviController$2
  implements Runnable
{
  public ReadInJoyNaviController$2(nua paramnua, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    Object localObject = nua.a(this.this$0).a();
    nua.a(this.this$0, 1000L);
    if ((localObject != null) && (nua.a(this.this$0)))
    {
      nua.a(this.this$0, false);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -((View)localObject).getHeight());
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new nud(this));
      ((View)localObject).startAnimation(localTranslateAnimation);
      if (nua.a(this.this$0) != null)
      {
        localObject = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        ((Animation)localObject).setFillEnabled(true);
        ((Animation)localObject).setFillAfter(true);
        nua.a(this.this$0).startAnimation((Animation)localObject);
      }
      nua.a(1, nua.a(1, this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2
 * JD-Core Version:    0.7.0.1
 */