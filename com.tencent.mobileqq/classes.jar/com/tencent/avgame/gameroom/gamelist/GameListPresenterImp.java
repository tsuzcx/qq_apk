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
  protected IGameListView a;
  protected IGameRoomPresenter b;
  protected SimpleGameStatusListener c = new GameListPresenterImp.1(this);
  private boolean d = false;
  
  public GameListPresenterImp(IGameListView paramIGameListView)
  {
    this.a = paramIGameListView;
  }
  
  private List<Player> l()
  {
    List localList = this.b.p();
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
  
  public List<GameItem> a()
  {
    return IGameEngine.I().s().a;
  }
  
  public void a(EngineData paramEngineData)
  {
    this.a.a(paramEngineData);
  }
  
  public void a(GameItem paramGameItem)
  {
    if ((paramGameItem != null) && (!IGameEngine.J()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("autoStartGame ");
      ((StringBuilder)localObject1).append(paramGameItem);
      QLog.i("GameListPresenterImp", 2, ((StringBuilder)localObject1).toString());
      this.d = true;
      localObject1 = IGameEngine.I().s();
      Object localObject2 = ((EngineData)localObject1).b(paramGameItem.a);
      String str1 = ((EngineData)localObject1).d;
      String str2 = ((EngineData)localObject1).e;
      if ((localObject2 != null) && (((QuestionClassInfo)localObject2).b != null) && (((QuestionClassInfo)localObject2).b.size() > 0) && (str1 != null) && (str2 != null))
      {
        ((EngineData)localObject1).e(true);
        AVGameQuestionClassSelectDialog.a(this.a.getViewContext(), paramGameItem.a, ((QuestionClassInfo)localObject2).b, str1, str2, this.a);
        return;
      }
      localObject2 = l();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        paramGameItem = this.a;
        paramGameItem.a(AVGameUtil.a(paramGameItem.getViewContext(), (List)localObject2));
        return;
      }
      ((EngineData)localObject1).e(true);
      IGameEngine.I().a(paramGameItem.a, null);
    }
  }
  
  public void a(GameItem paramGameItem, int paramInt)
  {
    if (paramGameItem != null)
    {
      IGameEngine.I().b(paramGameItem.a);
      paramInt = paramGameItem.a;
      paramGameItem = new StringBuilder();
      paramGameItem.append("");
      paramGameItem.append(IGameEngine.I().s().e().players.size());
      ReportController.b(null, "dc00898", "", "", "0X800B06D", "0X800B06D", paramInt, 0, "", paramGameItem.toString(), "", "");
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.b = paramIGameRoomPresenter;
    IGameEngine.I().a(this.c);
  }
  
  public void b(GameItem paramGameItem, int paramInt)
  {
    this.d = false;
    Object localObject1 = this.b.p();
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
    if ((paramGameItem != null) && (!IGameEngine.J()))
    {
      Object localObject3 = IGameEngine.I().s();
      ((EngineData)localObject3).e(false);
      localObject1 = ((EngineData)localObject3).b(paramGameItem.a);
      localObject2 = ((EngineData)localObject3).d;
      localObject3 = ((EngineData)localObject3).e;
      if ((localObject1 != null) && (((QuestionClassInfo)localObject1).b != null) && (((QuestionClassInfo)localObject1).b.size() > 0) && (localObject2 != null) && (localObject3 != null))
      {
        AVGameQuestionClassSelectDialog.a(this.a.getViewContext(), paramGameItem.a, ((QuestionClassInfo)localObject1).b, (String)localObject2, (String)localObject3, null);
        return;
      }
      IGameEngine.I().a(paramGameItem.a, null);
    }
  }
  
  public boolean b()
  {
    return IGameEngine.I().d();
  }
  
  public int c()
  {
    return IGameEngine.I().s().b;
  }
  
  public void d()
  {
    if (IGameEngine.J()) {
      return;
    }
    EngineData localEngineData = IGameEngine.I().s();
    IGameEngine.I().a(localEngineData.i(), IGameEngine.K().getAccount(), 0, 3);
  }
  
  public void e()
  {
    if (IGameEngine.J()) {
      return;
    }
    EngineData localEngineData = IGameEngine.I().s();
    IGameEngine.I().a(localEngineData.i(), IGameEngine.K().getAccount(), 1, 3);
  }
  
  public void f()
  {
    IGameEngine.I().c(0);
  }
  
  public void g()
  {
    IGameEngine.I().w();
  }
  
  public void h()
  {
    if (AVGameUtil.b() == 2) {
      this.a.c(GameListView.k);
    }
  }
  
  public void i() {}
  
  public void j()
  {
    IGameEngine.I().b(this.c);
  }
  
  public void k()
  {
    this.a.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPresenterImp
 * JD-Core Version:    0.7.0.1
 */