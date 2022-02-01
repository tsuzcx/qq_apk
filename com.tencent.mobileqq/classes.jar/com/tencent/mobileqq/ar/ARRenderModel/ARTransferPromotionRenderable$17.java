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
    float f = ARTransferPromotionRenderable.c(this.this$0).getRotateDegree();
    boolean bool = ARTransferPromotionRenderable.e(this.this$0).m.isEmpty();
    ARTransferPromotionRenderable.w(this.this$0);
    if (this.this$0.b != 4)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:");
      ((StringBuilder)localObject).append(this.this$0.b);
      QLog.d("ARTransferPromotionRenderable", 1, ((StringBuilder)localObject).toString());
      ARTransferPromotionRenderable.d(this.this$0, false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.17.1(this, f));
    if (bool)
    {
      if (ARTransferPromotionRenderable.d(this.this$0) != null) {
        ARTransferPromotionRenderable.d(this.this$0).b(2, 0);
      }
      return;
    }
    Object localObject = ARTransferPromotionRenderable.e(this.this$0).b((int)f);
    if ((localObject != null) && (!TextUtils.isEmpty(((ARTransferDoorConfigInfo.FragmentInfo)localObject).c)))
    {
      if (ARTransferPromotionRenderable.b(this.this$0) != 6) {
        return;
      }
      if (ARTransferPromotionRenderable.a(this.this$0).c()) {
        ARTransferPromotionRenderable.a(this.this$0).b();
      }
      ARTransferPromotionRenderable.a(this.this$0, (ARTransferDoorConfigInfo.FragmentInfo)localObject);
      ARTransferPromotionRenderable.a(this.this$0, new ARTransferPromotionRenderable.17.2(this));
      ARTransferPromotionRenderable.p(this.this$0);
      ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.17.3(this));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:");
      ((StringBuilder)localObject).append(f);
      QLog.d("ARTransferPromotionRenderable", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ARTransferPromotionRenderable.d(this.this$0, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree ");
    ((StringBuilder)localObject).append(f);
    QLog.d("ARTransferPromotionRenderable", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
 * JD-Core Version:    0.7.0.1
 */