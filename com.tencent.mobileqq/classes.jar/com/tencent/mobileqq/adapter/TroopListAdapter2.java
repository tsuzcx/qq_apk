package com.tencent.mobileqq.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack;
  TroopListAdapter2.OnTroopListClickListener jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener;
  protected DiscussionManager a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopBusinessObserver a;
  protected TroopManager a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap<String, Switch> a;
  protected List<TroopListAdapter2.TroopListItem> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected List<Entity> b;
  protected boolean b;
  public int c;
  public boolean c;
  public int d;
  protected boolean d;
  public int e;
  public int f;
  public int g;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopListAdapter2.3(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopListAdapter2.4(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = paramIShowExternalTroopDataChangedCallBack;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopListAdapter2.1(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  private List<TroopListAdapter2.TroopListItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).a();
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      return localArrayList;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new TroopListAdapter2.CommonlyUsedTroopCompator());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject5).add(((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin));
      }
      this.e = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = this.jdField_b_of_type_JavaUtilList.iterator();
    label396:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject8));
        }
        for (;;)
        {
          if (((TroopInfo)localObject8).hasSetTroopName()) {
            break label396;
          }
          ((List)localObject6).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject8));
          break;
          if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject8));
          } else {
            ((List)localObject2).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject8));
          }
        }
      }
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject8 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    if (this.jdField_d_of_type_Boolean)
    {
      localObject8 = ((List)localObject8).iterator();
      label597:
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = ((RecentUserProxy)localObject7).a(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(1, localDiscussionInfo));
        }
        for (;;)
        {
          if (localDiscussionInfo.hasRenamed()) {
            break label597;
          }
          ((List)localObject6).add(new TroopListAdapter2.TroopListItemWithMask(1, localDiscussionInfo));
          break;
          ((List)localObject2).add(new TroopListAdapter2.TroopListItemWithMask(1, localDiscussionInfo));
        }
      }
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      ((List)localObject5).clear();
      ((List)localObject2).clear();
      ((List)localObject6).clear();
      ((List)localObject1).clear();
    }
    this.e = ((List)localObject5).size();
    this.jdField_b_of_type_Int = ((List)localObject4).size();
    this.jdField_d_of_type_Int = ((List)localObject2).size();
    this.f = ((List)localObject6).size();
    localObject7 = new TroopListAdapter2.TroopCompator();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.e > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new TroopListAdapter2.TroopListItem(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new TroopListAdapter2.TroopListItem(1, (DiscussionInfo)localObject7, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.f > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject5).next();
        if ((((TroopListAdapter2.TroopListItemWithMask)localObject6).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListAdapter2.TroopListItem(9, ((TroopListAdapter2.TroopListItemWithMask)localObject6).a));
        }
        else if ((((TroopListAdapter2.TroopListItemWithMask)localObject6).a instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((TroopListAdapter2.TroopListItemWithMask)localObject6).a;
          localArrayList.add(new TroopListAdapter2.TroopListItem(9, (DiscussionInfo)localObject6, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject4).next();
        if ((((TroopListAdapter2.TroopListItemWithMask)localObject5).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)localObject5).a));
        }
        else if ((((TroopListAdapter2.TroopListItemWithMask)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((TroopListAdapter2.TroopListItemWithMask)localObject5).a;
          localArrayList.add(new TroopListAdapter2.TroopListItem(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject3).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new TroopListAdapter2.TroopListItem(7, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject3).next()).a));
      }
    }
    if (this.jdField_d_of_type_Int > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next();
        if ((((TroopListAdapter2.TroopListItemWithMask)localObject3).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)localObject3).a));
        }
        else if ((((TroopListAdapter2.TroopListItemWithMask)localObject3).a instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((TroopListAdapter2.TroopListItemWithMask)localObject3).a;
          localArrayList.add(new TroopListAdapter2.TroopListItem(3, (DiscussionInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.g = ((List)localObject1).size();
    if (this.g > 0)
    {
      localArrayList.add(new TroopListAdapter2.TroopListItem(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new TroopListAdapter2.TroopListItem(11, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject1).next()).a));
      }
    }
    return localArrayList;
  }
  
  private void a(TroopListAdapter2.TroopListItem paramTroopListItem, String paramString, boolean paramBoolean)
  {
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack.a(paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean);
      }
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListAdapter2.TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    }
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject1 = (TroopListAdapter2.TroopListItem)getItem(paramInt);
    TroopListAdapter2.TroopListViewItemTag localTroopListViewItemTag;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560013, paramViewGroup, false);
      localTroopListViewItemTag = new TroopListAdapter2.TroopListViewItemTag(paramView);
      paramView.setTag(localTroopListViewItemTag);
      ((Button)paramView.findViewById(2131379853)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_Boolean) {
        localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      }
      localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject1);
      if ((this.jdField_a_of_type_Boolean) && (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 0) && (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 4) && (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 6) && (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 8) && (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 2))
      {
        localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch.setTag(localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (localTroopListViewItemTag.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
          break label380;
        }
        localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label255:
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int != 0) {
        break label392;
      }
      localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715335));
      localTroopListViewItemTag.e.setText(String.valueOf(this.e));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localTroopListViewItemTag = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      break;
      label380:
      localTroopListViewItemTag.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label255;
      label392:
      if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int == 2)
      {
        localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715673));
        localTroopListViewItemTag.e.setText(String.valueOf(this.jdField_d_of_type_Int));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int == 4)
      {
        localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715677));
        localTroopListViewItemTag.e.setText(String.valueOf(this.jdField_b_of_type_Int));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int == 6)
      {
        localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715680));
        localTroopListViewItemTag.e.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int == 8)
      {
        localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715678));
        localTroopListViewItemTag.e.setText(String.valueOf(this.f));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_Int == 10)
      {
        localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702612));
        localTroopListViewItemTag.e.setText(String.valueOf(this.g));
      }
      else
      {
        Object localObject2;
        if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          localTroopListViewItemTag.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject2).troopuin) != 3)
          {
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            label764:
            TextView localTextView = localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopDisplayName())) {
              break label981;
            }
            localObject1 = ((TroopInfo)localObject2).getTroopDisplayName();
            label789:
            localTextView.setText((CharSequence)localObject1);
            localTroopListViewItemTag.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
            if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
              break label991;
            }
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
            label868:
            if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
              break label1050;
            }
            if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
              break label1004;
            }
            localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
          }
          label1050:
          for (;;)
          {
            if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
              break label1063;
            }
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850879);
            break;
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850876);
            break label764;
            label981:
            localObject1 = ((TroopInfo)localObject2).troopuin;
            break label789;
            label991:
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label868;
            label1004:
            if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
            {
              localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
              localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
            }
            else
            {
              localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              continue;
              localTroopListViewItemTag.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          label1063:
          if (((TroopInfo)localObject2).troopCreditLevel == 1L)
          {
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850877);
          }
          else
          {
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
        else if (((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localTroopListViewItemTag.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localObject2 = ((TroopListAdapter2.TroopListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          localTroopListViewItemTag.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject2).uin;
          localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localTroopListViewItemTag.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject2));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localTroopListViewItemTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopListAdapter2.TroopListItem)localObject1).jdField_b_of_type_Int) }));
          }
          localTroopListViewItemTag.c.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.2(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      Object localObject = paramCompoundButton.getTag();
      if ((localObject instanceof TroopListAdapter2.TroopListItem))
      {
        localObject = (TroopListAdapter2.TroopListItem)localObject;
        if (((TroopListAdapter2.TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
          }
          String str1 = ((TroopListAdapter2.TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
          String str2 = ((TroopListAdapter2.TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.5(this, localTroopManager, str2, (TroopListAdapter2.TroopListItem)localObject, paramBoolean), 8, null, true);
          } else {
            a((TroopListAdapter2.TroopListItem)localObject, str1, paramBoolean);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */