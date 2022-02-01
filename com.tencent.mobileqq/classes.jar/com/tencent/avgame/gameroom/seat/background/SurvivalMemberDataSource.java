package com.tencent.avgame.gameroom.seat.background;

import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SurvivalMemberDataSource
{
  private Map<Integer, SurvivalMemberInfo> a = new ConcurrentHashMap();
  
  private int a()
  {
    if (this.a.size() >= GameRoomViewLayoutParamsDef.C) {
      j = -1;
    }
    int m;
    int k;
    int i;
    do
    {
      return j;
      m = GameRoomViewLayoutParamsDef.C - 1;
      k = new Random().nextInt(m) % (m - 0 + 1) + 0;
      i = k;
      j = i;
    } while (this.a.get(Integer.valueOf(i)) == null);
    if (i >= m) {}
    for (int j = 0;; j = i + 1)
    {
      i = j;
      if (j != k) {
        break;
      }
      return -1;
    }
  }
  
  public int a(long paramLong)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SurvivalMemberInfo localSurvivalMemberInfo = (SurvivalMemberInfo)localEntry.getValue();
      if (paramLong == localSurvivalMemberInfo.a())
      {
        int i = localSurvivalMemberInfo.b();
        this.a.remove(localEntry.getKey());
        return i;
      }
    }
    return -1;
  }
  
  public int a(SurvivalMemberInfo paramSurvivalMemberInfo)
  {
    int i;
    if (GameEngine.a().a().getAccount().equals(String.valueOf(paramSurvivalMemberInfo.a()))) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = a();
      i = j;
    } while (j < 0);
    paramSurvivalMemberInfo.b(j);
    this.a.put(Integer.valueOf(j), paramSurvivalMemberInfo);
    return j;
  }
  
  public SurvivalMemberInfo a(int paramInt)
  {
    return (SurvivalMemberInfo)this.a.get(Integer.valueOf(paramInt));
  }
  
  public List<Integer> a(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = a(new SurvivalMemberInfo(((Long)paramList.next()).longValue()));
        if (i >= 0) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public List<Integer> b(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        int i = a(((Long)paramList.next()).longValue());
        if (i >= 0) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberDataSource
 * JD-Core Version:    0.7.0.1
 */