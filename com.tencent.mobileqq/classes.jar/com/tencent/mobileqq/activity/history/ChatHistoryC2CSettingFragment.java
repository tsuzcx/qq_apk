package com.tencent.mobileqq.activity.history;

import ajsm;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import bdla;
import bhnp;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
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
  public int a;
  public SessionInfo a;
  FormSimpleItem a;
  FormSimpleItem b;
  
  private void a()
  {
    int i = getActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getActivity().app.getCurrentAccountUin(), 0);
    Object localObject = null;
    switch (i)
    {
    default: 
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        }
      }
      break;
    }
    while (!QLog.isColorLevel())
    {
      return;
      localObject = getResources().getString(2131716597);
      break;
      localObject = getResources().getString(2131716595);
      break;
      localObject = getResources().getString(2131716596);
      break;
      localObject = getResources().getString(2131716598);
      break;
      localObject = getResources().getString(2131716605);
      break;
    }
    QLog.d("Q.history.C2CSettingFragment", 2, "messge roam flag is error ,is : " + i);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, ChatHistoryC2CSettingFragment.class, paramInt2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131690773));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131364022));
    this.b = ((FormSimpleItem)this.mContentView.findViewById(2131363881));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public int getContentLayoutId()
  {
    return 2131558919;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      paramInt1 = getActivity().app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + getActivity().app.getCurrentAccountUin(), -1);
    } while (paramInt1 == this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = paramInt1;
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
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQAppInterface localQQAppInterface = getActivity().app;
        this.jdField_a_of_type_Int = localQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + localQQAppInterface.getCurrentAccountUin(), -1);
        VipUtils.a(localQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 1, 0, new String[] { "0", "0", "msgHistory" });
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        String str = bhnp.a("vipRoamChatCell");
        if (!TextUtils.isEmpty(str))
        {
          if (str.contains("?")) {}
          for (str = str + "&ADTAG=msgHistory";; str = str + "?ADTAG=msgHistory")
          {
            localIntent.putExtra("url", str);
            startActivityForResult(localIntent, 2011);
            bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A0AE", "0X800A0AE", 0, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        QQToast.a(BaseApplication.getContext(), 1, 2131718132, 1).a();
        continue;
        bdla.b(getActivity().app, "dc00898", "", "", "0X800A17C", "0X800A17C", 2, 0, "", "", "", "");
        ChatSettingActivity.a(getActivity().app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, new ajsm(this), 3);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    paramBundle = getActivity().getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin = paramBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = paramBundle.getInt("uintype");
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment
 * JD-Core Version:    0.7.0.1
 */