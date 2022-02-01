package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.biz.INotifyMsg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class QQNotifySettingBaseFragment
  extends PublicBaseFragment
  implements View.OnClickListener, INotifyMsg
{
  public static final int a = WebViewUtil.a("qw_mix") << 8;
  private static final String k = "QQNotifySettingBaseFragment";
  protected View b;
  protected TextView c;
  protected TextView d;
  protected Button e;
  protected CheckBox f;
  protected boolean g;
  boolean h;
  protected int i = 9;
  protected String j = "user cancel";
  private final Handler l = new Handler(Looper.getMainLooper());
  private QQNotifyLoadingDialog m;
  private IQQReminderDataService n;
  private CalendarEntity o;
  private String p;
  private String q;
  private String r;
  private FakeUrl s;
  
  private CalendarEntity b(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    CalendarEntity localCalendarEntity = new CalendarEntity();
    localCalendarEntity.content = "";
    localCalendarEntity.msg_id = this.p;
    localCalendarEntity.notice_time = paramAcsGetMsgRsp.notice_time;
    localCalendarEntity.title = paramAcsGetMsgRsp.title;
    localCalendarEntity.jump_url = paramAcsGetMsgRsp.jump_url;
    return localCalendarEntity;
  }
  
  private QQAppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void d()
  {
    IQQReminderService localIQQReminderService = (IQQReminderService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendGetMsgs(this.p, this.r, new QQNotifySettingBaseFragment.1(this));
  }
  
  private void e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    IQQReminderService localIQQReminderService = (IQQReminderService)localQQAppInterface.getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendSubscribeReminder(this.p, this.r, new QQNotifySettingBaseFragment.2(this, localQQAppInterface));
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected void a(int paramInt, String paramString)
  {
    if (getBaseActivity() != null)
    {
      c(paramInt, paramString);
      getBaseActivity().finish();
    }
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    if (paramAcsGetMsgRsp != null) {
      if (paramAcsGetMsgRsp.ret_code == 0)
      {
        this.c.setText(paramAcsGetMsgRsp.content);
        long l1 = paramAcsGetMsgRsp.notice_time;
        if (l1 == 0L) {
          this.d.setText(HardCodeUtil.a(2131908214));
        } else {
          this.d.setText(DateUtil.a(l1 * 1000L, "yyyy-MM-dd HH:mm:ss"));
        }
        this.e.setEnabled(true);
        int i1;
        if (paramAcsGetMsgRsp.calendar == 1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        paramAcsGetMsgRsp = this.f;
        if ((paramAcsGetMsgRsp != null) && (i1 != 0) && (this.h))
        {
          paramAcsGetMsgRsp.setVisibility(0);
          this.f.setChecked(true);
        }
      }
      else
      {
        b();
        this.e.setEnabled(false);
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a(this.i, this.j);
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.h = ((IQQReminderCalendarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).isCalendarOpen(getActivity());
    this.m = new QQNotifyLoadingDialog(getBaseActivity());
    this.m.show();
    this.s = new FakeUrl();
    this.s.init(getBaseActivity());
    d();
    MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "1", 100, this.p, "15", 1);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429840)
    {
      if (i1 == 2131430021)
      {
        String str = (String)paramView.getTag();
        if ("0".equals(str))
        {
          QQNotifyHelper.a(c(), "open_click", this.q, this.p, null, null);
          e();
        }
        else if ("1".equals(str))
        {
          a(this.i, this.j);
        }
      }
    }
    else
    {
      QQNotifyHelper.a(c(), "pending_click", this.q, this.p, null, null);
      a(this.i, this.j);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = a(paramLayoutInflater, paramViewGroup);
    new ImmersionBar(getBaseActivity(), 0, this.b.findViewById(2131446325));
    this.c = ((TextView)this.b.findViewById(2131448617));
    this.d = ((TextView)this.b.findViewById(2131448618));
    this.f = ((CheckBox)this.b.findViewById(2131430666));
    this.e = ((Button)this.b.findViewById(2131430021));
    this.e.setOnClickListener(this);
    this.p = getArguments().getString("key_msgid");
    this.q = getArguments().getString("key_busid");
    this.r = getArguments().getString("key_domain");
    this.n = ((IQQReminderDataService)c().getRuntimeService(IQQReminderDataService.class, ""));
    QQNotifyHelper.a(c(), "authorizepage_exp", this.q, this.p, null, null);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.m;
    if ((localObject != null) && (((QQNotifyLoadingDialog)localObject).isShowing())) {
      this.m.dismiss();
    }
    localObject = this.l;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
 * JD-Core Version:    0.7.0.1
 */