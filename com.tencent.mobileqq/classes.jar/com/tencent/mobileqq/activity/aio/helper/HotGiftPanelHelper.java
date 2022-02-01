package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.ITroopGiftPanelForNearby;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XPanelContainer;

public class HotGiftPanelHelper
  extends GiftPanelHelper
  implements PanelProvider<View>
{
  public INearbyGiftPanelDialog g;
  public ITroopGiftPanelForNearby h;
  
  public HotGiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a()
  {
    this.b.d().a(this);
    this.b.d().a(this);
    this.b.d().a(this);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getSystemService("input_method");
    View localView = this.c.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.g == null)
    {
      this.h = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getTroopGiftPanelForNearby(this.d, this.b.b(), new HotGiftPanelHelper.1(this), false, false, false, this);
      this.g = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getNearbyGiftPanelDialog(this.d, this.c, this.b.O(), this.h, this.a.aZ, true, false);
    }
    this.h.setIsPttRoom(false);
    this.g.a(paramBoolean, false, 4);
    this.a.aw();
  }
  
  public View createPanel(Context paramContext)
  {
    return null;
  }
  
  public void e()
  {
    INearbyGiftPanelDialog localINearbyGiftPanelDialog = this.g;
    if (localINearbyGiftPanelDialog != null) {
      localINearbyGiftPanelDialog.a();
    }
  }
  
  public View getPanel()
  {
    return null;
  }
  
  public int getPanelId()
  {
    return 19;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    b(true);
    paramXPanelContainer = this.d.getHotChatMng(true).c(this.b.O().b);
    if ((paramXPanelContainer != null) && (paramXPanelContainer.isBuLuoHotChat())) {
      paramXPanelContainer = "507";
    } else {
      paramXPanelContainer = "503";
    }
    NearbyFlowerManager.a("gift_aio", "clk_icon", this.a.ag(), paramXPanelContainer, "", "");
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */