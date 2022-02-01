package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.AIOConfigurationListener;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.helper.TopGestureTouchEventListener;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.tips.RobotContext;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkHelper
  implements AIOConfigurationListener, OnFinishListener, TopGestureTouchEventListener, ILifeCycleHelper, PanelProvider<ArkAppRootLayout>, AbsListView.OnScrollListener
{
  private final AIOContext a;
  private ArkTipsBar b;
  private ArkRecommendController c;
  private final BaseChatPie d;
  
  public ArkHelper(AIOContext paramAIOContext, BaseChatPie paramBaseChatPie)
  {
    this.a = paramAIOContext;
    this.d = paramBaseChatPie;
    paramAIOContext = paramAIOContext.d();
    paramAIOContext.a(this);
    paramAIOContext.a(this);
    paramAIOContext.a(this);
  }
  
  private void g()
  {
    ChatXListView localChatXListView = this.d.U;
    if (localChatXListView != null)
    {
      if (localChatXListView.getAdapter() == null) {
        return;
      }
      int i = localChatXListView.getFirstVisiblePosition();
      int j = localChatXListView.getLastVisiblePosition();
      while ((i <= j) && (i < localChatXListView.getAdapter().getCount()))
      {
        Object localObject = localChatXListView.getAdapter().getItem(i);
        if ((localObject instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer != null) {
            ((MessageForArkApp)localObject).arkContainer.h();
          }
        }
        i += 1;
      }
    }
  }
  
  private void h()
  {
    if (f()) {
      return;
    }
    ArkTipsManager.b().b(this.a);
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    b();
  }
  
  private void i()
  {
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
  }
  
  private void j()
  {
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
  }
  
  private void k() {}
  
  public ArkAppRootLayout a()
  {
    return this.c.d();
  }
  
  public ArkAppRootLayout a(Context paramContext)
  {
    return this.c.d();
  }
  
  public ArkTipsBar a(String paramString, long paramLong)
  {
    if (this.b == null)
    {
      this.b = new ArkTipsBar(this.a.c(), this.a.b());
      this.a.c().b(this.b);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showArkTips : hide? :");
      boolean bool;
      if (paramString == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(",mID=");
      localStringBuilder.append(paramLong);
      QLog.d("ArkHelper", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      this.a.c().c();
    } else {
      this.a.c().a(this.b, new Object[] { paramString, Long.valueOf(paramLong) });
    }
    return this.b;
  }
  
  public void a(Configuration paramConfiguration)
  {
    ArkAppCenterUtil.a(paramConfiguration);
  }
  
  public void a(MotionEvent paramMotionEvent) {}
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public int b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent = this.d.U;
    int i = paramMotionEvent.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramMotionEvent.getChildAt(i);
      if ((localView != null) && ((AIOUtils.b(localView) instanceof ArkAppItemBubbleBuilder.Holder)))
      {
        localView = localView.findViewById(2131428746);
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)f1, (int)f2)) {
          return 2;
        }
      }
      i -= 1;
    }
    return 0;
  }
  
  public void b()
  {
    ArkRecommendController localArkRecommendController = this.c;
    if (localArkRecommendController != null)
    {
      localArkRecommendController.b();
      this.c = null;
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void d()
  {
    ArkRecommendController localArkRecommendController = this.c;
    if (localArkRecommendController != null) {
      localArkRecommendController.c();
    }
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public ArkRecommendController e()
  {
    return this.c;
  }
  
  public void e(int paramInt)
  {
    if (f()) {
      return;
    }
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
  }
  
  public boolean f()
  {
    BaseChatPie localBaseChatPie = this.d;
    if ((localBaseChatPie != null) && (localBaseChatPie.f != null)) {
      return ((IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all")).isFromAllMsgGameSinglePage(this.d.f.getIntent());
    }
    return false;
  }
  
  public int getPanelId()
  {
    return 22;
  }
  
  @NonNull
  public String getTag()
  {
    return "ArkHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 0, 7, 11, 15, 19, 22 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    if ((this.c != null) && (this.a.q().b() == 22)) {
      this.c.a();
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 11)
          {
            if (paramInt != 15)
            {
              if (paramInt != 19)
              {
                if (paramInt != 22) {
                  return;
                }
                ArkAppCenterUtil.b();
                return;
              }
              k();
              return;
            }
            h();
            return;
          }
          j();
          return;
        }
        ArkTipsManager.b().a(this.a);
        return;
      }
      i();
      return;
    }
    if (this.c == null) {
      this.c = new ArkRecommendController(this.a);
    }
    if ((this.a instanceof RobotContext))
    {
      ArkRecommendController localArkRecommendController = this.c;
      if (localArkRecommendController != null)
      {
        localArkRecommendController.b();
        this.c = null;
      }
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    ArkRecommendController localArkRecommendController = this.c;
    if (localArkRecommendController != null) {
      localArkRecommendController.a(paramInt1, paramInt2);
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(22);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      g();
    }
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ArkHelper
 * JD-Core Version:    0.7.0.1
 */