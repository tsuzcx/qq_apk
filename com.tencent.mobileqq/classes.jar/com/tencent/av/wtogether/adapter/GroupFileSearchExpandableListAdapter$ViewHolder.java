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
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout = ((ChildPressEffectRelativeLayout)paramView.findViewById(2131380055));
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131380060));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramView.findViewById(2131380061));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380058));
    this.b = ((TextView)paramView.findViewById(2131380067));
    this.b.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366932));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  public void a(TroopFileSearchItemData paramTroopFileSearchItemData, int paramInt, boolean paramBoolean)
  {
    label42:
    TroopFileInfo localTroopFileInfo;
    Object localObject1;
    label163:
    label174:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (!TextUtils.isEmpty(paramTroopFileSearchItemData.jdField_a_of_type_JavaLangString))
    {
      this.b.setText(paramTroopFileSearchItemData.jdField_a_of_type_JavaLangString);
      this.b.setVisibility(0);
      if (paramInt != 0) {
        break label554;
      }
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setTag(2131374302, paramTroopFileSearchItemData);
      localTroopFileInfo = paramTroopFileSearchItemData.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo;
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramTroopFileSearchItemData.jdField_a_of_type_Long + "", paramTroopFileSearchItemData.jdField_b_of_type_Long + "");
      if ((localObject1 == null) || (!ContactUtils.a(((TroopMemberInfo)localObject1).troopnick, paramTroopFileSearchItemData.jdField_c_of_type_Long + ""))) {
        break label567;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label572;
      }
      localObject1 = ((TroopMemberInfo)localObject1).troopnick;
      if (paramTroopFileSearchItemData.jdField_c_of_type_Long <= 0L) {
        break label715;
      }
      localObject2 = String.valueOf(paramTroopFileSearchItemData.jdField_c_of_type_Long);
      localObject3 = TroopFileSearchManager.a();
      localObject4 = ((TroopFileSearchManager)localObject3).a((String)localObject2);
      if (localObject4 == null) {
        break label578;
      }
      paramInt = TroopFileSearchManager.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject1, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject4).jdField_c_of_type_JavaLangString, ((ContactSearchableFriend)localObject4).d, paramTroopFileSearchItemData.d, ((ContactSearchableFriend)localObject4).jdField_a_of_type_JavaLangString, ((ContactSearchableFriend)localObject4).jdField_b_of_type_JavaLangString);
      localObject1 = TroopFileSearchManager.a((String)localObject1, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, paramTroopFileSearchItemData.d, paramInt);
      label268:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label631;
      }
      if (!TextUtils.isEmpty(paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString)) {
        break label622;
      }
      localObject1 = paramTroopFileSearchItemData.d;
      label292:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label304:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      for (;;)
      {
        if ((paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList != null) && (paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject3 = (String)paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
          if ((TextUtils.isEmpty(localTroopFileInfo.jdField_c_of_type_JavaLangString)) || (!localTroopFileInfo.jdField_c_of_type_JavaLangString.toLowerCase().contains(((String)localObject3).toLowerCase()))) {}
        }
        for (;;)
        {
          GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, localTroopFileInfo, (String)localObject3);
          localObject3 = localTroopFileInfo.a();
          localObject4 = localTroopFileInfo.m;
          GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, paramBoolean, localTroopFileInfo, this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramTroopFileSearchItemData);
          paramTroopFileSearchItemData = GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter, (String)localObject4, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1, (String)localObject3);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopFileSearchItemData);
          paramTroopFileSearchItemData = new StringBuilder();
          paramTroopFileSearchItemData.append(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getText()).append(",").append((String)localObject3).append(",").append("来自").append(",").append((String)localObject1).append(",").append((String)localObject4);
          this.jdField_a_of_type_AndroidViewView.setContentDescription(paramTroopFileSearchItemData.toString());
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localTroopFileInfo.a.equals(GroupFileSearchExpandableListAdapter.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter)));
          return;
          this.b.setVisibility(8);
          break;
          label554:
          this.b.setTag(2131374302, paramTroopFileSearchItemData);
          break label42;
          label567:
          paramInt = 0;
          break label163;
          label572:
          localObject1 = null;
          break label174;
          label578:
          paramInt = TroopFileSearchManager.a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject1, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, null, null, paramTroopFileSearchItemData.d, null, null);
          localObject1 = TroopFileSearchManager.a((String)localObject1, paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString, paramTroopFileSearchItemData.d, paramInt);
          break label268;
          label622:
          localObject1 = paramTroopFileSearchItemData.jdField_c_of_type_JavaLangString;
          break label292;
          label631:
          if ((paramInt == 1) || (paramInt == 4) || (paramInt == 7))
          {
            localObject3 = this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label304;
          }
          if ((paramInt != 5) && (paramInt != 6) && (paramInt != 2) && (paramInt != 3)) {
            break label799;
          }
          localObject3 = ((TroopFileSearchManager)localObject3).a(this.jdField_a_of_type_ComTencentAvWtogetherAdapterGroupFileSearchExpandableListAdapter.jdField_b_of_type_JavaLangString, (String)localObject2);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label304;
          label715:
          if (paramInt != 0) {}
          for (;;)
          {
            if ((paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList == null) || (paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label792;
            }
            localObject2 = (String)paramTroopFileSearchItemData.jdField_a_of_type_JavaUtilArrayList.get(0);
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).toLowerCase().contains(((String)localObject2).toLowerCase()))) {
              break label792;
            }
            break;
            localObject1 = paramTroopFileSearchItemData.jdField_b_of_type_JavaLangString;
          }
          localObject3 = "";
        }
        label792:
        localObject2 = "";
      }
      label799:
      localObject2 = localObject1;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */