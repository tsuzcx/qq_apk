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
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class amde
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  
  public amde(SpecailCareListActivity paramSpecailCareListActivity)
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
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561527, paramViewGroup, false);
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
        i = ((anvk)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
        paramView = (Button)((View)localObject1).findViewById(2131366146);
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, "getView  friends count = " + i);
        }
        localObject2 = (TextView)((View)localObject1).findViewById(2131370111);
        localObject3 = (TextView)((View)localObject1).findViewById(2131370112);
        if (i > 0) {
          break label230;
        }
        ((TextView)localObject3).setVisibility(8);
        paramView.setVisibility(8);
      }
      for (;;)
      {
        paramView = (View)localObject1;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        paramView = new ViewGroup.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
        break;
        label230:
        ((TextView)localObject3).setVisibility(0);
        paramView.setVisibility(0);
        ((TextView)localObject2).setText(2131718954);
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      }
    }
    if (paramView != null)
    {
      localObject1 = (amdg)paramView.getTag();
      label272:
      if (localObject1 != null) {
        break label1798;
      }
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561531, paramViewGroup, false);
      localObject2 = new amdg();
      ((View)localObject1).setTag(localObject2);
      ((amdg)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368381));
      ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378659));
      ((amdg)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380060));
      ((amdg)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378661));
      ((amdg)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369564));
      ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131371471));
      ((amdg)localObject2).d = ((ImageView)((View)localObject1).findViewById(2131362986));
      ((amdg)localObject2).e = ((ImageView)((View)localObject1).findViewById(2131369554));
      ((amdg)localObject2).f = ((ImageView)((View)localObject1).findViewById(2131369508));
      ((amdg)localObject2).g = ((ImageView)((View)localObject1).findViewById(2131369510));
      ((amdg)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131377234);
      ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)((View)localObject1).findViewById(2131371752));
      ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView = ((OnlineStatusView)((View)localObject1).findViewById(2131366314));
      ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setViewStyle(2);
      ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setTextSize(ViewUtils.dip2px(14.0F));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
    }
    for (;;)
    {
      localObject3 = (Friends)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.b.get(paramInt);
      ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqDataFriends = ((Friends)localObject3);
      ((amdg)localObject2).jdField_a_of_type_JavaLangString = ((Friends)localObject3).uin;
      ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView.setTag(((Friends)localObject3).uin);
      ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
      if (AppSetting.c) {
        ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131713686));
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, ((Friends)localObject3).uin, 0);
      if (paramView == null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(((Friends)localObject3).uin, 1, true);
        }
        ((amdg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((BitmapDrawable)bheg.a());
        label674:
        i = ContactUtils.getFriendStatus(((Friends)localObject3).detalStatusFlag, ((Friends)localObject3).iTermType);
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        switch (i)
        {
        case 5: 
        default: 
          paramView = paramView.getOfflineTipsConfig(((Friends)localObject3).getLastLoginType());
          if (paramView == null) {
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718976);
          }
          break;
        }
      }
      for (;;)
      {
        label781:
        label796:
        label835:
        int j;
        boolean bool;
        label941:
        label986:
        String str;
        int k;
        Object localObject4;
        RelativeLayout.LayoutParams localLayoutParams1;
        RelativeLayout.LayoutParams localLayoutParams2;
        if ((i == 0) || (i == 6))
        {
          i = 1;
          if (!((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, (Friends)localObject3)) {
            break label1548;
          }
          ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(0);
          ((amdg)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((Friends)localObject3, (amdg)localObject2);
          ((amdg)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          j = 0;
          if (i == 0) {
            j = ((Friends)localObject3).netTypeIconId;
          }
          bool = bdfk.b();
          if ((i != 0) || (bool) || ((!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) && (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))) {
            break label1604;
          }
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167168));
          if ((bool) || (!((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            break label1628;
          }
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850517, 0);
          str = ContactUtils.getFriendName((Friends)localObject3);
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(str);
          ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.app, ((Friends)localObject3).uin, 4);
          k = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.a((View)localObject1, (amdg)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c);
          localObject4 = new RelativeLayout.LayoutParams((int)(50.0F * SpecailCareListActivity.k(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), (int)(50.0F * SpecailCareListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)));
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams1.addRule(1, 2131368381);
          localLayoutParams1.addRule(10);
          localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams2.addRule(1, 2131368381);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.c) {
            break label1691;
          }
          ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          ((amdg)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((amdg)localObject2).d.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(46.0F * SpecailCareListActivity.m(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.n(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          int m = (int)(22.0F * SpecailCareListActivity.o(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity));
          float f = SpecailCareListActivity.p(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity);
          localLayoutParams1.setMargins(0, m, (int)(k + 23.0F * f), 0);
          localLayoutParams2.setMargins(0, (int)(24.0F * SpecailCareListActivity.q(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
        for (;;)
        {
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
          if (AppSetting.c)
          {
            localObject4 = new StringBuilder(24);
            ((StringBuilder)localObject4).append(str).append(".").append(paramView).append(".");
            if ((((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
              ((StringBuilder)localObject4).append("QQ会员").append(".");
            }
            ((StringBuilder)localObject4).append(((amdg)localObject2).jdField_b_of_type_AndroidWidgetTextView.getText()).append(".");
            if (i == 0) {
              ((StringBuilder)localObject4).append(ContactUtils.getNetDescription(j));
            }
            if (!TextUtils.isEmpty(((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a)) {
              ((StringBuilder)localObject4).append(((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a.toString());
            }
            ((View)localObject1).setContentDescription((CharSequence)localObject4);
          }
          paramView = (View)localObject1;
          break;
          localObject1 = null;
          break label272;
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramView));
          break label674;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718967);
          break label781;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718969);
          break label781;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718973);
          break label781;
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getString(2131718978);
          break label781;
          paramView = "";
          break label781;
          paramView = ContactUtils.getNetOnlineStatus(((Friends)localObject3).netTypeIconId);
          break label781;
          i = 0;
          break label796;
          label1548:
          ((amdg)localObject2).jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusView.setVisibility(8);
          ((amdg)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((amdg)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText("[" + paramView + "]");
          break label835;
          label1604:
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.getResources().getColorStateList(2131167026));
          break label941;
          label1628:
          if ((!bool) && (((Friends)localObject3).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)))
          {
            ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity.jdField_a_of_type_Int);
            ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130850854, 0);
            break label986;
          }
          ((amdg)localObject2).jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label986;
          label1691:
          ((amdg)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          ((amdg)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((amdg)localObject2).d.setVisibility(8);
          ((RelativeLayout.LayoutParams)localObject4).setMargins((int)(12.0F * SpecailCareListActivity.r(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, (int)(10.0F * SpecailCareListActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0);
          localLayoutParams1.setMargins(0, (int)(10.0F * SpecailCareListActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), k, 0);
          localLayoutParams2.setMargins(0, (int)(36.0F * SpecailCareListActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareSpecailCareListActivity)), 0, 0);
        }
      }
      label1798:
      localObject2 = localObject1;
      localObject1 = paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amde
 * JD-Core Version:    0.7.0.1
 */