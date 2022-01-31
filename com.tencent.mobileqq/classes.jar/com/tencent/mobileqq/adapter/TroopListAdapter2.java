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
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import yff;
import yfh;
import yfj;
import yfk;
import yfl;

public class TroopListAdapter2
  extends FacePreloadBaseAdapter
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  public Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack;
  public TroopListAdapter2.OnTroopListClickListener a;
  protected DiscussionManager a;
  public QQAppInterface a;
  public TroopManager a;
  protected TroopObserver a;
  public SlideDetectListView a;
  public HashMap a;
  public List a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected List b;
  protected boolean b;
  public int c;
  public boolean c;
  public int d;
  public int e;
  public int f;
  
  public TroopListAdapter2(Context paramContext, QQAppInterface paramQQAppInterface, TroopListAdapter2.OnTroopListClickListener paramOnTroopListClickListener, XListView paramXListView, int paramInt, boolean paramBoolean, ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack paramIShowExternalTroopDataChangedCallBack)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new yfj(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new yfk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$OnTroopListClickListener = paramOnTroopListClickListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack = paramIShowExternalTroopDataChangedCallBack;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(52));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new yff(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
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
  
  private List a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).a();
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      return localArrayList1;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new TroopListAdapter2.CommonlyUsedTroopCompator());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((TroopManager)localObject1).a(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin);
        if ((localObject3 != null) && (!((TroopInfo)localObject3).isQidianPrivateTroop())) {
          ((List)localObject5).add(localObject3);
        }
      }
      this.e = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = new ArrayList();
    Object localObject3 = this.jdField_b_of_type_JavaUtilList.iterator();
    label382:
    while (((Iterator)localObject3).hasNext())
    {
      localObject6 = (TroopInfo)((Iterator)localObject3).next();
      if (!((TroopInfo)localObject6).isQidianPrivateTroop())
      {
        int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject6).troopuin));
        if ((((TroopInfo)localObject6).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject6));
        }
        for (;;)
        {
          if (((TroopInfo)localObject6).hasSetTroopName()) {
            break label382;
          }
          ((List)localObject7).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject6));
          break;
          if ((((TroopInfo)localObject6).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject2).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject6));
          } else {
            ((List)localObject1).add(new TroopListAdapter2.TroopListItemWithMask(i, (Entity)localObject6));
          }
        }
      }
    }
    localObject3 = new TroopListAdapter2.TroopCompator();
    Collections.sort((List)localObject4, (Comparator)localObject3);
    Collections.sort((List)localObject2, (Comparator)localObject3);
    Collections.sort((List)localObject1, (Comparator)localObject3);
    Collections.sort((List)localObject7, (Comparator)localObject3);
    Object localObject9 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
    Object localObject8 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject3 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    localObject9 = ((List)localObject9).iterator();
    label607:
    while (((Iterator)localObject9).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject9).next();
      if (localRecentUserProxy.a(localDiscussionInfo.uin, 3000).showUpTime != 0L) {
        ((List)localObject8).add(localDiscussionInfo);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject6).add(localDiscussionInfo);
      }
      for (;;)
      {
        if (localDiscussionInfo.hasRenamed()) {
          break label607;
        }
        localArrayList2.add(localDiscussionInfo);
        break;
        ((List)localObject3).add(localDiscussionInfo);
      }
    }
    this.e += ((List)localObject8).size();
    if (this.e > 0)
    {
      localArrayList1.add(new TroopListAdapter2.TroopListItem(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        localArrayList1.add(new TroopListAdapter2.TroopListItem(1, (Entity)((Iterator)localObject5).next()));
      }
      localObject5 = ((List)localObject8).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject8 = (DiscussionInfo)((Iterator)localObject5).next();
        localArrayList1.add(new TroopListAdapter2.TroopListItem(1, (DiscussionInfo)localObject8, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject8).uin)));
      }
    }
    this.f = (((List)localObject7).size() + localArrayList2.size());
    if (this.f > 0)
    {
      localArrayList1.add(new TroopListAdapter2.TroopListItem(8, null));
      localObject5 = ((List)localObject7).iterator();
      while (((Iterator)localObject5).hasNext()) {
        localArrayList1.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject5).next()).a));
      }
      localObject5 = localArrayList2.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (DiscussionInfo)((Iterator)localObject5).next();
        localArrayList1.add(new TroopListAdapter2.TroopListItem(3, (DiscussionInfo)localObject7, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject7).uin)));
      }
    }
    this.jdField_b_of_type_Int = (((List)localObject4).size() + ((List)localObject6).size());
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList1.add(new TroopListAdapter2.TroopListItem(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        localArrayList1.add(new TroopListAdapter2.TroopListItem(5, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject4).next()).a));
      }
      localObject4 = ((List)localObject6).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
        localArrayList1.add(new TroopListAdapter2.TroopListItem(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject5).uin)));
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject2).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList1.add(new TroopListAdapter2.TroopListItem(6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localArrayList1.add(new TroopListAdapter2.TroopListItem(7, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject2).next()).a));
      }
    }
    this.d = (((List)localObject1).size() + ((List)localObject3).size());
    if (this.d > 0)
    {
      localArrayList1.add(new TroopListAdapter2.TroopListItem(2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList1.add(new TroopListAdapter2.TroopListItem(3, ((TroopListAdapter2.TroopListItemWithMask)((Iterator)localObject1).next()).a));
      }
      localObject1 = ((List)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
        localArrayList1.add(new TroopListAdapter2.TroopListItem(3, (DiscussionInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject2).uin)));
      }
    }
    return localArrayList1;
  }
  
  private void a(TroopListAdapter2.TroopListItem paramTroopListItem, String paramString, boolean paramBoolean)
  {
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramString, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$IShowExternalTroopDataChangedCallBack.a(paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean);
      }
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((TroopListAdapter2.TroopListItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
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
    Object localObject3 = (TroopListAdapter2.TroopListItem)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969448, paramViewGroup, false);
      localObject2 = new TroopListAdapter2.TroopListViewItemTag((View)localObject1);
      ((View)localObject1).setTag(localObject2);
      ((Button)((View)localObject1).findViewById(2131366516)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = (ViewGroup)localObject2;
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        ((TroopListAdapter2.TroopListViewItemTag)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem = ((TroopListAdapter2.TroopListItem)localObject3);
      if ((this.jdField_a_of_type_Boolean) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 0) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 4) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 6) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 8) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_Int != 2))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2$TroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          break label369;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label260:
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int != 0) {
        break label380;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429832, new Object[] { String.valueOf(this.e) }));
    }
    label687:
    label711:
    label970:
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return paramView;
      paramViewGroup = (TroopListAdapter2.TroopListViewItemTag)paramView.getTag();
      break;
      label369:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label260;
      label380:
      if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429826, new Object[] { String.valueOf(this.d) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 4)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429824, new Object[] { String.valueOf(this.jdField_b_of_type_Int) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 6)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429825, new Object[] { String.valueOf(this.jdField_c_of_type_Int) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_Int == 8)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131429827, new Object[] { String.valueOf(this.f) }));
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject2 = ((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin) != 3)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
            break label893;
          }
          localObject1 = ((TroopInfo)localObject2).getTroopName();
          ((TextView)localObject3).setText((CharSequence)localObject1);
          paramViewGroup.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
          if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
            break label903;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
          if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
            break label958;
          }
          if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
            break label915;
          }
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130841393);
        }
        for (;;)
        {
          if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
            break label970;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845953);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845948);
          break label687;
          label893:
          localObject1 = ((TroopInfo)localObject2).troopuin;
          break label711;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label787;
          if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
          {
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130841393);
          }
          else
          {
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            continue;
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        if (((TroopInfo)localObject2).troopCreditLevel == 1L)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845951);
        }
        else
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      else if (((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject1 = ((TroopListAdapter2.TroopListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1));
        if (!((DiscussionInfo)localObject1).hasRenamed())
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopListAdapter2.TroopListItem)localObject3).jdField_b_of_type_Int) }));
        }
        paramViewGroup.c.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new yfh(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        paramCompoundButton = paramCompoundButton.getTag();
      } while (!(paramCompoundButton instanceof TroopListAdapter2.TroopListItem));
      paramCompoundButton = (TroopListAdapter2.TroopListItem)paramCompoundButton;
    } while (paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    }
    String str1 = paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
    String str2 = paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
    if (TextUtils.isEmpty(str1))
    {
      ThreadManager.post(new yfl(this, localTroopManager, str2, paramCompoundButton, paramBoolean), 8, null, true);
      return;
    }
    a(paramCompoundButton, str1, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2
 * JD-Core Version:    0.7.0.1
 */