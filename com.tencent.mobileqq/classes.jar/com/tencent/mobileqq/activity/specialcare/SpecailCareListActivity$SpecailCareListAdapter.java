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
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
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
      localObject1 = paramView;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561642, paramViewGroup, false);
        paramView = ((View)localObject1).getLayoutParams();
        if (paramView != null)
        {
          paramView.height = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight();
          paramView.width = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
          ((View)localObject1).setLayoutParams(paramView);
        }
      }
      else
      {
        i = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
        paramView = (Button)((View)localObject1).findViewById(2131366318);
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "getView  friends count = " + i);
        }
        localObject2 = (TextView)((View)localObject1).findViewById(2131370383);
        localObject3 = (TextView)((View)localObject1).findViewById(2131370384);
        if (i > 0) {
          break label238;
        }
        ((TextView)localObject3).setVisibility(8);
        paramView.setVisibility(8);
      }
      for (;;)
      {
        paramView = (View)localObject1;
        localObject2 = localObject1;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
        break;
        label238:
        ((TextView)localObject3).setVisibility(0);
        paramView.setVisibility(0);
        ((TextView)localObject2).setText(2131719481);
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      }
    }
    if (paramView != null)
    {
      localObject1 = (SpecailCareListActivity.ViewHolder)paramView.getTag();
      label280:
      if (localObject1 != null) {
        break label1862;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561646, paramViewGroup, false);
      localObject2 = new SpecailCareListActivity.ViewHolder();
      ((View)localObject1).setTag(localObject2);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368603));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379092));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380497));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379094));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369834));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371783));
      ((SpecailCareListActivity.ViewHolder)localObject2).d = ((ImageView)((View)localObject1).findViewById(2131363028));
      ((SpecailCareListActivity.ViewHolder)localObject2).e = ((ImageView)((View)localObject1).findViewById(2131369823));
      ((SpecailCareListActivity.ViewHolder)localObject2).f = ((ImageView)((View)localObject1).findViewById(2131369767));
      ((SpecailCareListActivity.ViewHolder)localObject2).g = ((ImageView)((View)localObject1).findViewById(2131369769));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131377653);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)((View)localObject1).findViewById(2131372067));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)((View)localObject1).findViewById(2131366488));
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
      ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setTextSize(ViewUtils.a(14.0F));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
    }
    for (;;)
    {
      if ((localObject1 instanceof FormItemRelativeLayout))
      {
        if (paramInt == getCount() - 1) {
          ((FormItemRelativeLayout)localObject1).setBGType(3);
        }
      }
      else
      {
        label564:
        localObject3 = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)localObject3);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((Friends)localObject3).uin;
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setTag(((Friends)localObject3).uin);
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
        if (AppSetting.d) {
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714182));
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, ((Friends)localObject3).uin, 0);
        if (paramView != null) {
          break label1512;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(((Friends)localObject3).uin, 1, true);
        }
        ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)ImageUtil.d());
        label715:
        i = ContactUtils.a(((Friends)localObject3).detalStatusFlag, ((Friends)localObject3).iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        switch (i)
        {
        case 5: 
        default: 
          paramView = paramView.getOfflineTipsConfig(((Friends)localObject3).getLastLoginType());
          if (paramView == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719511);
          }
          break;
        }
      }
      for (;;)
      {
        label821:
        label836:
        label875:
        int j;
        boolean bool;
        label981:
        String str;
        label1026:
        int k;
        Object localObject4;
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        if ((i == 0) || (i == 6))
        {
          i = 1;
          if (!((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, (Friends)localObject3)) {
            break label1612;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((Friends)localObject3, (SpecailCareListActivity.ViewHolder)localObject2);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          j = 0;
          if (i == 0) {
            j = ((Friends)localObject3).netTypeIconId;
          }
          bool = SimpleUIUtil.a();
          if ((i != 0) || (bool) || ((!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1668;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167175));
          if ((bool) || (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            break label1692;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850920, 0);
          str = ContactUtils.a((Friends)localObject3);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, ((Friends)localObject3).uin, 4);
          k = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((View)localObject1, (SpecailCareListActivity.ViewHolder)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c);
          localObject4 = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(50.0F * SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)));
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(1, 2131368603);
          localLayoutParams1.addRule(10);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2.addRule(1, 2131368603);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1755;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((SpecailCareListActivity.ViewHolder)localObject2).d.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(46.0F * SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          int m = (int)(22.0F * SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          float f = SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, m, (int)(k + 23.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
        for (;;)
        {
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          if (AppSetting.d)
          {
            localObject4 = new StringBuilder(24);
            ((StringBuilder)localObject4).append(str).append(".").append(paramView).append(".");
            if ((((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              ((StringBuilder)localObject4).append("QQ会员").append(".");
            }
            ((StringBuilder)localObject4).append(((SpecailCareListActivity.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getText()).append(".");
            if (i == 0) {
              ((StringBuilder)localObject4).append(ContactUtils.b(j));
            }
            if (!TextUtils.isEmpty(((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a)) {
              ((StringBuilder)localObject4).append(((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a.toString());
            }
            ((View)localObject1).setContentDescription((CharSequence)localObject4);
          }
          paramView = (View)localObject1;
          localObject2 = paramView;
          break;
          localObject1 = null;
          break label280;
          ((FormItemRelativeLayout)localObject1).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localObject1).setBGType(2);
          break label564;
          label1512:
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label715;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719501);
          break label821;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719503);
          break label821;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719507);
          break label821;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131719513);
          break label821;
          paramView = "";
          break label821;
          paramView = ContactUtils.a(((Friends)localObject3).netTypeIconId);
          break label821;
          i = 0;
          break label836;
          label1612:
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          break label875;
          label1668:
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167033));
          break label981;
          label1692:
          if ((!bool) && (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
          {
            ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
            ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851283, 0);
            break label1026;
          }
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label1026;
          label1755:
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((SpecailCareListActivity.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject2).d.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(12.0F * SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          localLayoutParams1.setMargins(0, (int)(10.0F * SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), k, 0);
          localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
      }
      label1862:
      localObject2 = localObject1;
      localObject1 = paramView;
    }
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