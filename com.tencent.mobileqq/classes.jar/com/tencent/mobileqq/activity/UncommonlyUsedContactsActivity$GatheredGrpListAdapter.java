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
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localGatheredViewHolder = (UncommonlyUsedContactsActivity.GatheredViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.a.getLayoutInflater().inflate(2131561028, null);
      localGatheredViewHolder = new UncommonlyUsedContactsActivity.GatheredViewHolder(this.a, null);
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367802));
      localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367601));
      localGatheredViewHolder.d = ((TextView)paramView.findViewById(2131377095));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364613));
      localGatheredViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.setTag(localGatheredViewHolder);
    }
    Object localObject2 = (TextView)paramView.findViewById(2131377263);
    Object localObject3 = paramView.findViewById(2131376384);
    if (((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_Int == 0)
    {
      ((View)localObject3).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      if (AppSetting.d)
      {
        ((TextView)localObject2).setFocusable(true);
        ((TextView)localObject2).setContentDescription(((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString);
      }
      localGatheredViewHolder.jdField_b_of_type_Int = 0;
      localGatheredViewHolder.jdField_a_of_type_JavaLangString = "";
      localGatheredViewHolder.jdField_a_of_type_Int = paramInt;
    }
    else
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)localObject2).setVisibility(8);
      if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
      {
        localObject2 = (Friends)((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localGatheredViewHolder.jdField_a_of_type_JavaLangString = ((Friends)localObject2).uin;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark))
        {
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject2).remark);
          localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
          if (AppSetting.d) {
            localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject2).remark);
          }
        }
        else if (!TextUtils.isEmpty(((Friends)localObject2).smartRemark))
        {
          if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
            localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject2).name);
          } else {
            localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject2).uin);
          }
          localObject1 = localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(((Friends)localObject2).smartRemark);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
          if (AppSetting.d)
          {
            localObject3 = localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(((Friends)localObject2).name)) {
              localObject1 = ((Friends)localObject2).uin;
            } else {
              localObject1 = ((Friends)localObject2).name;
            }
            ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
            localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(((Friends)localObject2).smartRemark);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
            localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject2).name);
          } else {
            localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((Friends)localObject2).uin);
          }
          localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
          if (AppSetting.d)
          {
            localObject3 = localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView;
            if (TextUtils.isEmpty(((Friends)localObject2).name)) {
              localObject1 = ((Friends)localObject2).uin;
            } else {
              localObject1 = ((Friends)localObject2).name;
            }
            ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
          }
        }
        if (TextUtils.equals(HardCodeUtil.a(2131715649), ((Friends)localObject2).recommReason)) {
          ((Friends)localObject2).recommReason = HardCodeUtil.a(2131715653);
        }
        localGatheredViewHolder.d.setText(((Friends)localObject2).recommReason);
        if (((Friends)localObject2).age != 0) {
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(((Friends)localObject2).age));
        } else {
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(null);
        }
        int i = ((Friends)localObject2).gender;
        if (i != 1)
        {
          if (i != 2)
          {
            localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846056);
            i = 0;
          }
          else
          {
            i = 2130840540;
            localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846054);
          }
        }
        else
        {
          i = 2130840545;
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130846056);
        }
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if ((((Friends)localObject2).age == 0) && (i == 0)) {
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        } else {
          localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (AppSetting.d)
        {
          localObject3 = localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView;
          if (i == 0)
          {
            localObject1 = String.valueOf(((Friends)localObject2).age);
          }
          else
          {
            if (((Friends)localObject2).gender == 1)
            {
              localObject1 = new StringBuilder();
              i = 2131715650;
            }
            else
            {
              localObject1 = new StringBuilder();
              i = 2131715655;
            }
            ((StringBuilder)localObject1).append(HardCodeUtil.a(i));
            ((StringBuilder)localObject1).append(((Friends)localObject2).age);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
          localGatheredViewHolder.d.setContentDescription(((Friends)localObject2).recommReason);
        }
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((Friends)localObject2).uin));
      }
      else if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact))
      {
        localObject1 = (PhoneContact)((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
        localGatheredViewHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).mobileCode;
        localGatheredViewHolder.jdField_c_of_type_Int = 11;
        localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localGatheredViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(null);
        localGatheredViewHolder.d.setText(HardCodeUtil.a(2131715654));
        if (AppSetting.d)
        {
          localGatheredViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(((PhoneContact)localObject1).name);
          localGatheredViewHolder.d.setContentDescription(HardCodeUtil.a(2131715652));
        }
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        localGatheredViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(localGatheredViewHolder.jdField_a_of_type_JavaLangString, 11, (byte)0));
      }
      localGatheredViewHolder.jdField_a_of_type_Int = paramInt;
      localGatheredViewHolder.jdField_b_of_type_Int = 1;
      paramView.setOnClickListener(this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.GatheredGrpListAdapter
 * JD-Core Version:    0.7.0.1
 */