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
      paramView = this.a.getLayoutInflater().inflate(2131627369, null);
      localGatheredViewHolder = new UncommonlyUsedContactsActivity.GatheredViewHolder(this.a, null);
      localGatheredViewHolder.A = ((ImageView)paramView.findViewById(2131435219));
      localGatheredViewHolder.a = ((TextView)paramView.findViewById(16908308));
      localGatheredViewHolder.b = ((TextView)paramView.findViewById(2131434375));
      localGatheredViewHolder.c = ((TextView)paramView.findViewById(2131434144));
      localGatheredViewHolder.d = ((TextView)paramView.findViewById(2131445467));
      localGatheredViewHolder.e = ((ImageView)paramView.findViewById(2131430688));
      localGatheredViewHolder.e.setVisibility(8);
      paramView.setTag(localGatheredViewHolder);
    }
    Object localObject2 = (TextView)paramView.findViewById(2131445650);
    Object localObject3 = paramView.findViewById(2131444600);
    if (((UncommonlyUsedContactsActivity.ListItem)localObject1).a == 0)
    {
      ((View)localObject3).setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((UncommonlyUsedContactsActivity.ListItem)localObject1).c);
      if (AppSetting.e)
      {
        ((TextView)localObject2).setFocusable(true);
        ((TextView)localObject2).setContentDescription(((UncommonlyUsedContactsActivity.ListItem)localObject1).c);
      }
      localGatheredViewHolder.g = 0;
      localGatheredViewHolder.y = "";
      localGatheredViewHolder.f = paramInt;
    }
    else
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)localObject2).setVisibility(8);
      if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).b instanceof Friends))
      {
        localObject2 = (Friends)((UncommonlyUsedContactsActivity.ListItem)localObject1).b;
        localGatheredViewHolder.y = ((Friends)localObject2).uin;
        if (!TextUtils.isEmpty(((Friends)localObject2).remark))
        {
          localGatheredViewHolder.a.setText(((Friends)localObject2).remark);
          localGatheredViewHolder.b.setText(null);
          if (AppSetting.e) {
            localGatheredViewHolder.a.setContentDescription(((Friends)localObject2).remark);
          }
        }
        else if (!TextUtils.isEmpty(((Friends)localObject2).smartRemark))
        {
          if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
            localGatheredViewHolder.a.setText(((Friends)localObject2).name);
          } else {
            localGatheredViewHolder.a.setText(((Friends)localObject2).uin);
          }
          localObject1 = localGatheredViewHolder.b;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append(((Friends)localObject2).smartRemark);
          ((StringBuilder)localObject3).append(")");
          ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
          if (AppSetting.e)
          {
            localObject3 = localGatheredViewHolder.a;
            if (TextUtils.isEmpty(((Friends)localObject2).name)) {
              localObject1 = ((Friends)localObject2).uin;
            } else {
              localObject1 = ((Friends)localObject2).name;
            }
            ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
            localGatheredViewHolder.b.setContentDescription(((Friends)localObject2).smartRemark);
          }
        }
        else
        {
          if (!TextUtils.isEmpty(((Friends)localObject2).name)) {
            localGatheredViewHolder.a.setText(((Friends)localObject2).name);
          } else {
            localGatheredViewHolder.a.setText(((Friends)localObject2).uin);
          }
          localGatheredViewHolder.b.setText(null);
          if (AppSetting.e)
          {
            localObject3 = localGatheredViewHolder.a;
            if (TextUtils.isEmpty(((Friends)localObject2).name)) {
              localObject1 = ((Friends)localObject2).uin;
            } else {
              localObject1 = ((Friends)localObject2).name;
            }
            ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
          }
        }
        if (TextUtils.equals(HardCodeUtil.a(2131913117), ((Friends)localObject2).recommReason)) {
          ((Friends)localObject2).recommReason = HardCodeUtil.a(2131913121);
        }
        localGatheredViewHolder.d.setText(((Friends)localObject2).recommReason);
        if (((Friends)localObject2).age != 0) {
          localGatheredViewHolder.c.setText(String.valueOf(((Friends)localObject2).age));
        } else {
          localGatheredViewHolder.c.setText(null);
        }
        int i = ((Friends)localObject2).gender;
        if (i != 1)
        {
          if (i != 2)
          {
            localGatheredViewHolder.c.setBackgroundResource(2130847526);
            i = 0;
          }
          else
          {
            i = 2130841306;
            localGatheredViewHolder.c.setBackgroundResource(2130847524);
          }
        }
        else
        {
          i = 2130841311;
          localGatheredViewHolder.c.setBackgroundResource(2130847526);
        }
        localGatheredViewHolder.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if ((((Friends)localObject2).age == 0) && (i == 0)) {
          localGatheredViewHolder.c.setVisibility(8);
        } else {
          localGatheredViewHolder.c.setVisibility(0);
        }
        if (AppSetting.e)
        {
          localObject3 = localGatheredViewHolder.c;
          if (i == 0)
          {
            localObject1 = String.valueOf(((Friends)localObject2).age);
          }
          else
          {
            if (((Friends)localObject2).gender == 1)
            {
              localObject1 = new StringBuilder();
              i = 2131913118;
            }
            else
            {
              localObject1 = new StringBuilder();
              i = 2131913123;
            }
            ((StringBuilder)localObject1).append(HardCodeUtil.a(i));
            ((StringBuilder)localObject1).append(((Friends)localObject2).age);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          ((TextView)localObject3).setContentDescription((CharSequence)localObject1);
          localGatheredViewHolder.d.setContentDescription(((Friends)localObject2).recommReason);
        }
        localGatheredViewHolder.A.setImageBitmap(a(1, ((Friends)localObject2).uin));
      }
      else if ((((UncommonlyUsedContactsActivity.ListItem)localObject1).b instanceof PhoneContact))
      {
        localObject1 = (PhoneContact)((UncommonlyUsedContactsActivity.ListItem)localObject1).b;
        localGatheredViewHolder.y = ((PhoneContact)localObject1).mobileCode;
        localGatheredViewHolder.z = 11;
        localGatheredViewHolder.a.setText(((PhoneContact)localObject1).name);
        localGatheredViewHolder.b.setText(null);
        localGatheredViewHolder.d.setText(HardCodeUtil.a(2131913122));
        if (AppSetting.e)
        {
          localGatheredViewHolder.a.setContentDescription(((PhoneContact)localObject1).name);
          localGatheredViewHolder.d.setContentDescription(HardCodeUtil.a(2131913120));
        }
        localGatheredViewHolder.c.setVisibility(8);
        localGatheredViewHolder.A.setImageBitmap(a(localGatheredViewHolder.y, 11, (byte)0));
      }
      localGatheredViewHolder.f = paramInt;
      localGatheredViewHolder.g = 1;
      paramView.setOnClickListener(this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.GatheredGrpListAdapter
 * JD-Core Version:    0.7.0.1
 */