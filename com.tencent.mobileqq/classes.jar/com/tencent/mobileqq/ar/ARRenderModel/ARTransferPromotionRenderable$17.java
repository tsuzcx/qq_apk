package com.tencent.mobileqq.ar.ARRenderModel;

import android.text.TextUtils;
import android.view.View;
import apfk;
import apfp;
import aphq;
import aphx;
import aphz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$17
  implements Runnable
{
  public ARTransferPromotionRenderable$17(aphx paramaphx, View paramView) {}
  
  public void run()
  {
    float f = aphx.a(this.this$0).getRotateDegree();
    boolean bool = aphx.a(this.this$0).a.isEmpty();
    aphx.e(this.this$0);
    if (this.this$0.b != 4)
    {
      QLog.d("ARTransferPromotionRenderable", 1, "not under nativeGameStatus:GameStatus_INSIDE_WORLD_360 mNativeGameStatus:" + this.this$0.b);
      aphx.d(this.this$0, false);
    }
    apfp localapfp;
    do
    {
      do
      {
        return;
        ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.17.1(this, f));
        if (!bool) {
          break;
        }
      } while (aphx.a(this.this$0) == null);
      aphx.a(this.this$0).b(2, 0);
      return;
      localapfp = aphx.a(this.this$0).a((int)f);
      if ((localapfp == null) || (TextUtils.isEmpty(localapfp.c))) {
        break;
      }
    } while (aphx.a(this.this$0) != 6);
    if (aphx.a(this.this$0).a()) {
      aphx.a(this.this$0).b();
    }
    aphx.a(this.this$0, localapfp);
    aphx.a(this.this$0, new ARTransferPromotionRenderable.17.2(this));
    aphx.a(this.this$0);
    ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.17.3(this));
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER fit current degree:" + f);
    return;
    aphx.d(this.this$0, false);
    QLog.d("ARTransferPromotionRenderable", 1, "switchGameStatus ARPromotionConstant.GameStatus_WORLD_360_VIDEO_OVER not fit degree " + f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.17
 * JD-Core Version:    0.7.0.1
 */