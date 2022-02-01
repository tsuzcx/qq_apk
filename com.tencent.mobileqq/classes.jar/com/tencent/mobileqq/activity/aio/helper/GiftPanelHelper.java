package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.AIOOnTouchListener;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;

public class GiftPanelHelper
  implements AIOOnTouchListener, OnFinishListener, ILifeCycleHelper, OnActivityResultCallback
{
  protected BaseChatPie a;
  protected AIOContext b;
  protected Activity c;
  protected QQAppInterface d;
  public AIOGiftPanelContainer e;
  protected TroopGiftAnimationController f;
  
  public GiftPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.bv();
    this.c = paramBaseChatPie.aX();
    this.d = paramBaseChatPie.d;
    a();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1))
    {
      TroopGiftPanel localTroopGiftPanel = this.e.d();
      if (localTroopGiftPanel != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          localTroopGiftPanel.a(paramIntent.getLong("duration_time"), paramIntent.getLong("elapsed_time"), paramIntent.getBoolean("profitable_flag", false));
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((AIOGiftPanelContainer)localObject).d();
      if (localObject != null) {
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = ((AIOGiftPanelContainer)localObject).d();
      if (localObject != null) {
        ((TroopGiftPanel)localObject).a(null);
      }
    }
  }
  
  protected void a()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((!(localBaseChatPie instanceof HotChatPie)) && (!(localBaseChatPie instanceof TroopChatPie)) && (!(localBaseChatPie instanceof NearbyChatPie)))
    {
      this.b.d().a(this);
      this.b.d().a(this);
      this.b.d().a(this);
    }
  }
  
  public void a(int paramInt)
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.e;
    if (localAIOGiftPanelContainer != null) {
      localAIOGiftPanelContainer.a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QVipGiftProcessor.a().isEnable())
    {
      GiftJsPlugin.openGiftBrowser(this.b.b(), this.b.O().b);
      return;
    }
    if (this.e == null) {
      this.e = new AIOGiftPanelContainer(this.a);
    }
    this.e.a(paramBoolean, paramInt);
  }
  
  public boolean a(BaseAIOContext paramBaseAIOContext, View paramView, MotionEvent paramMotionEvent)
  {
    e();
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public TroopGiftAnimationController b()
  {
    if (this.f == null) {
      this.f = new TroopGiftAnimationController(this.a, this.c, this.d);
    }
    return this.f;
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public int bM_()
  {
    Object localObject = this.a;
    if (((localObject instanceof LimitChatPie)) || ((localObject instanceof QCircleChatPie)) || ((localObject instanceof RobotChatPie)))
    {
      localObject = this.e;
      if ((localObject != null) && (((AIOGiftPanelContainer)localObject).c()))
      {
        this.e.a();
        return 1;
      }
    }
    return 0;
  }
  
  public TroopGiftAioPanelData d()
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.e;
    if (localAIOGiftPanelContainer != null) {
      return localAIOGiftPanelContainer.b();
    }
    return null;
  }
  
  public boolean d(int paramInt)
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.e;
    if ((localAIOGiftPanelContainer != null) && (localAIOGiftPanelContainer.c()))
    {
      this.e.a();
      if (paramInt == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void e()
  {
    AIOGiftPanelContainer localAIOGiftPanelContainer = this.e;
    if (localAIOGiftPanelContainer != null) {
      localAIOGiftPanelContainer.a();
    }
  }
  
  public void e(int paramInt) {}
  
  @NonNull
  public String getTag()
  {
    return "GiftPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 10, 11 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 12008) {
      a(paramInt2, paramIntent);
    } else if (paramInt1 == 12007) {
      f();
    }
    if (((this.a instanceof DiscussChatPie)) && (paramInt2 == -1) && (paramInt1 == 12006)) {
      a(paramIntent);
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 6)
    {
      Object localObject;
      if (paramInt != 10)
      {
        if (paramInt != 11) {
          return;
        }
        localObject = this.f;
        if (localObject != null) {
          ((TroopGiftAnimationController)localObject).d();
        }
      }
      else
      {
        localObject = this.a;
        if (!(localObject instanceof TroopChatPie)) {
          AIOAnimationControlManager.a((BaseChatPie)localObject, true);
        }
      }
    }
    else
    {
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper
 * JD-Core Version:    0.7.0.1
 */