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
  private QQProgressDialog a;
  private SysSuspiciousMsg b;
  private QQAppInterface c;
  private FriendListObserver d = new AddRequestSuspiciousMsgFragment.1(this);
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("base_uin", String.valueOf(this.b.uin));
    localBundle.putString("base_nick", this.b.nick);
    localBundle.putInt("verfy_type", 0);
    localBundle.putString("verfy_msg", this.b.msg);
    FragmentActivity localFragmentActivity = getActivity();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.uin);
    localStringBuilder.append("");
    AutoRemarkActivity.a(localFragmentActivity, 0, localStringBuilder.toString(), 0L, localBundle);
  }
  
  private void c()
  {
    if (this.mContentView != null)
    {
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddRequestSuspiciousMsgFragment", 2, "initView msg null");
        }
        this.mContentView.setVisibility(4);
        return;
      }
      this.mContentView.setBackgroundResource(2130838959);
      setTitle(getString(2131916966));
      this.mContentView.findViewById(2131430096).setOnClickListener(this);
      Object localObject1 = this.c;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.b.uin);
      Object localObject2 = "";
      ((StringBuilder)localObject3).append("");
      localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject1, 1, ((StringBuilder)localObject3).toString());
      ((ImageView)this.mContentView.findViewById(2131432714)).setBackgroundDrawable((Drawable)localObject1);
      ((TextView)this.mContentView.findViewById(2131439320)).setText(this.b.nick);
      TextView localTextView2 = (TextView)this.mContentView.findViewById(2131430095);
      localObject3 = (TextView)this.mContentView.findViewById(2131430093);
      TextView localTextView1 = (TextView)this.mContentView.findViewById(2131430094);
      if (this.b.sex == 1)
      {
        localObject1 = getString(2131891484);
        localTextView2.setVisibility(0);
      }
      else if (this.b.sex == 2)
      {
        localObject1 = getString(2131889246);
        localTextView2.setVisibility(0);
      }
      else
      {
        localTextView2.setVisibility(8);
        localObject1 = "";
      }
      localTextView2.setText((CharSequence)localObject1);
      if (this.b.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b.age);
        ((StringBuilder)localObject1).append(getString(2131916946));
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
      localObject3 = (LinearLayout)this.mContentView.findViewById(2131449365);
      ((LinearLayout)localObject3).setVisibility(0);
      localTextView1 = (TextView)((LinearLayout)localObject3).findViewById(2131449373);
      localTextView1.setSingleLine(false);
      if (this.b.msg == null) {
        localObject1 = "";
      } else {
        localObject1 = this.b.msg;
      }
      localTextView1.setText((CharSequence)localObject1);
      if ((!TextUtils.isEmpty(this.b.msg)) && (!TextUtils.equals(this.b.msg, "请求加为好友"))) {
        ((TextView)((LinearLayout)localObject3).findViewById(2131449374)).setText(2131890934);
      }
      if (this.b.session_key != null) {
        this.mContentView.findViewById(2131444657).setOnClickListener(this);
      } else {
        this.mContentView.findViewById(2131444657).setVisibility(8);
      }
      localObject3 = (TextView)this.mContentView.findViewById(2131438946);
      if (this.b.source == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = this.b.source;
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = (LinearLayout)this.mContentView.findViewById(2131431328);
      if ((((LinearLayout)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)((LinearLayout)localObject1).getLayoutParams()).topMargin = 0;
      }
      localObject1 = (TextView)this.mContentView.findViewById(2131447710);
      if (!TextUtils.isEmpty(this.b.reason))
      {
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(this.b.reason);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject2 = getResources().getDrawable(2130849705);
      ((Drawable)localObject2).setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      ((TextView)localObject1).setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
      this.mContentView.findViewById(2131444568).setVisibility(8);
      localObject1 = (Button)this.mContentView.findViewById(2131427912);
      ((Button)localObject1).setText(2131886465);
      if ((((Button)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((Button)localObject1).getLayoutParams();
        int i = ViewUtils.dip2px(10.0F);
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = i;
      }
      ((Button)localObject1).setOnClickListener(this);
      this.mContentView.findViewById(2131445841).setVisibility(8);
      this.mContentView.findViewById(2131427490).setVisibility(8);
      this.mContentView.findViewById(2131427491).setOnClickListener(this);
      localObject2 = (LinearLayout)this.mContentView.findViewById(2131438941);
      if (this.b.sourceflag == 1) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      AddRequestActivity.a(this.c, getActivity(), (LinearLayout)localObject2, "AddRequestSuspiciousMsgFragment", this.b.entity_category, this.b.entity_name, this.b.entity_url, (String)localObject1, "2");
    }
  }
  
  private void d()
  {
    if (this.a == null) {
      this.a = new QQProgressDialog(getBaseActivity());
    }
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  private void e()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "gotoReply ");
    }
    ReportController.b(this.c, "dc00898", "", "", "0X800A330", "0X800A330", 0, 0, "", "", "", "");
    Object localObject2 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b.uin);
    ((StringBuilder)localObject1).append("");
    boolean bool = ((FriendsManager)localObject2).n(((StringBuilder)localObject1).toString());
    localObject1 = AIOUtils.a(new Intent(getBaseActivity(), SplashActivity.class), null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.uin);
    localStringBuilder.append("");
    ((Intent)localObject1).putExtra("uin", localStringBuilder.toString());
    ((Intent)localObject1).putExtra("add_friend_source_id", 3041);
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.uin);
      localStringBuilder.append("");
      localObject2 = ((FriendsManager)localObject2).m(localStringBuilder.toString());
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("cSpecialFlag", ((Friends)localObject2).cSpecialFlag);
        ((Intent)localObject1).putExtra("uinname", ContactUtils.a((Friends)localObject2));
      }
    }
    else
    {
      ((Intent)localObject1).putExtra("uinname", this.b.nick);
    }
    int i = 1022;
    if (bool) {
      i = 0;
    }
    ((Intent)localObject1).putExtra("uintype", i);
    if ((this.b.session_key != null) && (this.b.session_key.length > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("has session key ");
        ((StringBuilder)localObject2).append(this.b.uin);
        QLog.d("AddRequestSuspiciousMsgFragment", 2, ((StringBuilder)localObject2).toString());
      }
      this.c.getMsgCache().n(String.valueOf(this.b.uin), this.b.session_key);
    }
    startActivity((Intent)localObject1);
  }
  
  void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    localActionSheet.addButton(getString(2131887669), 3);
    localActionSheet.setOnButtonClickListener(new AddRequestSuspiciousMsgFragment.2(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  protected int getContentLayoutId()
  {
    return 2131627866;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131444657: 
      f();
      break;
    case 2131430096: 
      ReportController.b(this.c, "dc00898", "", "", "0X800A32F", "0X800A32F", 0, 0, "", "", "", "");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.uin);
      ((StringBuilder)localObject).append("");
      localObject = new AllInOne(((StringBuilder)localObject).toString(), 108);
      ProfileUtils.openProfileCard(getActivity(), (AllInOne)localObject);
      break;
    case 2131427912: 
      ReportController.b(this.c, "dc00898", "", "", "0X800A32C", "0X800A32C", 2, 0, "", "", "", "");
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
      {
        QQToast.makeText(getBaseActivity(), 2131892113, 0).show();
      }
      else
      {
        ((FriendListHandler)this.c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).agreeSuspiciousMsg(this.b.uin);
        d();
      }
      break;
    case 2131427491: 
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
      this.b = ((SysSuspiciousMsg)paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AddRequestSuspiciousMsgFragment", 2, this.b.toString());
      }
    }
    this.c = getBaseActivity().app;
    this.c.addObserver(this.d);
  }
  
  public void onDestroy()
  {
    e();
    this.c.removeObserver(this.d);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment
 * JD-Core Version:    0.7.0.1
 */