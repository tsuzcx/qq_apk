package com.tencent.avgame.gameroom.seat;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.List;

public class SeatPresenterImp
  implements ISeatPresenter
{
  protected ISeatView a;
  protected IGameRoomPresenter b;
  private Runnable c = new SeatPresenterImp.1(this);
  
  public SeatPresenterImp(ISeatView paramISeatView)
  {
    this.a = paramISeatView;
  }
  
  public RectF a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public List<SeatMemberInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.b.p();
    int i4 = 0;
    int i1 = 0;
    int k = 0;
    int i = 0;
    int j;
    int m;
    for (int i2 = 0;; i2 = j)
    {
      j = i4;
      if (i1 >= localList.size()) {
        break;
      }
      SeatMemberInfo localSeatMemberInfo = new SeatMemberInfo();
      localSeatMemberInfo.a = ((Player)localList.get(i1));
      localArrayList.add(localSeatMemberInfo);
      m = b(localSeatMemberInfo.a.uin);
      int i3;
      int n;
      if (m > k)
      {
        i3 = m;
        n = k;
        j = i;
      }
      else if (m > i)
      {
        i3 = k;
        n = m;
        j = i;
      }
      else
      {
        i3 = k;
        n = i;
        j = i2;
        if (m > i2)
        {
          j = m;
          n = i;
          i3 = k;
        }
      }
      i1 += 1;
      k = i3;
      i = n;
    }
    while (j < localArrayList.size())
    {
      m = b(((SeatMemberInfo)localArrayList.get(j)).a.uin);
      if (m > 0) {
        if (m == k) {
          ((SeatMemberInfo)localArrayList.get(j)).b = 1;
        } else if (m == i) {
          ((SeatMemberInfo)localArrayList.get(j)).b = 2;
        } else if (m == i2) {
          ((SeatMemberInfo)localArrayList.get(j)).b = 3;
        }
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.a.a(paramLong, paramBoolean);
  }
  
  public void a(EngineData paramEngineData)
  {
    this.a.a(paramEngineData);
  }
  
  public void a(Player paramPlayer)
  {
    if (GameEngine.a().f() != null)
    {
      if (paramPlayer == null) {
        return;
      }
      EngineData localEngineData = GameEngine.a().s();
      Object localObject = GameEngine.a().f().getCurrentAccountUin();
      GameEngine.a().c(localEngineData.i(), (String)localObject, paramPlayer.uin);
      paramPlayer = paramPlayer.uin;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(localEngineData.i());
      ReportController.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer, ((StringBuilder)localObject).toString(), "", "");
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.b = paramIGameRoomPresenter;
    AVGameHandler.a().c().postDelayed(this.c, 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, paramBoolean2);
  }
  
  public int b(String paramString)
  {
    return GameEngine.a().s().b(paramString);
  }
  
  public void b(Player paramPlayer)
  {
    if (GameEngine.a().f() != null) {
      if (paramPlayer == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramPlayer = paramPlayer.uin;
        Object localObject = new AllInOne(paramPlayer, 118);
        ((AllInOne)localObject).profileEntryType = 999;
        ((AllInOne)localObject).chatAbility = 1;
        ProfileUtils.openProfileCard(this.b.m(), (AllInOne)localObject);
        localObject = UserInfoHandler.b(paramPlayer);
        if ((localObject == null) || (!((UserInfo)localObject).d)) {
          break label137;
        }
        i = 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(GameEngine.a().s().i());
        ReportController.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      catch (Exception paramPlayer)
      {
        paramPlayer.printStackTrace();
      }
      return;
      label137:
      int i = 2;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.b(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    EngineData localEngineData = GameEngine.a().s();
    int i = AVGameUtil.b();
    boolean bool2 = false;
    if ((i == 2) && (GameEngine.a().v())) {
      return false;
    }
    RoomInfo localRoomInfo = localEngineData.e();
    i = localEngineData.j();
    boolean bool1 = bool2;
    if (localRoomInfo.getPlayers().size() < 8)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.b.m();
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().f();
    String str1 = localBaseAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().s();
    long l = localEngineData.i();
    String str2 = localEngineData.e().getNick(str1);
    AVGameShareUtil.a().a(localBaseAVGameAppInterface, localQBaseActivity, l, Long.valueOf(str1).longValue(), str2, localEngineData.p());
    this.b.e().b(this.b.m().getString(2131887260));
  }
  
  public void c(Player paramPlayer)
  {
    if ((GameEngine.a().f() != null) && (paramPlayer != null))
    {
      Object localObject1 = (QBaseActivity)this.b.m();
      String str = GameEngine.a().f().getCurrentAccountUin();
      EngineData localEngineData = GameEngine.a().s();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("roomid=");
      ((StringBuilder)localObject2).append(localEngineData.i());
      localObject2 = ((StringBuilder)localObject2).toString();
      NewReportPlugin.a((QBaseActivity)localObject1, paramPlayer.uin, "", (String)localObject2, str, 25031, null, null);
      paramPlayer = paramPlayer.uin;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(localEngineData.i());
      ReportController.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer, ((StringBuilder)localObject1).toString(), "", "");
      return;
    }
  }
  
  public List<MemberVideoDisplayInfo> d()
  {
    return this.a.getMemberHeadViewDisplayInfoList();
  }
  
  public void e()
  {
    AVGameHandler.a().c().removeCallbacks(this.c);
  }
  
  public RectF f()
  {
    return this.a.getAddMemberViewRectInRootView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatPresenterImp
 * JD-Core Version:    0.7.0.1
 */