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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItem;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
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
  protected TroopManager a;
  protected TroopMngObserver a;
  protected TroopShowExternalObserver a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap<String, Switch> a;
  protected List<TroopListItem> a;
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopListAdapter2.4(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopListAdapter2.5(this);
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
      this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver = new TroopListAdapter2.1(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopListAdapter2.2(this);
    }
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 1;
          }
          return 2;
        }
        return 4;
      }
      return 3;
    }
    return 1;
  }
  
  private List<TroopListItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (localObject1 != null) {
        ((HashMap)localObject1).clear();
      }
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
      Collections.sort((List)localObject2, new CommonlyUsedTroopCompator());
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
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new TroopListItemWithMask(i, (Entity)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListItemWithMask(i, (Entity)localObject8));
        } else if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListItemWithMask(i, (Entity)localObject8));
        } else {
          ((List)localObject2).add(new TroopListItemWithMask(i, (Entity)localObject8));
        }
        if (!((TroopInfo)localObject8).hasSetTroopName()) {
          ((List)localObject6).add(new TroopListItemWithMask(i, (Entity)localObject8));
        }
      }
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject8 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    if (this.jdField_d_of_type_Boolean)
    {
      localObject8 = ((List)localObject8).iterator();
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = ((RecentUserProxy)localObject7).a(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new TroopListItemWithMask(1, localDiscussionInfo));
        } else {
          ((List)localObject2).add(new TroopListItemWithMask(1, localDiscussionInfo));
        }
        if (!localDiscussionInfo.hasRenamed()) {
          ((List)localObject6).add(new TroopListItemWithMask(1, localDiscussionInfo));
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
    localObject7 = new TroopCompator();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.e > 0)
    {
      localArrayList.add(new TroopListItem(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(1, (Entity)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new TroopListItem(1, (DiscussionInfo)localObject7, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.f > 0)
    {
      localArrayList.add(new TroopListItem(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (TroopListItemWithMask)((Iterator)localObject5).next();
        if ((((TroopListItemWithMask)localObject6).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(9, ((TroopListItemWithMask)localObject6).a));
        }
        else if ((((TroopListItemWithMask)localObject6).a instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((TroopListItemWithMask)localObject6).a;
          localArrayList.add(new TroopListItem(9, (DiscussionInfo)localObject6, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList.add(new TroopListItem(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (TroopListItemWithMask)((Iterator)localObject4).next();
        if ((((TroopListItemWithMask)localObject5).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(5, ((TroopListItemWithMask)localObject5).a));
        }
        else if ((((TroopListItemWithMask)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((TroopListItemWithMask)localObject5).a;
          localArrayList.add(new TroopListItem(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject3).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList.add(new TroopListItem(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new TroopListItem(7, ((TroopListItemWithMask)((Iterator)localObject3).next()).a));
      }
    }
    if (this.jdField_d_of_type_Int > 0)
    {
      localArrayList.add(new TroopListItem(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListItemWithMask)((Iterator)localObject2).next();
        if ((((TroopListItemWithMask)localObject3).a instanceof TroopInfo))
        {
          localArrayList.add(new TroopListItem(3, ((TroopListItemWithMask)localObject3).a));
        }
        else if ((((TroopListItemWithMask)localObject3).a instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((TroopListItemWithMask)localObject3).a;
          localArrayList.add(new TroopListItem(3, (DiscussionInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.g = ((List)localObject1).size();
    if (this.g > 0)
    {
      localArrayList.add(new TroopListItem(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new TroopListItem(11, ((TroopListItemWithMask)((Iterator)localObject1).next()).a));
      }
    }
    return localArrayList;
  }
  
  private void a(TroopListItem paramTroopListItem, String paramString, boolean paramBoolean)
  {
    ((ITroopShowExternalHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER)).a(paramString, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "", "");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack;
    if (paramString != null) {
      paramString.a(paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramBoolean);
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
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
    Object localObject4 = (TroopListItem)getItem(paramInt);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559884, paramViewGroup, false);
      localObject3 = new TroopListAdapter2.TroopListViewItemTag((View)localObject2);
      ((View)localObject2).setTag(localObject3);
      ((Button)((View)localObject2).findViewById(2131379182)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject1 = localObject2;
      paramView = (View)localObject3;
      if (this.jdField_a_of_type_Boolean)
      {
        ((TroopListAdapter2.TroopListViewItemTag)localObject3).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        localObject1 = localObject2;
        paramView = (View)localObject3;
      }
    }
    else
    {
      localObject2 = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem = ((TroopListItem)localObject4);
    if ((this.jdField_a_of_type_Boolean) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_Int != 0) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_Int != 4) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_Int != 6) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_Int != 8) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_Int != 2))
    {
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem);
      if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (paramView.jdField_a_of_type_ComTencentMobileqqTroopAdapterContactTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
        paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      } else {
        paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      }
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramView.jdField_a_of_type_ComTencentWidgetSwitch);
      }
    }
    if (((TroopListItem)localObject4).jdField_a_of_type_Int == 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715257));
      paramView.e.setText(String.valueOf(this.e));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_Int == 2)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715597));
      paramView.e.setText(String.valueOf(this.jdField_d_of_type_Int));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_Int == 4)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715601));
      paramView.e.setText(String.valueOf(this.jdField_b_of_type_Int));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_Int == 6)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715604));
      paramView.e.setText(String.valueOf(this.jdField_c_of_type_Int));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_Int == 8)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715602));
      paramView.e.setText(String.valueOf(this.f));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_Int == 10)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702744));
      paramView.e.setText(String.valueOf(this.g));
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject3 = ((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      paramView.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject3).troopuin;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject3).troopuin) != 3)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850813);
      }
      localObject4 = paramView.jdField_a_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(((TroopInfo)localObject3).getTroopDisplayName())) {
        localObject2 = ((TroopInfo)localObject3).getTroopDisplayName();
      } else {
        localObject2 = ((TroopInfo)localObject3).troopuin;
      }
      ((TextView)localObject4).setText((CharSequence)localObject2);
      paramView.c.setImageBitmap(a(4, ((TroopInfo)localObject3).troopuin));
      if ((!((TroopInfo)localObject3).hasSetTroopName()) && (((TroopInfo)localObject3).wMemberNumClient > 0))
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject3).wMemberNumClient) }));
      }
      else
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((((TroopInfo)localObject3).dwGroupFlagExt & 0x800) != 0L)
      {
        if (((TroopInfo)localObject3).dwAuthGroupType == 2L)
        {
          paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843985);
        }
        else if (((TroopInfo)localObject3).dwAuthGroupType == 1L)
        {
          paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843985);
        }
        else
        {
          paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else {
        paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (((TroopInfo)localObject3).troopCreditLevel == 2L)
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850816);
      }
      else if (((TroopInfo)localObject3).troopCreditLevel == 1L)
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850814);
      }
      else
      {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
    else if (((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
    {
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject2 = ((TroopListItem)localObject4).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
      paramView.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject2).uin;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject2));
      if (!((DiscussionInfo)localObject2).hasRenamed())
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopListItem)localObject4).jdField_b_of_type_Int) }));
      }
      paramView.c.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
    }
    this.jdField_b_of_type_Boolean = false;
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.3(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject = paramCompoundButton.getTag();
      if ((localObject instanceof TroopListItem))
      {
        localObject = (TroopListItem)localObject;
        if (((TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
          }
          String str1 = ((TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
          String str2 = ((TroopListItem)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
          TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
          if (TextUtils.isEmpty(str1)) {
            ThreadManager.post(new TroopListAdapter2.6(this, localTroopManager, str2, (TroopListItem)localObject, paramBoolean), 8, null, true);
          } else {
            a((TroopListItem)localObject, str1, paramBoolean);
          }
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */