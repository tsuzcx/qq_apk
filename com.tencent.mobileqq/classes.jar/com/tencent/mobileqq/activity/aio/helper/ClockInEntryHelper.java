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
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.TogetherEntryBean;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TroopClockInObserver jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver = new ClockInEntryHelper.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap<String, Long> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public ClockInEntryHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private long a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        localObject = ((StringBuilder)localObject).toString();
        SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(localSharedPreferences.getLong((String)localObject, 0L)));
      }
      return ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0).edit().putLong(paramString, paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject == null) {
        return;
      }
      localObject = (ImageView)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369211);
      if (localObject == null) {
        return;
      }
      if (paramBoolean1)
      {
        ((ImageView)localObject).setVisibility(8);
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
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  private boolean a()
  {
    Object localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131365361);
    if (localObject == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null;
    }
    localObject = ((ViewStub)localObject).inflate();
    if (localObject == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)((View)localObject).findViewById(2131369247));
    return this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null;
  }
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private long b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        long l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInime", 0).getLong((String)localObject, 0L);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(l));
      }
      return ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private void b(String paramString, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInime", 0).edit().putLong(paramString, paramLong);
    }
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
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    long l1 = a(str);
    if (l1 <= 0L) {
      return true;
    }
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {
      return false;
    }
    if ((int)(l2 / 86400L - l1 / 86400L) > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
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
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
      float f;
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        f = 1.0F;
      } else {
        f = 3.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getResources());
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop_sign_in/data.json");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_Int));
      localObject = ((StringBuilder)localObject).toString();
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(localObject)))
      {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromJson(this.jdField_a_of_type_JavaLangString, (String)localObject);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("troop_sign_in/data.json");
        }
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getScale(), 1)) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleXY(0.5F, 0.5F);
      }
      a(c() ^ true, b(), paramBoolean);
      if (paramBoolean)
      {
        long l = NetConnInfoCenter.getServerTime();
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, l);
      }
    }
  }
  
  private boolean c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    long l1 = b(str);
    if (l1 <= 0L) {
      return false;
    }
    long l2 = NetConnInfoCenter.getServerTime();
    if (l1 > l2) {
      return true;
    }
    if ((int)(l2 / 86400L - l1 / 86400L) == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      int i = 1;
      if (j == 1)
      {
        if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: is homeWorkTroop");
          }
          return false;
        }
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if ((localObject == null) || (((TroopManager)localObject).g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          i = 0;
        }
        if (i == 0)
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
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid chatPie");
    }
    return false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onCreate()");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        return;
      }
      if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      a(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject == null)
      {
        QLog.d("ClockInEntryHelper.helper", 2, "onCreate ClockInEntry is null");
        return;
      }
      ((DiniFlyAnimationView)localObject).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver);
      if (!d()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localSharedPreferences.getLong((String)localObject, 0L));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378784)).getCurrentTextColor();
    ThreadManager.getFileThreadHandler().post(new ClockInEntryHelper.3(this, i, paramBoolean));
  }
  
  public void b()
  {
    if (!d()) {
      return;
    }
    boolean bool1 = c();
    boolean bool2 = b();
    Object localObject;
    if (bool1)
    {
      a(false, false, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
      int i;
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        i = 2130850788;
      } else {
        i = 2130850789;
      }
      ((NavBarAIO)localObject).setRight2Icon(i);
    }
    else if (bool2)
    {
      a(true, true, false);
    }
    else
    {
      a(true, false, false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume: mTitleClockInEntry visiable ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" animation: ");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("ClockInEntryHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onDestroy()");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopClockinApiTroopClockInObserver);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
      if (localObject != null) {
        ((DiniFlyAnimationView)localObject).setVisibility(8);
      }
    }
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
    return new int[] { 9, 7, 15 };
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369247)
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
    if (paramInt != 7)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        c();
        return;
      }
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper
 * JD-Core Version:    0.7.0.1
 */