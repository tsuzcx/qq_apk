package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

class UncommonlyUsedContactsActivity$GatheredGrpListAdapter
  extends FacePreloadBaseAdapter
{
  public UncommonlyUsedContactsActivity$GatheredGrpListAdapter(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.a != null) && (paramInt >= 0) && (paramInt < this.a.a.size())) {
      return this.a.a.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (UncommonlyUsedContactsActivity.ListItem)getItem(paramInt);
    UncommonlyUsedContactsActivity.GatheredViewHolder localGatheredViewHolder;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localGatheredViewHolder = (UncommonlyUsedContactsActivity.GatheredViewHolder)paramView.getTag();
      localView = paramView;
    }
    Object localObject2;
    for (;;)
    {
      paramView = (TextView)localView.findViewById(2131377837);
      localObject2 = localView.findViewById(2131376894);
      if (((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_Int != 0) {
        break;
      }
      ((View)localObject2).setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.d)
      {
        paramView.setFocusable(true);
        paramView.setContentDescription(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      }
      localGatheredViewHolder.jdField_b_of_type_Int = 0;
      localGatheredViewHolder.jdField_a_of_type_JavaLangString = "";
      localGatheredViewHolder.jdField_a_of_type_Int = paramInt;
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = this.a.getLayoutInflater().inflate(2131561165, null);
      localGatheredViewHolder = new UncommonlyUsedContactsActivity.GatheredViewHolder(this.a, null);
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(16908308));
      localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368050));
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367834));
      localGatheredViewHolder.d = ((TextView)localView.findViewById(2131377655));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364726));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localView.setTag(localGatheredViewHolder);
    }
    ((View)localObject2).setVisibility(0);
    paramView.setVisibility(8);
    label373:
    int i;
    if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localObject1 = (Friends)((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      localGatheredViewHolder.jdField_a_of_type_JavaLangString = ((Friends)localObject1).uin;
      label513:
      label540:
      if (!TextUtils.isEmpty(((Friends)localObject1).remark))
      {
        localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).remark);
        localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (AppSetting.d) {
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).remark);
        }
        if (TextUtils.equals(HardCodeUtil.a(2131715725), ((Friends)localObject1).recommReason)) {
          ((Friends)localObject1).recommReason = HardCodeUtil.a(2131715729);
        }
        localGatheredViewHolder.d.setText(((Friends)localObject1).recommReason);
        if (((Friends)localObject1).age == 0) {
          break label846;
        }
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject1).age));
        label436:
        switch (((Friends)localObject1).gender)
        {
        default: 
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846180);
          i = 0;
          label477:
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if ((((Friends)localObject1).age == 0) && (i == 0))
          {
            localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.d)
            {
              localObject2 = localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView;
              if (i != 0) {
                break label904;
              }
              paramView = String.valueOf(((Friends)localObject1).age);
              ((TextView)localObject2).setContentDescription(paramView);
              localGatheredViewHolder.d.setContentDescription(((Friends)localObject1).recommReason);
            }
            localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject1).uin));
          }
          break;
        }
      }
    }
    for (;;)
    {
      localGatheredViewHolder.jdField_a_of_type_Int = paramInt;
      localGatheredViewHolder.jdField_b_of_type_Int = 1;
      localView.setOnClickListener(this.a);
      break;
      if (!TextUtils.isEmpty(((Friends)localObject1).smartRemark))
      {
        if (!TextUtils.isEmpty(((Friends)localObject1).name))
        {
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
          label636:
          localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText("(" + ((Friends)localObject1).smartRemark + ")");
          if (!AppSetting.d) {
            break label373;
          }
          localObject2 = localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
            break label740;
          }
        }
        label740:
        for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
        {
          ((TextView)localObject2).setContentDescription(paramView);
          localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject1).smartRemark);
          break;
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
          break label636;
        }
      }
      if (!TextUtils.isEmpty(((Friends)localObject1).name))
      {
        localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).name);
        label773:
        localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        if (!AppSetting.d) {
          break label373;
        }
        localObject2 = localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(((Friends)localObject1).name)) {
          break label837;
        }
      }
      label837:
      for (paramView = ((Friends)localObject1).uin;; paramView = ((Friends)localObject1).name)
      {
        ((TextView)localObject2).setContentDescription(paramView);
        break;
        localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject1).uin);
        break label773;
      }
      label846:
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(null);
      break label436;
      i = 2130840670;
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846180);
      break label477;
      i = 2130840665;
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846178);
      break label477;
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label513;
      label904:
      if (((Friends)localObject1).gender == 1)
      {
        paramView = HardCodeUtil.a(2131715726) + ((Friends)localObject1).age;
        break label540;
      }
      paramView = HardCodeUtil.a(2131715731) + ((Friends)localObject1).age;
      break label540;
      if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        paramView = (PhoneContact)((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localGatheredViewHolder.jdField_a_of_type_JavaLangString = paramView.mobileCode;
        localGatheredViewHolder.jdField_c_of_type_Int = 11;
        localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.name);
        localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localGatheredViewHolder.d.setText(HardCodeUtil.a(2131715730));
        if (AppSetting.d)
        {
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView.name);
          localGatheredViewHolder.d.setContentDescription(HardCodeUtil.a(2131715728));
        }
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localGatheredViewHolder.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.GatheredGrpListAdapter
 * JD-Core Version:    0.7.0.1
 */