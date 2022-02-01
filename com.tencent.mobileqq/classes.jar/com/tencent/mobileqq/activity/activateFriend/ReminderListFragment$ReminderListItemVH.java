package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.biz.ReminderListItemModel;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReminderListFragment$ReminderListItemVH
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  RelativeLayout a;
  RelativeLayout b;
  TextView c;
  TextView d;
  TextView e;
  ImageView f;
  ImageView g;
  FrameLayout h;
  
  public ReminderListFragment$ReminderListItemVH(ReminderListFragment paramReminderListFragment, View paramView)
  {
    super(paramView);
    this.a = ((RelativeLayout)paramView.findViewById(2131444610));
    this.b = ((RelativeLayout)paramView.findViewById(2131444609));
    this.b.setOnClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131444614));
    this.g = ((ImageView)paramView.findViewById(2131444611));
    this.c = ((TextView)paramView.findViewById(2131437302));
    this.d = ((TextView)paramView.findViewById(2131437300));
    this.f = ((ImageView)paramView.findViewById(2131444612));
    this.h = ((FrameLayout)paramView.findViewById(2131444613));
    this.h.setOnClickListener(this);
  }
  
  private void a(View paramView, AcsMsg paramAcsMsg)
  {
    if ((paramView instanceof FrameLayout))
    {
      paramView = ((FrameLayout)paramView).getChildAt(0);
      if ((paramView instanceof Button))
      {
        paramView = (Button)paramView;
        paramView.setTag(paramAcsMsg);
        paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
        paramAcsMsg = new Rect();
        this.f.getLocalVisibleRect(paramAcsMsg);
        paramView.rightMargin = paramAcsMsg.right;
        this.f.getGlobalVisibleRect(paramAcsMsg);
        paramView.topMargin = (paramAcsMsg.top - paramView.width);
      }
    }
  }
  
  public void a(ReminderListItemModel paramReminderListItemModel)
  {
    this.h.setTag(paramReminderListItemModel.a);
    this.c.setText(paramReminderListItemModel.a.title);
    this.b.setTag(paramReminderListItemModel.a.jump_url);
    Object localObject1 = paramReminderListItemModel.a.busi_icon;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.g.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.g.getWidth();
    localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
    if (localObject1 != null) {
      this.g.setImageDrawable((Drawable)localObject1);
    }
    String str = DateUtil.a(paramReminderListItemModel.a.notice_time * 1000L, "yyyy.MM.dd");
    localObject2 = DateUtil.a(paramReminderListItemModel.a.notice_time * 1000L, "HH:mm");
    localObject1 = localObject2;
    if (paramReminderListItemModel.c == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("　　　开启时提醒");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("　　　");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    this.d.setText((CharSequence)localObject1);
    localObject1 = this.e;
    if (!StringUtil.isEmpty(paramReminderListItemModel.b))
    {
      ((TextView)localObject1).setText(paramReminderListItemModel.b);
      ((TextView)localObject1).setVisibility(0);
      return;
    }
    ((TextView)localObject1).setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131444609)
    {
      if ((j == 2131444613) && (ReminderListFragment.b(this.i) != null))
      {
        a(ReminderListFragment.b(this.i).getContentView(), (AcsMsg)this.h.getTag());
        ReminderListFragment.b(this.i).showAtLocation(ReminderListFragment.e(this.i), 17, 0, 0);
      }
    }
    else if (!StringUtil.isEmpty((String)paramView.getTag()))
    {
      Intent localIntent = new Intent(this.i.getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)paramView.getTag());
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.i.startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.ReminderListItemVH
 * JD-Core Version:    0.7.0.1
 */