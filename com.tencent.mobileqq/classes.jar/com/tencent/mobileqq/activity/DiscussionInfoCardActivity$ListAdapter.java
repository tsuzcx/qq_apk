package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class DiscussionInfoCardActivity$ListAdapter
  extends BaseAdapter
{
  private FriendsManager b = null;
  
  public DiscussionInfoCardActivity$ListAdapter(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.b = ((FriendsManager)paramDiscussionInfoCardActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public int getCount()
  {
    if (DiscussionInfoCardActivity.g(this.a) == null) {
      return 1;
    }
    return 1 + DiscussionInfoCardActivity.g(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((DiscussionInfoCardActivity.g(this.a) != null) && (paramInt < DiscussionInfoCardActivity.g(this.a).size())) {
      return DiscussionInfoCardActivity.g(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131624461, null);
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.a = ((ImageView)localView.findViewById(2131435219));
      localViewHolder.b = ((TextView)localView.findViewById(2131439121));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.setFocusable(false);
    TextView localTextView = localViewHolder.b;
    ImageView localImageView = localViewHolder.a;
    Object localObject1;
    if (paramInt == getCount() - 1)
    {
      localObject1 = this.a.getString(2131891027);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextColor(this.a.getResources().getColor(2131168002));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839322);
      localImageView.setTag(localObject1);
      if ((this.a.h.isDiscussHrMeeting()) && (QAVHrMeeting.a(this.a.h.mSelfRight))) {
        localImageView.setEnabled(false);
      } else {
        localImageView.setEnabled(true);
      }
    }
    else
    {
      int i = getCount();
      Object localObject2 = "";
      if (paramInt > i - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130846392);
        localTextView.setTextColor(this.a.getResources().getColor(2131167993));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.g(this.a).get(paramInt)).memberUin;
        localViewHolder.c = str;
        localObject1 = ContactUtils.a(this.a.app, DiscussionInfoCardActivity.c(this.a), str);
        if (TextUtils.isEmpty(str))
        {
          if (localObject1 == null) {
            localObject1 = localObject2;
          }
          localTextView.setText((CharSequence)localObject1);
          localImageView.setImageDrawable(ImageUtil.j());
        }
        else
        {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.b;
            if (localObject2 != null)
            {
              localObject2 = ((FriendsManager)localObject2).m(str);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend())) {
                localObject1 = ContactUtils.a(this.a.app, str);
              }
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localTextView.setText((CharSequence)localObject2);
          this.a.a(localViewHolder, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131446817, localObject2);
        }
      }
    }
    if (AppSetting.e) {
      ViewCompat.setImportantForAccessibility(localImageView, 2);
    }
    localImageView.setOnClickListener(this.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */