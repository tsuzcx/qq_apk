package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class TroopListBaseAdapter
  extends BaseFacePreloadExpandableListAdapter
{
  protected int a;
  protected Context a;
  protected AppInterface a;
  protected TroopAvatarObserver a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  protected Set<String> a;
  private boolean a;
  protected List<Entity> b = new ArrayList();
  protected List<TroopListItemWithMask> c = new ArrayList();
  protected List<TroopListItemWithMask> d = new ArrayList();
  protected List<TroopListItemWithMask> e = new ArrayList();
  protected List<TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListItemWithMask> g = new ArrayList();
  
  public TroopListBaseAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, (QQAppInterface)paramAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new TroopListBaseAdapter.4(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = AIOUtils.b(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localSet.contains(localStringBuilder.toString());
  }
  
  private void d()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()), 8, null, true);
  }
  
  public TroopListBaseAdapter.ItemInfo a(int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue();
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 6)
          {
            if (paramInt1 != 8)
            {
              if (paramInt1 != 13) {
                return null;
              }
              localEntity = ((TroopListItemWithMask)this.g.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
              localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
              localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
              localItemInfo.jdField_a_of_type_Int = 13;
              return localItemInfo;
            }
            localEntity = ((TroopListItemWithMask)this.f.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
            localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
            localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
            localItemInfo.jdField_a_of_type_Int = 8;
            return localItemInfo;
          }
          localEntity = ((TroopListItemWithMask)this.d.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
          localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
          localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
          localItemInfo.jdField_a_of_type_Int = 6;
          return localItemInfo;
        }
        localEntity = ((TroopListItemWithMask)this.c.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
        localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
        localItemInfo.jdField_a_of_type_Int = 4;
        return localItemInfo;
      }
      localEntity = ((TroopListItemWithMask)this.e.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 2;
      return localItemInfo;
    }
    Entity localEntity = (Entity)this.b.get(paramInt2);
    TroopListBaseAdapter.ItemInfo localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
    localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
    localItemInfo.jdField_a_of_type_Int = 0;
    return localItemInfo;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null)
    {
      int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null) {
          localView.setOnClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return 0;
      }
      j = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
      if (j != 0)
      {
        if (j != 2)
        {
          if (j != 4)
          {
            if (j != 6)
            {
              if (j != 8)
              {
                if (j == 13) {
                  i = this.g.size();
                }
              }
              else {
                i = this.f.size();
              }
            }
            else {
              i = this.d.size();
            }
          }
          else {
            i = this.c.size();
          }
        }
        else {
          i = this.e.size();
        }
      }
      else {
        i = this.b.size();
      }
      j = i;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getChildrenCount count:");
        localStringBuilder.append(i);
        localStringBuilder.append("  groupPosition:");
        localStringBuilder.append(paramInt);
        QLog.d("TroopListBaseAdapter", 2, localStringBuilder.toString());
        j = i;
      }
    }
    return j;
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildrenCount mGroups.size():");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("TroopListBaseAdapter", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
    {
      ThreadManager.postImmediately(new TroopListBaseAdapter.1(this), null, false);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */