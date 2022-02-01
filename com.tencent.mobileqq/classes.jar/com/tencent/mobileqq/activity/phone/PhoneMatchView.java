package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;

@SuppressLint({"ViewConstructor"})
public class PhoneMatchView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener
{
  ContactBindObserver l;
  private Button m;
  private Handler n = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  public PhoneMatchView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2131624973, true);
  }
  
  private void k()
  {
    if (!NetworkUtil.isNetSupport(getContext()))
    {
      b(2131892157);
      return;
    }
    PhoneMatchView.1 local1 = new PhoneMatchView.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.b, new DenyRunnable.JumpSettingAction(this.a));
    PermissionChecker.a(this.b, local1, localDenyRunnable);
  }
  
  protected void a()
  {
    super.a();
    this.h.setText(HardCodeUtil.a(2131905826));
    if (this.c == 2)
    {
      this.g.setVisibility(4);
      this.g.setText(2131892520);
      return;
    }
    if (this.c == 3)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        a(paramIntent);
        return;
      }
      a(new Intent(getContext(), PhoneLaunchActivity.class));
      return;
    }
    if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if ((((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) && ((getContext() instanceof Activity)))
      {
        paramIntent = (Activity)getContext();
        ContactBindedActivity.a(this.a, -1, 2, null);
        paramIntent.setResult(-1);
        paramIntent.finish();
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    paramPhoneInnerFrame = ((INewFriendApi)QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
    String str;
    if (PermissionChecker.a().d())
    {
      str = paramPhoneInnerFrame.d.a;
      paramIntent = paramPhoneInnerFrame.d.b;
      paramPhoneInnerFrame = paramPhoneInnerFrame.d.c;
    }
    else
    {
      str = paramPhoneInnerFrame.c.a;
      paramIntent = paramPhoneInnerFrame.c.b;
      paramPhoneInnerFrame = paramPhoneInnerFrame.c.c;
    }
    ((TextView)a(2131431259)).setText(str);
    ((TextView)a(2131431258)).setText(paramIntent);
    this.m = ((Button)a(2131431256));
    this.m.setOnClickListener(this);
    this.m.setText(paramPhoneInnerFrame);
    paramIntent = a(2131436854);
    if ((paramIntent != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramIntent.setBackgroundResource(2130839577);
    } else if (paramIntent != null) {
      paramIntent.setBackgroundResource(2130838958);
    }
    PhoneContactUtils.a(this.a, getResources(), (ImageView)a(2131431257));
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("PhoneMatchView", 2, String.format("onUploadResult [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    this.n.removeMessages(0);
    if (this.l != null)
    {
      this.a.unRegistObserver(this.l);
      this.l = null;
    }
    h();
    if (paramBoolean) {
      a(new Intent(getContext(), ContactListView.class));
    }
    if (paramBoolean) {
      paramString = HardCodeUtil.a(2131905828);
    } else {
      paramString = HardCodeUtil.a(2131905829);
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramInt = i;
    if (paramBoolean) {
      paramInt = 2;
    }
    QQToast.makeText(localBaseApplication, paramInt, paramString, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
  }
  
  protected void d()
  {
    if (this.l != null)
    {
      this.a.unRegistObserver(this.l);
      this.l = null;
    }
    super.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = ((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
      if ((i != 2) && (i != 4) && (i != 9) && (i != 8))
      {
        a(false, -1, "MSG_TIME_OUT");
        return true;
      }
      a(true, 0, "MSG_TIME_OUT");
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.m) {
      k();
    } else {
      a(new Intent(getContext(), SettingActivity2.class), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */