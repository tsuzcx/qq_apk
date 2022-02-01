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
  protected IGameRoomPresenter a;
  protected ISeatView a;
  private Runnable a;
  
  public SeatPresenterImp(ISeatView paramISeatView)
  {
    this.jdField_a_of_type_JavaLangRunnable = new SeatPresenterImp.1(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView = paramISeatView;
  }
  
  public int a(String paramString)
  {
    return GameEngine.a().a().a(paramString);
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a();
  }
  
  public RectF a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(paramString);
  }
  
  public List<SeatMemberInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
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
      localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localList.get(i1));
      localArrayList.add(localSeatMemberInfo);
      m = a(localSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
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
      m = a(((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m > 0) {
        if (m == k) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().a();
    String str1 = localBaseAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    long l = localEngineData.a();
    String str2 = localEngineData.a().getNick(str1);
    AVGameShareUtil.a().a(localBaseAVGameAppInterface, localQBaseActivity, l, Long.valueOf(str1).longValue(), str2, localEngineData.d());
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getString(2131690349));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a(paramLong, paramBoolean);
  }
  
  public void a(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a(paramEngineData);
  }
  
  public void a(Player paramPlayer)
  {
    if (GameEngine.a().a() != null)
    {
      if (paramPlayer == null) {
        return;
      }
      EngineData localEngineData = GameEngine.a().a();
      Object localObject = GameEngine.a().a().getCurrentAccountUin();
      GameEngine.a().c(localEngineData.a(), (String)localObject, paramPlayer.uin);
      paramPlayer = paramPlayer.uin;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(localEngineData.a());
      ReportController.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer, ((StringBuilder)localObject).toString(), "", "");
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    EngineData localEngineData = GameEngine.a().a();
    int i = AVGameUtil.b();
    boolean bool2 = false;
    if ((i == 2) && (GameEngine.a().e())) {
      return false;
    }
    RoomInfo localRoomInfo = localEngineData.a();
    i = localEngineData.a();
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
  
  public List<MemberVideoDisplayInfo> b()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.a();
  }
  
  public void b()
  {
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(Player paramPlayer)
  {
    if (GameEngine.a().a() != null) {
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
        ProfileUtils.openProfileCard(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(), (AllInOne)localObject);
        localObject = UserInfoHandler.b(paramPlayer);
        if ((localObject == null) || (!((UserInfo)localObject).a)) {
          break label139;
        }
        i = 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(GameEngine.a().a().a());
        ReportController.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, ((StringBuilder)localObject).toString(), "", "");
        return;
      }
      catch (Exception paramPlayer)
      {
        paramPlayer.printStackTrace();
      }
      return;
      label139:
      int i = 2;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.b(paramBoolean1, paramBoolean2);
  }
  
  public void c(Player paramPlayer)
  {
    if ((GameEngine.a().a() != null) && (paramPlayer != null))
    {
      Object localObject1 = (QBaseActivity)this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
      String str = GameEngine.a().a().getCurrentAccountUin();
      EngineData localEngineData = GameEngine.a().a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("roomid=");
      ((StringBuilder)localObject2).append(localEngineData.a());
      localObject2 = ((StringBuilder)localObject2).toString();
      NewReportPlugin.a((QBaseActivity)localObject1, paramPlayer.uin, "", (String)localObject2, str, 25031, null);
      paramPlayer = paramPlayer.uin;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(localEngineData.a());
      ReportController.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer, ((StringBuilder)localObject1).toString(), "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatPresenterImp
 * JD-Core Version:    0.7.0.1
 */