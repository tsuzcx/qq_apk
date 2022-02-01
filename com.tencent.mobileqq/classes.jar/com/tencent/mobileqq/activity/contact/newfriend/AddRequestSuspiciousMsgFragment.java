package com.tencent.mobileqq.activity.contact.newfriend;

import agej;
import ajje;
import ajjf;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anyu;
import anyw;
import aoot;
import bcrg;
import bdll;
import bhlg;
import bhnv;
import bhtq;
import bjbs;
import blir;
import blji;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AddRequestSuspiciousMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private anyu jdField_a_of_type_Anyu = new ajje(this);
  private bjbs jdField_a_of_type_Bjbs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SysSuspiciousMsg jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg;
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("base_uin", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin));
    localBundle.putString("base_nick", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    localBundle.putInt("verfy_type", 0);
    localBundle.putString("verfy_msg", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg);
    AutoRemarkActivity.a(getActivity(), 0, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 0L, localBundle);
  }
  
  private void c()
  {
    if (this.mContentView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddRequestSuspiciousMsgFragment", 2, "initView msg null");
        }
        this.mContentView.setVisibility(4);
      }
    }
    else {
      return;
    }
    this.mContentView.setBackgroundResource(2130838779);
    setTitle(getString(2131718506));
    this.mContentView.findViewById(2131364010).setOnClickListener(this);
    Object localObject1 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    ((ImageView)this.mContentView.findViewById(2131366213)).setBackgroundDrawable((Drawable)localObject1);
    ((TextView)this.mContentView.findViewById(2131371827)).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    TextView localTextView2 = (TextView)this.mContentView.findViewById(2131364009);
    Object localObject2 = (TextView)this.mContentView.findViewById(2131364007);
    TextView localTextView1 = (TextView)this.mContentView.findViewById(2131364008);
    localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 1)
    {
      localObject1 = getString(2131693473);
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject1);
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age <= 0) {
        break label655;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age + getString(2131718495);
      ((TextView)localObject2).setVisibility(0);
      label263:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localTextView1.setVisibility(8);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131380649);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131380656);
      ((TextView)localObject2).setSingleLine(false);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg != null) {
        break label664;
      }
      localObject1 = "";
      label321:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key == null) {
        break label675;
      }
      this.mContentView.findViewById(2131376532).setOnClickListener(this);
      label349:
      localObject2 = (TextView)this.mContentView.findViewById(2131371490);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source != null) {
        break label692;
      }
      localObject1 = "";
      label375:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131365052);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131379150);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason)) {
        break label703;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason);
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130847814);
      ((Drawable)localObject2).setBounds(0, 0, bhtq.a(16.0F), bhtq.a(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(bhtq.a(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131376452).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131362316);
      ((Button)localObject1).setText(2131689824);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = bhtq.a(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131377566).setVisibility(8);
      this.mContentView.findViewById(2131361928).setVisibility(8);
      this.mContentView.findViewById(2131361929).setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 2)
      {
        localObject1 = getString(2131692060);
        localTextView2.setVisibility(0);
        break;
      }
      localTextView2.setVisibility(8);
      break;
      label655:
      ((TextView)localObject2).setVisibility(8);
      break label263;
      label664:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg;
      break label321;
      label675:
      this.mContentView.findViewById(2131376532).setVisibility(8);
      break label349;
      label692:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source;
      break label375;
      label703:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bjbs == null) {
      this.jdField_a_of_type_Bjbs = new bjbs(getActivity());
    }
    if (!this.jdField_a_of_type_Bjbs.isShowing()) {
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  private void f()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool = ((anyw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    Intent localIntent = agej.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    localIntent.putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localObject = ((anyw)localObject).e(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
      if (localObject != null)
      {
        localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        localIntent.putExtra("uinname", bhlg.a((Friends)localObject));
      }
      if (!bool) {
        break label345;
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", i);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddRequestSuspiciousMsgFragment", 2, "has session key " + this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().o(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin), this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key);
      }
      startActivity(localIntent);
      return;
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
      break;
      label345:
      i = 1022;
    }
  }
  
  void a()
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(getString(2131690600), 3);
    localblir.a(new ajjf(this, localblir));
    localblir.c(2131690580);
    localblir.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  public int getContentLayoutId()
  {
    return 2131561597;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 108);
      ProfileActivity.b(getActivity(), localAllInOne);
      continue;
      f();
      continue;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!bhnv.g(getActivity()))
      {
        QQToast.a(getActivity(), 2131693974, 0).a();
      }
      else
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        d();
        continue;
        a();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getSerializableExtra("msg_extra");
    if ((paramBundle instanceof SysSuspiciousMsg))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg = ((SysSuspiciousMsg)paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AddRequestSuspiciousMsgFragment", 2, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  public void onDestroy()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */