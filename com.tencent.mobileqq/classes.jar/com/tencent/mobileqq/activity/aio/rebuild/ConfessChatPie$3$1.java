package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ConfessChatPie$3$1
  implements OnCompositionLoadedListener
{
  ConfessChatPie$3$1(ConfessChatPie.3 param3) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = AIOUtils.b(30.0F, this.a.this$0.a.getResources());
    int j = AIOUtils.b(30.0F, this.a.this$0.a.getResources());
    if (paramLottieComposition == null)
    {
      QLog.e(this.a.this$0.b, 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).loop(false);
    ConfessChatPie.a(this.a.this$0, (LottieDrawable)localObject);
    ConfessChatPie.a(this.a.this$0).addAnimatorListener(new ConfessChatPie.3.1.1(this));
    ThreadManager.getUIHandler().post(new ConfessChatPie.3.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3.1
 * JD-Core Version:    0.7.0.1
 */