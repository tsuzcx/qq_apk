package com.tencent.avgame.gameroom.seat.background;

import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SurvivalMemberDataSource
{
  private Map<Integer, SurvivalMemberInfo> a = new ConcurrentHashMap();
  
  private int b()
  {
    if (this.a.size() >= GameRoomViewLayoutParamsDef.N) {
      return -1;
    }
    int m = GameRoomViewLayoutParamsDef.N - 1;
    int k = new Random().nextInt(m) % (m + 0 + 1) + 0;
    int j = k;
    while (this.a.get(Integer.valueOf(j)) != null)
    {
      int i;
      if (j >= m) {
        i = 0;
      } else {
        i = j + 1;
      }
      j = i;
      if (i == k) {
        return -1;
      }
    }
    return j;
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
        int i = localSurvivalMemberInfo.c();
        this.a.remove(localEntry.getKey());
        return i;
      }
    }
    return -1;
  }
  
  public int a(SurvivalMemberInfo paramSurvivalMemberInfo)
  {
    if (MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount().equals(String.valueOf(paramSurvivalMemberInfo.a()))) {
      return -1;
    }
    int i = b();
    if (i < 0) {
      return i;
    }
    paramSurvivalMemberInfo.b(i);
    this.a.put(Integer.valueOf(i), paramSurvivalMemberInfo);
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.background.SurvivalMemberDataSource
 * JD-Core Version:    0.7.0.1
 */