package com.tencent.ilive.litepages.room.roomconfig;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule;
import com.tencent.ilive.audiencepages.room.bizmodule.AudioFocusListenerModule;
import com.tencent.ilive.audiencepages.room.roomconfig.AudienceBaseBootModules;
import com.tencent.ilive.base.bizmodule.BizModuleBaseAdapter;
import com.tencent.ilive.litepages.room.bizmodule.AudLiteFloatWindowModule;
import com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule;
import com.tencent.ilive.litepages.room.bizmodule.LiteRoomCloseBtnModule;
import com.tencent.ilive.litepages.room.bizmodule.LiteRoomWebModule;
import com.tencent.ilive.pages.room.RoomBizContext;

public class AudienceLiteEntBootModules
  extends AudienceBaseBootModules
{
  protected AudLiteFloatWindowModule audLiteFloatWindowModule;
  protected AudioFocusListenerModule audioFocusListenerModule;
  protected LiteLuxuryGiftModule luxuryGiftModule;
  ViewGroup normalLayout;
  protected LiteRoomCloseBtnModule roomCloseBtnModule;
  protected LiteRoomWebModule roomWebModule;
  
  public BizModuleBaseAdapter getBizModuleAdapter()
  {
    return null;
  }
  
  public int getLandscapeViewId()
  {
    return 0;
  }
  
  public int getPortraitViewId()
  {
    return 0;
  }
  
  public int getScreenOrientation()
  {
    return 1;
  }
  
  public void onCreateBottomBizModules()
  {
    addBottomLayoutBizModules(new AVPlayerModule());
  }
  
  public ViewGroup onCreateBottomLayout()
  {
    return (ViewGroup)LayoutInflater.from(this.context).inflate(2131559363, null);
  }
  
  public void onCreateNormalBizModules()
  {
    this.audioFocusListenerModule = new AudioFocusListenerModule();
    this.audLiteFloatWindowModule = new AudLiteFloatWindowModule();
    this.roomCloseBtnModule = new LiteRoomCloseBtnModule();
    this.roomWebModule = new LiteRoomWebModule();
    this.luxuryGiftModule = new LiteLuxuryGiftModule();
    onCreateNormalBizModules(false);
  }
  
  public void onCreateNormalBizModules(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    addNormalLayoutBizModules(this.audioFocusListenerModule, false);
    addNormalLayoutBizModules(this.audLiteFloatWindowModule, false);
    addNormalLayoutBizModules(this.roomCloseBtnModule, false);
    addNormalLayoutBizModules(this.roomWebModule, false);
    addNormalLayoutBizModules(this.luxuryGiftModule, false);
  }
  
  public ViewGroup onCreateNormalLayout()
  {
    this.normalLayout = ((ViewGroup)LayoutInflater.from(this.context).inflate(2131559365, null));
    return this.normalLayout;
  }
  
  public void onCreateTopBizModules() {}
  
  public ViewGroup onCreateTopLayout()
  {
    return (ViewGroup)LayoutInflater.from(this.context).inflate(2131559364, null);
  }
  
  public void setRoomBizContext(RoomBizContext paramRoomBizContext)
  {
    super.setRoomBizContext(paramRoomBizContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.roomconfig.AudienceLiteEntBootModules
 * JD-Core Version:    0.7.0.1
 */