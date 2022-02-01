package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class LoginAnimBtnView$2$1
  implements OnCompositionLoadedListener
{
  LoginAnimBtnView$2$1(LoginAnimBtnView.2 param2) {}
  
  public void onCompositionLoaded(LottieComposition arg1)
  {
    if ((??? != null) && (!LoginAnimBtnView.a(this.a.this$0)))
    {
      int i = Utils.a(70.0F, this.a.this$0.getResources());
      int j = Utils.a(70.0F, this.a.this$0.getResources());
      Object localObject1 = ???.getBounds();
      float f1 = i / ((Rect)localObject1).width();
      float f2 = j / ((Rect)localObject1).height();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCompositionLoaded iw:");
        localStringBuilder.append(i);
        localStringBuilder.append(", ih:");
        localStringBuilder.append(j);
        localStringBuilder.append(": : rw:");
        localStringBuilder.append(((Rect)localObject1).width());
        localStringBuilder.append(", rh:");
        localStringBuilder.append(((Rect)localObject1).height());
        QLog.i("LoginAnimBtnView", 2, localStringBuilder.toString());
      }
      localObject1 = new LottieDrawable();
      ((LottieDrawable)localObject1).setImageAssetDelegate(new LoginBtnImageAssetDelegate(this.a.this$0.getContext().getApplicationContext()));
      ((LottieDrawable)localObject1).setComposition(???);
      ((LottieDrawable)localObject1).setScale(f1, f2);
      ((LottieDrawable)localObject1).loop(true);
      ??? = ((LottieDrawable)localObject1).getBounds();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCompositionLoaded rw:");
        localStringBuilder.append(???.width());
        localStringBuilder.append(", rh:");
        localStringBuilder.append(???.height());
        localStringBuilder.append(" mIsDestroyed:");
        localStringBuilder.append(LoginAnimBtnView.a(this.a.this$0));
        QLog.i("LoginAnimBtnView", 2, localStringBuilder.toString());
      }
      LoginAnimBtnView.a(this.a.this$0, (LottieDrawable)localObject1);
      if (LoginAnimBtnView.a(this.a.this$0))
      {
        ((LottieDrawable)localObject1).cancelAnimation();
        ((LottieDrawable)localObject1).recycleBitmaps();
        ((LottieDrawable)localObject1).clearComposition();
        ((LottieDrawable)localObject1).setImageAssetDelegate(null);
        LoginAnimBtnView.a(this.a.this$0, null);
      }
      else if (this.a.this$0.isEnabled())
      {
        this.a.this$0.removeCallbacks(LoginAnimBtnView.a(this.a.this$0));
        this.a.this$0.post(LoginAnimBtnView.a(this.a.this$0));
      }
      synchronized (LoginAnimBtnView.a(this.a.this$0))
      {
        LoginAnimBtnView.a(this.a.this$0, null);
        LoginAnimBtnView.a(this.a.this$0, null);
        return;
      }
    }
    ??? = new StringBuilder();
    ???.append("onCompositionLoaded lottieComposition is null or mIsDestroyed:");
    ???.append(LoginAnimBtnView.a(this.a.this$0));
    QLog.e("LoginAnimBtnView", 1, ???.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginAnimBtnView.2.1
 * JD-Core Version:    0.7.0.1
 */