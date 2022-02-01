package com.tencent.avgame.gameroom.gamelist;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.QuestionClassInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.listener.SimpleGameStatusListener;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.ui.AVGameQuestionClassSelectDialog;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

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
    return GameEngine.a().a().jdField_a_of_type_Int;
  }
  
  public List<GameItem> a()
  {
    return GameEngine.a().a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  }
  
  public void a()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.a(), GameEngine.a().a().getAccount(), 0, 3);
  }
  
  public void a(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(paramEngineData);
  }
  
  public void a(GameItem paramGameItem)
  {
    if (paramGameItem != null)
    {
      QLog.i("GameListPresenterImp", 2, "autoStartGame " + paramGameItem);
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = GameEngine.a().a();
      localObject1 = ((EngineData)localObject2).a(paramGameItem.jdField_a_of_type_Int);
      String str = ((EngineData)localObject2).jdField_a_of_type_JavaLangString;
      localObject2 = ((EngineData)localObject2).b;
      if ((localObject1 != null) && (((QuestionClassInfo)localObject1).a != null) && (((QuestionClassInfo)localObject1).a.size() > 0) && (str != null) && (localObject2 != null))
      {
        GameEngine.a().a().d(true);
        AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(), paramGameItem.jdField_a_of_type_Int, ((QuestionClassInfo)localObject1).a, str, (String)localObject2, this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView);
      }
    }
    else
    {
      return;
    }
    Object localObject1 = b();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(AVGameUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(), (List)localObject1));
      return;
    }
    GameEngine.a().a().d(true);
    GameEngine.a().a(paramGameItem.jdField_a_of_type_Int, null);
  }
  
  public void a(GameItem paramGameItem, int paramInt)
  {
    if (paramGameItem != null)
    {
      GameEngine.a().b(paramGameItem.jdField_a_of_type_Int);
      ReportController.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", paramGameItem.jdField_a_of_type_Int, 0, "", "" + GameEngine.a().a().a().players.size(), "", "");
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameStatusListener);
  }
  
  public boolean a()
  {
    return GameEngine.a().a();
  }
  
  public void b()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.a(), GameEngine.a().a().getAccount(), 1, 3);
  }
  
  public void b(GameItem paramGameItem, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    QLog.i("GameListPresenterImp", 1, "clickBeginGame players:" + localObject1);
    if (((List)localObject1).size() <= 1) {}
    label217:
    for (;;)
    {
      return;
      paramInt = 0;
      if (paramInt < ((List)localObject1).size()) {
        if ((((List)localObject1).get(paramInt) == null) || (((Player)((List)localObject1).get(paramInt)).status != 0)) {}
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt != 0) || (paramGameItem == null)) {
          break label217;
        }
        Object localObject2 = GameEngine.a().a();
        ((EngineData)localObject2).d(false);
        localObject1 = ((EngineData)localObject2).a(paramGameItem.jdField_a_of_type_Int);
        String str = ((EngineData)localObject2).jdField_a_of_type_JavaLangString;
        localObject2 = ((EngineData)localObject2).b;
        if ((localObject1 != null) && (((QuestionClassInfo)localObject1).a != null) && (((QuestionClassInfo)localObject1).a.size() > 0) && (str != null) && (localObject2 != null))
        {
          AVGameQuestionClassSelectDialog.a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.a(), paramGameItem.jdField_a_of_type_Int, ((QuestionClassInfo)localObject1).a, str, (String)localObject2, null);
          return;
          paramInt += 1;
          break;
        }
        GameEngine.a().a(paramGameItem.jdField_a_of_type_Int, null);
        return;
      }
    }
  }
  
  public void c()
  {
    GameEngine.a().c(0);
  }
  
  public void d()
  {
    GameEngine.a().f();
  }
  
  public void e()
  {
    if (AVGameUtils.b() == 2) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.c(GameListView.jdField_a_of_type_Int);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameStatusListener);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistIGameListView.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPresenterImp
 * JD-Core Version:    0.7.0.1
 */