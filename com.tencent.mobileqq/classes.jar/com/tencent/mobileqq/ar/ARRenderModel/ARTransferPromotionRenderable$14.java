package com.tencent.mobileqq.ar.ARRenderModel;

import ajjy;
import akjt;
import akkv;
import aklt;
import akma;
import akmc;
import badq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$14
  implements Runnable
{
  public ARTransferPromotionRenderable$14(akma paramakma, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int i = 1;
    if (this.a == 1)
    {
      if (this.b != 0) {
        break label204;
      }
      i = this.this$0.a;
      this.this$0.a = 0;
      switch (i)
      {
      case 5: 
      case 6: 
      default: 
        akma.d(this.this$0);
      }
    }
    label204:
    int j;
    label342:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (akma.a(this.this$0) != null)
              {
                QLog.d("ARTransferPromotionRenderable", 2, "native_switchGameStatusWithVideoId status " + this.b);
                akma.a(this.this$0).native_switchGameStatusWithVideoId(i, this.c);
              }
              if (i == 7)
              {
                ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.1(this));
                QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_USER_DETERMINE_STATUS real start here");
                return;
              }
              if (i != 3) {
                break;
              }
              QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_TRAVERSING_DOOR");
              akma.b(this.this$0, true);
              ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.14.2(this));
              break;
            } while (this.b != 1);
            akma.d(this.this$0);
            j = this.this$0.b;
            QLog.d("ARTransferPromotionRenderable", 2, "ARPromotionMediaPlayerWrapper.PLAYER_STATUS_END status " + this.this$0.b);
            switch (j)
            {
            case 3: 
            case 6: 
            default: 
              return;
            case 2: 
            case 4: 
            case 7: 
              if ((this.c == 0) || (j != 7)) {
                break label342;
              }
            }
          } while (akma.a(this.this$0) == null);
          akma.a(this.this$0).b(2, this.c);
          return;
          akma.a(this.this$0);
          if ((this.c == 0) && (j == 7) && (!badq.g(BaseApplication.getContext())))
          {
            akkv.a(ajjy.a(2131634966), false);
            QLog.d("ARTransferPromotionRenderable", 2, "net work is so terrible ,we have to stop it");
            return;
          }
          if ((this.this$0.b != 4) || (akma.a(this.this$0).e != 2)) {
            break label439;
          }
        } while (akma.a(this.this$0) == null);
        akma.a(this.this$0).b(2, 0);
        return;
        if ((this.this$0.b == 4) && (akma.a(this.this$0).e == 1)) {
          akma.a(this.this$0).e = 0;
        }
        if ((this.this$0.b != 4) || (akma.a(this.this$0).e != 0)) {
          break label683;
        }
        if (!akma.a(this.this$0).a.isEmpty()) {
          break label540;
        }
      } while (akma.a(this.this$0) == null);
      akma.a(this.this$0).b(2, 0);
      return;
      if (akma.a(this.this$0).a(1))
      {
        akma.a(this.this$0).b(true);
        return;
      }
      if (akma.a(this.this$0).a(2)) {
        akma.a(this.this$0, akma.a(this.this$0).b());
      }
      while (akma.a(this.this$0) == null)
      {
        QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 error hapen mFixFullScreenVideoUrl is null");
        return;
        if (akma.a(this.this$0).a(3)) {
          akma.a(this.this$0, akma.a(this.this$0).a());
        }
      }
      QLog.d("ARTransferPromotionRenderable", 1, "onMediaPlayerStatusChange deal GameStatus_INSIDE_WORLD_360 with auto play:" + akma.a(this.this$0));
    } while (this.this$0.b == 5);
    label439:
    if (this.this$0.b == 4) {
      label705:
      if (i == 0) {
        break label738;
      }
    }
    label540:
    label683:
    label738:
    for (i = j + 2; (i > 0) && (i < 14); i = j + 1)
    {
      this.this$0.a(i);
      return;
      i = 0;
      break label705;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "GameStatus_OUTSIDE_WORLD_360 error happen, not have this status");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14
 * JD-Core Version:    0.7.0.1
 */