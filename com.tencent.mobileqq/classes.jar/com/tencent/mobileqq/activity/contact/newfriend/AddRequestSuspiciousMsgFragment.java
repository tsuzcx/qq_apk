package com.tencent.mobileqq.activity.contact.newfriend;

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
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class AddRequestSuspiciousMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddRequestSuspiciousMsgFragment.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SysSuspiciousMsg jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
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
    this.mContentView.setBackgroundResource(2130838980);
    setTitle(getString(2131719686));
    this.mContentView.findViewById(2131364212).setOnClickListener(this);
    Object localObject1 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    ((ImageView)this.mContentView.findViewById(2131366520)).setBackgroundDrawable((Drawable)localObject1);
    ((TextView)this.mContentView.findViewById(2131372288)).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    TextView localTextView2 = (TextView)this.mContentView.findViewById(2131364211);
    Object localObject2 = (TextView)this.mContentView.findViewById(2131364209);
    TextView localTextView1 = (TextView)this.mContentView.findViewById(2131364210);
    localObject1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 1)
    {
      localObject1 = getString(2131693923);
      localTextView2.setVisibility(0);
      localTextView2.setText((CharSequence)localObject1);
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age <= 0) {
        break label771;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age + getString(2131719672);
      ((TextView)localObject2).setVisibility(0);
      label263:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localTextView1.setVisibility(8);
      localObject2 = (LinearLayout)this.mContentView.findViewById(2131381157);
      ((LinearLayout)localObject2).setVisibility(0);
      localTextView1 = (TextView)((LinearLayout)localObject2).findViewById(2131381165);
      localTextView1.setSingleLine(false);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg != null) {
        break label780;
      }
      localObject1 = "";
      label323:
      localTextView1.setText((CharSequence)localObject1);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg)) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg, "请求加为好友"))) {
        ((TextView)((LinearLayout)localObject2).findViewById(2131381166)).setText(2131693430);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key == null) {
        break label791;
      }
      this.mContentView.findViewById(2131376946).setOnClickListener(this);
      label394:
      localObject2 = (TextView)this.mContentView.findViewById(2131371957);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source != null) {
        break label808;
      }
      localObject1 = "";
      label420:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131365300);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131379648);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason)) {
        break label819;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason);
      label501:
      localObject2 = getResources().getDrawable(2130848172);
      ((Drawable)localObject2).setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(ViewUtils.a(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131376861).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131362352);
      ((Button)localObject1).setText(2131689905);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = ViewUtils.a(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131378018).setVisibility(8);
      this.mContentView.findViewById(2131361930).setVisibility(8);
      this.mContentView.findViewById(2131361931).setOnClickListener(this);
      localObject2 = (LinearLayout)this.mContentView.findViewById(2131371952);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sourceflag != 1) {
        break label828;
      }
    }
    label771:
    label780:
    label791:
    label808:
    label819:
    label828:
    for (localObject1 = "1";; localObject1 = "2")
    {
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), (LinearLayout)localObject2, "AddRequestSuspiciousMsgFragment", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_category, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_name, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_url, (String)localObject1, "2");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 2)
      {
        localObject1 = getString(2131692330);
        localTextView2.setVisibility(0);
        break;
      }
      localTextView2.setVisibility(8);
      break;
      ((TextView)localObject2).setVisibility(8);
      break label263;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg;
      break label323;
      this.mContentView.findViewById(2131376946).setVisibility(8);
      break label394;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source;
      break label420;
      ((TextView)localObject1).setVisibility(8);
      break label501;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void f()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool = ((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    Intent localIntent = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
    localIntent.putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localObject = ((FriendsManager)localObject).e(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "");
      if (localObject != null)
      {
        localIntent.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        localIntent.putExtra("uinname", ContactUtils.a((Friends)localObject));
      }
      if (!bool) {
        break label346;
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().n(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin), this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key);
      }
      startActivity(localIntent);
      return;
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
      break;
      label346:
      i = 1022;
    }
  }
  
  void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.addButton(getString(2131690821), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestSuspiciousMsgFragment.2(this, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  public int getContentLayoutId()
  {
    return 2131561654;
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin + "", 108);
      ProfileActivity.b(getActivity(), localAllInOne);
      continue;
      f();
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!NetworkUtil.g(getActivity()))
      {
        QQToast.a(getActivity(), 2131694468, 0).a();
      }
      else
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).agreeSuspiciousMsg(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void onDestroy()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */