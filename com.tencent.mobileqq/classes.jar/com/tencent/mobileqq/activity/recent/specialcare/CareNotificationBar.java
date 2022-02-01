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
  public static int a;
  private volatile View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private final BannerListener jdField_a_of_type_ComTencentMobileqqBannerBannerListener;
  private final FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int jdField_b_of_type_Int;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = AIOUtils.b(57.0F, BaseApplicationImpl.getApplication().getResources());
  }
  
  public CareNotificationBar(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramViewGroup.findViewById(2131376184));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)paramViewGroup.findViewById(2131376171));
    k();
    b();
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerListener = new CareNotificationBar.1(this);
    BannerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqBannerBannerListener);
  }
  
  private int a(Object paramObject)
  {
    if (b(paramObject)) {
      return 17;
    }
    if (c(paramObject)) {
      return 100;
    }
    return -1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f;
    if ((paramInt1 == 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 100;
    } else if ((paramInt1 > 0) && (paramInt2 == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
    } else if ((paramInt1 > 0) && (this.jdField_b_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
    }
    if (i != this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g = -1;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Int != paramInt1)
    {
      this.jdField_b_of_type_Int = paramInt1;
      if ((paramInt1 > 0) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
        if (QLog.isColorLevel()) {
          QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
        }
      }
      else if (paramInt1 == 0)
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
    }
    if (this.c != paramInt2)
    {
      this.c = paramInt2;
      if (paramInt2 == 0)
      {
        this.d = 0;
        return;
      }
      if (paramInt1 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      if (paramInt1 != this.d)
      {
        this.d = paramInt1;
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", paramInt1, 1, 0, "", "", "", "");
      }
    }
  }
  
  private boolean b(Object paramObject)
  {
    boolean bool2 = NotifyIdManager.a();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    Object localObject1 = (RecentBaseData)paramObject;
    if (((RecentBaseData)localObject1).isUnreadMsgNumInTabNum()) {
      i = ((RecentBaseData)localObject1).getUnreadNum();
    } else {
      i = 0;
    }
    if (i == 0) {
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
          i = 1;
          break label116;
        }
        if ((localObject2 instanceof TroopAtMsg)) {
          ((TroopAtMsg)localObject2).a();
        }
      }
      i = 0;
      label116:
      bool2 = BaseApplicationImpl.getContext().getResources().getString(2131699558).equals(((RecentUserBaseData)localObject1).mContentDesc);
      if ((i != 0) || (bool2))
      {
        i = 1;
        break label153;
      }
    }
    int i = 0;
    label153:
    if ((i != 0) || (a(paramObject))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean c()
  {
    boolean bool;
    if ((!NotifyIdManager.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 2, new Object[] { "needHideWhenCurrentTypeSpCared: invoked. careBar setting disabled", " hide: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  private boolean c(Object paramObject)
  {
    if ((paramObject instanceof RecentUserBaseData))
    {
      paramObject = (RecentUserBaseData)paramObject;
      if (paramObject.mUser.getType() == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface))
        {
          paramObject = ((TroopAioNavigateBarManager)localAppRuntime.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a(paramObject.mUser.uin, 100);
          if ((paramObject != null) && (paramObject.size() > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.d();
    }
    return false;
  }
  
  private void i()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "show: invoked. ");
    }
    g();
    if ((bool) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void j()
  {
    CareNotificationBar.4 local4 = new CareNotificationBar.4(this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(local4);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
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
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(local2);
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j;
    int i;
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      j = 872415231;
      i = 1381653;
    }
    else
    {
      j = 335743002;
      i = 11580351;
    }
    if (paramView.getTag(2131374943) == null)
    {
      paramView.setTag(2131374943, paramView.getBackground());
      paramView.post(new CareNotificationBar.3(this, paramView, i, j));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 4, new Object[] { "setMiniAppVisible: invoked. ", " visible: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean a(RecentAdapter paramRecentAdapter)
  {
    int i = 0;
    while (i < 2)
    {
      for (;;)
      {
        int m = paramRecentAdapter.getCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g + 1;
        while (j < m)
        {
          localObject = paramRecentAdapter.getItem(j);
          if ((localObject instanceof RecentBaseData))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)
            {
              if (a(localObject) != 17) {}
            }
            else {
              while ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 100) && (a(localObject) == 100))
              {
                k = 1;
                break;
              }
            }
            int k = 0;
            if (k != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.g = j;
              return true;
            }
          }
          j += 1;
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
        ((Conversation)localObject).g = -1;
        if (((Conversation)localObject).f != 17) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 100;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f = 17;
      i += 1;
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
      bool3 = BaseApplicationImpl.getContext().getResources().getString(2131716894).equals(paramObject.mMsgExtroInfo);
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
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.q) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.e("CareNotificationBar", 1, "refresh: miniApp is visible.");
      a();
      return;
    }
    RecentAdapter localRecentAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    int j = 0;
    int k = 0;
    int n;
    for (int i = 0; j < localRecentAdapter.getCount(); i = n)
    {
      Object localObject = localRecentAdapter.getItem(j);
      int m = k;
      n = i;
      if ((localObject instanceof RecentBaseData))
      {
        int i1 = a(localObject);
        if (i1 == 17)
        {
          m = k + 1;
          n = i;
        }
        else
        {
          m = k;
          n = i;
          if (i1 == 100)
          {
            n = i + 1;
            m = k;
          }
        }
      }
      j += 1;
      k = m;
    }
    a(k, i);
    if (c())
    {
      a();
      return;
    }
    b(k, i);
    QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(k), " keyword=", Integer.valueOf(i) });
    j();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376187));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376186));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      e();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    String str;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.f == 17)
    {
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131716895, new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
      i = 2130839532;
    }
    else
    {
      str = this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131699496, new Object[] { Integer.valueOf(this.c) });
      i = 2130847702;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(i);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!NotifyIdManager.a()) {
      a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376183);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376187);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130849854);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130851085);
  }
  
  public void f()
  {
    b();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.getHeaderViewsCount() - 1;
      int i = j;
      if (j < 0) {
        i = 0;
      }
      float f = BaseApplication.context.getResources().getDimension(2131298534);
      int k = (int)(jdField_a_of_type_Int + i * f);
      j = k;
      if (d()) {
        j = k + ViewUtils.a(55.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CareNotificationBar", 2, new Object[] { "updateTopMargin: invoked. ", " bannerViewsCount: ", Integer.valueOf(i), " margin=", Integer.valueOf(j), " sContainerMarginTop=", Integer.valueOf(jdField_a_of_type_Int), " tipsbarHeight=", Float.valueOf(f) });
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (localLayoutParams.topMargin != j)
      {
        localLayoutParams.topMargin = j;
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
          this.jdField_a_of_type_AndroidViewView.requestLayout();
        }
      }
    }
  }
  
  public void h()
  {
    BannerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqBannerBannerListener);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131376183)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.z();
      if (this.c > 0) {
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.d, 1, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar
 * JD-Core Version:    0.7.0.1
 */