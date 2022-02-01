package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter;
import com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.ItemInfo;
import com.tencent.mobileqq.adapter.FacePreloadHolder.ViewHolder;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class ForwardTroopListAdapter
  extends TroopListBaseAdapter
  implements ExpandableListView.OnGroupClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ForwardTroopListAdapter.1(this);
  private ForwardTroopListAdapter.IForwardTroopListAdapterCallback jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback;
  private View.OnClickListener b;
  
  public ForwardTroopListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, ForwardTroopListAdapter.IForwardTroopListAdapterCallback paramIForwardTroopListAdapterCallback)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ForwardTroopListAdapter.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback = paramIForwardTroopListAdapterCallback;
  }
  
  private void a(GroupTag paramGroupTag)
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      i = 0;
    } else {
      i = paramGroupTag.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.jdField_a_of_type_JavaUtilHashSet.remove(this.jdField_a_of_type_JavaUtilList.get(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i == 13)
                  {
                    str = HardCodeUtil.a(2131704943);
                    i = this.g.size();
                    break label213;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131704949);
                  i = this.f.size();
                  break label213;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131704947);
                i = this.d.size();
                break label213;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131704942);
              i = this.c.size();
              break label213;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131704953);
            i = this.e.size();
            break label213;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131704946);
          i = this.jdField_b_of_type_JavaUtilList.size();
          break label213;
        }
      }
      String str = "";
      int i = 0;
      label213:
      StringBuilder localStringBuilder1 = paramGroupTag.jdField_a_of_type_JavaLangStringBuilder;
      if (AppSetting.d)
      {
        if (localStringBuilder1 == null) {
          localStringBuilder1 = new StringBuilder(24);
        } else {
          localStringBuilder1.delete(0, localStringBuilder1.length());
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(" 分组");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      paramGroupTag.jdField_a_of_type_Int = paramInt;
      paramGroupTag.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(str);
      paramGroupTag.b.setVisibility(8);
      paramGroupTag.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramGroupTag.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setText(String.valueOf(i));
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).b = ((SingleLineTextView)paramView.findViewById(2131379843));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      ((GroupTag)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false))
    {
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ForwardRecentItemView(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup = new FacePreloadHolder.ViewHolder();
      paramView.setTag(paramViewGroup);
    }
    else
    {
      localObject1 = (ForwardRecentItemView)paramView;
      paramViewGroup = (FacePreloadHolder.ViewHolder)paramView.getTag();
      paramView = (View)localObject1;
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqSelectmemberResultRecord;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ResultRecord();
    }
    localObject2 = a(paramInt1, paramInt2);
    if ((localObject2 != null) && (((TroopListBaseAdapter.ItemInfo)localObject2).a != null))
    {
      if ((((TroopListBaseAdapter.ItemInfo)localObject2).a instanceof TroopInfo))
      {
        TroopInfo localTroopInfo = (TroopInfo)((TroopListBaseAdapter.ItemInfo)localObject2).a;
        paramViewGroup.a = localTroopInfo.troopuin;
        paramViewGroup.jdField_c_of_type_Int = 4;
        if (!TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
          localObject2 = localTroopInfo.getTroopDisplayName();
        } else {
          localObject2 = localTroopInfo.troopuin;
        }
        ((ResultRecord)localObject1).init(localTroopInfo.troopuin, (String)localObject2, 1, "", "");
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback.a(localTroopInfo.troopuin, 1);
        paramView.a((String)localObject2, String.valueOf(localTroopInfo.wMemberNumClient), null, (ResultRecord)localObject1, true, paramBoolean);
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return paramView;
      }
      if ((((TroopListBaseAdapter.ItemInfo)localObject2).a instanceof DiscussionInfo))
      {
        localObject2 = (DiscussionInfo)((TroopListBaseAdapter.ItemInfo)localObject2).a;
        paramViewGroup.a = ((DiscussionInfo)localObject2).uin;
        paramViewGroup.jdField_c_of_type_Int = 101;
        ((ResultRecord)localObject1).init(((DiscussionInfo)localObject2).uin, ((DiscussionInfo)localObject2).discussionName, 3000, "", "");
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback.a(((DiscussionInfo)localObject2).uin, 3000);
        paramInt1 = ((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject2).uin);
        paramView.a(((DiscussionInfo)localObject2).discussionName, String.valueOf(paramInt1), null, (ResultRecord)localObject1, true, paramBoolean);
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return paramView;
      }
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("getChildView data:");
        paramViewGroup.append(((TroopListBaseAdapter.ItemInfo)localObject2).a);
        paramViewGroup.append(" groupPosition:");
        paramViewGroup.append(paramInt1);
        paramViewGroup.append(" childPosition:");
        paramViewGroup.append(paramInt2);
        QLog.d("ContactsTroopAdapter", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getChildView itemInfo data null");
      paramViewGroup.append(paramInt1);
      paramViewGroup.append(" childPosition:");
      paramViewGroup.append(paramInt2);
      QLog.d("ContactsTroopAdapter", 2, paramViewGroup.toString());
    }
    return paramView;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558918, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131367855));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setDefaultTextColor(-8355712);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131369353));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView = ((SimpleTextView)paramView.findViewById(2131365107));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setDefaultTextColor(1711276032);
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131369450));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131379843));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_Int));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendSimpleTextView.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558918;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      a((GroupTag)paramExpandableListView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListAdapter
 * JD-Core Version:    0.7.0.1
 */