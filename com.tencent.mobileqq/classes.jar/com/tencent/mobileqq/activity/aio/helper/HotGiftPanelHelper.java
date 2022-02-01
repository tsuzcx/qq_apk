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
  public INearbyGiftPanelDialog a;
  public ITroopGiftPanelForNearby a;
  
  public HotGiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftITroopGiftPanelForNearby = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getTroopGiftPanelForNearby(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), new HotGiftPanelHelper.1(this), false, false, false, this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getNearbyGiftPanelDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqNearbyGiftITroopGiftPanelForNearby, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c, true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftITroopGiftPanelForNearby.setIsPttRoom(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog.a(paramBoolean, false, 4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.Q();
  }
  
  public void b()
  {
    INearbyGiftPanelDialog localINearbyGiftPanelDialog = this.jdField_a_of_type_ComTencentMobileqqNearbyGiftINearbyGiftPanelDialog;
    if (localINearbyGiftPanelDialog != null) {
      localINearbyGiftPanelDialog.a();
    }
  }
  
  public View createPanel(Context paramContext)
  {
    return null;
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
    a(true);
    paramXPanelContainer = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a);
    if ((paramXPanelContainer != null) && (paramXPanelContainer.isBuLuoHotChat())) {
      paramXPanelContainer = "507";
    } else {
      paramXPanelContainer = "503";
    }
    NearbyFlowerManager.a("gift_aio", "clk_icon", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.d(), paramXPanelContainer, "", "");
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */