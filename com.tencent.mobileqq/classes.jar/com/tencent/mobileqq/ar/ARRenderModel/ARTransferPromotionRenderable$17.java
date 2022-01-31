package com.tencent.mobileqq.ar.ARRenderModel;

import amoo;
import amot;
import amqu;
import amrb;
import amrd;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$17
  implements Runnable
{
  public ARTransferPromotionRenderable$17(amrb paramamrb, View paramView) {}
  
  public void run()
  {
    float f = amrb.a(this.this$0).getRotateDegree();
    boolean bool = amrb.a(this.this$0).a.isEmpty();
    amrb.d(this.this$0);
    if (this.this$0.b != 4)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:" + this.this$0.b);
      amrb.d(this.this$0, false);
    }
    amot localamot;
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.17.1(this, f));
        if (!bool) {
          break;
        }
      } while (amrb.a(this.this$0) == null);
      amrb.a(this.this$0).b(2, 0);
      return;
      localamot = amrb.a(this.this$0).a((int)f);
      if ((localamot == null) || (TextUtils.isEmpty(localamot.c))) {
        break;
      }
    } while (amrb.a(this.this$0) != 6);
    if (amrb.a(this.this$0).a()) {
      amrb.a(this.this$0).c();
    }
    amrb.a(this.this$0, localamot);
    amrb.a(this.this$0, new ARTransferPromotionRenderable.17.2(this));
    amrb.a(this.this$0);
    ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.17.3(this));
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:" + f);
    return;
    amrb.d(this.this$0, false);
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree " + f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
 * JD-Core Version:    0.7.0.1
 */