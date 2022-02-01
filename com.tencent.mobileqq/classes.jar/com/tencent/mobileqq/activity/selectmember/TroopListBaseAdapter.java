package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.view.View;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
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
  protected DiscussionManager a;
  protected QQAppInterface a;
  protected TroopBusinessObserver a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  protected Set<String> a;
  private boolean a;
  protected List<Entity> b = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> c = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> d = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> e = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> g = new ArrayList();
  
  public TroopListBaseAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(6);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopListBaseAdapter.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = AIOUtils.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
  }
  
  private boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString + "_" + paramInt);
  }
  
  private void d()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a()), 8, null, true);
  }
  
  public TroopListBaseAdapter.ItemInfo a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return null;
    case 0: 
      localEntity = (Entity)this.b.get(paramInt2);
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 0;
      return localItemInfo;
    case 4: 
      localEntity = ((TroopListAdapter2.TroopListItemWithMask)this.c.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 4;
      return localItemInfo;
    case 6: 
      localEntity = ((TroopListAdapter2.TroopListItemWithMask)this.d.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 6;
      return localItemInfo;
    case 2: 
      localEntity = ((TroopListAdapter2.TroopListItemWithMask)this.e.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 2;
      return localItemInfo;
    case 8: 
      localEntity = ((TroopListAdapter2.TroopListItemWithMask)this.f.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
      localItemInfo.jdField_a_of_type_Int = 8;
      return localItemInfo;
    }
    Entity localEntity = ((TroopListAdapter2.TroopListItemWithMask)this.g.get(paramInt2)).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
    TroopListBaseAdapter.ItemInfo localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
    localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity = localEntity;
    localItemInfo.jdField_a_of_type_Int = 13;
    return localItemInfo;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.a(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
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
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
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
    int j;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      j = 0;
      return j;
    }
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount count:" + i + "  groupPosition:" + paramInt);
      return i;
      i = this.b.size();
      continue;
      i = this.c.size();
      continue;
      i = this.d.size();
      continue;
      i = this.e.size();
      continue;
      i = this.f.size();
      continue;
      i = this.g.size();
    }
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
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
    if (((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
    {
      ThreadManager.postImmediately(new TroopListBaseAdapter.1(this), null, false);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */