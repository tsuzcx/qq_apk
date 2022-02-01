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
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public SpecailCareListActivity$SpecailCareListAdapter(SpecailCareListActivity paramSpecailCareListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramSpecailCareListActivity.getSystemService("layout_inflater"));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size();
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.size() == 0) {
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
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561492, paramViewGroup, false);
        paramView = ((View)localObject1).getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
          paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
        }
        else
        {
          paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
        }
        ((View)localObject1).setLayoutParams(paramView);
        paramView = (View)localObject1;
      }
      i = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
      localObject1 = (Button)paramView.findViewById(2131366206);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getView  friends count = ");
        ((StringBuilder)localObject2).append(i);
        QLog.d("SpecialCare", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = (TextView)paramView.findViewById(2131370044);
      localObject3 = (TextView)paramView.findViewById(2131370045);
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
        ((TextView)localObject2).setText(2131719199);
        ((Button)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
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
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561496, paramViewGroup, false);
        localObject2 = new SpecailCareListActivity.ViewHolder();
        ((View)localObject1).setTag(localObject2);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368343));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378461));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379798));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378463));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369520));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371409));
        ((SpecailCareListActivity.ViewHolder)localObject2).d = ((ImageView)((View)localObject1).findViewById(2131362976));
        ((SpecailCareListActivity.ViewHolder)localObject2).e = ((ImageView)((View)localObject1).findViewById(2131369507));
        ((SpecailCareListActivity.ViewHolder)localObject2).f = ((ImageView)((View)localObject1).findViewById(2131369457));
        ((SpecailCareListActivity.ViewHolder)localObject2).g = ((ImageView)((View)localObject1).findViewById(2131369459));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131377093);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)((View)localObject1).findViewById(2131371664));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)((View)localObject1).findViewById(2131366371));
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setTextSize(ViewUtils.a(14.0F));
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
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
      Friends localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends = localFriends;
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = localFriends.uin;
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setTag(localFriends.uin);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      if (AppSetting.d) {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714111));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, localFriends.uin, 0);
      if (paramView == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(localFriends.uin, 1, true);
        }
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.f());
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
      }
      i = OnlineStatusUtils.a(localFriends.detalStatusFlag, localFriends.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      switch (i)
      {
      case 5: 
      default: 
        localObject3 = paramView.getOfflineTipsConfig(localFriends.getLastLoginType());
        paramView = (View)localObject3;
        if (localObject3 == null) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719229);
        }
        break;
      case 7: 
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719225);
        break;
      case 6: 
        paramView = "";
        break;
      case 4: 
      case 8: 
        paramView = ContactUtils.a(localFriends.netTypeIconId);
        break;
      case 3: 
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719231);
        break;
      case 2: 
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719221);
        break;
      case 1: 
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719219);
      }
      if ((i != 0) && (i != 6)) {
        i = 0;
      } else {
        i = 1;
      }
      if (((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, localFriends, ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject3 = ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[");
        ((StringBuilder)localObject4).append(paramView);
        ((StringBuilder)localObject4).append("]");
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a(localFriends, (SpecailCareListActivity.ViewHolder)localObject2);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      int j;
      if (i == 0) {
        j = localFriends.netTypeIconId;
      } else {
        j = 0;
      }
      boolean bool = SimpleUIUtil.a();
      if ((i == 0) && (!bool) && ((localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167200));
      } else {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167056));
      }
      if ((!bool) && (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850860, 0);
      }
      else if ((!bool) && (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851196, 0);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      Object localObject4 = ContactUtils.a(localFriends);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, localFriends.uin, 4);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity;
      int k = ((SpecailCareListActivity)localObject3).a((View)localObject1, (SpecailCareListActivity.ViewHolder)localObject2, ((SpecailCareListActivity)localObject3).c);
      localObject3 = new RelativeLayout.LayoutParams((int)(SpecailCareListActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 50.0F), (int)(SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 50.0F));
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(1, 2131368343);
      localLayoutParams1.addRule(10);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(1, 2131368343);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c)
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((SpecailCareListActivity.ViewHolder)localObject2).d.setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject3).setMargins((int)(SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 46.0F), 0, (int)(SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 10.0F), 0);
        localLayoutParams1.setMargins(0, (int)(SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 22.0F), (int)(SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 23.0F + k), 0);
        localLayoutParams2.setMargins(0, (int)(SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 24.0F), 0, 0);
      }
      else
      {
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((SpecailCareListActivity.ViewHolder)localObject2).d.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject3).setMargins((int)(SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 12.0F), 0, (int)(SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 10.0F), 0);
        localLayoutParams1.setMargins(0, (int)(SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 10.0F), k, 0);
        localLayoutParams2.setMargins(0, (int)(SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity) * 36.0F), 0, 0);
      }
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
      localObject3 = localObject1;
      if (AppSetting.d)
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
        ((StringBuilder)localObject3).append(((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getText());
        ((StringBuilder)localObject3).append(".");
        if (i == 0) {
          ((StringBuilder)localObject3).append(ContactUtils.b(j));
        }
        if (!TextUtils.isEmpty(((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a)) {
          ((StringBuilder)localObject3).append(((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.SpecailCareListAdapter
 * JD-Core Version:    0.7.0.1
 */