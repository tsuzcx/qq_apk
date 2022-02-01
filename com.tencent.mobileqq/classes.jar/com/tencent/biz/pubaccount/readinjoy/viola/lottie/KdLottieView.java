package com.tencent.biz.pubaccount.readinjoy.viola.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.component.VLottie.IVLottieLoadListener;
import com.tencent.viola.ui.view.lottie.IVLottieViewProxy;
import java.util.HashMap;
import java.util.Map;

public class KdLottieView
  extends DiniFlyAnimationView
  implements IVLottieViewProxy
{
  public KdLottieView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(String paramString, VLottie.IVLottieLoadListener paramIVLottieLoadListener)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = paramString;
    localHttpRequset.method = "GET";
    localHttpRequset.timeoutMs = 5000;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("Content-Type", "application/json;charset=UTF-8");
    localHttpRequset.paramMap = ((Map)localObject);
    localObject = ViolaSDKManager.getInstance().getHttpAdapter();
    if (localObject != null) {
      ((IHttpAdapter)localObject).sendRequest(localHttpRequset, new KdLottieView.2(this, paramString, paramIVLottieLoadListener), true);
    }
  }
  
  public void v_addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    addAnimatorListener(paramAnimatorListener);
  }
  
  public void v_cancelAnimation()
  {
    cancelAnimation();
  }
  
  public void v_loop(boolean paramBoolean)
  {
    loop(paramBoolean);
  }
  
  public void v_pauseAnimation()
  {
    pauseAnimation();
  }
  
  public void v_playAnimation()
  {
    playAnimation();
  }
  
  public void v_removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    removeAnimatorListener(paramAnimatorListener);
  }
  
  public void v_resumeAnimation()
  {
    resumeAnimation();
  }
  
  public void v_setAnimation(String paramString, VLottie.IVLottieLoadListener paramIVLottieLoadListener)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")))
      {
        a(paramString, paramIVLottieLoadListener);
        return;
      }
      try
      {
        LottieComposition.Factory.fromJsonString(paramString, new KdLottieView.1(this, paramIVLottieLoadListener));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("KdLottieView", 2, "v_setAnimation exception", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieView
 * JD-Core Version:    0.7.0.1
 */