package com.tencent.avgame.gamelobby.data;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameLobbyDataSource
  implements IBaseDataSource
{
  private List<AVGameBaseData> a = new ArrayList();
  private boolean b = false;
  
  private boolean b(List<? extends AVGameBaseData> paramList)
  {
    if (paramList.size() > 0)
    {
      if (!(paramList.get(0) instanceof AVGameLobbySurvivalContentInfo)) {
        return false;
      }
      paramList = this.a.iterator();
      while (paramList.hasNext()) {
        if (((AVGameBaseData)paramList.next() instanceof AVGameLobbySurvivalContentInfo)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  @Nullable
  public AVGameBaseData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (AVGameBaseData)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(AVGameBaseData paramAVGameBaseData)
  {
    this.a.add(paramAVGameBaseData);
  }
  
  public void a(List<? extends AVGameBaseData> paramList)
  {
    this.a.addAll(paramList);
  }
  
  public void a(List<? extends AVGameBaseData> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()) && (!b(paramList))) {
      this.a.addAll(paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  @Nullable
  public <T extends IBaseData> T b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (IBaseData)this.a.get(paramInt);
    }
    return null;
  }
  
  public void b()
  {
    a(new AVGameLobbyBannerContentInfo());
    if (this.b)
    {
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_random.png", 2131887293, 2130838841, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_ufo5.png", null, 1));
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_create_room.png", 2131887292, 2130838831, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house5.png", null, 2));
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_search_room.png", 2131887295, 2130838842, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door5.png", null, 3));
      return;
    }
    a(new AVGameLobbyCreateAndJoinContentInfo(7, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house7.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door7.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_create_room.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_search_room.png"));
  }
  
  @Nullable
  public int c(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((AVGameBaseData)this.a.get(paramInt)).c();
    }
    return 0;
  }
  
  public void c()
  {
    a(new AVGameLobbyFeedbackContentInfo());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AVGameBaseData)localIterator.next();
      if (((AVGameBaseData)localObject).a() == 4)
      {
        localObject = (AVGameLobbySurvivalContentInfo)localObject;
        ((AVGameLobbySurvivalContentInfo)localObject).d("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_order.png");
        ((AVGameLobbySurvivalContentInfo)localObject).e("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_no_order.png");
      }
    }
  }
  
  public void d()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyDataSource
 * JD-Core Version:    0.7.0.1
 */