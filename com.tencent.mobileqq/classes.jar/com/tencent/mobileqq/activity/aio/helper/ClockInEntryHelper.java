package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ClockInEntryHelper
  implements Handler.Callback, View.OnClickListener, ILifeCycleHelper
{
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new ClockInEntryHelper.2(this, Looper.getMainLooper());
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ClockInEntryHelper.1(this);
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap<String, Long> b;
  
  public ClockInEntryHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private long a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(localSharedPreferences.getLong(str, 0L)));
    }
    return ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
  }
  
  private void a(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0).edit().putLong(paramString, paramLong);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369496);
    } while (localImageView == null);
    if (paramBoolean1)
    {
      localImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      if (paramBoolean2)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        ThreadManager.excute(new ClockInEntryHelper.4(this, paramBoolean3), 32, null, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setProgress(1.0F);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    localImageView.setVisibility(0);
  }
  
  private boolean a()
  {
    boolean bool = true;
    Object localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131365515);
    if (localObject == null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
        bool = true;
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
        localObject = ((ViewStub)localObject).inflate();
        if (localObject != null) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null);
      return false;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)((View)localObject).findViewById(2131369532));
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null);
    return false;
  }
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private long b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    if (!this.b.containsKey(paramString))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + paramString;
      long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInime", 0).getLong(str, 0L);
      this.b.put(paramString, Long.valueOf(l));
    }
    return ((Long)this.b.get(paramString)).longValue();
  }
  
  private void b(String paramString, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
    this.b.put(paramString, Long.valueOf(paramLong));
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInime", 0).edit().putLong(paramString, paramLong);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        localHashMap.put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        localHashMap.put("A8", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      ClockReportUtil.a("play#aio_icon_video", localHashMap);
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = a(str);
      if (l1 <= 0L) {
        return true;
      }
      l2 = NetConnInfoCenter.getServerTime();
    } while (l1 > l2);
    if ((int)(l2 / 86400L - l1 / 86400L) > 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    if (!a())
    {
      QLog.d("ClockInEntryHelper.helper", 2, "handleClockInEntryThemeChange: !getClockInEntry()");
      return;
    }
    if (!d())
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    float f;
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      f = 1.0F;
      label84:
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(f, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getResources());
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label240;
      }
      localObject = "troop_sign_in/data.json" + String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromJson(this.jdField_a_of_type_JavaLangString, (String)localObject);
      label160:
      if (a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getScale(), 1)) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleXY(0.5F, 0.5F);
      }
      if (c()) {
        break label253;
      }
    }
    label240:
    label253:
    for (boolean bool = true;; bool = false)
    {
      a(bool, b(), paramBoolean);
      if (!paramBoolean) {
        break;
      }
      long l = NetConnInfoCenter.getServerTime();
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, l);
      return;
      f = 3.0F;
      break label84;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("troop_sign_in/data.json");
      break label160;
    }
  }
  
  private boolean c()
  {
    boolean bool = true;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {}
    long l1;
    do
    {
      return false;
      l1 = b(str);
    } while (l1 <= 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {
      return true;
    }
    if ((int)(l2 / 86400L - l1 / 86400L) == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid chatPie");
      }
      return false;
    }
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: is homeWorkTroop");
      }
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (!((TroopManager)localObject).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: isPassiveExit");
      }
      return false;
    }
    localObject = (TogetherEntryBean)QConfigManager.a().a(553);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid config, id: 553");
      }
      return false;
    }
    return ((TogetherEntryBean)localObject).jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onCreate()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {}
    while (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null)
    {
      QLog.d("ClockInEntryHelper.helper", 2, "onCreate ClockInEntry is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (!d()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localSharedPreferences.getLong(str, 0L));
  }
  
  public void a(boolean paramBoolean)
  {
    int i = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131379432)).getCurrentTextColor();
    ThreadManager.getFileThreadHandler().post(new ClockInEntryHelper.3(this, i, paramBoolean));
  }
  
  public void b()
  {
    if (!d()) {}
    label140:
    for (;;)
    {
      return;
      boolean bool1 = c();
      boolean bool2 = b();
      int i;
      if (bool1)
      {
        a(false, false, false);
        NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          i = 2130850851;
          localNavBarAIO.setRight2Icon(i);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label140;
        }
        QLog.d("ClockInEntryHelper.helper", 2, "onResume: mTitleClockInEntry visiable " + bool1 + " animation: " + bool2);
        return;
        i = 2130850852;
        break;
        if (bool2) {
          a(true, true, false);
        } else {
          a(true, false, false);
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onDestroy()");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    } while (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
  }
  
  public String getTag()
  {
    return "ClockInEntryHelper.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 6, 14 };
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369532)
    {
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(43);
      if (localTogetherControlHelper != null) {
        localTogetherControlHelper.b(1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8: 
      a();
      return;
    case 6: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper
 * JD-Core Version:    0.7.0.1
 */