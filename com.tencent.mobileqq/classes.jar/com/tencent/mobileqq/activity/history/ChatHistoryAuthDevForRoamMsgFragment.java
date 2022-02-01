package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;

public class ChatHistoryAuthDevForRoamMsgFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ChatHistoryAuthDevForRoamMsgFragment.1(this);
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  private void a()
  {
    MessageRoamHandler localMessageRoamHandler = (MessageRoamHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
    if (localMessageRoamHandler != null)
    {
      localMessageRoamHandler.a((short)1);
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "set_roam_message_auth_mode: 1");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701851));
      if (!getBaseActivity().isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    PublicFragmentActivity.a(paramActivity, new Intent(), ChatHistoryAuthDevForRoamMsgFragment.class, paramInt);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(getString(2131696362));
    this.mContentView.findViewById(2131380289).setOnClickListener(this);
    this.mContentView.findViewById(2131380292).setOnClickListener(this);
    paramLayoutInflater = new MqqWeakReferenceHandler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    getBaseActivity().app.setHandler(getClass(), paramLayoutInflater);
    VipUtils.a(getBaseActivity().app, "chat_history", "LockSet", "switch_devlock", 1, 0, new String[0]);
  }
  
  protected int getContentLayoutId()
  {
    return 2131561865;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 10000) {
      return;
    }
    if (paramInt2 == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "not verify passwd");
      }
      getBaseActivity().setResult(0);
      getBaseActivity().finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryAuthDevForRoamMsgFragment", 2, "verify passwd ok ");
    }
    a();
  }
  
  public boolean onBackEvent()
  {
    getBaseActivity().setResult(0);
    boolean bool = super.onBackEvent();
    getBaseActivity().overridePendingTransition(2130771991, 2130771992);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380289)
    {
      this.mContentView.findViewById(2131380289).setEnabled(false);
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "switch_devlock"));
      VipUtils.a(getBaseActivity().app, "chat_history", "LockSet", "Clk_usedevlock", 1, 0, new String[0]);
      startActivityForResult(localIntent, 10000);
    }
    else if (paramView.getId() == 2131380292)
    {
      VipUtils.a(getBaseActivity().app, "chat_history", "LockSet", "Clk_PswUse", 2, 0, new String[0]);
      getBaseActivity().setResult(0);
      getBaseActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(2130771991, 2130771992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment
 * JD-Core Version:    0.7.0.1
 */