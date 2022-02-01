package com.tencent.mobileqq.activity.specialcare;

import QQService.EVIPSPEC;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

class SpecailCareListActivity$SpecailCareListAdapter
  extends BaseAdapter
{
  View a;
  LayoutInflater b;
  
  public SpecailCareListActivity$SpecailCareListAdapter(SpecailCareListActivity paramSpecailCareListActivity)
  {
    this.b = ((LayoutInflater)paramSpecailCareListActivity.getSystemService("layout_inflater"));
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public int getCount()
  {
    int i = this.c.u.size();
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.c.u.size()) {
      return this.c.u.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.c.u.size() == 0) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (getItemViewType(paramInt) == 1)
    {
      if (paramView == null)
      {
        localObject1 = this.b.inflate(2131627849, paramViewGroup, false);
        paramView = ((View)localObject1).getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.c.h.getHeight();
          paramView.width = this.c.h.getWidth();
        }
        else
        {
          paramView = new ViewGroup.LayoutParams(this.c.h.getWidth(), this.c.h.getHeight());
        }
        ((View)localObject1).setLayoutParams(paramView);
        paramView = (View)localObject1;
      }
      i = ((FriendsManager)this.c.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).u();
      localObject1 = (Button)paramView.findViewById(2131432494);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getView  friends count = ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("SpecialCare", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (TextView)paramView.findViewById(2131437200);
      localObject3 = (TextView)paramView.findViewById(2131437201);
      if (i <= 0)
      {
        ((TextView)localObject3).setVisibility(8);
        ((Button)localObject1).setVisibility(8);
        localObject3 = paramView;
      }
      else
      {
        ((TextView)localObject3).setVisibility(0);
        ((Button)localObject1).setVisibility(0);
        ((TextView)localObject2).setText(2131916741);
        ((Button)localObject1).setOnClickListener(this.c);
        localObject3 = paramView;
      }
    }
    for (;;)
    {
      break;
      if (paramView != null) {
        localObject1 = (SpecailCareListActivity.ViewHolder)paramView.getTag();
      } else {
        localObject1 = null;
      }
      if (localObject1 == null)
      {
        localObject1 = this.b.inflate(2131627853, paramViewGroup, false);
        localObject2 = new SpecailCareListActivity.ViewHolder();
        ((View)localObject1).setTag(localObject2);
        ((SpecailCareListActivity.ViewHolder)localObject2).b = ((ImageView)((View)localObject1).findViewById(2131435219));
        ((SpecailCareListActivity.ViewHolder)localObject2).c = ((TextView)((View)localObject1).findViewById(2131447063));
        ((SpecailCareListActivity.ViewHolder)localObject2).f = ((TextView)((View)localObject1).findViewById(2131448627));
        ((SpecailCareListActivity.ViewHolder)localObject2).d = ((TextView)((View)localObject1).findViewById(2131447065));
        ((SpecailCareListActivity.ViewHolder)localObject2).e = ((ImageView)((View)localObject1).findViewById(2131436608));
        ((SpecailCareListActivity.ViewHolder)localObject2).h = ((ImageView)((View)localObject1).findViewById(2131438753));
        ((SpecailCareListActivity.ViewHolder)localObject2).i = ((ImageView)((View)localObject1).findViewById(2131428776));
        ((SpecailCareListActivity.ViewHolder)localObject2).j = ((ImageView)((View)localObject1).findViewById(2131436594));
        ((SpecailCareListActivity.ViewHolder)localObject2).k = ((ImageView)((View)localObject1).findViewById(2131436520));
        ((SpecailCareListActivity.ViewHolder)localObject2).l = ((ImageView)((View)localObject1).findViewById(2131436522));
        ((SpecailCareListActivity.ViewHolder)localObject2).m = ((View)localObject1).findViewById(2131445462);
        ((SpecailCareListActivity.ViewHolder)localObject2).n = ((MutualMarkIconsView)((View)localObject1).findViewById(2131439085));
        ((SpecailCareListActivity.ViewHolder)localObject2).g = ((OnlineStatusView)((View)localObject1).findViewById(2131432679));
        ((SpecailCareListActivity.ViewHolder)localObject2).g.setViewStyle(2);
        ((SpecailCareListActivity.ViewHolder)localObject2).g.setTextSize(ViewUtils.dip2px(14.0F));
        ((View)localObject1).setOnClickListener(this.c);
      }
      else
      {
        localObject2 = localObject1;
        localObject1 = paramView;
      }
      if ((localObject1 instanceof FormItemRelativeLayout)) {
        if (paramInt == getCount() - 1)
        {
          ((FormItemRelativeLayout)localObject1).setBGType(3);
        }
        else
        {
          paramView = (FormItemRelativeLayout)localObject1;
          paramView.setNeedFocusBg(true);
          paramView.setBGType(2);
        }
      }
      Friends localFriends = (Friends)this.c.u.get(paramInt);
      ((SpecailCareListActivity.ViewHolder)localObject2).o = localFriends;
      ((SpecailCareListActivity.ViewHolder)localObject2).a = localFriends.uin;
      ((SpecailCareListActivity.ViewHolder)localObject2).h.setTag(localFriends.uin);
      ((SpecailCareListActivity.ViewHolder)localObject2).h.setOnClickListener(this.c);
      if (AppSetting.e) {
        ((SpecailCareListActivity.ViewHolder)localObject2).h.setContentDescription(HardCodeUtil.a(2131911641));
      }
      paramView = this.c.p.getBitmapFromCache(1, localFriends.uin, 0);
      if (paramView == null)
      {
        if (!this.c.p.isPausing()) {
          this.c.p.requestDecodeFace(localFriends.uin, 1, true);
        }
        ((SpecailCareListActivity.ViewHolder)localObject2).b.setBackgroundDrawable((BitmapDrawable)ImageUtil.m());
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).b.setBackgroundDrawable(new BitmapDrawable(paramView));
      }
      i = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
      paramView = (FriendListHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      switch (i)
      {
      case 5: 
      default: 
        localObject3 = paramView.getOfflineTipsConfig(localFriends.getLastLoginType());
        paramView = (View)localObject3;
        if (localObject3 == null) {
          paramView = this.c.getString(2131916781);
        }
        break;
      case 7: 
        paramView = this.c.getString(2131916777);
        break;
      case 6: 
        paramView = "";
        break;
      case 4: 
      case 8: 
        paramView = ContactUtils.a(localFriends.netTypeIconId);
        break;
      case 3: 
        paramView = this.c.getString(2131916783);
        break;
      case 2: 
        paramView = this.c.getString(2131916773);
        break;
      case 1: 
        paramView = this.c.getString(2131916771);
      }
      if ((i != 0) && (i != 6)) {
        i = 0;
      } else {
        i = 1;
      }
      if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.c.app, localFriends, ((SpecailCareListActivity.ViewHolder)localObject2).g))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).g.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).f.setVisibility(8);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).g.setVisibility(8);
        ((SpecailCareListActivity.ViewHolder)localObject2).f.setVisibility(0);
        localObject3 = ((SpecailCareListActivity.ViewHolder)localObject2).f;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[");
        ((StringBuilder)localObject4).append(paramView);
        ((StringBuilder)localObject4).append("]");
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
      }
      this.c.a(localFriends, (SpecailCareListActivity.ViewHolder)localObject2);
      ((SpecailCareListActivity.ViewHolder)localObject2).e.setVisibility(8);
      int j;
      if (i == 0) {
        j = localFriends.netTypeIconId;
      } else {
        j = 0;
      }
      boolean bool = SimpleUIUtil.e();
      if ((i == 0) && (!bool) && ((localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setTextColor(this.c.getResources().getColorStateList(2131168185));
      } else {
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setTextColor(this.c.getResources().getColorStateList(2131167993));
      }
      if ((!bool) && (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setCompoundDrawablePadding(this.c.c);
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130852711, 0);
      }
      else if ((!bool) && (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setCompoundDrawablePadding(this.c.c);
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130853452, 0);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      Object localObject4 = ContactUtils.a(localFriends);
      ((SpecailCareListActivity.ViewHolder)localObject2).c.setText((CharSequence)localObject4);
      ((SpecailCareListActivity.ViewHolder)localObject2).n.a(this.c.app, localFriends.uin, 4);
      localObject3 = this.c;
      int k = ((SpecailCareListActivity)localObject3).a((View)localObject1, (SpecailCareListActivity.ViewHolder)localObject2, ((SpecailCareListActivity)localObject3).z);
      localObject3 = new RelativeLayout.LayoutParams((int)(SpecailCareListActivity.o(this.c) * 50.0F), (int)(SpecailCareListActivity.p(this.c) * 50.0F));
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(1, 2131435219);
      localLayoutParams1.addRule(10);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(1, 2131435219);
      if (this.c.z)
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).h.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).m.setVisibility(4);
        ((SpecailCareListActivity.ViewHolder)localObject2).i.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject3).setMargins((int)(SpecailCareListActivity.q(this.c) * 46.0F), 0, (int)(SpecailCareListActivity.r(this.c) * 10.0F), 0);
        localLayoutParams1.setMargins(0, (int)(SpecailCareListActivity.s(this.c) * 22.0F), (int)(SpecailCareListActivity.t(this.c) * 23.0F + k), 0);
        localLayoutParams2.setMargins(0, (int)(SpecailCareListActivity.u(this.c) * 24.0F), 0, 0);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).h.setVisibility(8);
        ((SpecailCareListActivity.ViewHolder)localObject2).m.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).i.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject3).setMargins((int)(SpecailCareListActivity.v(this.c) * 12.0F), 0, (int)(SpecailCareListActivity.w(this.c) * 10.0F), 0);
        localLayoutParams1.setMargins(0, (int)(SpecailCareListActivity.x(this.c) * 10.0F), k, 0);
        localLayoutParams2.setMargins(0, (int)(SpecailCareListActivity.y(this.c) * 36.0F), 0, 0);
      }
      ((SpecailCareListActivity.ViewHolder)localObject2).b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((SpecailCareListActivity.ViewHolder)localObject2).c.setLayoutParams(localLayoutParams1);
      ((SpecailCareListActivity.ViewHolder)localObject2).m.setLayoutParams(localLayoutParams2);
      localObject3 = localObject1;
      if (AppSetting.e)
      {
        localObject3 = new StringBuilder(24);
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append(".");
        ((StringBuilder)localObject3).append(paramView);
        ((StringBuilder)localObject3).append(".");
        if ((localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
        {
          ((StringBuilder)localObject3).append("QQ会员");
          ((StringBuilder)localObject3).append(".");
        }
        ((StringBuilder)localObject3).append(((SpecailCareListActivity.ViewHolder)localObject2).d.getText());
        ((StringBuilder)localObject3).append(".");
        if (i == 0) {
          ((StringBuilder)localObject3).append(ContactUtils.b(j));
        }
        if (!TextUtils.isEmpty(((SpecailCareListActivity.ViewHolder)localObject2).n.h)) {
          ((StringBuilder)localObject3).append(((SpecailCareListActivity.ViewHolder)localObject2).n.h.toString());
        }
        ((View)localObject1).setContentDescription((CharSequence)localObject3);
        localObject3 = localObject1;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject3, paramViewGroup, getItemId(paramInt));
    return localObject3;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.SpecailCareListAdapter
 * JD-Core Version:    0.7.0.1
 */