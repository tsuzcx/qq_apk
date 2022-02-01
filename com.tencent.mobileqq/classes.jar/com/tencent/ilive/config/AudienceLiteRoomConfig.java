package com.tencent.ilive.config;

import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.base.component.ComponentConfig;
import com.tencent.ilive.base.component.CustomComponentConfig;
import com.tencent.ilive.base.page.PageType;
import com.tencent.ilive.bizmodules.AudienceLiteBizModuleBuilder;
import com.tencent.ilive.components.floatwindow.LIteFloatWindowBuilder;
import com.tencent.ilive.components.literoomclose.LiteRoomCloseBuilder;
import com.tencent.ilive.components.luxurygift.LiteLuxuryGiftCreateBuilder;
import com.tencent.ilive.roomclosecomponent_interface.RoomCloseComponent;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowComponent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;
import java.util.Map;

public class AudienceLiteRoomConfig
  implements PageConfigInterface
{
  public BizModulesConfig createBizModulesConfig()
  {
    BizModulesConfig localBizModulesConfig1 = new BizModulesConfig();
    localBizModulesConfig1.add(PageType.LIVE_ROOM_AUDIENCE_LITE.value, new AudienceLiteBizModuleBuilder());
    BizModulesConfig localBizModulesConfig2 = (BizModulesConfig)UIConfig.bizModulesConfigMap.get(Integer.valueOf(PageType.LIVE_ROOM_AUDIENCE_LITE.value));
    if (localBizModulesConfig2 != null) {
      localBizModulesConfig1.merge(localBizModulesConfig2);
    }
    return localBizModulesConfig1;
  }
  
  public ComponentConfig createComponentConfig(boolean paramBoolean)
  {
    ComponentConfig localComponentConfig = new ComponentConfig();
    localComponentConfig.add(FloatWindowComponent.class, new LIteFloatWindowBuilder());
    localComponentConfig.add(RoomCloseComponent.class, new LiteRoomCloseBuilder());
    localComponentConfig.add(LuxuryGiftComponent.class, new LiteLuxuryGiftCreateBuilder());
    CustomComponentConfig localCustomComponentConfig = (CustomComponentConfig)UIConfig.componentConfigMap.get(Integer.valueOf(PageType.LIVE_ROOM_AUDIENCE_LITE.value));
    if (localCustomComponentConfig != null) {
      localComponentConfig.merge(localCustomComponentConfig.getComponentConfig());
    }
    return localComponentConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.config.AudienceLiteRoomConfig
 * JD-Core Version:    0.7.0.1
 */