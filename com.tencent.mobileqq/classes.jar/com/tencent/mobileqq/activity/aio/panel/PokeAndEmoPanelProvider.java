package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.widget.XPanelContainer;

public class PokeAndEmoPanelProvider
  implements PanelProvider<PokeAndEmoPanel>
{
  private BaseChatPie a;
  private PokeAndEmoPanel b;
  
  public PokeAndEmoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public PokeAndEmoPanel a()
  {
    return this.b;
  }
  
  public PokeAndEmoPanel a(Context paramContext)
  {
    this.b = ((PokeAndEmoPanel)View.inflate(paramContext, 2131624120, null));
    paramContext = this.b;
    BaseChatPie localBaseChatPie = this.a;
    paramContext.a(localBaseChatPie, localBaseChatPie.ah);
    return this.b;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    PokePanel.a(paramQQAppInterface);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if ((bool2) || ((PokeItemHelper.b(paramQQAppInterface, 1) == 0) && (PokeItemHelper.b(paramQQAppInterface, 0) == 0)) || (QidianManager.b(paramQQAppInterface, paramSessionInfo.b))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = this.a.i();
    SessionInfo localSessionInfo = this.a.aE();
    if (a(localQQAppInterface, localSessionInfo, PokeItemHelper.a(localQQAppInterface)))
    {
      ChatActivityFacade.b(localQQAppInterface, BaseApplicationImpl.getContext(), localSessionInfo);
      return;
    }
    PokeItemHelper.g(localQQAppInterface);
    if (PokePanel.f)
    {
      if (this.a.bm() != null) {
        this.a.bm().a(23);
      }
    }
    else
    {
      a(localQQAppInterface);
      ChatActivityFacade.b(localQQAppInterface, BaseApplicationImpl.getContext(), localSessionInfo);
    }
  }
  
  public int getPanelId()
  {
    return 23;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    PokeAndEmoPanel localPokeAndEmoPanel;
    if (paramInt2 == 23)
    {
      localPokeAndEmoPanel = this.b;
      if (localPokeAndEmoPanel != null) {
        localPokeAndEmoPanel.a();
      }
    }
    if (paramInt1 == 23)
    {
      localPokeAndEmoPanel = this.b;
      if (localPokeAndEmoPanel != null) {
        localPokeAndEmoPanel.c();
      }
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    this.a.W.setShowRed(23, false);
    PokeItemHelper.b(this.a.d, true);
    b();
    ReportController.b(this.a.i(), "CliOper", "", "", "0X8007F20", "0X8007F20", 0, 0, "", "", "", "");
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 23) && (this.a.W != null)) {
      this.a.W.setSelected(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanelProvider
 * JD-Core Version:    0.7.0.1
 */