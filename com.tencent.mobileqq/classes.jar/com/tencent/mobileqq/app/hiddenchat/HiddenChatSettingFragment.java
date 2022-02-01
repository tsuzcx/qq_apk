package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class HiddenChatSettingFragment
  extends IphoneTitleBarFragment
  implements CompoundButton.OnCheckedChangeListener
{
  private QQAppInterface a;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private CardObserver d = new HiddenChatSettingFragment.1(this);
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, HiddenChatSettingFragment.class, paramInt);
  }
  
  private void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.a = ((QQAppInterface)getBaseActivity().getAppRuntime());
      this.b = ((FormSwitchItem)this.mContentView.findViewById(2131442490));
      this.c = ((FormSwitchItem)this.mContentView.findViewById(2131442492));
      this.a.addObserver(this.d);
      boolean bool = HiddenChatUtil.a(this.a.getCurrentUin(), getBaseActivity());
      a(this.b, bool);
      bool = HiddenChatUtil.b(this.a.getCurrentUin(), getBaseActivity());
      a(this.c, bool);
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131629156;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    int i;
    if (paramCompoundButton == this.b.getSwitch())
    {
      ((CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean, 42318);
      localQQAppInterface = getBaseActivity().app;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A34C", "0X800A34C", i, 0, "0", "0", "", "");
    }
    else if (paramCompoundButton == this.c.getSwitch())
    {
      ((CardHandler)this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(paramBoolean, 42319);
      localQQAppInterface = getBaseActivity().app;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A350", "0X800A350", i, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131916361));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.removeObserver(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */