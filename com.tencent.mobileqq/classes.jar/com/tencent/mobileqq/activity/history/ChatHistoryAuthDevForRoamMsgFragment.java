package com.tencent.mobileqq.activity.history;

import akaa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import anzj;
import apdn;
import bjbs;
import blha;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ChatHistoryAuthDevForRoamMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  Handler.Callback a;
  public bjbs a;
  
  public ChatHistoryAuthDevForRoamMsgFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new akaa(this);
  }
  
  private void a()
  {
    apdn localapdn = (apdn)getActivity().app.a(59);
    if (localapdn != null)
    {
      localapdn.a((short)1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "set_roam_message_auth_mode: 1");
      }
      this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.setCancelable(false);
      this.jdField_a_of_type_Bjbs.a(anzj.a(2131700550));
      if (!getActivity().isFinishing()) {
        this.jdField_a_of_type_Bjbs.show();
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), ChatHistoryAuthDevForRoamMsgFragment.class, paramInt);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131695702));
    this.mContentView.findViewById(2131380518).setOnClickListener(this);
    this.mContentView.findViewById(2131380521).setOnClickListener(this);
    paramLayoutInflater = new blha(this.jdField_a_of_type_AndroidOsHandler$Callback);
    getActivity().app.setHandler(getClass(), paramLayoutInflater);
    VipUtils.a(getActivity().app, "chat_history", "LockSet", "switch_devlock", 1, 0, new String[0]);
  }
  
  public int getContentLayoutId()
  {
    return 2131561954;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "not verify passwd");
      }
      getActivity().setResult(0);
      getActivity().finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "verify passwd ok ");
    }
    a();
  }
  
  public boolean onBackEvent()
  {
    getActivity().setResult(0);
    boolean bool = super.onBackEvent();
    getActivity().overridePendingTransition(2130771977, 2130771978);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380518)
    {
      this.mContentView.findViewById(2131380518).setEnabled(false);
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "switch_devlock"));
      VipUtils.a(getActivity().app, "chat_history", "LockSet", "Clk_usedevlock", 1, 0, new String[0]);
      startActivityForResult(localIntent, 10000);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131380521)
      {
        VipUtils.a(getActivity().app, "chat_history", "LockSet", "Clk_PswUse", 2, 0, new String[0]);
        getActivity().setResult(0);
        getActivity().finish();
      }
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771977, 2130771978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment
 * JD-Core Version:    0.7.0.1
 */