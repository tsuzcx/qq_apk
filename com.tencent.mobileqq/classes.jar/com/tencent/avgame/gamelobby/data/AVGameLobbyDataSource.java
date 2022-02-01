package com.tencent.avgame.gamelobby.data;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameLobbyDataSource
  implements IBaseDataSource
{
  private List<AVGameBaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  private boolean a(List<? extends AVGameBaseData> paramList)
  {
    if (paramList.size() > 0)
    {
      if (!(paramList.get(0) instanceof AVGameLobbySurvivalContentInfo)) {
        return false;
      }
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
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
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @Nullable
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((AVGameBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b();
    }
    return 0;
  }
  
  @Nullable
  public AVGameBaseData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (AVGameBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public <T extends IBaseData> T a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (IBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(new AVGameLobbyBannerContentInfo());
    if (this.jdField_a_of_type_Boolean)
    {
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_random.png", 2131690382, 2130838662, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_ufo5.png", null, 1));
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_create_room.png", 2131690381, 2130838661, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house5.png", null, 2));
      a(new AVGameLobbyFixedContentInfo("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_search_room.png", 2131690384, 2130838663, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door5.png", null, 3));
      return;
    }
    a(new AVGameLobbyCreateAndJoinContentInfo(7, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house7.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door7.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_create_room.png", "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_search_room.png"));
  }
  
  public void a(AVGameBaseData paramAVGameBaseData)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAVGameBaseData);
  }
  
  public void a(List<? extends AVGameBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(List<? extends AVGameBaseData> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (!a(paramList))) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramInt, paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    a(new AVGameLobbyFeedbackContentInfo());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.data.AVGameLobbyDataSource
 * JD-Core Version:    0.7.0.1
 */