package com.tencent.mobileqq.ar.ARRenderModel;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo.FragmentInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ARTransferPromotionRenderable$17
  implements Runnable
{
  ARTransferPromotionRenderable$17(ARTransferPromotionRenderable paramARTransferPromotionRenderable, View paramView) {}
  
  public void run()
  {
    float f = ARTransferPromotionRenderable.a(this.this$0).getRotateDegree();
    boolean bool = ARTransferPromotionRenderable.a(this.this$0).a.isEmpty();
    ARTransferPromotionRenderable.e(this.this$0);
    if (this.this$0.b != 4)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:" + this.this$0.b);
      ARTransferPromotionRenderable.d(this.this$0, false);
    }
    ARTransferDoorConfigInfo.FragmentInfo localFragmentInfo;
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.17.1(this, f));
        if (!bool) {
          break;
        }
      } while (ARTransferPromotionRenderable.a(this.this$0) == null);
      ARTransferPromotionRenderable.a(this.this$0).b(2, 0);
      return;
      localFragmentInfo = ARTransferPromotionRenderable.a(this.this$0).a((int)f);
      if ((localFragmentInfo == null) || (TextUtils.isEmpty(localFragmentInfo.c))) {
        break;
      }
    } while (ARTransferPromotionRenderable.a(this.this$0) != 6);
    if (ARTransferPromotionRenderable.a(this.this$0).a()) {
      ARTransferPromotionRenderable.a(this.this$0).b();
    }
    ARTransferPromotionRenderable.a(this.this$0, localFragmentInfo);
    ARTransferPromotionRenderable.a(this.this$0, new ARTransferPromotionRenderable.17.2(this));
    ARTransferPromotionRenderable.a(this.this$0);
    ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.17.3(this));
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:" + f);
    return;
    ARTransferPromotionRenderable.d(this.this$0, false);
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree " + f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
 * JD-Core Version:    0.7.0.1
 */