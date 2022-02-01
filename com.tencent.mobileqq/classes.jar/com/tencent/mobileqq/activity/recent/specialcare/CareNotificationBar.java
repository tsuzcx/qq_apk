package com.tencent.mobileqq.activity.recent.specialcare;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerListener;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.util.notification.NotifyIdManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class CareNotificationBar
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static int a = AIOUtils.b(57.0F, BaseApplicationImpl.getApplication().getResources());
  private final Conversation b;
  private final FPSSwipListView c;
  private final BannerListener d;
  private ViewStub e;
  private volatile View f;
  private TextView g;
  private URLImageView h;
  private TranslateAnimation i;
  private TranslateAnimation j;
  private AtomicBoolean k = new AtomicBoolean(false);
  private WeakReferenceHandler l;
  private volatile int m;
  private volatile int n;
  private int o;
  private AtomicBoolean p = new AtomicBoolean(false);
  
  public CareNotificationBar(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.b = paramConversation;
    this.l = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.e = ((ViewStub)paramViewGroup.findViewById(2131444390));
    this.c = ((FPSSwipListView)paramViewGroup.findViewById(2131444377));
    n();
    d();
    this.d = new CareNotificationBar.1(this);
    BannerManager.a().a(this.b.s(), this.d);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = this.b.am;
    if ((paramInt1 == 0) && (paramInt2 > 0)) {
      this.b.am = 100;
    } else if ((paramInt1 > 0) && (paramInt2 == 0)) {
      this.b.am = 17;
    } else if ((paramInt1 > 0) && (this.m == 0)) {
      this.b.am = 17;
    }
    if (i1 != this.b.am) {
      this.b.ao = -1;
    }
  }
  
  private int b(Object paramObject)
  {
    if (c(paramObject)) {
      return 17;
    }
    if (d(paramObject)) {
      return 100;
    }
    return -1;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.m != paramInt1)
    {
      this.m = paramInt1;
      if ((paramInt1 > 0) && (!this.p.get()))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
        this.p.compareAndSet(false, true);
        if (QLog.isColorLevel()) {
          QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
        }
      }
      else if (paramInt1 == 0)
      {
        this.p.set(false);
      }
    }
    if (this.n != paramInt2)
    {
      this.n = paramInt2;
      if (paramInt2 == 0)
      {
        this.o = 0;
        return;
      }
      if (paramInt1 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      if (paramInt1 != this.o)
      {
        this.o = paramInt1;
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", paramInt1, 1, 0, "", "", "", "");
      }
    }
  }
  
  private boolean c(Object paramObject)
  {
    boolean bool2 = NotifyIdManager.a();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject1 = (RecentBaseData)paramObject;
    if (((RecentBaseData)localObject1).isUnreadMsgNumInTabNum()) {
      i1 = ((RecentBaseData)localObject1).getUnreadNum();
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return false;
    }
    if ((paramObject instanceof RecentUserBaseData))
    {
      localObject1 = (RecentUserBaseData)paramObject;
      Object localObject2 = ((RecentUserBaseData)localObject1).mUser;
      if (localObject2 != null)
      {
        String str = ((RecentUser)localObject2).uin;
        localObject2 = ((RecentUser)localObject2).msg;
        if ((localObject2 instanceof TroopSpecialAttentionMsg))
        {
          i1 = 1;
          break label116;
        }
        if ((localObject2 instanceof TroopAtMsg)) {
          ((TroopAtMsg)localObject2).c();
        }
      }
      i1 = 0;
      label116:
      bool2 = BaseApplicationImpl.getContext().getResources().getString(2131897589).equals(((RecentUserBaseData)localObject1).mContentDesc);
      if ((i1 != 0) || (bool2))
      {
        i1 = 1;
        break label153;
      }
    }
    int i1 = 0;
    label153:
    if ((i1 != 0) || (a(paramObject))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean d(Object paramObject)
  {
    if ((paramObject instanceof RecentUserBaseData))
    {
      paramObject = (RecentUserBaseData)paramObject;
      if (paramObject.mUser.getType() == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface))
        {
          paramObject = ((TroopAioNavigateBarManager)localAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).b(paramObject.mUser.uin, 100);
          if ((paramObject != null) && (paramObject.size() > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void k()
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "show: invoked. ");
    }
    i();
    if ((bool) || (this.f.getVisibility() == 8))
    {
      this.f.clearAnimation();
      this.f.startAnimation(this.i);
      this.f.setVisibility(0);
    }
  }
  
  private boolean l()
  {
    boolean bool;
    if ((!NotifyIdManager.a()) && (this.b.am == 17)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 2, new Object[] { "needHideWhenCurrentTypeSpCared: invoked. careBar setting disabled", " hide: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private void m()
  {
    CareNotificationBar.4 local4 = new CareNotificationBar.4(this);
    this.l.post(local4);
  }
  
  private void n()
  {
    this.i = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.i.setDuration(300L);
    this.i.setAnimationListener(this);
    this.j = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.j.setDuration(300L);
    this.j.setAnimationListener(this);
  }
  
  private boolean o()
  {
    if (this.b.aa != null) {
      return this.b.aa.z();
    }
    return false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "hide: invoked. ");
    }
    CareNotificationBar.2 local2 = new CareNotificationBar.2(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local2.run();
      return;
    }
    this.l.post(local2);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.l.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      i2 = 872415231;
      i1 = 1381653;
    }
    else
    {
      i2 = 335743002;
      i1 = 11580351;
    }
    if (paramView.getTag(2131443128) == null)
    {
      paramView.setTag(2131443128, paramView.getBackground());
      paramView.post(new CareNotificationBar.3(this, paramView, i1, i2));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 4, new Object[] { "setMiniAppVisible: invoked. ", " visible: ", Boolean.valueOf(paramBoolean) });
    }
    this.k.set(paramBoolean);
  }
  
  public boolean a(RecentAdapter paramRecentAdapter)
  {
    int i1 = 0;
    while (i1 < 2)
    {
      for (;;)
      {
        int i4 = paramRecentAdapter.getCount();
        int i2 = this.b.ao + 1;
        while (i2 < i4)
        {
          localObject = paramRecentAdapter.getItem(i2);
          if ((localObject instanceof RecentBaseData))
          {
            if (this.b.am == 17)
            {
              if (b(localObject) != 17) {}
            }
            else {
              while ((this.b.am == 100) && (b(localObject) == 100))
              {
                i3 = 1;
                break;
              }
            }
            int i3 = 0;
            if (i3 != 0)
            {
              this.b.ao = i2;
              return true;
            }
          }
          i2 += 1;
        }
        Object localObject = this.b;
        ((Conversation)localObject).ao = -1;
        if (((Conversation)localObject).am != 17) {
          break;
        }
        this.b.am = 100;
      }
      this.b.am = 17;
      i1 += 1;
    }
    return false;
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool3 = paramObject instanceof RecentUserBaseData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (RecentUserBaseData)paramObject;
      String str = paramObject.getRecentUserUin();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((QQAppInterface)localObject).getCurrentUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(str);
        bool1 = QvipSpecialCareUtil.a(localStringBuilder.toString());
      }
      else
      {
        bool1 = false;
      }
      bool3 = BaseApplicationImpl.getContext().getResources().getString(2131914367).equals(paramObject.mMsgExtroInfo);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    return this.k.get();
  }
  
  public boolean c()
  {
    if (this.f == null)
    {
      this.f = this.e.inflate();
      this.g = ((TextView)this.f.findViewById(2131444393));
      this.h = ((URLImageView)this.f.findViewById(2131444392));
      this.f.setOnClickListener(this);
      g();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (!this.b.an) {
      return;
    }
    if (this.k.get())
    {
      QLog.e("CareNotificationBar", 1, "refresh: miniApp is visible.");
      a();
      return;
    }
    RecentAdapter localRecentAdapter = this.b.K();
    int i2 = 0;
    int i3 = 0;
    int i5;
    for (int i1 = 0; i2 < localRecentAdapter.getCount(); i1 = i5)
    {
      Object localObject = localRecentAdapter.getItem(i2);
      int i4 = i3;
      i5 = i1;
      if ((localObject instanceof RecentBaseData))
      {
        int i6 = b(localObject);
        if (i6 == 17)
        {
          i4 = i3 + 1;
          i5 = i1;
        }
        else
        {
          i4 = i3;
          i5 = i1;
          if (i6 == 100)
          {
            i5 = i1 + 1;
            i4 = i3;
          }
        }
      }
      i2 += 1;
      i3 = i4;
    }
    a(i3, i1);
    if (l())
    {
      a();
      return;
    }
    b(i3, i1);
    QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(i3), " keyword=", Integer.valueOf(i1) });
    m();
  }
  
  public void e()
  {
    String str;
    int i1;
    if (this.b.am == 17)
    {
      str = this.g.getResources().getString(2131914368, new Object[] { Integer.valueOf(this.m) });
      i1 = 2130839730;
    }
    else
    {
      str = this.g.getResources().getString(2131897527, new Object[] { Integer.valueOf(this.n) });
      i1 = 2130849362;
    }
    this.g.setText(str);
    this.g.setContentDescription(str);
    this.h.setImageResource(i1);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!NotifyIdManager.a()) {
      a();
    }
  }
  
  public void g()
  {
    if (this.f == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.f.findViewById(2131444389);
    TextView localTextView = (TextView)this.f.findViewById(2131444393);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130851561);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130853320);
  }
  
  public void h()
  {
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    if (this.f != null)
    {
      int i2 = this.c.getHeaderViewsCount() - 1;
      int i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      float f1 = BaseApplication.context.getResources().getDimension(2131299248);
      int i3 = (int)(a + i1 * f1);
      i2 = i3;
      if (o()) {
        i2 = i3 + ViewUtils.dip2px(55.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, new Object[] { "updateTopMargin: invoked. ", " bannerViewsCount: ", Integer.valueOf(i1), " margin=", Integer.valueOf(i2), " sContainerMarginTop=", Integer.valueOf(a), " tipsbarHeight=", Float.valueOf(f1) });
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      if (localLayoutParams.topMargin != i2)
      {
        localLayoutParams.topMargin = i2;
        if (this.f.getVisibility() != 8) {
          this.f.requestLayout();
        }
      }
    }
  }
  
  public void j()
  {
    BannerManager.a().b(this.b.s(), this.d);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131444389)
    {
      this.b.N();
      if (this.n > 0) {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.o, 1, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar
 * JD-Core Version:    0.7.0.1
 */