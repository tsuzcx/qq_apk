package com.tencent.mobileqq.armap;

import abck;
import abcl;
import abcm;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.ConversationActiveListViewListener;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ConversationARMap
  extends ConversationPullDownActiveBase
{
  public int a;
  private ARMapShuaMsgView jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView;
  private ARMapSplashView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView;
  public ARMapHongBaoListView.ConversationActiveListViewListener a;
  public Runnable a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  private int h;
  private int i;
  private int j = -1;
  private int k = -1;
  private boolean m = true;
  private boolean n;
  private boolean o = true;
  
  public ConversationARMap(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    super(paramConversation, paramViewGroup);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener = new abcl(this);
    this.jdField_a_of_type_JavaLangRunnable = new abcm(this);
    this.jdField_i_of_type_Int = -1;
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "switch2Prepare, mState：" + this.jdField_a_of_type_Int + "  isCurfew:" + paramBoolean + "  mIsInCurfew:" + this.n);
    }
    this.n = paramBoolean;
    if ((this.jdField_a_of_type_Int != 2) || (this.n != paramBoolean))
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setVisibility(0);
      if (!paramBoolean) {
        break label115;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodType(0);
    }
    for (;;)
    {
      this.n = paramBoolean;
      return;
      label115:
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodType(2);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "switch2Formal, mState：" + this.jdField_a_of_type_Int + "  isCurfew:" + paramBoolean + "  mIsInCurfew:" + this.n);
    }
    if ((this.jdField_a_of_type_Int != 3) || (this.n != paramBoolean))
    {
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setVisibility(0);
      if (!paramBoolean) {
        break label110;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodType(0);
    }
    for (;;)
    {
      this.n = paramBoolean;
      return;
      label110:
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodType(1);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "stopPreGuide  mState:" + this.jdField_a_of_type_Int + "  pendanting:" + this.jdField_e_of_type_Boolean + "  breathing:" + this.jdField_d_of_type_Boolean);
    }
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h();
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "doJumpToMain mState:" + this.jdField_a_of_type_Int + ", isDoingJumpAnimation:" + this.jdField_a_of_type_Boolean + ", mResume:" + this.jdField_c_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.b();
    }
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(false);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_d_of_type_Int <= 0) {
      i();
    }
    c(-this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2004);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 400L);
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "JumpToARMapMainRunnable run, mState:" + this.jdField_a_of_type_Int + ", isDoingJumpAnimation:" + this.jdField_a_of_type_Boolean + ", mResume:" + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar.b();
    }
    s();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.a(new abck(this));
    }
  }
  
  private void t()
  {
    int i2;
    int i3;
    int i1;
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363964));
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363972));
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase = this;
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().heightPixels;
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().widthPixels;
      if (i2 > i3)
      {
        i1 = i2;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          break label762;
        }
        i1 -= ImmersiveUtils.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    label172:
    label762:
    for (;;)
    {
      this.h = i1;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Int = (i1 * 57 / 100);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
      if ((localObject == null) || (((View)localObject).getBottom() - ((View)localObject).getTop() == 0))
      {
        this.jdField_f_of_type_Int = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        this.jdField_b_of_type_Int = AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131559584) - this.jdField_f_of_type_Int) / 2);
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_f_of_type_Int = this.jdField_c_of_type_Int;
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getHeight();
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getWidth();
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = ((BreathEffectView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363979));
        SplashBitmapUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView = new ARMapSplashView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setSplashMode(1);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setWealthGodOffset(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView = new ARMapShuaMsgView(this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.a(this);
        localObject = new FrameLayout.LayoutParams(-1, i1);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView);
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setPadding(0, this.jdField_f_of_type_Int, 0, 0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView);
        this.jdField_a_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.d("ConversationARMap", 2, "ensureInit mListViewHeight:" + this.jdField_d_of_type_Int + " mListViewWidth:" + this.jdField_e_of_type_Int + " mBackgroundBannerHeight:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Int + " mBannerHeightWithoutTitlebar:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_f_of_type_Int + " mPullMsgMaxScope:" + this.jdField_c_of_type_Int + " mTitlebarHeight:" + this.jdField_f_of_type_Int + " screenW:" + i3 + " screenH:" + i2 + " mViewHeight:" + this.h);
        }
      }
      do
      {
        do
        {
          return;
          i1 = i3;
          break;
          this.jdField_f_of_type_Int = (((View)localObject).getBottom() - ((View)localObject).getTop());
          break label172;
        } while ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase == this));
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationPullDownActiveBase = this;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Int = (this.h * 57 / 100);
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_f_of_type_Int = this.jdField_c_of_type_Int;
      } while (!QLog.isColorLevel());
      QLog.d("ConversationARMap", 2, "ensureInit handle after conflict, mListViewHeight:" + this.jdField_d_of_type_Int + " mListViewWidth:" + this.jdField_e_of_type_Int + " mBackgroundBannerHeight:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_e_of_type_Int + " mBannerHeightWithoutTitlebar:" + this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_f_of_type_Int + " mPullMsgMaxScope:" + this.jdField_c_of_type_Int + " mTitlebarHeight:" + this.jdField_f_of_type_Int + " mViewHeight:" + this.h);
      return;
    }
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "startPreGuide  mState:" + this.jdField_a_of_type_Int + "  pendanting:" + this.jdField_e_of_type_Boolean + "  breathing:" + this.jdField_d_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      v();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_i_of_type_Int != 1)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g();
      return;
      c();
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "showListViewPreGuide mState:" + this.jdField_a_of_type_Int);
    }
    if (FrameHelperActivity.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "showListViewPreGuide -- isDrawerFrameOpenOrMoving");
      }
      return;
    }
    if ((this.k == 0) || (this.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = false;; bool = true)
    {
      this.m = true;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(true, bool);
      return;
    }
  }
  
  public void a()
  {
    ARMapConfigManager localARMapConfigManager = (ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189);
    boolean bool = localARMapConfigManager.c();
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "checkCurrentStatus  pendanting:" + this.jdField_e_of_type_Boolean + "  breathing:" + this.jdField_d_of_type_Boolean + "  isCurfew:" + bool + "  mState:" + this.jdField_a_of_type_Int);
    }
    if (((3 != this.jdField_a_of_type_Int) || (this.n != bool)) && (localARMapConfigManager.d()))
    {
      e(bool);
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) && (this.jdField_c_of_type_Boolean) && (this.g))
      {
        if ((this.j != 1) && (this.jdField_a_of_type_Int == 3)) {
          break label386;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
      }
      label173:
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView != null) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase != null))
      {
        if ((this.k != 0) && (this.k != 1) && (this.jdField_a_of_type_Int != 2)) {
          break label396;
        }
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_i_of_type_Int != 0)) {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h();
        }
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(0);
      }
    }
    for (this.jdField_i_of_type_Int = 0;; this.jdField_i_of_type_Int = 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2003);
      long l1 = MessageCache.a() * 1000L;
      long l2 = localARMapConfigManager.c();
      if (l2 > l1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConversationARMap", 2, "checkCurrentStatus  delay check after " + (l2 - l1 + 1000L) + "ms");
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2003, l2 - l1 + 1000L);
      }
      return;
      if (((2 == this.jdField_a_of_type_Int) && (this.n == bool)) || (localARMapConfigManager.d())) {
        break;
      }
      d(bool);
      break;
      label386:
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
      break label173;
      label396:
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_a_of_type_ComTencentMobileqqArmapConversationActivePendantHolderBase.a(1);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_i_of_type_Int != 1)) {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (!VersionUtils.d()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "onHidePreGuide,preGuideType =" + paramInt + ",mState = " + this.jdField_a_of_type_Int);
      }
    } while ((paramInt != 2) && (paramInt != 4));
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.d();
    }
    c();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "breathe switcher = " + paramBoolean + " armap not show");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ConversationARMap", 2, "breathe switcher:" + paramBoolean + " breathing:" + this.jdField_d_of_type_Boolean);
        }
      } while ((this.jdField_d_of_type_Boolean == paramBoolean) && (paramInt == this.j));
      this.j = paramInt;
      this.jdField_d_of_type_Boolean = paramBoolean;
      a();
    } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView == null) || (this.jdField_d_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.e();
  }
  
  public boolean a()
  {
    if (!VersionUtils.d()) {}
    while ((this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) || (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForHongBao) || (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.h) || (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_f_of_type_Boolean)) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (!VersionUtils.d()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "showEntrance, " + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        t();
        if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3)) {
          break;
        }
        ARMapConfigManager localARMapConfigManager = (ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189);
        bool = localARMapConfigManager.c();
        if (localARMapConfigManager.d())
        {
          e(bool);
          d();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        this.jdField_a_of_type_Int = -1;
        QLog.i("ConversationARMap", 1, "showEntrance error " + localThrowable.getMessage());
        return;
      }
      d(bool);
    }
  }
  
  public void b(int paramInt)
  {
    if ((!a()) || (this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onMsgPullFinished, result=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.a(paramInt);
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "pendant switcher = " + paramBoolean + " armap not show");
      }
    }
    label144:
    label273:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "pendant switcher:" + paramBoolean + " pendanting:" + this.jdField_e_of_type_Boolean + " type:" + paramInt + "  mPendantType:" + this.k);
      }
      if ((this.jdField_e_of_type_Boolean != paramBoolean) || (paramInt != this.k))
      {
        if (paramBoolean)
        {
          this.k = paramInt;
          this.jdField_e_of_type_Boolean = paramBoolean;
          a();
          if (!this.jdField_e_of_type_Boolean) {
            break;
          }
          if ((paramInt != 1) && (paramInt != 3)) {
            break label262;
          }
          this.jdField_b_of_type_Boolean = false;
        }
        for (this.jdField_i_of_type_Boolean = false;; this.jdField_i_of_type_Boolean = true)
        {
          if (!this.jdField_c_of_type_Boolean) {
            break label273;
          }
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e();
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2002);
          u();
          if (!this.o) {
            break;
          }
          ReportController.b(null, "dc01440", "", "", "0X80079C2", "0X80079C2", 0, 0, "", "", "", "");
          this.o = false;
          return;
          this.jdField_e_of_type_Boolean = paramBoolean;
          this.k = -1;
          break label144;
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
    label262:
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.f();
    f(true);
    this.o = true;
  }
  
  public void c()
  {
    if (!VersionUtils.d()) {}
    do
    {
      return;
      b(true);
    } while ((this.jdField_a_of_type_Int == -1) || (!a()));
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "normalMode");
    }
    c(0);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.i();
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setActiveListViewListener(null);
    f(true);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapShuaMsgView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.o = true;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void d()
  {
    if (!VersionUtils.d()) {}
    while ((this.jdField_a_of_type_Int == -1) || (a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "ARMapMode");
    }
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.j();
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setActiveListViewListener(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView$ConversationActiveListViewListener);
  }
  
  public void e()
  {
    super.e();
    if (!VersionUtils.d()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "onResume enter");
      }
      ((ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189)).e();
    } while (!a());
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setEnableTouch(true);
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onResume, mState=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView != null) && (this.g))
    {
      if ((this.j != 1) && (this.jdField_a_of_type_Int == 3)) {
        break label257;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.b();
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e();
          if (this.o)
          {
            ReportController.b(null, "dc01440", "", "", "0X80079C2", "0X80079C2", 0, 0, "", "", "", "");
            this.o = false;
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2002);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2002, 500L);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
      return;
      label257:
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
    }
  }
  
  public void f()
  {
    super.f();
    if (!VersionUtils.d()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationARMap", 2, "onPause enter");
      }
      ((ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(189)).f();
    } while (!a());
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onPause, mState=" + this.jdField_a_of_type_Int);
    }
    f(false);
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationARMap", 2, "onPostThemeChanged");
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    c();
  }
  
  public void h()
  {
    this.g = true;
    if (!a()) {}
    do
    {
      do
      {
        return;
        a();
        if ((this.jdField_i_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
          c();
        }
      } while ((!this.jdField_e_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null));
      if (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.e();
        if (this.o)
        {
          ReportController.b(null, "dc01440", "", "", "0X80079C2", "0X80079C2", 0, 0, "", "", "", "");
          this.o = false;
        }
      }
    } while (this.jdField_i_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      u();
      continue;
      a();
      continue;
      r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationARMap
 * JD-Core Version:    0.7.0.1
 */