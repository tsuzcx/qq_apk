package com.tencent.mobileqq.activity.contact.newfriend.poke;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.avgame.gameroom.AVGameLottieHelper.LottieDrawableLoadedListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qav.thread.ThreadManager;

final class NewFriendNotifyPokeMsgHelper$3
  implements OnCompositionLoadedListener
{
  NewFriendNotifyPokeMsgHelper$3(int paramInt1, Context paramContext, int paramInt2, int paramInt3, String paramString, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    int i = AIOUtils.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(this.b, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramLottieComposition == null)
    {
      QLog.w("NewFriendNotifyPokeMsgHelper", 1, "onCompositionLoaded, fail");
      return;
    }
    Object localObject = paramLottieComposition.getBounds();
    float f1 = i / ((Rect)localObject).width();
    float f2 = j / ((Rect)localObject).height();
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).setScale(f1, f2);
    ((LottieDrawable)localObject).setRepeatCount(this.c);
    ((LottieDrawable)localObject).setImageAssetDelegate(new NewFriendNotifyPokeMsgHelper.3.1(this));
    ThreadManager.a().post(new NewFriendNotifyPokeMsgHelper.3.2(this, (LottieDrawable)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper.3
 * JD-Core Version:    0.7.0.1
 */