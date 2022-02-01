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
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopEnterEffectController jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController;
  protected TroopPicEffectsController a;
  
  public TroopEffectHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
    localITroopEnterEffectService.setMode(0);
    localITroopEnterEffectService.setSvipLevel(0);
    localITroopEnterEffectService.setSvipType(0);
    localITroopEnterEffectService.setGroupLevel(0);
    if (!SimpleUIUtil.a()) {
      localITroopEnterEffectService.notifyEnterTroop(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  private void b()
  {
    TroopEnterEffectController localTroopEnterEffectController = this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController;
    if (localTroopEnterEffectController != null) {
      localTroopEnterEffectController.e();
    }
    f();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.c();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  private void d()
  {
    Object localObject = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
    if ((((ITroopEnterEffectService)localObject).getMode() != 0) && (!AnonymousChatHelper.a().a(localSessionInfo.a)) && (!SimpleUIUtil.a()))
    {
      ((ITroopEnterEffectService)localObject).addTroopEnterEffectData(new TroopEnterEffectData(((ITroopEnterEffectService)localObject).getEffectId(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localSessionInfo.a, ((ITroopEnterEffectService)localObject).getSvipLevel(), ((ITroopEnterEffectService)localObject).getSvipType(), ((ITroopEnterEffectService)localObject).getGroupLevel(), ((ITroopEnterEffectService)localObject).getMode()));
      localObject = a();
      ((TroopEnterEffectController)localObject).a(localSessionInfo.a);
      ((TroopEnterEffectController)localObject).a();
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
    if (localObject != null) {
      ((TroopPicEffectsController)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController.d();
    localObject = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
    ((ITroopEnterEffectService)localObject).setMode(0);
    ((ITroopEnterEffectService)localObject).setSvipLevel(0);
    ((ITroopEnterEffectService)localObject).setSvipType(0);
    ((ITroopEnterEffectService)localObject).setGroupLevel(0);
  }
  
  private void f()
  {
    TroopPicEffectsController localTroopPicEffectsController = this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
    if (localTroopPicEffectsController != null)
    {
      localTroopPicEffectsController.b();
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = null;
    }
  }
  
  public TroopEnterEffectController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController = new TroopEnterEffectController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.findViewById(2131364485));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopEnterEffectTroopEnterEffectController;
  }
  
  public TroopPicEffectsController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController = new TroopPicEffectsController(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsController;
  }
  
  public void a(AIOContext paramAIOContext) {}
  
  public boolean a(AIOContext paramAIOContext)
  {
    return false;
  }
  
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
            b();
            return;
          }
          e();
          return;
        }
        d();
        return;
      }
      a();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopEffectHelper
 * JD-Core Version:    0.7.0.1
 */