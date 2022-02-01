package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ARTransferPromotionRenderable$14
  implements Runnable
{
  ARTransferPromotionRenderable$14(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (this.a == 1)
    {
      int j = this.b;
      int i = 0;
      Object localObject;
      if (j == 0)
      {
        i = this.this$0.a;
        this.this$0.a = 0;
        if ((i == 2) || (i == 3) || (i == 4) || (i == 7))
        {
          if (ARTransferPromotionRenderable.c(this.this$0) != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("native_switchGameStatusWithVideoId status ");
            ((StringBuilder)localObject).append(this.b);
            QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
            ARTransferPromotionRenderable.c(this.this$0).native_switchGameStatusWithVideoId(i, this.c);
          }
          if (i == 7)
          {
            ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.1(this));
            QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_USER_DETERMINE_STATUS real start here");
            return;
          }
          if (i == 3)
          {
            QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_TRAVERSING_DOOR");
            ARTransferPromotionRenderable.b(this.this$0, true);
            ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.2(this));
          }
        }
        ARTransferPromotionRenderable.w(this.this$0);
        return;
      }
      if (j == 1)
      {
        ARTransferPromotionRenderable.w(this.this$0);
        j = this.this$0.b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ARPromotionMediaPlayerWrapper.PLAYER_STATUS_END status ");
        ((StringBuilder)localObject).append(this.this$0.b);
        QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
        if (j != 2)
        {
          if (j == 3) {
            return;
          }
          if (j != 4) {
            if (j != 5)
            {
              if (j == 7) {}
            }
            else
            {
              QLog.d("ARTransferPromotionRenderable", 1, "GameStatus_OUTSIDE_WORLD_360 error happen, not have this status");
              return;
            }
          }
        }
        if ((this.c != 0) && (j == 7))
        {
          if (ARTransferPromotionRenderable.d(this.this$0) != null) {
            ARTransferPromotionRenderable.d(this.this$0).b(2, this.c);
          }
          return;
        }
        ARTransferPromotionRenderable.p(this.this$0);
        if ((this.c == 0) && (j == 7) && (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())))
        {
          ARRecordUtils.a(HardCodeUtil.a(2131899003), false);
          QLog.d("ARTransferPromotionRenderable", 2, "net work is so terrible ,we have to stop it");
          return;
        }
        if ((this.this$0.b == 4) && (ARTransferPromotionRenderable.e(this.this$0).l == 2))
        {
          if (ARTransferPromotionRenderable.d(this.this$0) != null) {
            ARTransferPromotionRenderable.d(this.this$0).b(2, 0);
          }
          return;
        }
        if ((this.this$0.b == 4) && (ARTransferPromotionRenderable.e(this.this$0).l == 1)) {
          ARTransferPromotionRenderable.e(this.this$0).l = 0;
        }
        if ((this.this$0.b == 4) && (ARTransferPromotionRenderable.e(this.this$0).l == 0))
        {
          if (ARTransferPromotionRenderable.e(this.this$0).m.isEmpty())
          {
            if (ARTransferPromotionRenderable.d(this.this$0) != null) {
              ARTransferPromotionRenderable.d(this.this$0).b(2, 0);
            }
            return;
          }
          if (ARTransferPromotionRenderable.e(this.this$0).a(1))
          {
            ARTransferPromotionRenderable.m(this.this$0).b(true);
            return;
          }
          if (ARTransferPromotionRenderable.e(this.this$0).a(2))
          {
            localObject = this.this$0;
            ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, ARTransferPromotionRenderable.e((ARTransferPromotionRenderable)localObject).c());
          }
          else if (ARTransferPromotionRenderable.e(this.this$0).a(3))
          {
            localObject = this.this$0;
            ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, ARTransferPromotionRenderable.e((ARTransferPromotionRenderable)localObject).a());
          }
          if (ARTransferPromotionRenderable.y(this.this$0) == null)
          {
            QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 error hapen mFixFullScreenVideoUrl is null");
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 with auto play:");
          ((StringBuilder)localObject).append(ARTransferPromotionRenderable.y(this.this$0));
          QLog.d("ARTransferPromotionRenderable", 1, ((StringBuilder)localObject).toString());
        }
        if (this.this$0.b != 5)
        {
          if (this.this$0.b == 4) {
            i = 1;
          }
          if (i != 0) {
            i = j + 2;
          } else {
            i = j + 1;
          }
          if ((i > 0) && (i < 14)) {
            this.this$0.a(i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14
 * JD-Core Version:    0.7.0.1
 */