package com.tencent.mobileqq.activity.history;

import ahto;
import alpo;
import ammr;
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
import bepp;
import bhoe;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

public class ChatHistoryAuthDevForRoamMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  Handler.Callback a;
  public bepp a;
  
  public ChatHistoryAuthDevForRoamMsgFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ahto(this);
  }
  
  private void a()
  {
    ammr localammr = (ammr)getActivity().app.a(59);
    if (localammr != null)
    {
      localammr.a((short)1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "set_roam_message_auth_mode: 1");
      }
      this.jdField_a_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_a_of_type_Bepp.setCancelable(false);
      this.jdField_a_of_type_Bepp.a(alpo.a(2131702011));
      if (!getActivity().isFinishing()) {
        this.jdField_a_of_type_Bepp.show();
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
    setTitle(getString(2131696835));
    this.mContentView.findViewById(2131379348).setOnClickListener(this);
    this.mContentView.findViewById(2131379351).setOnClickListener(this);
    paramLayoutInflater = new bhoe(this.jdField_a_of_type_AndroidOsHandler$Callback);
    getActivity().app.setHandler(getClass(), paramLayoutInflater);
    VipUtils.a(getActivity().app, "chat_history", "LockSet", "switch_devlock", 1, 0, new String[0]);
  }
  
  public int getContentLayoutId()
  {
    return 2131561659;
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
    if (paramView.getId() == 2131379348)
    {
      this.mContentView.findViewById(2131379348).setEnabled(false);
      paramView = new Intent(getActivity(), QQBrowserActivity.class);
      paramView.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "switch_devlock"));
      VipUtils.a(getActivity().app, "chat_history", "LockSet", "Clk_usedevlock", 1, 0, new String[0]);
      startActivityForResult(paramView, 10000);
    }
    while (paramView.getId() != 2131379351) {
      return;
    }
    VipUtils.a(getActivity().app, "chat_history", "LockSet", "Clk_PswUse", 2, 0, new String[0]);
    getActivity().setResult(0);
    getActivity().finish();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771977, 2130771978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment
 * JD-Core Version:    0.7.0.1
 */