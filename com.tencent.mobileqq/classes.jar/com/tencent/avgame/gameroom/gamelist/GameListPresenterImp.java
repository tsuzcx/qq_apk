package com.tencent.avgame.gameroom.gamelist;

import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.SimpleGameStatusListener;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.ui.AVGameQuestionClassSelectDialog;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class GameListPresenterImp
  implements IGameListPresenter
{
  protected SimpleGameStatusListener a;
  protected IGameRoomPresenter a;
  protected IGameListView a;
  private boolean a;
  
  public GameListPresenterImp(IGameListView paramIGameListView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameStatusListener = new GameListPresenterImp.1(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView = paramIGameListView;
  }
  
  private List<Player> b()
  {
    List localList = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    while (i < localList.size())
    {
      Player localPlayer = (Player)localList.get(i);
      if ((localPlayer != null) && (localPlayer.status == 0)) {
        localArrayList.add(localPlayer);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int a()
  {
    return IGameEngine.a().a().jdField_a_of_type_Int;
  }
  
  public List<GameItem> a()
  {
    return IGameEngine.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    if (IGameEngine.k()) {
      return;
    }
    EngineData localEngineData = IGameEngine.a().a();
    IGameEngine.a().a(localEngineData.a(), IGameEngine.a().getAccount(), 0, 3);
  }
  
  public void a(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(paramEngineData);
  }
  
  public void a(GameItem paramGameItem)
  {
    if ((paramGameItem != null) && (!IGameEngine.k()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("autoStartGame ");
      ((StringBuilder)localObject1).append(paramGameItem);
      QLog.i("GameListPresenterImp", 2, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_Boolean = true;
      localObject1 = IGameEngine.a().a();
      Object localObject2 = ((EngineData)localObject1).a(paramGameItem.jdField_a_of_type_Int);
      String str1 = ((EngineData)localObject1).jdField_a_of_type_JavaLangString;
      String str2 = ((EngineData)localObject1).b;
      if ((localObject2 != null) && (((QuestionClassInfo)localObject2).a != null) && (((QuestionClassInfo)localObject2).a.size() > 0) && (str1 != null) && (str2 != null))
      {
        ((EngineData)localObject1).d(true);
        AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(), paramGameItem.jdField_a_of_type_Int, ((QuestionClassInfo)localObject2).a, str1, str2, this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView);
        return;
      }
      localObject2 = b();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        paramGameItem = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView;
        paramGameItem.a(AVGameUtil.a(paramGameItem.a(), (List)localObject2));
        return;
      }
      ((EngineData)localObject1).d(true);
      IGameEngine.a().a(paramGameItem.jdField_a_of_type_Int, null);
    }
  }
  
  public void a(GameItem paramGameItem, int paramInt)
  {
    if (paramGameItem != null)
    {
      IGameEngine.a().b(paramGameItem.jdField_a_of_type_Int);
      paramInt = paramGameItem.jdField_a_of_type_Int;
      paramGameItem = new StringBuilder();
      paramGameItem.append("");
      paramGameItem.append(IGameEngine.a().a().a().players.size());
      ReportController.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", paramInt, 0, "", paramGameItem.toString(), "", "");
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameStatusListener);
  }
  
  public boolean a()
  {
    return IGameEngine.a().a();
  }
  
  public void b()
  {
    if (IGameEngine.k()) {
      return;
    }
    EngineData localEngineData = IGameEngine.a().a();
    IGameEngine.a().a(localEngineData.a(), IGameEngine.a().getAccount(), 1, 3);
  }
  
  public void b(GameItem paramGameItem, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("clickBeginGame players:");
    ((StringBuilder)localObject2).append(localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = 1;
    QLog.i("GameListPresenterImp", 1, (String)localObject2);
    if (((List)localObject1).size() <= 1) {
      return;
    }
    paramInt = 0;
    while (paramInt < ((List)localObject1).size())
    {
      if ((((List)localObject1).get(paramInt) != null) && (((Player)((List)localObject1).get(paramInt)).status == 0))
      {
        paramInt = i;
        break label125;
      }
      paramInt += 1;
    }
    paramInt = 0;
    label125:
    if (paramInt != 0) {
      return;
    }
    if ((paramGameItem != null) && (!IGameEngine.k()))
    {
      Object localObject3 = IGameEngine.a().a();
      ((EngineData)localObject3).d(false);
      localObject1 = ((EngineData)localObject3).a(paramGameItem.jdField_a_of_type_Int);
      localObject2 = ((EngineData)localObject3).jdField_a_of_type_JavaLangString;
      localObject3 = ((EngineData)localObject3).b;
      if ((localObject1 != null) && (((QuestionClassInfo)localObject1).a != null) && (((QuestionClassInfo)localObject1).a.size() > 0) && (localObject2 != null) && (localObject3 != null))
      {
        AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(), paramGameItem.jdField_a_of_type_Int, ((QuestionClassInfo)localObject1).a, (String)localObject2, (String)localObject3, null);
        return;
      }
      IGameEngine.a().a(paramGameItem.jdField_a_of_type_Int, null);
    }
  }
  
  public void c()
  {
    IGameEngine.a().c(0);
  }
  
  public void d()
  {
    IGameEngine.a().f();
  }
  
  public void e()
  {
    if (AVGameUtil.b() == 2) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.c(GameListView.jdField_a_of_type_Int);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    IGameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameStatusListener);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPresenterImp
 * JD-Core Version:    0.7.0.1
 */