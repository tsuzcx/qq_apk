package com.tencent.mobileqq.activity.contacts.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController;
import com.tencent.mobileqq.activity.contacts.troopnotificationentry.TroopNotificationEntryController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.mobileqq.widget.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, INewFriendListener, CommonLoadingView.OnFirstDrawListener
{
  MqqHandler a = new MqqHandler(Looper.getMainLooper(), this);
  private int b;
  private boolean c = false;
  private LinearLayout d;
  private ImmersiveTitleBar2 e;
  private RelativeLayout f;
  private RelativeLayout g;
  private ImageView h;
  private TextView i;
  private RedTouch j;
  private RelativeLayout k;
  private ExtendFriendContactEntranceContainer l;
  private CTNewFriendEntryController m;
  private TroopNotificationEntryController n;
  private CommonLoadingView o;
  private ImageView p;
  private ContactsViewController q;
  private boolean r = false;
  private SearchBarAssistant s = null;
  private GameCenterObserver t = new Contacts.1(this);
  private NewFriendVerificationObserver u = new Contacts.2(this);
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUnreadCount|count = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", fromResume = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Tab.Contacts", 2, ((StringBuilder)localObject).toString());
    }
    if (this.m != null)
    {
      localObject = ((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).getAllUnreadMsg();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateUnreadCount|count = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", realcount = ");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append(", fromResume = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("Tab.Contacts", 2, localStringBuilder.toString());
      }
      this.m.a((List)localObject, paramBoolean ^ true, paramBoolean);
    }
    if (paramInt > 0)
    {
      localObject = this.q;
      if (localObject != null) {
        ((ContactsViewController)localObject).h();
      }
    }
    Object localObject = this.n;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).d();
    }
  }
  
  private void l()
  {
    if (this.b > 0) {
      return;
    }
    this.b = (P().getTitleBarHeight() - (int)DisplayUtils.a(P(), 5.0F));
    this.q.c();
    this.q.b(this.b);
    n();
    this.o = ((CommonLoadingView)this.d.findViewById(2131431148));
    this.o.setOnFirstDrawListener(this);
    this.p = ((ImageView)this.d.findViewById(2131431266));
    c(-1);
    m();
  }
  
  private void m()
  {
    View localView = this.d.findViewById(2131431253);
    this.s = new SearchBarAssistant((BaseActivity)P(), 2, localView);
    this.l = ((ExtendFriendContactEntranceContainer)localView.findViewById(2131432682));
    this.k = ((RelativeLayout)localView.findViewById(2131439213));
    this.m = new CTNewFriendEntryController(this.k, (QQAppInterface)this.aF);
    this.k.setOnClickListener(this);
    this.n = new TroopNotificationEntryController(localView, (QQAppInterface)this.aF, P());
    r();
  }
  
  private void n()
  {
    this.d = ((LinearLayout)d(2131431265));
    this.g = ((RelativeLayout)this.d.findViewById(2131445043));
    this.aH = ((QQBlurView)d(2131429596));
    this.h = ((ImageView)this.d.findViewById(2131436194));
    this.h.setVisibility(0);
    this.h.setContentDescription(HardCodeUtil.a(2131886199));
    this.h.setOnClickListener(this);
    this.j = new RedTouch(P(), this.h).c(21).e(10).a();
    this.i = ((TextView)this.d.findViewById(2131436227));
    this.i.setVisibility(0);
    a(this.i);
    this.e = ((ImmersiveTitleBar2)this.d.findViewById(2131447582));
    this.f = ((RelativeLayout)this.d.findViewById(2131446342));
    IphoneTitleBarActivity.setLayerType(this.g);
    IphoneTitleBarActivity.setLayerType(this.h);
    IphoneTitleBarActivity.setLayerType(this.e);
    a(this.aH, this.d);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.f, true);
      a(this.e, true);
      a(this.g, true);
      this.i.setTextColor(-1);
    }
    else
    {
      SimpleModeHelper.a(this, this.e, this.g, this.f);
      this.i.setTextColor(Q().getColorStateList(2131167990));
    }
    SimpleUIUtil.a(this.e, P().getWindow());
  }
  
  private void o()
  {
    this.aF.registObserver(this.t);
    ((QQAppInterface)this.aF).addObserver(this.u);
    ((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).addListener(this);
  }
  
  private void p()
  {
    this.aF.unRegistObserver(this.t);
    ((QQAppInterface)this.aF).removeObserver(this.u);
    ((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).removeListener(this);
  }
  
  private void q()
  {
    if (this.j != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101200");
      this.j.a(localAppInfo);
    }
  }
  
  private void r()
  {
    boolean bool = SimpleUIUtil.e();
    View localView = this.d.findViewById(2131431253);
    if (localView != null)
    {
      int i1 = AIOUtils.b(12.0F, Q());
      Object localObject1 = this.k;
      int i4 = 0;
      int i2;
      if (localObject1 != null)
      {
        localObject1 = (ViewGroup.MarginLayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        if (bool) {
          i2 = 0;
        } else {
          i2 = i1;
        }
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = i2;
      }
      localObject1 = localView.findViewById(2131446070);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
        if (bool) {
          i2 = 0;
        } else {
          i2 = i1;
        }
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = i2;
      }
      SimpleModeHelper.a(this.d, bool, i1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        i1 = 2130846400;
      } else {
        i1 = 2130846399;
      }
      Object localObject2 = localView.findViewById(2131432018);
      if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0)) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      ((View)localObject2).setBackgroundResource(i1);
      if (bool) {
        i3 = 0;
      } else {
        i3 = 8;
      }
      ((View)localObject2).setVisibility(i3);
      int i5 = 4;
      if (i2 != 0) {
        i3 = ((View)localObject2).getVisibility();
      } else {
        i3 = 4;
      }
      ((View)localObject2).setVisibility(i3);
      localObject1 = localView.findViewById(2131432019);
      ((View)localObject1).setBackgroundResource(i1);
      if (bool) {
        i3 = i4;
      } else {
        i3 = 8;
      }
      ((View)localObject1).setVisibility(i3);
      int i3 = i5;
      if (i2 != 0) {
        i3 = ((View)localObject1).getVisibility();
      }
      ((View)localObject1).setVisibility(i3);
      SimpleModeHelper.a(bool, localView, i1);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = LayoutInflater.from(P()).inflate(2131624543, null);
    this.q = new ContactsViewController(P());
    this.q.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void a()
  {
    super.a();
    l();
    o();
    ((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000)
    {
      if (paramInt2 == 0)
      {
        R();
        ((QQAppInterface)this.aF).exit(false);
      }
    }
    else if (paramInt1 == 1000000)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("bind phone suc requestCode: ");
        paramIntent.append(paramInt1);
        paramIntent.append(", src: ");
        paramIntent.append(12);
        QLog.i("BindMsgConstant", 2, paramIntent.toString());
      }
    }
    else if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      ((IPhoneContactService)this.aF.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.q.a(paramBoolean);
    a(((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount(), true);
    if (AppSetting.e)
    {
      this.i.setFocusable(true);
      localObject = e(2131891479);
      this.i.setContentDescription((CharSequence)localObject);
      P().setTitle(e(2131891479));
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).b();
    }
    q();
    ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
    ApngImage.playByTag(3);
    if (this.r)
    {
      this.r = false;
      this.q.j();
    }
    localObject = this.n;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).c();
    }
    localObject = this.l;
    if (localObject != null) {
      ((ExtendFriendContactEntranceContainer)localObject).a();
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    c(paramInt);
    a(this.aH, this.d);
    a(this.i);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      a(this.f, true);
      a(this.e, true);
      a(this.g, true);
      this.i.setTextColor(-1);
    }
    else
    {
      SimpleModeHelper.a(this, this.e, this.g, this.f);
      this.i.setTextColor(Q().getColorStateList(2131167990));
    }
    SimpleUIUtil.a(this.e, P().getWindow());
    r();
    BuddyListItem.c.clear();
    Object localObject = this.s;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).d();
    }
    localObject = this.l;
    if (localObject != null) {
      ((ExtendFriendContactEntranceContainer)localObject).d();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.aF != null)
    {
      o();
      this.q.a((QQAppInterface)this.aF);
      if ("0".equals(((QQAppInterface)this.aF).getCurrentAccountUin())) {
        return;
      }
      c(-1);
      this.m.a((QQAppInterface)this.aF);
      ((INewFriendService)this.aF.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
      Object localObject = this.s;
      if (localObject != null) {
        ((SearchBarAssistant)localObject).a((QQAppInterface)this.aF);
      }
      localObject = this.n;
      if (localObject != null) {
        ((TroopNotificationEntryController)localObject).a((QQAppInterface)this.aF, P());
      }
      localObject = this.l;
      if (localObject != null) {
        ((ExtendFriendContactEntranceContainer)localObject).a((QQAppInterface)this.aF);
      }
    }
  }
  
  public void bQ_()
  {
    ApngImage.pauseByTag(3);
    super.bQ_();
    this.q.d();
  }
  
  public void bR_() {}
  
  void c(int paramInt)
  {
    Object localObject = this.q;
    if (localObject != null) {
      ((ContactsViewController)localObject).a(paramInt);
    }
    if (this.p == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Tab.Contacts", 2, "setThemeDiyBgContacts mBgImageView == null");
      }
      return;
    }
    localObject = this.aF;
    ImageView localImageView = this.p;
    paramInt = 2130838959;
    ThemeBackground.a((AppRuntime)localObject, localImageView, 3, 2130838959, "-contacts-");
    localObject = this.d.findViewById(2131446666);
    if (localObject != null)
    {
      if (ThemeUtil.isDefaultTheme()) {
        paramInt = 2130839577;
      }
      ((View)localObject).setBackgroundResource(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void cx_()
  {
    super.cx_();
    if (!this.c) {
      return;
    }
    ContactsViewController localContactsViewController = this.q;
    if (localContactsViewController != null) {
      localContactsViewController.i();
    }
  }
  
  protected String cy_()
  {
    return P().getString(2131891479);
  }
  
  public boolean cz_()
  {
    return this.c;
  }
  
  protected void d()
  {
    super.d();
    Object localObject = this.s;
    if (localObject != null) {
      ((SearchBarAssistant)localObject).c();
    }
    this.q.e();
    this.a.removeCallbacksAndMessages(null);
    localObject = this.n;
    if (localObject != null) {
      ((TroopNotificationEntryController)localObject).b();
    }
    p();
    localObject = this.l;
    if (localObject != null) {
      ((ExtendFriendContactEntranceContainer)localObject).c();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 9528)
    {
      if (i1 != 9529) {
        return true;
      }
      paramMessage = this.q;
      if (paramMessage != null)
      {
        paramMessage.l();
        return true;
      }
    }
    else
    {
      this.o.setVisibility(8);
      if (!this.c) {
        a(true);
      }
      this.c = true;
      this.a.sendEmptyMessageDelayed(9529, 300L);
    }
    return true;
  }
  
  public void i()
  {
    this.a.sendEmptyMessage(9528);
  }
  
  public void i_(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void k()
  {
    p();
    ContactsViewController localContactsViewController = this.q;
    if (localContactsViewController != null) {
      localContactsViewController.f();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i1 = paramView.getId();
      if (i1 != 2131436194)
      {
        if (i1 == 2131439213)
        {
          this.m.a();
          ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(P(), null, 2);
        }
      }
      else
      {
        Intent localIntent = new Intent(P(), AddContactsActivity.class);
        localIntent.putExtra("entrence_data_report", 1);
        localIntent.putExtra("EntranceId", 3);
        a(localIntent);
        ReportController.b(this.aF, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
      }
    }
    try
    {
      ((IRedTouchManager)this.aF.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(String.valueOf(101200));
      label149:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.Contacts
 * JD-Core Version:    0.7.0.1
 */