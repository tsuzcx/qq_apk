package com.tencent.avgame.gameroom.seat;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
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
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
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
    int i4 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    int k = 0;
    int j = i4;
    int m;
    if (i1 < localList.size())
    {
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
      for (;;)
      {
        i1 += 1;
        i2 = j;
        i = n;
        k = i3;
        break;
        if (m > i)
        {
          j = i;
          n = m;
          i3 = k;
        }
        else
        {
          j = i2;
          n = i;
          i3 = k;
          if (m > i2)
          {
            j = m;
            n = i;
            i3 = k;
          }
        }
      }
    }
    if (j < localArrayList.size())
    {
      m = a(((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m <= 0) {}
      for (;;)
      {
        j += 1;
        break;
        if (m == k) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((SeatMemberInfo)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    AVGameAppInterface localAVGameAppInterface = GameEngine.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    long l = localEngineData.a();
    String str2 = localEngineData.a().getNick(str1);
    AVGameShareUtil.a().a(localAVGameAppInterface, localBaseActivity, l, Long.valueOf(str1).longValue(), str2, localEngineData.d());
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getString(2131690425));
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
    if ((GameEngine.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    EngineData localEngineData = GameEngine.a().a();
    String str = GameEngine.a().a().getCurrentAccountUin();
    GameEngine.a().c(localEngineData.a(), str, paramPlayer.uin);
    ReportController.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer.uin, "" + localEngineData.a(), "", "");
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
    if ((AVGameUtils.b() == 2) && (GameEngine.a().e())) {}
    RoomInfo localRoomInfo;
    int i;
    do
    {
      return false;
      localRoomInfo = localEngineData.a();
      i = localEngineData.a();
    } while ((localRoomInfo.getPlayers().size() >= 8) || (i != 0));
    return true;
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
    int i = 1;
    if ((GameEngine.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramPlayer = paramPlayer.uin;
        Object localObject = new ProfileActivity.AllInOne(paramPlayer, 118);
        ((ProfileActivity.AllInOne)localObject).h = 999;
        ((ProfileActivity.AllInOne)localObject).d = 1;
        ProfileActivity.b(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(), (ProfileActivity.AllInOne)localObject);
        localObject = UserInfoHandler.b(paramPlayer);
        if ((localObject != null) && (((UserInfo)localObject).a))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, "" + GameEngine.a().a().a(), "", "");
          return;
        }
      }
      catch (Exception paramPlayer)
      {
        paramPlayer.printStackTrace();
        return;
      }
      i = 2;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatView.b(paramBoolean1, paramBoolean2);
  }
  
  public void c(Player paramPlayer)
  {
    if ((GameEngine.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    String str1 = GameEngine.a().a().getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().a();
    String str2 = "roomid=" + localEngineData.a();
    NewReportPlugin.a(localBaseActivity, paramPlayer.uin, "", str2, str1, 25031, null);
    ReportController.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer.uin, "" + localEngineData.a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatPresenterImp
 * JD-Core Version:    0.7.0.1
 */