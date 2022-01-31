package com.tencent.mobileqq.activity.contact.newfriend;

import actn;
import afji;
import afjj;
import ajxl;
import ajxn;
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
import awzw;
import axqw;
import baxt;
import bbcl;
import bbev;
import bbkx;
import bcpq;
import bcpw;
import bfol;
import bfoy;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;

public class AddRequestSuspiciousMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private ajxl jdField_a_of_type_Ajxl = new afji(this);
  private bcpq jdField_a_of_type_Bcpq;
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
    this.mContentView.setBackgroundResource(2130838515);
    setTitle(getString(2131719978));
    this.mContentView.findViewById(2131363721).setOnClickListener(this);
    Object localObject1 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    ((ImageView)this.mContentView.findViewById(2131365824)).setBackgroundDrawable((Drawable)localObject1);
    ((TextView)this.mContentView.findViewById(2131370832)).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    TextView localTextView2 = (TextView)this.mContentView.findViewById(2131363720);
    Object localObject2 = (TextView)this.mContentView.findViewById(2131363718);
    TextView localTextView1 = (TextView)this.mContentView.findViewById(2131363719);
    localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 1)
    {
      localObject1 = getString(2131694073);
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject1);
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age <= 0) {
        break label655;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age + getString(2131719960);
      ((TextView)localObject2).setVisibility(0);
      label263:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localTextView1.setVisibility(8);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131378844);
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131378851);
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
      this.mContentView.findViewById(2131375140).setOnClickListener(this);
      label349:
      localObject2 = (TextView)this.mContentView.findViewById(2131370497);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source != null) {
        break label692;
      }
      localObject1 = "";
      label375:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131364698);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131377549);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason)) {
        break label703;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason);
    }
    for (;;)
    {
      localObject2 = getResources().getDrawable(2130846890);
      ((Drawable)localObject2).setBounds(0, 0, bbkx.a(16.0F), bbkx.a(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(bbkx.a(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131375062).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131362210);
      ((Button)localObject1).setText(2131689873);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = bbkx.a(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131376067).setVisibility(8);
      this.mContentView.findViewById(2131361883).setVisibility(8);
      this.mContentView.findViewById(2131361884).setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 2)
      {
        localObject1 = getString(2131692394);
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
      this.mContentView.findViewById(2131375140).setVisibility(8);
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
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(getActivity());
    }
    if (!this.jdField_a_of_type_Bcpq.isShowing()) {
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  private void f()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool = ((ajxn)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    Intent localIntent = actn.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    localIntent.putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localObject = ((ajxn)localObject).e(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
      if (localObject != null)
      {
        localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        localIntent.putExtra("uinname", bbcl.a((Friends)localObject));
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
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    localbfol.a(getString(2131690621), 3);
    localbfol.a(new afjj(this, localbfol));
    localbfol.c(2131690596);
    localbfol.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  public int getContentLayoutId()
  {
    return 2131561120;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363721: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 108);
      ProfileActivity.b(getActivity(), paramView);
      return;
    case 2131375140: 
      f();
      return;
    case 2131362210: 
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!bbev.g(getActivity()))
      {
        bcpw.a(getActivity(), 2131694620, 0).a();
        return;
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
      d();
      return;
    }
    a();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
  }
  
  public void onDestroy()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */