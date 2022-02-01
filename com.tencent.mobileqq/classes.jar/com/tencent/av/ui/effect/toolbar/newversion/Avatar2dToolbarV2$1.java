package com.tencent.av.ui.effect.toolbar.newversion;

import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.avatar2d.EffectAvatar2dManager;
import com.tencent.av.opengl.effects.TipsInfo;
import com.tencent.av.ui.effect.view.QavEffectSlidingTabView.Interceptor;
import com.tencent.qphone.base.util.BaseApplication;

class Avatar2dToolbarV2$1
  implements QavEffectSlidingTabView.Interceptor
{
  Avatar2dToolbarV2$1(Avatar2dToolbarV2 paramAvatar2dToolbarV2) {}
  
  public boolean a(int paramInt)
  {
    Avatar2dItem localAvatar2dItem = (Avatar2dItem)Avatar2dToolbarV2.access$000(this.a).c();
    boolean bool = true;
    if ((localAvatar2dItem != null) || (paramInt != 1)) {
      bool = false;
    }
    if (bool)
    {
      TipsInfo.a().b(BaseApplication.getContext().getString(2131893206));
      TipsInfo.a().a(1500);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2.1
 * JD-Core Version:    0.7.0.1
 */