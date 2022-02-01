package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;

public class GroupPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public GroupPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
  }
  
  private void a(SessionInfo paramSessionInfo, boolean paramBoolean, HotChatManager paramHotChatManager)
  {
    paramHotChatManager = paramHotChatManager.c(paramSessionInfo.b);
    a(AIOPanelUtiles.b);
    a(AIOPanelUtiles.W);
    if (!paramHotChatManager.isRobotHotChat) {
      a(AIOPanelUtiles.G);
    }
    a(AIOPanelUtiles.I);
    if (paramBoolean) {
      paramSessionInfo = AIOPanelUtiles.j;
    } else {
      paramSessionInfo = AIOPanelUtiles.f;
    }
    a(paramSessionInfo);
    if (!paramHotChatManager.isRobotHotChat) {
      a(AIOPanelUtiles.x);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if ((!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) && (!ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)))
    {
      AIOPanelUtiles.Z[2] = 2130837959;
      return;
    }
    AIOPanelUtiles.Z[2] = 2130837958;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    a(AIOPanelUtiles.b);
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = AIOPanelUtiles.q;
    } else {
      arrayOfInt = AIOPanelUtiles.m;
    }
    a(arrayOfInt);
    a(this.c.a().j());
    c();
    if (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).Z(paramSessionInfo.b)) {
      a(AIOPanelUtiles.A);
    } else if (AIOPanelUtiles.a) {
      a(AIOPanelUtiles.C);
    }
    a(AIOPanelUtiles.Z);
    if (paramBoolean) {
      paramQQAppInterface = AIOPanelUtiles.j;
    } else {
      paramQQAppInterface = AIOPanelUtiles.f;
    }
    a(paramQQAppInterface);
    a(AIOPanelUtiles.x);
  }
  
  private void a(boolean paramBoolean)
  {
    a(AIOPanelUtiles.c);
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = AIOPanelUtiles.r;
    } else {
      arrayOfInt = AIOPanelUtiles.n;
    }
    a(arrayOfInt);
    a(AIOPanelUtiles.u);
    if (paramBoolean) {
      arrayOfInt = AIOPanelUtiles.k;
    } else {
      arrayOfInt = AIOPanelUtiles.g;
    }
    a(arrayOfInt);
    a(AIOPanelUtiles.y);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    paramBaseChatPie = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseChatPie != null) && (paramBaseChatPie.b(paramSessionInfo.b)))
    {
      paramQQAppInterface = paramBaseChatPie.c(paramSessionInfo.b);
      this.a.add(AIOPanelUtiles.e);
      this.a.add(AIOPanelUtiles.X);
      if (!paramQQAppInterface.isRobotHotChat) {
        this.a.add(AIOPanelUtiles.H);
      }
      this.a.add(AIOPanelUtiles.J);
      this.a.add(AIOPanelUtiles.i);
      if (!paramQQAppInterface.isRobotHotChat) {
        this.a.add(AIOPanelUtiles.z);
      }
    }
    else
    {
      a(AIOPanelUtiles.e);
      a(AIOPanelUtiles.p);
      a();
      b();
      if (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).Z(paramSessionInfo.b)) {
        a(AIOPanelUtiles.B);
      } else if (AIOPanelUtiles.a) {
        a(AIOPanelUtiles.D);
      }
      a(AIOPanelUtiles.Z);
      a(AIOPanelUtiles.i);
      a(AIOPanelUtiles.z);
    }
  }
  
  protected void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface, paramSessionInfo, this.c.a().i());
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool1 = AnonymousChatHelper.a().a(paramSessionInfo.b);
    boolean bool2 = this.c.a().i();
    if (bool1)
    {
      a(bool2);
      return;
    }
    paramBaseChatPie = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramBaseChatPie != null) && (paramBaseChatPie.b(paramSessionInfo.b)))
    {
      a(paramSessionInfo, bool2, paramBaseChatPie);
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, bool2);
  }
  
  public List<AIOPanelIconItem> d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface);
    return super.d(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return paramSessionInfo.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */