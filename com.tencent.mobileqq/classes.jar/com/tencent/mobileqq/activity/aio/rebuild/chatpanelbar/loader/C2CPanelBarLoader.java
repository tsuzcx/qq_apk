package com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.BaseChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.mobileqq.pluspanel.PlusPanelUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class C2CPanelBarLoader
  extends BaseChatPanelBarLoader
{
  public C2CPanelBarLoader(ChatPanelBarContext paramChatPanelBarContext)
  {
    super(paramChatPanelBarContext);
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
  
  protected void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a.add(AIOPanelUtiles.e);
    this.a.add(AIOPanelUtiles.p);
    a();
    b();
    if (AIOPanelUtiles.a) {
      this.a.add(AIOPanelUtiles.D);
    }
    this.a.add(AIOPanelUtiles.i);
    if (Utils.c(paramSessionInfo.b))
    {
      this.a.add(AIOPanelUtiles.V);
      return;
    }
    this.a.add(AIOPanelUtiles.z);
  }
  
  protected void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.c.a().i();
    this.a.add(AIOPanelUtiles.b);
    paramBaseChatPie = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.q;
    } else {
      paramQQAppInterface = AIOPanelUtiles.m;
    }
    paramBaseChatPie.add(paramQQAppInterface);
    a(this.c.a().j());
    c();
    if (AIOPanelUtiles.a) {
      this.a.add(AIOPanelUtiles.C);
    }
    paramBaseChatPie = this.a;
    if (bool) {
      paramQQAppInterface = AIOPanelUtiles.j;
    } else {
      paramQQAppInterface = AIOPanelUtiles.f;
    }
    paramBaseChatPie.add(paramQQAppInterface);
    if (Utils.c(paramSessionInfo.b))
    {
      this.a.add(AIOPanelUtiles.U);
      return;
    }
    this.a.add(AIOPanelUtiles.x);
  }
  
  public List<AIOPanelIconItem> d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    a(paramQQAppInterface);
    Context localContext = this.c.a().j();
    if (!Utils.c(paramSessionInfo.b)) {
      this.b = PlusPanelUtil.a(localContext);
    }
    if ((this.b == null) || (this.b.size() <= 0))
    {
      this.a = e(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      this.b = a(localContext, this.a);
    }
    return this.b;
  }
  
  public List<int[]> e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    boolean bool = this.c.a().a();
    this.a = new ArrayList();
    if (bool)
    {
      if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
        a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      } else {
        b(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
      }
    }
    else {
      c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
    return this.a;
  }
  
  public boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return (SessionTypeUtil.a(paramQQAppInterface, paramSessionInfo, paramSessionInfo.a)) && (!SessionTypeUtil.a(paramQQAppInterface, paramSessionInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.C2CPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */