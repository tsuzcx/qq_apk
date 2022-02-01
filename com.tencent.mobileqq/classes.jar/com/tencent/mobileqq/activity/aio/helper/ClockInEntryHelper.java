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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.together.clockin.ClockReportUtil;
import com.tencent.mobileqq.troop.clockin.api.TroopClockInObserver;
import com.tencent.mobileqq.utils.QQTheme;
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
  private BaseChatPie a;
  private ImageView b;
  private ConcurrentHashMap<String, Long> c;
  private ConcurrentHashMap<String, Long> d;
  private TroopClockInObserver e = new ClockInEntryHelper.1(this);
  private Handler f = new ClockInEntryHelper.2(this, Looper.getMainLooper());
  
  public ClockInEntryHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private long a(String paramString)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).ah != null) && (this.a.ah.b != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0L;
      }
      if (this.d == null) {
        this.d = new ConcurrentHashMap();
      }
      if (!this.d.containsKey(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.d.getCurrentUin());
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        long l = this.a.d.getApp().getSharedPreferences("colckInime", 0).getLong((String)localObject, 0L);
        this.d.put(paramString, Long.valueOf(l));
      }
      return ((Long)this.d.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).ah != null) && (this.a.ah.b != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.c == null) {
        this.c = new ConcurrentHashMap();
      }
      this.c.put(paramString, Long.valueOf(paramLong));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.d.getCurrentUin());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      this.a.d.getApp().getSharedPreferences("colckInEntryLastShowTime", 0).edit().putLong(paramString, paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b != null)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = (ImageView)((BaseChatPie)localObject).p.findViewById(2131436189);
      if (localObject == null) {
        return;
      }
      if (paramBoolean1)
      {
        ((ImageView)localObject).setVisibility(8);
        this.b.setVisibility(0);
        b(paramBoolean2);
        return;
      }
      this.b.setVisibility(8);
      ((ImageView)localObject).setVisibility(0);
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).ah != null) && (this.a.ah.b != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.d == null) {
        this.d = new ConcurrentHashMap();
      }
      this.d.put(paramString, Long.valueOf(paramLong));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.d.getCurrentUin());
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
      this.a.d.getApp().getSharedPreferences("colckInime", 0).edit().putLong(paramString, paramLong);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      if ((this.a.ah != null) && (!TextUtils.isEmpty(this.a.ah.b))) {
        localHashMap.put("qq_group_num", this.a.ah.b);
      }
      if ((this.a.d != null) && (!TextUtils.isEmpty(this.a.d.getCurrentAccountUin()))) {
        localHashMap.put("A8", this.a.d.getCurrentAccountUin());
      }
      ClockReportUtil.a("play#aio_icon_video", localHashMap);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).p != null))
    {
      if (this.a.ah == null) {
        return;
      }
      if (!d())
      {
        QLog.d("ClockInEntryHelper.helper", 2, "handleClockInEntryThemeChange: !getClockInEntry()");
        return;
      }
      if (!f())
      {
        this.b.setVisibility(8);
        return;
      }
      if (QQTheme.isNowSimpleUI())
      {
        int i;
        if (AnonymousChatHelper.a().a(this.a.ah.b)) {
          i = 2130851955;
        } else {
          i = 2130851956;
        }
        this.b.setImageResource(i);
        a(true, false);
        return;
      }
      this.b.setImageResource(2130851941);
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      float f1;
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        f1 = 1.0F;
      } else {
        f1 = 3.0F;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(f1, this.b.getResources());
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      a(e() ^ true, paramBoolean);
      if (paramBoolean)
      {
        long l = NetConnInfoCenter.getServerTime();
        a(this.a.ah.b, l);
      }
    }
  }
  
  private boolean d()
  {
    Object localObject = (ViewStub)this.a.p.findViewById(2131431553);
    if (localObject == null) {
      return this.b != null;
    }
    localObject = ((ViewStub)localObject).inflate();
    if (localObject == null) {
      return this.b != null;
    }
    this.b = ((ImageView)((View)localObject).findViewById(2131436220));
    return this.b != null;
  }
  
  private boolean e()
  {
    String str = this.a.ah.b;
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    long l1 = a(str);
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
  
  private boolean f()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      int j = this.a.ah.a;
      int i = 1;
      if (j == 1)
      {
        if (((TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER)).aa(this.a.ah.b))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: is homeWorkTroop");
          }
          return false;
        }
        localObject = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
        if ((localObject == null) || (((TroopManager)localObject).F(this.a.ah.b))) {
          i = 0;
        }
        if (i == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: isPassiveExit");
          }
          return false;
        }
        localObject = (TogetherEntryBean)QConfigManager.b().b(553);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ClockInEntryHelper.helper", 2, "isShowTogetherEntry: invalid config, id: 553");
          }
          return false;
        }
        return ((TogetherEntryBean)localObject).a;
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
    Object localObject = this.a;
    if ((localObject != null) && (((BaseChatPie)localObject).d != null))
    {
      if (this.a.ah.a != 1) {
        return;
      }
      if (((TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER)).aa(this.a.ah.b)) {
        return;
      }
      a(true);
      localObject = this.b;
      if (localObject == null)
      {
        QLog.d("ClockInEntryHelper.helper", 2, "onCreate ClockInEntry is null");
        return;
      }
      ((ImageView)localObject).setOnClickListener(this);
      this.a.d.addObserver(this.e);
      if (!f()) {
        this.b.setVisibility(8);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.d.getCurrentUin());
      ((StringBuilder)localObject).append(this.a.ah.b);
      localObject = ((StringBuilder)localObject).toString();
      SharedPreferences localSharedPreferences = this.a.d.getApp().getSharedPreferences("colckInEntryLastShowTime", 0);
      a(this.a.ah.b, localSharedPreferences.getLong((String)localObject, 0L));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((TextView)this.a.p.findViewById(2131447463)).getCurrentTextColor();
    ThreadManager.getFileThreadHandler().post(new ClockInEntryHelper.3(this, paramBoolean));
  }
  
  public void b()
  {
    if (!f()) {
      return;
    }
    boolean bool = e();
    Object localObject;
    if (bool)
    {
      a(false, false);
      localObject = this.a.p;
      int i;
      if (AnonymousChatHelper.a().a(this.a.ah.b)) {
        i = 2130852610;
      } else {
        i = 2130852611;
      }
      ((NavBarAIO)localObject).setRight2Icon(i);
    }
    else
    {
      a(true, false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume: mTitleClockInEntry visiable ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ClockInEntryHelper.helper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClockInEntryHelper.helper", 2, "onDestroy()");
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).d == null) {
        return;
      }
      this.a.d.removeObserver(this.e);
      localObject = this.b;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
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
    if (paramView.getId() == 2131436220)
    {
      TogetherControlHelper localTogetherControlHelper = (TogetherControlHelper)this.a.q(43);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ClockInEntryHelper
 * JD-Core Version:    0.7.0.1
 */