package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.GroupTag;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class TroopDiscussionMemSelectAdapter
  extends TroopListBaseAdapter
  implements ExpandableListView.OnGroupClickListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public TroopDiscussionMemSelectAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopDiscussionMemSelectAdapter.1(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new TroopDiscussionMemSelectAdapter.2(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {}
    for (int i = 0; this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i); i = paramGroupTag.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a(BuddyListAdapter.GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    String str;
    int i;
    StringBuilder localStringBuilder;
    if (paramGroupTag != null)
    {
      str = "";
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {}
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
        localStringBuilder = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
        if (AppSetting.d)
        {
          if (localStringBuilder != null) {
            break label356;
          }
          localStringBuilder = new StringBuilder(24);
        }
        break;
      }
    }
    for (;;)
    {
      localStringBuilder.append(str + " 分组");
      paramGroupTag.jdField_a_of_type_Int = paramInt;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramGroupTag.b.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(String.valueOf(i));
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      return;
      str = HardCodeUtil.a(2131715146);
      i = this.jdField_b_of_type_JavaUtilList.size();
      break;
      str = HardCodeUtil.a(2131715150);
      i = this.jdField_c_of_type_JavaUtilList.size();
      break;
      str = HardCodeUtil.a(2131715147);
      i = this.d.size();
      break;
      str = HardCodeUtil.a(2131715148);
      i = this.e.size();
      break;
      str = HardCodeUtil.a(2131715149);
      i = this.f.size();
      break;
      str = HardCodeUtil.a(2131715151);
      i = this.g.size();
      break;
      label356:
      localStringBuilder.delete(0, localStringBuilder.length());
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
        break label172;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
      paramView = (BuddyListAdapter.GroupTag)paramView.getTag();
      break;
      label172:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167117);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    TroopListBaseAdapter.ItemInfo localItemInfo;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localItemInfo = a(paramInt1, paramInt2);
      if ((localItemInfo == null) || (localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity == null)) {
        break label573;
      }
      if (!(localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof TroopInfo)) {
        break label363;
      }
      localTroopInfo = (TroopInfo)localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_c_of_type_Int = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
        break label340;
      }
      localObject = localTroopInfo.getTroopDisplayName();
      paramView.jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
      paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
      paramView.jdField_a_of_type_Int = localItemInfo.jdField_a_of_type_Int;
      if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
        break label350;
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    label340:
    label350:
    label363:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563005, this.jdField_a_of_type_ComTencentWidgetExpandableListView, false);
          paramView = new TroopDiscussionMemSelectAdapter.TroopViewHolder(this);
          paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366520));
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131366546));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379987));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379973));
          paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131363027));
          paramViewGroup.setTag(paramView);
          break;
          localObject = localTroopInfo.troopuin;
          continue;
          paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof DiscussionInfo))
        {
          localObject = (DiscussionInfo)localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
          paramView.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject).uin;
          paramView.jdField_c_of_type_Int = 101;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject));
          if (!((DiscussionInfo)localObject).hasRenamed())
          {
            paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramView.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionManager.a(((DiscussionInfo)localObject).uin)) }));
          }
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          a(paramView, null);
          paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject);
          paramView.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
          paramView.jdField_a_of_type_Int = localItemInfo.jdField_a_of_type_Int;
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView data:" + localItemInfo.jdField_a_of_type_ComTencentMobileqqPersistenceEntity + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label573:
    QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
    return paramViewGroup;
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
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false)) {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return paramView;
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167117);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131559024;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof BuddyListAdapter.GroupTag)) {
      a((BuddyListAdapter.GroupTag)paramExpandableListView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionMemSelectAdapter
 * JD-Core Version:    0.7.0.1
 */