package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.nearby.gift.ITroopGiftPanelForNearby;
import com.tencent.mobileqq.qroute.QRoute;

public class NearByGiftPanelHelper
  extends GiftPanelHelper
{
  public INearbyGiftPanelDialog g;
  public ITroopGiftPanelForNearby h;
  
  public NearByGiftPanelHelper(BaseChatPie paramBaseChatPie)
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
    Object localObject1 = (InputMethodManager)this.c.getSystemService("input_method");
    Object localObject2 = this.c.getWindow().peekDecorView();
    if ((localObject2 != null) && (((View)localObject2).getWindowToken() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
    }
    if (this.g == null)
    {
      localObject1 = (IFactoryApi)QRoute.api(IFactoryApi.class);
      localObject2 = this.d;
      Activity localActivity = this.c;
      NearByGiftPanelHelper.1 local1 = new NearByGiftPanelHelper.1(this);
      boolean bool;
      if (this.b.O().a == 10002) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = ((IFactoryApi)localObject1).getTroopGiftPanelForNearby(localObject2, localActivity, local1, true, false, bool, this);
      this.g = ((IFactoryApi)QRoute.api(IFactoryApi.class)).getNearbyGiftPanelDialog(this.d, this.c, this.b.O(), this.h, this.a.aZ, false, true);
    }
    localObject1 = this.g;
    if (this.b.O().a == 10002) {
      paramInt = 8;
    } else {
      paramInt = 6;
    }
    ((INearbyGiftPanelDialog)localObject1).a(paramBoolean, true, paramInt);
    this.a.aw();
  }
  
  public void e()
  {
    INearbyGiftPanelDialog localINearbyGiftPanelDialog = this.g;
    if (localINearbyGiftPanelDialog != null) {
      localINearbyGiftPanelDialog.a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 12007)
    {
      paramIntent = this.h;
      if (paramIntent != null) {
        paramIntent.a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearByGiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */