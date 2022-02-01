package com.tencent.mobileqq.activity.contacts.troop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ContactsTroopAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  public int a;
  protected Context a;
  protected DiscussionManager a;
  protected QQAppInterface a;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ContactsTroopAdapter.8(this);
  protected SwipTextViewMenuBuilder a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int[] a;
  private int b;
  protected List<Entity> b;
  protected int[] b;
  private int c;
  protected List<TroopListAdapter2.TroopListItemWithMask> c;
  protected int[] c;
  protected List<TroopListAdapter2.TroopListItemWithMask> d = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> e = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListAdapter2.TroopListItemWithMask> g = new ArrayList();
  
  public ContactsTroopAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(5);
    this.jdField_a_of_type_Int = -2;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_b_of_type_ArrayOfInt = new int[6];
    this.jdField_c_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = AIOUtils.a(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new ContactsTroopAdapter.1(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296829) }, -1, new int[] { 2131371189, 2131371189 }, new int[] { 2131693109, 2131693107 }, new int[] { 2130839650, 2130839650 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return 0;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return 0;
    case 0: 
      return 0;
    case 4: 
      return 1;
    case 6: 
      return 2;
    case 2: 
      return 3;
    case 10: 
      return 4;
    }
    return 5;
  }
  
  private int a(List<TroopListAdapter2.TroopListItemWithMask> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      TroopListAdapter2.TroopListItemWithMask localTroopListItemWithMask = (TroopListAdapter2.TroopListItemWithMask)paramList.next();
      if ((localTroopListItemWithMask.a == null) || (!(localTroopListItemWithMask.a instanceof TroopInfo)) || (((TroopInfo)localTroopListItemWithMask.a).lastMsgTime <= 0L)) {
        break label100;
      }
      i += 1;
    }
    label100:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
      }
      return i;
    }
  }
  
  private View a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563142, null);
    TextView localTextView = (TextView)localView.findViewById(2131367369);
    String str = HardCodeUtil.a(2131702583) + this.jdField_c_of_type_ArrayOfInt[paramInt] + ")";
    localTextView.setText(str);
    localView.setOnClickListener(new ContactsTroopAdapter.2(this, paramInt));
    localView.setOnTouchListener(new ContactsTroopAdapter.3(this, localTextView));
    localView.setContentDescription(str + HardCodeUtil.a(2131702556));
    return localView;
  }
  
  private Entity a(int paramInt1, int paramInt2)
  {
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      return null;
    case 0: 
      return (Entity)this.jdField_b_of_type_JavaUtilList.get(paramInt2);
    case 4: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.jdField_c_of_type_JavaUtilList.get(paramInt2)).a;
    case 6: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.d.get(paramInt2)).a;
    case 2: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.e.get(paramInt2)).a;
    case 8: 
      return ((TroopListAdapter2.TroopListItemWithMask)this.f.get(paramInt2)).a;
    }
    return ((TroopListAdapter2.TroopListItemWithMask)this.g.get(paramInt2)).a;
  }
  
  private void a(int paramInt)
  {
    int j = 0;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
    int i;
    label107:
    int k;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      if (j <= 10)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
        if (j > 10) {
          break label286;
        }
        k = j;
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
      this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
      return;
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      j = this.d.size();
      i = a(this.d);
      break;
      j = this.e.size();
      i = a(this.e);
      break;
      j = this.f.size();
      i = a(this.f);
      break;
      j = this.g.size();
      i = a(this.g);
      break;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label107;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      break label107;
      label286:
      k = i;
      if (i < 10) {
        k = 10;
      }
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag)
  {
    int k = 0;
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      i = 0;
      if (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i)) {
        break label100;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2) {
        this.jdField_a_of_type_ArrayOfInt[i] = 1;
      }
      i += 1;
      continue;
      i = paramGroupTag.jdField_a_of_type_Int;
      break;
      label100:
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(j))
        {
          this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(j);
          this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(j));
        }
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
      i = k;
    }
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    int i;
    String str1;
    int j;
    int k;
    label118:
    String str2;
    label132:
    label189:
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
      switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      default: 
        i = 0;
        str1 = "";
        j = 0;
        if (j <= 10)
        {
          k = j;
          if (j > 10) {
            break label609;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label632;
          }
          str2 = k + "/" + j;
          localStringBuilder1 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
          localStringBuilder2 = localStringBuilder1;
          if (AppSetting.d)
          {
            if (localStringBuilder1 != null) {
              break label658;
            }
            localStringBuilder1 = new StringBuilder(24);
            label221:
            localStringBuilder1.append(str1 + " 分组");
            localStringBuilder2 = localStringBuilder1;
          }
          paramGroupTag.jdField_a_of_type_Int = paramInt;
          paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
          paramGroupTag.b.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(str2);
          if (AppSetting.d) {
            localStringBuilder2.append("共" + j + "个" + str1);
          }
          paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
          if (AppSetting.d)
          {
            if (!paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label673;
            }
            localStringBuilder2.append(" 已展开");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setContentDescription(localStringBuilder2.toString());
      AccessibilityUtil.a(paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox, false);
      return;
      str1 = HardCodeUtil.a(2131702596);
      j = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      i = 0;
      break;
      str1 = HardCodeUtil.a(2131715677);
      j = this.jdField_c_of_type_JavaUtilList.size();
      i = a(this.jdField_c_of_type_JavaUtilList);
      break;
      str1 = HardCodeUtil.a(2131715680);
      j = this.d.size();
      i = a(this.d);
      break;
      str1 = HardCodeUtil.a(2131715673);
      j = this.e.size();
      i = a(this.e);
      break;
      str1 = HardCodeUtil.a(2131715678);
      j = this.f.size();
      i = a(this.f);
      break;
      str1 = HardCodeUtil.a(2131702612);
      j = this.g.size();
      i = a(this.g);
      break;
      k = i;
      if (i >= 10) {
        break label118;
      }
      k = 10;
      break label118;
      label609:
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label132;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      notifyDataSetChanged();
      break label132;
      label632:
      str2 = "" + j;
      break label189;
      label658:
      localStringBuilder1.delete(0, localStringBuilder1.length());
      break label221;
      label673:
      localStringBuilder2.append(" 已折叠");
    }
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag)
  {
    if ((paramTroopDisChildTag.jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
    {
      a(paramTroopDisChildTag, (DiscussionInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject;
    a(paramTroopDisChildTag, localTroopInfo);
    ThreadPriorityManager.a(true);
    paramTroopDisChildTag = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    paramTroopDisChildTag.putExtra("uin", localTroopInfo.troopuin);
    if (localTroopInfo.troopcode != null) {
      paramTroopDisChildTag.putExtra("troop_uin", localTroopInfo.troopcode);
    }
    paramTroopDisChildTag.putExtra("uintype", 1);
    paramTroopDisChildTag.putExtra("uinname", localTroopInfo.getTroopDisplayName());
    paramTroopDisChildTag.putExtra("open_chatfragment_withanim", true);
    paramTroopDisChildTag.putExtra("isFromContactTab", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopDisChildTag);
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, DiscussionInfo paramDiscussionInfo)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", paramDiscussionInfo.uin);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramDiscussionInfo.discussionName);
    localIntent.putExtra("open_chatfragment_withanim", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramTroopDisChildTag.jdField_a_of_type_Int)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramDiscussionInfo.uin, String.valueOf(i) }).a();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
    }
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, TroopInfo paramTroopInfo)
  {
    int i;
    int j;
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramTroopDisChildTag.jdField_a_of_type_Int)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
      switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin))
      {
      default: 
        j = 0;
      }
      break;
    }
    for (;;)
    {
      if (paramTroopDisChildTag.jdField_a_of_type_Boolean) {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_inactiveGrp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "choose_grp", "grplist", 0, 0, paramTroopInfo.troopuin + "", String.valueOf(i), j + "", "");
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_grp").a(new String[] { paramTroopInfo.troopuin, String.valueOf(i) }).a();
      if (i == 5) {
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("clk_unnamedGrp").a(new String[] { paramTroopInfo.troopuin }).a();
      }
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
      j = 0;
      continue;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 1;
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    boolean bool = localDiscussionHandler.a(paramDiscussionInfo);
    if (bool) {}
    for (int i = 2131693107;; i = 2131693109)
    {
      localActionSheet.addButton(i);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ContactsTroopAdapter.7(this, localDiscussionHandler, paramDiscussionInfo, bool, localActionSheet));
      try
      {
        localActionSheet.show();
        return;
      }
      catch (Exception paramDiscussionInfo) {}
    }
  }
  
  private void a(DiscussionInfo paramDiscussionInfo, BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, int paramInt1, int paramInt2, View paramView)
  {
    paramTroopDisChildTag.jdField_a_of_type_JavaLangString = paramDiscussionInfo.uin;
    paramTroopDisChildTag.jdField_a_of_type_JavaLangObject = paramDiscussionInfo;
    paramTroopDisChildTag.jdField_b_of_type_Int = 101;
    paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.setText(paramDiscussionInfo.discussionName);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(paramDiscussionInfo.uin);
    if ((!paramDiscussionInfo.hasRenamed()) && (i > 0))
    {
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(i) }));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "DiscussionInfo hasRenamed:" + paramDiscussionInfo.hasRenamed() + " | memberNum:" + i + " | uin:" + paramDiscussionInfo.uin + "  discussionName:" + paramDiscussionInfo.discussionName);
      }
      if ((paramDiscussionInfo.lastMsgTime != 0L) || (AppSetting.d)) {
        paramTroopDisChildTag.g.setContentDescription(paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramTroopDisChildTag, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramDiscussionInfo);
      return;
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopInfo.troopuin);
    Object localObject1 = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    int i;
    label64:
    Object localObject2;
    if (bool)
    {
      i = 1;
      if (((BizTroopHandler)localObject1).a(paramTroopInfo.troopcode, i))
      {
        if (!bool) {
          break label193;
        }
        localObject1 = "Clk_uncommgrp";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject1, 0, 0, paramTroopInfo.troopuin, "", "", "");
        localObject2 = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
        if (!bool) {
          break label201;
        }
        localObject1 = "Clk_unstick";
        label140:
        localObject1 = ((ReportTask)localObject2).d((String)localObject1);
        localObject2 = paramTroopInfo.troopuin;
        if (!paramTroopInfo.hasSetTroopHead()) {
          break label209;
        }
      }
    }
    label193:
    label201:
    label209:
    for (paramTroopInfo = "1";; paramTroopInfo = "0")
    {
      ((ReportTask)localObject1).a(new String[] { localObject2, paramTroopInfo }).a();
      return;
      i = 0;
      break;
      localObject1 = "Clk_setcommgrp";
      break label64;
      localObject1 = "Clk_stick";
      break label140;
    }
  }
  
  private void a(TroopInfo paramTroopInfo, BuddyListTroop.TroopDisChildTag paramTroopDisChildTag, int paramInt1, int paramInt2, View paramView)
  {
    paramTroopDisChildTag.jdField_a_of_type_JavaLangString = paramTroopInfo.troopuin;
    paramTroopDisChildTag.jdField_a_of_type_JavaLangObject = paramTroopInfo;
    paramTroopDisChildTag.jdField_b_of_type_Int = 4;
    paramTroopDisChildTag.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(paramTroopInfo.troopuin);
    Object localObject;
    if (i == 3)
    {
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850876);
      TextView localTextView = paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName())) {
        break label424;
      }
      localObject = paramTroopInfo.getTroopDisplayName();
      label88:
      localTextView.setText((CharSequence)localObject);
      if ((paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label433;
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
      label144:
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "TroopInfo hasSetTroopName:" + paramTroopInfo.hasSetTroopName() + " | memberNum:" + paramTroopInfo.wMemberNumClient);
      }
      if ((paramTroopInfo.lastMsgTime == 0L) && ((paramTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
        break label487;
      }
      if (paramTroopInfo.dwAuthGroupType != 2L) {
        break label445;
      }
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
      label243:
      if (!paramTroopInfo.isTroopBlocked) {
        break label512;
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!SimpleUIUtil.a()) {
        break label499;
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842670);
      label274:
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851175);
      localObject = (FrameLayout.LayoutParams)paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = (-ViewUtils.b(2.0F));
        ((FrameLayout.LayoutParams)localObject).rightMargin = (-ViewUtils.b(3.0F));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramTroopDisChildTag.g.setContentDescription(paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramTroopDisChildTag, null);
      paramView.setOnClickListener(this);
      paramView.setOnLongClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramTroopInfo);
      return;
      if (i == 1)
      {
        paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break;
      }
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839626);
      break;
      label424:
      localObject = paramTroopInfo.troopuin;
      break label88;
      label433:
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label144;
      label445:
      if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
        break label243;
      }
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label487:
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label499:
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842669);
      break label274;
      label512:
      if (paramTroopInfo.troopCreditLevel == 2L)
      {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (SimpleUIUtil.a()) {
          paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842670);
        }
        for (;;)
        {
          paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850879);
          break;
          paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842669);
        }
      }
      if (paramTroopInfo.troopCreditLevel == 1L)
      {
        paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (SimpleUIUtil.a()) {
          paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842670);
        }
        for (;;)
        {
          paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850877);
          break;
          paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842669);
        }
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt1 < this.jdField_b_of_type_ArrayOfInt.length) && (paramInt2 > this.jdField_b_of_type_ArrayOfInt[paramInt1]);
  }
  
  private void b(BuddyListAdapter.GroupTag paramGroupTag)
  {
    a(paramGroupTag);
    a(paramGroupTag.jdField_a_of_type_Int);
    if ((paramGroupTag.jdField_a_of_type_Int >= 0) && (paramGroupTag.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfInt.length)) {
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label139;
      }
    }
    label139:
    for (int i = 0;; i = paramGroupTag.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfInt[paramGroupTag.jdField_a_of_type_Int] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i)))
      {
        i = a(paramGroupTag.jdField_a_of_type_Int);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(i) }).a();
      }
      return;
    }
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    boolean bool = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopInfo.troopuin);
    if (bool) {}
    for (int i = 2131693107;; i = 2131693109)
    {
      localActionSheet.addButton(i);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ContactsTroopAdapter.6(this, bool, paramTroopInfo, localActionSheet));
      try
      {
        localActionSheet.show();
        return;
      }
      catch (Exception paramTroopInfo) {}
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "only one group");
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getString("700_sp_key_last_troop_expanded", "700_sp_key_last_troop_expanded");
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "readExpand=" + (String)localObject);
    }
    HashSet localHashSet = new HashSet();
    label168:
    int i;
    label170:
    int j;
    if (((String)localObject).equalsIgnoreCase("700_sp_key_last_troop_expanded")) {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size()) {
          if (localHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i)))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
            if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
              break label428;
            }
            j = 0;
          }
        }
      }
    }
    for (;;)
    {
      if ((i > 0) && (i < this.jdField_a_of_type_ArrayOfInt.length)) {
        a(i);
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      if ((i < this.jdField_a_of_type_ArrayOfInt.length) && (this.jdField_a_of_type_ArrayOfInt[i] == 1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(j)))
      {
        j = a(i);
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("Grp_contactlist").d("exp_inactive").a(new String[] { "", String.valueOf(j) }).a();
      }
      i += 1;
      break label170;
      break;
      this.jdField_a_of_type_Boolean = true;
      break label168;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label168;
      }
      localObject = ((String)localObject).split("_");
      j = localObject.length;
      i = 0;
      label395:
      if (i >= j) {
        break label168;
      }
      String str = localObject[i];
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str)));
        label421:
        i += 1;
        break label395;
        label428:
        j = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label421;
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      localStringBuffer = new StringBuffer();
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuffer.append((Integer)localIterator.next());
        localStringBuffer.append("_");
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactsTroopAdapter", 2, "saveExpanded=" + localStringBuffer.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putString("700_sp_key_last_troop_expanded", localStringBuffer.toString()).commit();
    }
    while (!QLog.isColorLevel())
    {
      StringBuffer localStringBuffer;
      Iterator localIterator;
      return;
    }
    QLog.d("ContactsTroopAdapter", 2, "less than 1 group : don't saveExpanded");
  }
  
  private void h()
  {
    ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void i()
  {
    boolean bool = false;
    Object localObject = new TroopListAdapter2.TroopCompator();
    Collections.sort(this.jdField_c_of_type_JavaUtilList, (Comparator)localObject);
    Collections.sort(this.d, (Comparator)localObject);
    Collections.sort(this.e, (Comparator)localObject);
    Collections.sort(this.f, (Comparator)localObject);
    Collections.sort(this.g, (Comparator)localObject);
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      if (this.f.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if (this.d.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
      }
      if (this.e.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      if (this.g.size() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
      }
      localObject = new HashSet(5);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (this.jdField_a_of_type_JavaUtilList.contains(localInteger)) {
          ((HashSet)localObject).add(localInteger);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject);
    c(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      f();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        localObject = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
    }
    i = 0;
    label393:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
        break label442;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    }
    for (;;)
    {
      i += 1;
      break label393;
      break;
      label442:
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
    }
  }
  
  public void a()
  {
    g();
  }
  
  protected void a(int paramInt, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem, Object paramObject)
  {
    int i = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    label97:
    for (;;)
    {
      return;
      if (paramArrayOfSwipRightMenuItem.length < 0) {
        if ((paramObject instanceof TroopInfo))
        {
          paramObject = (TroopInfo)paramObject;
          if (this.jdField_b_of_type_JavaUtilList.contains(paramObject))
          {
            paramInt = 1;
            paramArrayOfSwipRightMenuItem[0].jdField_b_of_type_Int = paramInt;
            paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfSwipRightMenuItem.length) {
          break label97;
        }
        paramArrayOfSwipRightMenuItem[paramInt].jdField_b_of_type_Int = -1;
        paramArrayOfSwipRightMenuItem[paramInt].jdField_a_of_type_Int = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
        break;
        paramInt = 0;
      }
    }
  }
  
  public void a(View paramView, int paramInt, BuddyListItem.ViewTag paramViewTag, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, paramObject, paramViewTag, paramOnClickListener);; i = 0)
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (paramInt != this.jdField_a_of_type_Int) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
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
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(null);
      int j = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetExpandableListView.getChildAt(i);
        if (localView != null)
        {
          localView.setOnClickListener(null);
          localView.setOnLongClickListener(null);
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.5(this));
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof BuddyListAdapter.GroupTag))
    {
      localObject = new BuddyListAdapter.GroupTag();
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368102));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((BuddyListAdapter.GroupTag)localObject).b = ((SingleLineTextView)paramView.findViewById(2131380558));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365230));
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((BuddyListAdapter.GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369760));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
        break label180;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
      paramView = (BuddyListAdapter.GroupTag)paramView.getTag();
      break;
      label180:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167117);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt2 == getChildrenCount(paramInt1) - 1) && (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)) {
      paramViewGroup = a(paramInt1);
    }
    Object localObject;
    do
    {
      return paramViewGroup;
      if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListTroop.TroopDisChildTag)))
      {
        localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563143, null);
        ((View)localObject).setMinimumHeight(this.jdField_b_of_type_Int);
        paramViewGroup = new BuddyListTroop.TroopDisChildTag();
        paramView = this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.g = ((View)localObject);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379092));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379094));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131368603));
        if ((paramViewGroup.d instanceof ThemeImageView)) {
          ((ThemeImageView)paramViewGroup.d).setSupportMaskView(false);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371065));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131378434));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371959));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379848));
        localObject = paramView.getResources().getColorStateList(2131167040);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt1;
        localObject = a(paramInt1, paramInt2);
        if ((localObject == null) || (!(localObject instanceof TroopInfo))) {
          break;
        }
        a((TroopInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
        paramViewGroup = (BuddyListTroop.TroopDisChildTag)paramView.getTag();
      }
      if ((localObject != null) && ((localObject instanceof DiscussionInfo)))
      {
        a((DiscussionInfo)localObject, paramViewGroup, paramInt1, paramInt2, paramView);
        return paramView;
      }
      paramViewGroup = paramView;
    } while (!QLog.isColorLevel());
    QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      i = 0;
      return i;
    }
    switch (((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue())
    {
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    default: 
      i = 0;
    }
    for (;;)
    {
      int j = i;
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 1)
      {
        j = i;
        if (this.jdField_b_of_type_ArrayOfInt[paramInt] < i) {
          j = this.jdField_b_of_type_ArrayOfInt[paramInt] + 1;
        }
      }
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount count:" + j + "  groupPosition:" + paramInt);
      return j;
      i = this.jdField_b_of_type_JavaUtilList.size();
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
      continue;
      i = this.jdField_c_of_type_JavaUtilList.size();
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
      QLog.d("ContactsTroopAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559024, paramViewGroup, false);
      paramViewGroup = new BuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131368102));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369653));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365230));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369760));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131380558));
      paramView.setTag(paramViewGroup);
    }
    while (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (BuddyListAdapter.GroupTag)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_c_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167117);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131559024;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    if (((ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
    {
      ThreadManager.postImmediately(new ContactsTroopAdapter.4(this), null, false);
      return;
    }
    h();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof BuddyListAdapter.GroupTag)) {
      b((BuddyListAdapter.GroupTag)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof BuddyListTroop.TroopDisChildTag)) {
        a((BuddyListTroop.TroopDisChildTag)localObject);
      } else if ((localObject instanceof TroopInfo)) {
        a((TroopInfo)localObject);
      }
    }
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof BuddyListAdapter.GroupTag)) {
      a((BuddyListAdapter.GroupTag)paramExpandableListView);
    }
    return true;
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    HeaderScrollView localHeaderScrollView = null;
    while ((localViewParent != null) && (localHeaderScrollView == null)) {
      if ((localViewParent instanceof HeaderScrollView)) {
        localHeaderScrollView = (HeaderScrollView)localViewParent;
      } else if ((localViewParent instanceof View)) {
        localViewParent = ((View)localViewParent).getParent();
      } else {
        localViewParent = null;
      }
    }
    if ((localHeaderScrollView != null) && (localHeaderScrollView.jdField_a_of_type_Boolean)) {
      return false;
    }
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof BuddyListItem.ViewTag)))
    {
      paramView = ((BuddyListItem.ViewTag)paramView).jdField_a_of_type_JavaLangObject;
      if (paramView != null) {
        if ((paramView instanceof TroopInfo)) {
          b((TroopInfo)paramView);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (!(paramView instanceof DiscussionInfo)) {
        break;
      }
      a((DiscussionInfo)paramView);
      break;
    }
  }
  
  public boolean supportSwip(View paramView)
  {
    return true;
  }
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter
 * JD-Core Version:    0.7.0.1
 */