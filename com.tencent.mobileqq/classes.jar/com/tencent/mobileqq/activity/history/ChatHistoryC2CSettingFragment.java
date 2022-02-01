package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class ChatHistoryC2CSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  FormSimpleItem a;
  FormSimpleItem b;
  public int c;
  public SessionInfo d;
  
  private void a()
  {
    Object localObject1 = getBaseActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("message_roam_flag");
    ((StringBuilder)localObject2).append(getBaseActivity().app.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              localObject1 = null;
            } else {
              localObject1 = getResources().getString(2131914223);
            }
          }
          else {
            localObject1 = getResources().getString(2131914221);
          }
        }
        else {
          localObject1 = getResources().getString(2131914222);
        }
      }
      else {
        localObject1 = getResources().getString(2131914224);
      }
    }
    else {
      localObject1 = getResources().getString(2131914231);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.a;
      if (localObject2 != null) {
        ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("messge roam flag is error ,is : ");
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.history.C2CSettingFragment", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, ChatHistoryC2CSettingFragment.class, paramInt2);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131887737));
    this.a = ((FormSimpleItem)this.mContentView.findViewById(2131430000));
    this.b = ((FormSimpleItem)this.mContentView.findViewById(2131429858));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624478;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 2011) {
      return;
    }
    paramIntent = getBaseActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(getBaseActivity().app.getCurrentAccountUin());
    paramInt1 = paramIntent.getInt(localStringBuilder.toString(), -1);
    if (paramInt1 == this.c) {
      return;
    }
    this.c = paramInt1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131429858)
    {
      if (i == 2131430000) {
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQAppInterface localQQAppInterface = getBaseActivity().app;
          Object localObject1 = localQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("message_roam_flag");
          ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentAccountUin());
          this.c = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), -1);
          VipUtils.a(localQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, new String[] { "0", "0", "msgHistory" });
          localObject2 = new Intent(getBaseActivity(), QQBrowserActivity.class);
          localObject1 = IndividuationUrlHelper.a("vipRoamChatCell");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            StringBuilder localStringBuilder;
            if (((String)localObject1).contains("?"))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("&ADTAG=msgHistory");
              localObject1 = localStringBuilder.toString();
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("?ADTAG=msgHistory");
              localObject1 = localStringBuilder.toString();
            }
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            startActivityForResult((Intent)localObject2, 2011);
            ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A0AE", "0X800A0AE", 0, 0, "", "", "", "");
          }
        }
        else
        {
          QQToast.makeText(BaseApplication.getContext(), 1, 2131915846, 1).show();
        }
      }
    }
    else
    {
      ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A17C", "0X800A17C", 2, 0, "", "", "", "");
      ChatSettingActivity.a(getBaseActivity().app, getBaseActivity(), this.d.b, this.d.a, new ChatHistoryC2CSettingFragment.1(this), 3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = new SessionInfo();
    paramBundle = getBaseActivity().getIntent().getExtras();
    this.d.b = paramBundle.getString("uin");
    this.d.a = paramBundle.getInt("uintype");
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment
 * JD-Core Version:    0.7.0.1
 */