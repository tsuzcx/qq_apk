package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
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
    FragmentActivity localFragmentActivity = getActivity();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
    localStringBuilder.append("");
    AutoRemarkActivity.a(localFragmentActivity, 0, localStringBuilder.toString(), 0L, localBundle);
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
        return;
      }
      this.mContentView.setBackgroundResource(2130838740);
      setTitle(getString(2131719407));
      this.mContentView.findViewById(2131364129).setOnClickListener(this);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
      Object localObject2 = "";
      ((StringBuilder)localObject3).append("");
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, ((StringBuilder)localObject3).toString());
      ((ImageView)this.mContentView.findViewById(2131366401)).setBackgroundDrawable((Drawable)localObject1);
      ((TextView)this.mContentView.findViewById(2131371877)).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
      TextView localTextView2 = (TextView)this.mContentView.findViewById(2131364128);
      localObject3 = (TextView)this.mContentView.findViewById(2131364126);
      TextView localTextView1 = (TextView)this.mContentView.findViewById(2131364127);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 1)
      {
        localObject1 = getString(2131693879);
        localTextView2.setVisibility(0);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sex == 2)
      {
        localObject1 = getString(2131692259);
        localTextView2.setVisibility(0);
      }
      else
      {
        localTextView2.setVisibility(8);
        localObject1 = "";
      }
      localTextView2.setText((CharSequence)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.age);
        ((StringBuilder)localObject1).append(getString(2131719391));
        localObject1 = ((StringBuilder)localObject1).toString();
        ((TextView)localObject3).setVisibility(0);
      }
      else
      {
        ((TextView)localObject3).setVisibility(8);
        localObject1 = "";
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localTextView1.setVisibility(8);
      localObject3 = (LinearLayout)this.mContentView.findViewById(2131380414);
      ((LinearLayout)localObject3).setVisibility(0);
      localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(2131380422);
      localTextView1.setSingleLine(false);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg == null) {
        localObject1 = "";
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg;
      }
      localTextView1.setText((CharSequence)localObject1);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg)) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.msg, "请求加为好友"))) {
        ((TextView)((LinearLayout)localObject3).findViewById(2131380423)).setText(2131693385);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key != null) {
        this.mContentView.findViewById(2131376436).setOnClickListener(this);
      } else {
        this.mContentView.findViewById(2131376436).setVisibility(8);
      }
      localObject3 = (TextView)this.mContentView.findViewById(2131371565);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.source;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131365175);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131378992);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason))
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.reason);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject2 = getResources().getDrawable(2130848043);
      ((Drawable)localObject2).setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(ViewUtils.a(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131376352).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131362313);
      ((Button)localObject1).setText(2131689824);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = ViewUtils.a(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131377442).setVisibility(8);
      this.mContentView.findViewById(2131361936).setVisibility(8);
      this.mContentView.findViewById(2131361937).setOnClickListener(this);
      localObject2 = (LinearLayout)this.mContentView.findViewById(2131371560);
      if (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.sourceflag == 1) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), (LinearLayout)localObject2, "AddRequestSuspiciousMsgFragment", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_category, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_name, this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.entity_url, (String)localObject1, "2");
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void e()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
    ((StringBuilder)localObject1).append("");
    boolean bool = ((FriendsManager)localObject2).b(((StringBuilder)localObject1).toString());
    localObject1 = AIOUtils.a(new Intent(getBaseActivity(), SplashActivity.class), null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
    localStringBuilder.append("");
    ((Intent)localObject1).putExtra("uin", localStringBuilder.toString());
    ((Intent)localObject1).putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
      localStringBuilder.append("");
      localObject2 = ((FriendsManager)localObject2).e(localStringBuilder.toString());
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("cSpecialFlag", ((Friends)localObject2).cSpecialFlag);
        ((Intent)localObject1).putExtra("uinname", ContactUtils.a((Friends)localObject2));
      }
    }
    else
    {
      ((Intent)localObject1).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.nick);
    }
    int i = 1022;
    if (bool) {
      i = 0;
    }
    ((Intent)localObject1).putExtra("uintype", i);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key != null) && (this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key.length > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("has session key ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        QLog.d("AddRequestSuspiciousMsgFragment", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().n(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin), this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.session_key);
    }
    startActivity((Intent)localObject1);
  }
  
  void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
    localActionSheet.addButton(getString(2131690749), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestSuspiciousMsgFragment.2(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561505;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376436: 
      f();
      break;
    case 2131364129: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
      ((StringBuilder)localObject).append("");
      localObject = new AllInOne(((StringBuilder)localObject).toString(), 108);
      ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject);
      break;
    case 2131362313: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
      {
        QQToast.a(getBaseActivity(), 2131694433, 0).a();
      }
      else
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).agreeSuspiciousMsg(this.jdField_a_of_type_ComTencentMobileqqDataSysSuspiciousMsg.uin);
        d();
      }
      break;
    case 2131361937: 
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void onDestroy()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */