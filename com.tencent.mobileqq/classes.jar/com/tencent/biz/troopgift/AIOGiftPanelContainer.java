package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.qphone.base.util.QLog;

public class AIOGiftPanelContainer
{
  protected ViewGroup a;
  protected BaseChatPie b;
  protected PlusPanel c;
  protected Handler d = new Handler(Looper.getMainLooper());
  protected TroopGiftPanel e = null;
  protected TroopGiftAioPanelData f;
  private boolean g = false;
  
  public AIOGiftPanelContainer(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    this.a = this.b.aZ;
    this.c = ((PlusPanel)paramBaseChatPie.bq().d(8));
  }
  
  public void a()
  {
    TroopGiftPanel localTroopGiftPanel = this.e;
    if ((localTroopGiftPanel != null) && (localTroopGiftPanel.c()))
    {
      this.a.removeView(this.e);
      this.e.setIsShow(false);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.b.d, "GiftPanel_flower", false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.c;
    if ((localObject != null) && (paramInt == ((PlusPanel)localObject).getTroopGiftAppPagerIndex()))
    {
      if (this.f == null) {
        return;
      }
      int i = 0;
      long l1 = System.currentTimeMillis();
      long l2 = this.f.a;
      paramInt = i;
      if (this.f.n)
      {
        paramInt = i;
        if (l1 >= this.f.a)
        {
          paramInt = i;
          if (l1 <= l2 + 2592000000L)
          {
            paramInt = i;
            if (!((TroopGiftManager)this.b.d.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a()) {
              paramInt = 1;
            }
          }
        }
      }
      String str = this.b.ah.b;
      if (paramInt != 0) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(TroopMemberUtil.a(this.b.d, this.b.d.getCurrentAccountUin(), this.b.ah.b));
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "exp_plus", 0, 0, str, (String)localObject, "0", localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if ((this.g) && (this.f != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadGiftExtraInfo() , mHasGiftExtraInfo = ");
      localStringBuilder.append(this.g);
      QLog.i("AIOGiftPanelContainer", 1, localStringBuilder.toString());
      if (!this.b.f.isFinishing()) {
        this.d.post(new AIOGiftPanelContainer.1(this, paramInt1));
      }
      return;
    }
    ThreadManager.post(new AIOGiftPanelContainer.2(this, l, paramInt2, paramInt1), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((TroopGiftPanel)localObject1).c())) {
      return;
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.b.d, "GiftPanel_flower", true);
    this.b.aw();
    if (paramBoolean)
    {
      if (this.e == null)
      {
        localObject1 = this.b;
        if ((localObject1 instanceof BaseTroopChatPie))
        {
          this.e = new TroopGiftPanel(((BaseChatPie)localObject1).f, this.b);
          this.e.a(this.b.d, this.b.ah, true);
        }
        else if ((localObject1 instanceof DiscussChatPie))
        {
          this.e = new TroopGiftPanel(((BaseChatPie)localObject1).f, this.b, 13, 6);
          this.e.a(this.b.d, this.b.ah, false);
        }
        else if ((localObject1 instanceof FriendChatPie))
        {
          this.e = new TroopGiftPanel(((BaseChatPie)localObject1).f, this.b, 11, 2);
          this.e.a(this.b.d, this.b.ah, false);
        }
        else if ((localObject1 instanceof StrangerChatPie))
        {
          this.e = new TroopGiftPanel(((BaseChatPie)localObject1).f, this.b, 12, 7);
          this.e.a(this.b.d, this.b.ah, false);
        }
        else
        {
          return;
        }
      }
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      this.e.setIsShow(true);
      this.a.addView(this.e, (ViewGroup.LayoutParams)localObject1);
      int i;
      if (AnonymousChatHelper.a().a(this.b.ah.b))
      {
        i = 4;
      }
      else
      {
        localObject1 = this.b;
        if ((localObject1 instanceof DiscussChatPie)) {
          i = 6;
        } else if ((localObject1 instanceof FriendChatPie)) {
          i = 5;
        } else if ((localObject1 instanceof StrangerChatPie)) {
          i = 7;
        } else {
          i = 1;
        }
      }
      this.f = TroopGiftAioPanelData.a(this.b.e, i, this.b.ah.c);
      localObject1 = this.f;
      if (localObject1 != null) {
        this.e.setGiftData((TroopGiftAioPanelData)localObject1, true);
      } else {
        this.e.e();
      }
      a(paramInt, i);
      this.e.b(paramInt);
    }
    else if (this.e != null)
    {
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      this.a.addView(this.e, (ViewGroup.LayoutParams)localObject1);
      this.e.setIsShow(true);
    }
    if (this.e != null)
    {
      paramBoolean = AnonymousChatHelper.a().a(this.b.ah.b);
      Object localObject2 = this.e;
      if (paramBoolean) {
        localObject1 = "#333333";
      } else {
        localObject1 = "#FFFFFF";
      }
      ((TroopGiftPanel)localObject2).setMainAreaBackgroundColor(Color.parseColor((String)localObject1));
      if ((this.e.M instanceof TextView))
      {
        localObject2 = (TextView)this.e.M;
        if (paramBoolean) {
          localObject1 = "#878B99";
        } else {
          localObject1 = "#000000";
        }
        ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      }
    }
  }
  
  public TroopGiftAioPanelData b()
  {
    return this.f;
  }
  
  public boolean c()
  {
    TroopGiftPanel localTroopGiftPanel = this.e;
    if (localTroopGiftPanel != null) {
      return localTroopGiftPanel.c();
    }
    return false;
  }
  
  public TroopGiftPanel d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.AIOGiftPanelContainer
 * JD-Core Version:    0.7.0.1
 */