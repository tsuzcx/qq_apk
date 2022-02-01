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
  public long a;
  public GetTroopStoryListHandler a;
  public String a;
  public List<TroopStoryItemInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  
  public TroopStoryIdSynchronizer.DayItem a(int paramInt)
  {
    int j;
    for (int i = 0; paramInt > 0; i = j)
    {
      TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localTroopStoryItemInfo.itemType == 1)
      {
        TroopStoryIdSynchronizer.DayItem localDayItem = new TroopStoryIdSynchronizer.DayItem();
        localDayItem.jdField_a_of_type_Int = localTroopStoryItemInfo.publishCount;
        localDayItem.jdField_a_of_type_JavaLangString = localTroopStoryItemInfo.feedId;
        localDayItem.jdField_b_of_type_Int = (localDayItem.jdField_a_of_type_Int - i);
        return localDayItem;
      }
      j = i;
      if (localTroopStoryItemInfo.itemType == 2) {
        j = i + 1;
      }
      paramInt -= 1;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    Object localObject1;
    Object localObject2;
    if (this.jdField_b_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int == -2147483648)
        {
          localObject1 = (StoryConfigManager)SuperManager.a(10);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("TROOP_STORY_COOKIE");
          ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_Long));
          this.jdField_d_of_type_Int = ((Integer)((StoryConfigManager)localObject1).b(((StringBuilder)localObject2).toString(), Integer.valueOf(0))).intValue();
        }
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetTroopStoryListHandler.a(this.jdField_a_of_type_Long, this.jdField_d_of_type_Int);
      }
    }
    else
    {
      int j = this.jdField_b_of_type_Int + 1;
      int i = j + 10;
      if (i >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
        i = this.jdField_a_of_type_JavaUtilList.size() - 2;
      }
      a(i, j);
      ArrayList localArrayList = new ArrayList();
      for (localObject2 = null; j <= i; localObject2 = localObject1)
      {
        TroopStoryItemInfo localTroopStoryItemInfo = (TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilList.get(j);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = a(j);
          localObject1 = localObject2;
          if (!e) {
            if (localObject2 != null) {
              localObject1 = localObject2;
            } else {
              throw new AssertionError();
            }
          }
        }
        if (localTroopStoryItemInfo.itemType == 2)
        {
          localTroopStoryItemInfo.dayVideoCount = ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_a_of_type_Int;
          localTroopStoryItemInfo.feedId = ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_a_of_type_JavaLangString;
          int k = ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_b_of_type_Int;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_b_of_type_Int = (k - 1);
          localTroopStoryItemInfo.dayVideoIndex = k;
          localArrayList.add(0, localTroopStoryItemInfo);
        }
        else if (localTroopStoryItemInfo.itemType == 1)
        {
          localObject1 = new TroopStoryIdSynchronizer.DayItem();
          ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_a_of_type_Int = localTroopStoryItemInfo.publishCount;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_a_of_type_JavaLangString = localTroopStoryItemInfo.feedId;
          ((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_b_of_type_Int = (((TroopStoryIdSynchronizer.DayItem)localObject1).jdField_a_of_type_Int - 1);
        }
        j += 1;
      }
      localObject1 = new GetTroopStoryListHandler.GetTroopStoryListEvent(this.jdField_a_of_type_JavaLangString, new ErrorMessage());
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).jdField_a_of_type_JavaUtilList = localArrayList;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).f = this.jdField_a_of_type_Boolean;
      ((GetTroopStoryListHandler.GetTroopStoryListEvent)localObject1).g = this.jdField_b_of_type_Boolean;
      StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject1);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = true;
    if ((!bool2) && (this.jdField_d_of_type_Boolean) && (paramInt1 == this.jdField_a_of_type_JavaUtilList.size() - 2)) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (paramInt2 <= 3)
      {
        this.jdField_b_of_type_Boolean = true;
      }
      else if (paramInt2 == 4)
      {
        if (((TroopStoryItemInfo)this.jdField_a_of_type_JavaUtilList.get(3)).itemType == 2) {
          bool1 = false;
        }
        this.jdField_b_of_type_Boolean = bool1;
      }
    }
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
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