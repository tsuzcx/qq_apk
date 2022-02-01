package com.tencent.mobileqq.activity.selectmember;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.gamecenter.util.QQGameTroopManager;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TroopMemberListInnerFrame$TroopMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public TroopMemberListInnerFrame$TroopMemberListAdapter(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559435;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.a.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label65;
      }
      if (!this.a.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.a.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label65:
      i = -1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)this.a.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + i) {}
    return i;
  }
  
  public int getCount()
  {
    if ((this.a.jdField_a_of_type_ArrayOfInt == null) || (this.a.jdField_a_of_type_JavaUtilMap == null)) {}
    while (this.a.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.a.jdField_a_of_type_ArrayOfInt[(this.a.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[(this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562998, paramViewGroup, false);
      paramView = new TroopMemberListInnerFrame.ViewHolder(this.a, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377244));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380419));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364726));
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      paramView.b = ((TextView)localView.findViewById(2131372115));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131380575);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380492));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131380623));
      paramView.d = ((TextView)localView.findViewById(2131380497));
    }
    for (;;)
    {
      TroopMemberListInnerFrame.ViewHolder localViewHolder = (TroopMemberListInnerFrame.ViewHolder)localView.getTag();
      TroopMemberInfo localTroopMemberInfo;
      String str;
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localTroopMemberInfo = (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localTroopMemberInfo.memberuin))
        {
          localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
          localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localTroopMemberInfo.memberuin));
          str = ContactUtils.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 21) {
            break label814;
          }
          localObject = null;
          if ((TroopMemberListInnerFrame.a(this.a) == null) || (!TroopMemberListInnerFrame.a(this.a).isTroopOwner(localTroopMemberInfo.memberuin)) || (this.a.jdField_c_of_type_AndroidWidgetTextView == null) || (this.a.jdField_c_of_type_AndroidWidgetTextView.getTag() == null)) {
            break label710;
          }
          paramView = new SpannableString("[tag]" + " " + str);
          paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.jdField_c_of_type_AndroidWidgetTextView.getTag()), 0, "[tag]".length(), 18);
          label474:
          localViewHolder.b.setText(paramView);
          label483:
          localViewHolder.jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin;
          if (localViewHolder.jdField_a_of_type_AndroidViewView != null)
          {
            if (!RobotUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app, localTroopMemberInfo.memberuin)) {
              break label845;
            }
            localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          label531:
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localTroopMemberInfo.memberuin))) {
            break label858;
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          label574:
          if ((!AppSetting.d) || (!localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
            break label902;
          }
          if (!localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label870;
          }
          localView.setContentDescription(str + HardCodeUtil.a(2131715404));
          label631:
          localView.setOnClickListener(this.a);
          if (QQGameTroopManager.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity)) {
            QQGameTroopManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, localTroopMemberInfo, localViewHolder.jdField_c_of_type_AndroidWidgetTextView, localViewHolder.jdField_a_of_type_AndroidWidgetImageView, localViewHolder.d);
          }
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label710:
        paramView = localObject;
        if (this.a.b == null) {
          break label474;
        }
        paramView = localObject;
        if (this.a.b.getTag() == null) {
          break label474;
        }
        paramView = new SpannableString("[tag]" + " " + str);
        paramView.setSpan(new ImageSpan(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (Bitmap)this.a.b.getTag()), 0, "[tag]".length(), 18);
        break label474;
        label814:
        localViewHolder.b.setText(ContactUtils.g(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
        break label483;
        label845:
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        break label531;
        label858:
        localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label574;
        label870:
        localView.setContentDescription(str + HardCodeUtil.a(2131715428));
        break label631;
        label902:
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 14) || (localViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label631;
        }
        localView.setContentDescription(str + HardCodeUtil.a(2131715417));
        break label631;
        localViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131691884), new Object[] { paramView.toLowerCase() }));
      }
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */