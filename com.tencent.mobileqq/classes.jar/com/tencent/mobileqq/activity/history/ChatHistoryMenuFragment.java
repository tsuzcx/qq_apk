package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.ChatHistoryMenuItemView;
import com.tencent.mobileqq.widget.ChatHistoryMenuItemView.OnCategoryClickListener;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

public class ChatHistoryMenuFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, ChatHistoryMenuItemView.OnCategoryClickListener
{
  private AppRuntime a;
  private QBaseActivity b;
  private Intent c;
  private int d;
  private SessionInfo e;
  private RelativeLayout f;
  private BaseMessageSearchDialog g;
  private int[] h;
  
  private void a()
  {
    if ((!QQTheme.isDefaultTheme()) && (!QQTheme.isNowSimpleUI()))
    {
      this.f.setBackgroundResource(2130838958);
      return;
    }
    this.f.setBackgroundResource(2130852486);
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    QLog.d("Q.history.ChatHistoryMenuFragment", 1, "initViews start");
    paramViewGroup = paramLayoutInflater.inflate(2131624581, paramViewGroup, false);
    this.f = ((RelativeLayout)paramViewGroup.findViewById(2131447595));
    a();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(this.f, true);
    }
    paramViewGroup = (NavBarCommon)paramViewGroup.findViewById(2131444897);
    paramViewGroup.setLeftBackVisible(0);
    paramViewGroup.setTitle(getString(2131893871));
    paramViewGroup.setLeftViewName(2131887440);
    paramViewGroup.getLeftBackIcon().setOnClickListener(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131629215, this.f, false);
    paramLayoutInflater.findViewById(2131429816).setVisibility(8);
    paramLayoutInflater.setOnClickListener(this);
    paramViewGroup = (EditText)paramLayoutInflater.findViewById(2131432634);
    paramViewGroup.setFocusableInTouchMode(false);
    paramViewGroup.setCursorVisible(false);
    paramViewGroup.setOnClickListener(this);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, AIOUtils.b(60.0F, getResources()));
    paramViewGroup.addRule(3, 2131444897);
    this.f.addView(paramLayoutInflater, paramViewGroup);
    paramLayoutInflater = new ChatHistoryMenuItemView(getContext(), 3, getString(2131893872), this.h);
    paramLayoutInflater.a(this);
    paramViewGroup = new RelativeLayout.LayoutParams(-1, -2);
    paramViewGroup.addRule(3, 2131445416);
    this.f.addView(paramLayoutInflater, paramViewGroup);
  }
  
  private void a(String paramString)
  {
    a(paramString, "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.a;
    String str;
    if (this.d == 3011) {
      str = "1";
    } else {
      str = "2";
    }
    ReportController.a(localAppRuntime, "dc00898", "", "", paramString1, paramString1, 0, 0, str, "", paramString2, "");
  }
  
  private void b()
  {
    if (this.g == null)
    {
      Object localObject = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      int i = this.d;
      if (i == 3011)
      {
        this.g = new C2CMessageSearchDialog(getActivity(), (QQAppInterface)this.a, this.e, ((MessageRoamManager)localObject).I());
      }
      else if (i == 3012)
      {
        this.g = new TroopAllMessageSearchDialog(getActivity(), (QQAppInterface)this.a, this.e, ((MessageRoamManager)localObject).I());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showSearchDialog error: invalid fromType ");
        ((StringBuilder)localObject).append(this.d);
        QLog.e("Q.history.ChatHistoryMenuFragment", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (this.g.isShowing()) {
      return;
    }
    this.g.show();
    a("0X800BBF6");
  }
  
  private void c()
  {
    BaseMessageSearchDialog localBaseMessageSearchDialog = this.g;
    if ((localBaseMessageSearchDialog != null) && (localBaseMessageSearchDialog.isShowing()))
    {
      this.g.dismiss();
      this.g = null;
    }
  }
  
  private int[] d()
  {
    int i = this.d;
    if (i == 3011) {
      return ChatHistoryC2CViewController.e;
    }
    if (i == 3012) {
      return ChatHistoryTroopViewController.e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemNames error: invalid fromType ");
    localStringBuilder.append(this.d);
    QLog.e("Q.history.ChatHistoryMenuFragment", 1, localStringBuilder.toString());
    return new int[0];
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), ChatHistoryActivity.class);
    localIntent.putExtra("FromType", this.d);
    localIntent.putExtra("SissionUin", this.e.b);
    localIntent.putExtra("uin", this.e.b);
    localIntent.putExtra("uintype", this.e.a);
    localIntent.putExtra("TargetTabPos", paramInt);
    getActivity().startActivity(localIntent);
    a("0X800BBF7", getResources().getString(this.h[paramInt]));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131432634) {
      if (i != 2131436180)
      {
        if (i != 2131445416) {
          break label50;
        }
      }
      else
      {
        getActivity().finish();
        QLog.d("Q.history.ChatHistoryMenuFragment", 1, "user clicked left back btn, do finish");
        break label50;
      }
    }
    b();
    label50:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getQBaseActivity();
    this.a = this.b.getAppRuntime();
    this.c = getActivity().getIntent();
    this.d = this.c.getIntExtra("FromType", 3011);
    this.h = d();
    this.e = new SessionInfo();
    this.e.b = this.c.getStringExtra("uin");
    this.e.a = this.c.getIntExtra("uintype", 0);
    this.e.H = new ChatBackground();
    this.e.r = ChatTextSizeSettingActivity.a(getActivity());
    a(paramLayoutInflater, paramViewGroup);
    a("0X800BBF5");
    paramLayoutInflater = this.f;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    c();
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMenuFragment
 * JD-Core Version:    0.7.0.1
 */