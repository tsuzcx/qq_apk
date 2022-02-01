package com.tencent.mobileqq.activity.aio.helper;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;

public class TroopEffectHelper
  implements IMsgSendListener, ILifeCycleHelper
{
  protected TroopPicEffectsController a;
  private final TroopChatPie b;
  private final QQAppInterface c;
  private TroopEnterEffectController d;
  
  public TroopEffectHelper(TroopChatPie paramTroopChatPie)
  {
    this.b = paramTroopChatPie;
    this.c = paramTroopChatPie.d;
  }
  
  private void c()
  {
    this.d = b();
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)this.c.getRuntimeService(ITroopEnterEffectService.class, "all");
    localITroopEnterEffectService.setMode(0);
    localITroopEnterEffectService.setSvipLevel(0);
    localITroopEnterEffectService.setSvipType(0);
    localITroopEnterEffectService.setGroupLevel(0);
    if (!SimpleUIUtil.e()) {
      localITroopEnterEffectService.notifyEnterTroop(this.b.ah.b);
    }
  }
  
  private void d()
  {
    TroopEnterEffectController localTroopEnterEffectController = this.d;
    if (localTroopEnterEffectController != null) {
      localTroopEnterEffectController.g();
    }
    h();
  }
  
  private void e()
  {
    this.d = b();
    this.d.e();
    this.d.a(this.b.ah.b);
  }
  
  private void f()
  {
    Object localObject = (ITroopEnterEffectService)this.c.getRuntimeService(ITroopEnterEffectService.class, "all");
    SessionInfo localSessionInfo = this.b.aE();
    if ((((ITroopEnterEffectService)localObject).getMode() != 0) && (!AnonymousChatHelper.a().a(localSessionInfo.b)) && (!SimpleUIUtil.e()))
    {
      ((ITroopEnterEffectService)localObject).addTroopEnterEffectData(new TroopEnterEffectData(((ITroopEnterEffectService)localObject).getEffectId(), this.c.getCurrentAccountUin(), localSessionInfo.b, ((ITroopEnterEffectService)localObject).getSvipLevel(), ((ITroopEnterEffectService)localObject).getSvipType(), ((ITroopEnterEffectService)localObject).getGroupLevel(), ((ITroopEnterEffectService)localObject).getMode()));
      localObject = b();
      ((TroopEnterEffectController)localObject).a(localSessionInfo.b);
      ((TroopEnterEffectController)localObject).a();
    }
  }
  
  private void g()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((TroopPicEffectsController)localObject).a();
    }
    this.d = b();
    this.d.f();
    localObject = (ITroopEnterEffectService)this.c.getRuntimeService(ITroopEnterEffectService.class, "all");
    ((ITroopEnterEffectService)localObject).setMode(0);
    ((ITroopEnterEffectService)localObject).setSvipLevel(0);
    ((ITroopEnterEffectService)localObject).setSvipType(0);
    ((ITroopEnterEffectService)localObject).setGroupLevel(0);
  }
  
  private void h()
  {
    TroopPicEffectsController localTroopPicEffectsController = this.a;
    if (localTroopPicEffectsController != null)
    {
      localTroopPicEffectsController.b();
      this.a = null;
    }
  }
  
  public TroopPicEffectsController a()
  {
    if (this.a == null) {
      this.a = new TroopPicEffectsController(this.b.bG);
    }
    return this.a;
  }
  
  public boolean a(AIOContext paramAIOContext)
  {
    return false;
  }
  
  public TroopEnterEffectController b()
  {
    if (this.d == null) {
      this.d = new TroopEnterEffectController(this.c, (RelativeLayout)this.b.aZ.findViewById(2131430542));
    }
    return this.d;
  }
  
  public void b(AIOContext paramAIOContext) {}
  
  @NonNull
  public String getTag()
  {
    return "TroopEffectHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 8, 10, 11, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 8)
      {
        if (paramInt != 10)
        {
          if (paramInt != 11)
          {
            if (paramInt != 15) {
              return;
            }
            d();
            return;
          }
          g();
          return;
        }
        f();
        return;
      }
      c();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopEffectHelper
 * JD-Core Version:    0.7.0.1
 */