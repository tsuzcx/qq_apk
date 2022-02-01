package com.tencent.biz.qqstory.troop.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.GetFeedFeatureHandler;
import com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler;
import com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler.GetTroopStoryListEvent;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TroopStoryIdSynchronizer
  implements IEventReceiver
{
  public int a;
  public GetTroopStoryListHandler b;
  public int c;
  public int d;
  public boolean e;
  public boolean f;
  public List<TroopStoryItemInfo> g;
  public boolean h;
  public String i;
  public String j;
  public int k;
  public boolean l;
  public long m;
  
  public TroopStoryIdSynchronizer.DayItem a(int paramInt)
  {
    int i2;
    for (int i1 = 0; paramInt > 0; i1 = i2)
    {
      TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.g.get(paramInt);
      if (localTroopStoryItemInfo.itemType == 1)
      {
        TroopStoryIdSynchronizer.DayItem localDayItem = new TroopStoryIdSynchronizer.DayItem();
        localDayItem.a = localTroopStoryItemInfo.publishCount;
        localDayItem.c = localTroopStoryItemInfo.feedId;
        localDayItem.b = (localDayItem.a - i1);
        return localDayItem;
      }
      i2 = i1;
      if (localTroopStoryItemInfo.itemType == 2) {
        i2 = i1 + 1;
      }
      paramInt -= 1;
    }
    return null;
  }
  
  public void a()
  {
    if (this.e) {
      return;
    }
    this.a = 1;
    Object localObject1;
    Object localObject2;
    if (this.c == this.g.size() - 2)
    {
      if (!this.h)
      {
        this.h = true;
        if (this.k == -2147483648)
        {
          localObject1 = (StoryConfigManager)SuperManager.a(10);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TROOP_STORY_COOKIE");
          ((StringBuilder)localObject2).append(String.valueOf(this.m));
          this.k = ((Integer)((StoryConfigManager)localObject1).c(((StringBuilder)localObject2).toString(), Integer.valueOf(0))).intValue();
        }
        this.b.a(this.m, this.k);
      }
    }
    else
    {
      int i2 = this.c + 1;
      int i1 = i2 + 10;
      if (i1 >= this.g.size() - 1) {
        i1 = this.g.size() - 2;
      }
      a(i1, i2);
      ArrayList localArrayList = new ArrayList();
      for (localObject2 = null; i2 <= i1; localObject2 = localObject1)
      {
        TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.g.get(i2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = a(i2);
          localObject1 = localObject2;
          if (!n) {
            if (localObject2 != null) {
              localObject1 = localObject2;
            } else {
              throw new AssertionError();
            }
          }
        }
        if (localTroopStoryItemInfo.itemType == 2)
        {
          localTroopStoryItemInfo.dayVideoCount = ((TroopStoryIdSynchronizer.DayItem)localObject1).a;
          localTroopStoryItemInfo.feedId = ((TroopStoryIdSynchronizer.DayItem)localObject1).c;
          int i3 = ((TroopStoryIdSynchronizer.DayItem)localObject1).b;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).b = (i3 - 1);
          localTroopStoryItemInfo.dayVideoIndex = i3;
          localArrayList.add(0, localTroopStoryItemInfo);
        }
        else if (localTroopStoryItemInfo.itemType == 1)
        {
          localObject1 = new TroopStoryIdSynchronizer.DayItem();
          ((TroopStoryIdSynchronizer.DayItem)localObject1).a = localTroopStoryItemInfo.publishCount;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).c = localTroopStoryItemInfo.feedId;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).b = (((TroopStoryIdSynchronizer.DayItem)localObject1).a - 1);
        }
        i2 += 1;
      }
      localObject1 = new GetTroopStoryListHandler.GetTroopStoryListEvent(this.i, new ErrorMessage());
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).e = localArrayList;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).i = this.a;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).j = this.e;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).k = this.f;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.e;
    boolean bool1 = true;
    if ((!bool2) && (this.l) && (paramInt1 == this.g.size() - 2)) {
      this.e = true;
    }
    if (!this.f) {
      if (paramInt2 <= 3)
      {
        this.f = true;
      }
      else if (paramInt2 == 4)
      {
        if (((TroopStoryItemInfo)this.g.get(3)).itemType == 2) {
          bool1 = false;
        }
        this.f = bool1;
      }
    }
    this.d = paramInt2;
    this.c = paramInt1;
  }
  
  public void a(List<TroopStoryItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)paramList.next();
      if (localTroopStoryItemInfo.itemType == 1) {
        localArrayList.add(localTroopStoryItemInfo.feedId);
      }
    }
    if (localArrayList.size() > 0) {
      GetFeedFeatureHandler.a(localArrayList);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryIdSynchronizer
 * JD-Core Version:    0.7.0.1
 */