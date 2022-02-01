package com.tencent.av.wtogether.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.av.wtogether.view.ChildPressEffectRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.UUID;

class GroupFileSearchExpandableListAdapter$ViewHolder
{
  public View a;
  public CheckBox a;
  public TextView a;
  public ChildPressEffectRelativeLayout a;
  public AsyncImageView a;
  public EllipsizingTextView a;
  public TextView b;
  
  public GroupFileSearchExpandableListAdapter$ViewHolder(GroupFileSearchExpandableListAdapter paramGroupFileSearchExpandableListAdapter, View paramView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout = ((ChildPressEffectRelativeLayout)paramView.findViewById(2013331475));
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2013331478));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramView.findViewById(2013331479));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2013331477));
    this.b = ((TextView)paramView.findViewById(2013331480));
    this.b.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2013331461));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  public void a(TroopFileSearchItemData paramTroopFileSearchItemData, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramTroopFileSearchItemData.jdField_a_of_type_JavaLangString))
    {
      this.b.setText(paramTroopFileSearchItemData.jdField_a_of_type_JavaLangString);
      this.b.setVisibility(0);
    }
    else
    {
      this.b.setVisibility(8);
    }
    if (paramInt == 0) {
      this.b.setVisibility(8);
    } else {
      this.b.setTag(2131373858, paramTroopFileSearchItemData);
    }
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setTag(2131373858, paramTroopFileSearchItemData);
    TroopFileInfo localTroopFileInfo = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.a.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramTroopFileSearchItemData.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramTroopFileSearchItemData.jdField_b_of_type_Long);
    ((StringBuilder)localObject3).append("");
    localObject1 = ((TroopManager)localObject1).b((String)localObject2, ((StringBuilder)localObject3).toString());
    if (localObject1 != null)
    {
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramTroopFileSearchItemData.jdField_c_of_type_Long);
      ((StringBuilder)localObject3).append("");
      if (ContactUtils.a((String)localObject2, ((StringBuilder)localObject3).toString()))
      {
        paramInt = 1;
        break label235;
      }
    }
    paramInt = 0;
    label235:
    if (paramInt != 0) {
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
    } else {
      localObject2 = null;
    }
    if (paramTroopFileSearchItemData.jdField_c_of_type_Long > 0L)
    {
      localObject3 = String.valueOf(paramTroopFileSearchItemData.jdField_c_of_type_Long);
      localObject4 = TroopFileSearchManager.a();
      localObject1 = ((TroopFileSearchManager)localObject4).a((String)localObject3);
      if (localObject1 != null)
      {
        paramInt = TroopFileSearchManager.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject2, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).d, paramTroopFileSearchItemData.d, ((ContactSearchableFriend)localObject1).jdField_a_of_type_JavaLangString, ((ContactSearchableFriend)localObject1).jdField_b_of_type_JavaLangString);
        localObject2 = TroopFileSearchManager.a((String)localObject2, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, paramTroopFileSearchItemData.d, paramInt);
      }
      else
      {
        paramInt = TroopFileSearchManager.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject2, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, null, null, paramTroopFileSearchItemData.d, null, null);
        localObject2 = TroopFileSearchManager.a((String)localObject2, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, paramTroopFileSearchItemData.d, paramInt);
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (TextUtils.isEmpty(paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString)) {
          localObject1 = paramTroopFileSearchItemData.d;
        } else {
          localObject1 = paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString;
        }
      }
      do
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label510;
        if ((paramInt == 1) || (paramInt == 4) || (paramInt == 7)) {
          break label501;
        }
        if ((paramInt == 5) || (paramInt == 6) || (paramInt == 2)) {
          break;
        }
        localObject1 = localObject2;
      } while (paramInt != 3);
      localObject1 = ((TroopFileSearchManager)localObject4).a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject3);
    }
    label501:
    for (localObject1 = this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString;; localObject1 = "") {
      label510:
      do
      {
        break label587;
        if (paramInt == 0) {
          localObject2 = paramTroopFileSearchItemData.jdField_b_of_type_JavaLangString;
        }
        if ((paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList == null) || (paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        localObject1 = (String)paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
      } while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).toLowerCase().contains(((String)localObject1).toLowerCase())));
    }
    label587:
    if ((paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList != null) && (paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject3 = (String)paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((!TextUtils.isEmpty(localTroopFileInfo.jdField_c_of_type_JavaLangString)) && (localTroopFileInfo.jdField_c_of_type_JavaLangString.toLowerCase().contains(((String)localObject3).toLowerCase()))) {}
    }
    else
    {
      localObject3 = "";
    }
    GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, localTroopFileInfo, (String)localObject3);
    localObject3 = localTroopFileInfo.a();
    Object localObject4 = localTroopFileInfo.m;
    GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, paramBoolean, localTroopFileInfo, this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramTroopFileSearchItemData);
    paramTroopFileSearchItemData = GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, (String)localObject4, (String)localObject1, this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject2, (String)localObject3);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopFileSearchItemData);
    paramTroopFileSearchItemData = new StringBuilder();
    paramTroopFileSearchItemData.append(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getText());
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject3);
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append("来自");
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject2);
    paramTroopFileSearchItemData.append(",");
    paramTroopFileSearchItemData.append((String)localObject4);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(paramTroopFileSearchItemData.toString());
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localTroopFileInfo.a.equals(GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */