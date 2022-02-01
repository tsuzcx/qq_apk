package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.GameMsgAppDrawer;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppHelper
  implements ILifeCycleHelper, PanelListener
{
  private QQAppInterface a;
  private Context b;
  private Activity c;
  private BaseChatPie d;
  private SessionInfo e;
  
  public GameMsgAppHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.e;
    this.c = paramBaseChatPie.f;
    this.d = paramBaseChatPie;
    this.e = paramBaseChatPie.ah;
  }
  
  private BaseChatDrawer d()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!TextUtils.isEmpty(((SessionInfo)localObject).b)))
    {
      localObject = this.d;
      if ((localObject instanceof GameMsgChatPie)) {
        return new GameMsgAppDrawer((GameMsgChatPie)localObject);
      }
    }
    QLog.d("GameMsgAppHelper", 1, "createChatDrawer, sessionInfo == null or friendUin is empty");
    return null;
  }
  
  public void a() {}
  
  public void b()
  {
    if (!TextUtils.isEmpty(((IGameMsgManagerService)this.a.getRuntimeService(IGameMsgManagerService.class, "")).getAioHippyBundleName()))
    {
      BaseChatPie localBaseChatPie = this.d;
      if ((localBaseChatPie instanceof GameMsgChatPie)) {
        ((ChatDrawerHelper)localBaseChatPie.q(124)).b = d();
      }
    }
  }
  
  public void c() {}
  
  public String getTag()
  {
    return "GameMsgAppHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        a();
        return;
      }
      c();
      return;
    }
    b();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onPanelIconClickBeforeCreate], panelId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("GameMsgAppHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt != 3) {
      if (paramInt != 4) {
        if (paramInt != 5) {
          if (paramInt != 24) {
            localObject = "5";
          }
        }
      }
    }
    for (;;)
    {
      break;
      localObject = "4";
      continue;
      localObject = "3";
      continue;
      localObject = "2";
      continue;
      localObject = "1";
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "208982", "", "", "20", (String)localObject);
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgAppHelper
 * JD-Core Version:    0.7.0.1
 */