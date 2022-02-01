package com.tencent.av.wtogether.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.BuddyListItem.ViewTag;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.troop.BuddyListTroop.TroopDisChildTag;
import com.tencent.mobileqq.adapter.SwipFacePreloadExpandableAdapter;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
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

public class QGroupExpandableListAdapter
  extends SwipFacePreloadExpandableAdapter
  implements View.OnClickListener, AdapterView.OnItemLongClickListener, ExpandableListView.OnGroupClickListener, SwipPinnedHeaderExpandableListView.SwipListListener
{
  public int a;
  protected Context a;
  private QGroupExpandableListAdapter.UIEvent jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter$UIEvent;
  protected DiscussionManager a;
  protected QQAppInterface a;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new QGroupExpandableListAdapter.6(this);
  protected SwipTextViewMenuBuilder a;
  protected HashSet<Integer> a;
  protected List<Integer> a;
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
  
  public QGroupExpandableListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, QGroupExpandableListAdapter.UIEvent paramUIEvent)
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
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter$UIEvent = paramUIEvent;
    this.jdField_b_of_type_Int = AIOUtils.a(56.0F, paramContext.getResources());
    this.jdField_c_of_type_Int = AIOUtils.a(44.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentWidgetSwipTextViewMenuBuilder = new QGroupExpandableListAdapter.1(this, 1, 1, new int[] { paramContext.getResources().getDimensionPixelSize(2131296829) }, -1, new int[] { 2131371189, 2131371189 }, new int[] { 2131693109, 2131693107 }, new int[] { 2130839650, 2130839650 });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.setOnItemLongClickListener(this);
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
        QLog.d("QGroupListAdapter", 2, "getActiveTroopCount activeTroopCount:" + i);
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
    localView.setOnClickListener(new QGroupExpandableListAdapter.2(this, paramInt));
    localView.setOnTouchListener(new QGroupExpandableListAdapter.3(this, localTextView));
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
          label118:
          if (j > 10) {
            break label457;
          }
          this.jdField_a_of_type_ArrayOfInt[paramInt] = 3;
          label132:
          this.jdField_b_of_type_ArrayOfInt[paramInt] = k;
          this.jdField_c_of_type_ArrayOfInt[paramInt] = (j - k);
          if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
            break label480;
          }
        }
        break;
      }
    }
    label457:
    label480:
    for (String str2 = k + "/" + j;; str2 = "" + j)
    {
      paramGroupTag.jdField_a_of_type_Int = paramInt;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str1);
      paramGroupTag.b.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(str2);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
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
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 0) {
        break label132;
      }
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 1;
      notifyDataSetChanged();
      break label132;
    }
  }
  
  private void a(BuddyListTroop.TroopDisChildTag paramTroopDisChildTag)
  {
    String str;
    if ((paramTroopDisChildTag.jdField_a_of_type_JavaLangObject instanceof DiscussionInfo))
    {
      paramTroopDisChildTag = (DiscussionInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject;
      str = paramTroopDisChildTag.uin;
    }
    for (paramTroopDisChildTag = paramTroopDisChildTag.discussionName;; paramTroopDisChildTag = paramTroopDisChildTag.getTroopDisplayName())
    {
      this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter$UIEvent.a(str, paramTroopDisChildTag);
      return;
      paramTroopDisChildTag = (TroopInfo)paramTroopDisChildTag.jdField_a_of_type_JavaLangObject;
      str = paramTroopDisChildTag.getTroopUin();
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
        QLog.d("QGroupListAdapter", 2, "DiscussionInfo hasRenamed:" + paramDiscussionInfo.hasRenamed() + " | memberNum:" + i + " | uin:" + paramDiscussionInfo.uin + "  discussionName:" + paramDiscussionInfo.discussionName);
      }
      if ((paramDiscussionInfo.lastMsgTime != 0L) || (AppSetting.d)) {
        paramTroopDisChildTag.g.setContentDescription(paramTroopDisChildTag.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      a(paramTroopDisChildTag, null);
      paramView.setOnClickListener(this);
      a(paramView, paramInt1 << 16 | paramInt2, paramTroopDisChildTag, this, paramDiscussionInfo);
      return;
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
        break label418;
      }
      localObject = paramTroopInfo.getTroopDisplayName();
      label88:
      localTextView.setText((CharSequence)localObject);
      if ((paramTroopInfo.hasSetTroopName()) || (paramTroopInfo.wMemberNumClient <= 0)) {
        break label427;
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramTroopInfo.wMemberNumClient) }));
      label144:
      if (QLog.isColorLevel()) {
        QLog.d("QGroupListAdapter", 2, "TroopInfo hasSetTroopName:" + paramTroopInfo.hasSetTroopName() + " | memberNum:" + paramTroopInfo.wMemberNumClient);
      }
      if ((paramTroopInfo.lastMsgTime == 0L) && ((paramTroopInfo.dwGroupFlagExt & 0x800) == 0L)) {
        break label481;
      }
      if (paramTroopInfo.dwAuthGroupType != 2L) {
        break label439;
      }
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
      label243:
      if (!paramTroopInfo.isTroopBlocked) {
        break label506;
      }
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!SimpleUIUtil.a()) {
        break label493;
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
      label418:
      localObject = paramTroopInfo.troopuin;
      break label88;
      label427:
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label144;
      label439:
      if (paramTroopInfo.dwAuthGroupType == 1L)
      {
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130844081);
        break label243;
      }
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label481:
      paramTroopDisChildTag.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label243;
      label493:
      paramTroopDisChildTag.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842669);
      break label274;
      label506:
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
  }
  
  private void c()
  {
    QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable localLoadTroopDiscussInfoSubRunnable = new QGroupExpandableListAdapter.LoadTroopDiscussInfoSubRunnable(this, null);
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    localLoadTroopDiscussInfoSubRunnable.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ThreadManager.post(localLoadTroopDiscussInfoSubRunnable, 8, null, true);
  }
  
  private void d()
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
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
      this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(0));
      if ((this.jdField_a_of_type_ComTencentWidgetExpandableListView instanceof PinnedHeaderExpandableListView))
      {
        localObject = (PinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentWidgetExpandableListView;
        if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject).setHeaderViewShouldShow(bool);
      }
      return;
    }
    i = 0;
    label374:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_JavaUtilList.get(i))) {
        break label423;
      }
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    }
    for (;;)
    {
      i += 1;
      break label374;
      break;
      label423:
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    notifyDataSetChanged();
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
    QLog.d("QGroupListAdapter", 2, "getChildView data:" + localObject + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
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
      QLog.d("QGroupListAdapter", 2, "getChildrenCount count:" + j + "  groupPosition:" + paramInt);
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
      QLog.d("QGroupListAdapter", 2, "getChildrenCount mGroups.size():" + this.jdField_a_of_type_JavaUtilList.size());
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
      ThreadManager.postImmediately(new QGroupExpandableListAdapter.4(this), null, false);
      return;
    }
    c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */